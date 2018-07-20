package ace.ucv.licenta.core.ui;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;

import ace.ucv.licenta.business.service.IndexService;
import ace.ucv.licenta.business.service.ProcessService;
import ace.ucv.licenta.business.service.persistence.AnswerService;
import ace.ucv.licenta.business.service.persistence.QuestionService;
import ace.ucv.licenta.converter.FileStatusConverter;
import ace.ucv.licenta.converter.ScoreConverter;
import ace.ucv.licenta.converter.business.dto.FileStatusDTO;
import ace.ucv.licenta.converter.core.dto.AnswerDTO;
import ace.ucv.licenta.converter.core.dto.FileStatus;
import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.converter.core.dto.ScoreKeeper;
import ace.ucv.licenta.core.AuthUtils;
import ace.ucv.licenta.core.charts.BarChart;
import ace.ucv.licenta.core.ui.event.MainWindowListener;
import ace.ucv.licenta.core.ui.model.TableModel;

public class ProfessorPanelPresenter {

	@Autowired
	private ProfessorPanel professorPanel;

	@Autowired
	private QuestionsPanelPresenter questionsPresenter;

	@Autowired
	private IndexService indexService;

	@Autowired
	private ProcessService processService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private MainWindowListener mainWindowListener;

	@Autowired
	private QuestionService questionService;

	public void init() {
		professorPanel.init();
		questionsPresenter.init();

		addButtonListeners();
		addTableListener();
		addItemListener();
	}

	private void addItemListener() {
		professorPanel.getQuestionsCombobox().addItemListener(e -> onComboboxSelect(e));
	}

	private void onComboboxSelect(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			QuestionDTO item = (QuestionDTO) e.getItem();
			professorPanel.getRelevanceTextArea().setText(item.getCorrectAnswer());
			List<AnswerDTO> answers = item.getAnswers();
			TableModel model = (TableModel) professorPanel.getTable().getModel();
			model.clear();
			int index = 1;
			for (AnswerDTO answer : answers) {
				File file = new File("src/main/resources/data/answers/record" + index + ".txt");
				try {
					file.createNewFile();
					FileOutputStream outputStream = new FileOutputStream(file);
					byte[] strToBytes = answer.getContent().getBytes();
					outputStream.write(strToBytes);
					outputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				FileStatus fileStatus = new FileStatus(file.getAbsolutePath());
				fileStatus.setAuthor(
						answer.getCurrentUser().getFirstName() + " " + answer.getCurrentUser().getLastName());
				model.add(fileStatus);
				index++;
			}
			model.fireTableDataChanged();
		}
	}

	private void addTableListener() {
		professorPanel.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int selectedRow = professorPanel.getTable().getSelectedRow();
					int convertRowIndexToModel = professorPanel.getTable().convertRowIndexToModel(selectedRow);
					TableModel model = (TableModel) professorPanel.getTable().getModel();

					FileStatus fileStatus = model.getElements().get(convertRowIndexToModel);
					File file = new File(fileStatus.getPath());
					Desktop desktop = Desktop.getDesktop();
					if (file.exists()) {
						try {
							desktop.open(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}

	public void populate() throws IOException {
		List<QuestionDTO> questions = questionService.getQuestions(AuthUtils.getCurrentUser());
		JComboBox<QuestionDTO> questionsCmb = professorPanel.getQuestionsCombobox();
		questionsCmb.removeAllItems();
		if (questions == null || questions.isEmpty()) {
			TableModel model = (TableModel) professorPanel.getTable().getModel();
			model.clear();
			model.fireTableDataChanged();
			professorPanel.getRelevanceTextArea().setText(null);
		}
		for (QuestionDTO question : questions) {
			questionsCmb.addItem(question);
		}
	}

	public Component getView() {
		return professorPanel;
	}

	private void addButtonListeners() {
		professorPanel.getIndexBtn().addActionListener(l -> indexFiles());
		professorPanel.getProcessButton().addActionListener(l -> process());
		professorPanel.getLogoutButton().addActionListener(l -> logout());
		professorPanel.getChartsButton().addActionListener(l -> createCharts());
		professorPanel.getManageQuestionButton().addActionListener(l -> manageQuestions());
	}

	private void manageQuestions() {
		questionsPresenter.showDialog();
		try {
			populate();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createCharts() {
		TableModel model = (TableModel) professorPanel.getTable().getModel();
		List<FileStatus> elements = model.getElements();
		BarChart barChart = new BarChart(elements);
		barChart.display();
	}

	private void logout() {
		mainWindowListener.logout();
	}

	private void process() {
		String content = professorPanel.getRelevanceTextArea().getText();
		if (content == null) {
			JOptionPane.showMessageDialog(professorPanel, "No refrence file to compare with. Please select one");
			return;
		}
		try {
			ScoreConverter converter = new ScoreConverter();
			List<ScoreKeeper> scores = converter.converToModel(processService.process(content));
			TableModel model = (TableModel) professorPanel.getTable().getModel();
			for (ScoreKeeper score : scores) {
				model.setScore(score);
			}
			model.fireTableDataChanged();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(professorPanel, "An error occurred." + e.getMessage());
		}

	}

	private void indexFiles() {
		TableModel model = (TableModel) professorPanel.getTable().getModel();
		int rowCount = model.getRowCount();
		if (rowCount <= 0) {
			JOptionPane.showMessageDialog(professorPanel, "There are no elements to index.");
			return;
		}

		List<FileStatus> elements = model.getElements();
		FileStatusConverter converter = new FileStatusConverter();
		try {
			List<FileStatusDTO> updatedFiles = indexService.index(converter.convertFromModel(elements));
			List<FileStatus> files = converter.convertToModel(updatedFiles);
			model.update(files);
			model.fireTableDataChanged();
			JOptionPane.showMessageDialog(professorPanel, "Files indexed successfuly");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(professorPanel, "An error occurred." + e.getMessage());
		}
	}
}
