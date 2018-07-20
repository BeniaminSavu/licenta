package ace.ucv.licenta.core.ui.questions;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;

import ace.ucv.licenta.business.service.persistence.QuestionService;
import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.core.AuthUtils;
import ace.ucv.licenta.utils.CustomFileReader;

public class AddPanelPresenter {

	@Autowired
	private AddPanel addPanel;

	@Autowired
	private QuestionService questionService;

	public void init() {
		addPanel.init();

		addButtonListeners();
	}

	public JPanel getPanel() {
		return addPanel;
	}

	private void addButtonListeners() {
		addPanel.getAddButton().addActionListener(l -> createNewQuestion());
		addPanel.getChooseAnswerButton().addActionListener(l -> chooseAnswer());
	}

	private void chooseAnswer() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Select answer");
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnValue = jfc.showOpenDialog(addPanel);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();
			CustomFileReader customFileReader;
			try {
				customFileReader = new CustomFileReader(filePath);
				String content = customFileReader.getContent();
				addPanel.setQuestionAnswer(content);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(addPanel, "Cannot read selected file");
			}
		}
	}

	private void createNewQuestion() {
		String questionTitle = addPanel.getQuestionTitle();
		String questionAnswer = addPanel.getQuestionAnswer();

		QuestionDTO question = new QuestionDTO();
		question.setTitle(questionTitle);
		question.setCorrectAnswer(questionAnswer);
		question.setProfessor(AuthUtils.getCurrentUser());
		QuestionDTO savedQuestion = questionService.save(question);
		if (savedQuestion != null) {
			JOptionPane.showMessageDialog(addPanel, "Question saved succesfully");
			addPanel.clearFields();
		} else {
			JOptionPane.showMessageDialog(addPanel, "Question could not be saved");
		}
	}
}
