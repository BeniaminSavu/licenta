package ace.ucv.licenta.core.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.core.constants.UIConstants;
import ace.ucv.licenta.core.ui.renderer.QuestionCmbRenderer;

public class StudentPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel selectProfessorLbl;
	private JComboBox<String> professorsCmb;
	private JLabel selectQuestionLbl;
	private JComboBox<QuestionDTO> questionsCmb;
	private JLabel chooseAnswerLbl;
	private JButton chooseAnswerButton;
	private JLabel fileLoadedLbl;
	private JTextArea answerContent;
	private JScrollPane scrollPane;
	private JButton sendButton;
	private JButton logoutButton;

	public void init() {
		setBackground(new Color(255, 255, 255));
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		createUi(gbc);
	}

	private void createUi(GridBagConstraints gbc) {
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		selectProfessorLbl = new JLabel("Select a professor to send your answer: ");
		add(selectProfessorLbl, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		professorsCmb = new JComboBox<>();
		add(professorsCmb, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		selectQuestionLbl = new JLabel("Select the question: ");
		add(selectQuestionLbl, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		questionsCmb = new JComboBox<>();
		questionsCmb.setRenderer(new QuestionCmbRenderer());
		add(questionsCmb, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		chooseAnswerLbl = new JLabel("Please select an answer to send: ");
		add(chooseAnswerLbl, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		chooseAnswerButton = new JButton("Choose Answer");
		add(chooseAnswerButton, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		fileLoadedLbl = new JLabel();
		add(fileLoadedLbl, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridwidth = 3;
		answerContent = new JTextArea();
		answerContent.setWrapStyleWord(true);
		answerContent.setLineWrap(true);
		scrollPane = new JScrollPane(answerContent);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getViewport().setBackground(Color.WHITE);
		add(scrollPane, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		logoutButton = new JButton("Log out");
		add(logoutButton, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		sendButton = new JButton("Send");
		add(sendButton, gbc);
	}

	public JComboBox<String> getProfessorsCombobox() {
		return professorsCmb;
	}

	public void setFileLoadedLabel(String absolutePath) {
		fileLoadedLbl.setText(absolutePath);
	}

	public void setAnswerContent(String content) {
		answerContent.setText(content);
	}

	public JButton getChooseAnswerButton() {
		return chooseAnswerButton;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}

	public JButton getSendButton() {
		return sendButton;
	}

	public String getContentAnswer() {
		return answerContent.getText();
	}

	public String getSelectedProfessor() {
		return (String) professorsCmb.getSelectedItem();
	}
	
	public JComboBox<QuestionDTO> getQuestionsCombobox() {
		return questionsCmb;
	}
	
}