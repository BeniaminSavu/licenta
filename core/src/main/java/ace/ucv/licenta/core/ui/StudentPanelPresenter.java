package ace.ucv.licenta.core.ui;

import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;

import ace.ucv.licenta.business.service.persistence.AnswerService;
import ace.ucv.licenta.business.service.persistence.UserService;
import ace.ucv.licenta.converter.core.dto.AnswerDTO;
import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.converter.core.dto.UserDTO;
import ace.ucv.licenta.core.AuthUtils;
import ace.ucv.licenta.core.ui.event.MainWindowListener;
import ace.ucv.licenta.utils.CustomFileReader;

public class StudentPanelPresenter {

	@Autowired
	private StudentPanel studentPanel;

	@Autowired
	private UserService userService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private MainWindowListener mainWindowListener;

	public void init() {
		studentPanel.init();

		addButtonListeners();
		addItemListener();
	}

	private void addItemListener() {
		studentPanel.getProfessorsCombobox().addItemListener(e -> onProfessorSelect(e));
	}

	private void onProfessorSelect(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			String professorUsername = (String) e.getItem();
			UserDTO professor = userService.findByUsername(professorUsername);
			JComboBox<QuestionDTO> questionsCombobox = studentPanel.getQuestionsCombobox();
			questionsCombobox.removeAllItems();
			for(QuestionDTO question : professor.getQuestions()) {
				questionsCombobox.addItem(question);
			}
		}
	}

	public StudentPanel getView() {
		return studentPanel;
	}

	private void addButtonListeners() {
		studentPanel.getChooseAnswerButton().addActionListener(l -> chooseAnswer());
		studentPanel.getLogoutButton().addActionListener(l -> logout());
		studentPanel.getSendButton().addActionListener(l -> sendAnswer());
	}

	private void sendAnswer() {
		String content = studentPanel.getContentAnswer();
		UserDTO currentUser = AuthUtils.getCurrentUser();
		String selectedProfessor = studentPanel.getSelectedProfessor();
		QuestionDTO question = (QuestionDTO) studentPanel.getQuestionsCombobox().getSelectedItem();
		
		AnswerDTO answer = new AnswerDTO();
		answer.setContent(content);
		answer.setCurrentUser(currentUser);
		answer.setQuestion(question);
		AnswerDTO savedAnser = answerService.save(answer);
		if (savedAnser == null) {
			JOptionPane.showMessageDialog(studentPanel, "Could not save answer");
		} else {
			JOptionPane.showMessageDialog(studentPanel, "Answer processed successfuly");
		}

	}

	private void logout() {
		mainWindowListener.logout();
	}

	private void chooseAnswer() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Select answer");
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnValue = jfc.showOpenDialog(studentPanel);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();
			studentPanel.setFileLoadedLabel(filePath);
			CustomFileReader customFileReader;
			try {
				customFileReader = new CustomFileReader(filePath);
				String content = customFileReader.getContent();
				studentPanel.setAnswerContent(content);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(studentPanel, "Cannot read selected file");
			}
		}
	}

	public void populate() {
		List<UserDTO> professors = userService.findAllProfessors();
		JComboBox<String> professorsCombobox = studentPanel.getProfessorsCombobox();
		professorsCombobox.removeAllItems();
		for (UserDTO professor : professors) {
			professorsCombobox.addItem(professor.getUsername());
		}
	}

}
