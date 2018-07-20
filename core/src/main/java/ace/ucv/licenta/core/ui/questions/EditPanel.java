package ace.ucv.licenta.core.ui.questions;

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
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.core.constants.UIConstants;
import ace.ucv.licenta.core.ui.renderer.QuestionCmbRenderer;

public class EditPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel selectQuestionLbl;
	private JComboBox<QuestionDTO> questionsCmb;
	private JLabel questionTitleLbl;
	private JTextField questionTitleTf;
	private JLabel questionAnswerLbl;
	private JTextArea questionAnswerTa;
	private JScrollPane scrollPanel;
	private JButton editButton;

	public void init() {
		setBackground(new Color(255, 255, 255));
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		createUi(gbc);
	}

	private void createUi(GridBagConstraints gbc) {
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		selectQuestionLbl = new JLabel("Select Question");
		add(selectQuestionLbl, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		questionsCmb = new JComboBox<>();
		questionsCmb.setRenderer(new QuestionCmbRenderer());
		add(questionsCmb, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		questionTitleLbl = new JLabel("Question Title: ");
		add(questionTitleLbl, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		questionTitleTf = new JTextField();
		add(questionTitleTf, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		questionAnswerLbl = new JLabel("Question content: ");
		add(questionAnswerLbl, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 2;
		questionAnswerTa = new JTextArea();
		questionAnswerTa.setLineWrap(true);
		scrollPanel = new JScrollPane(questionAnswerTa);
		scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scrollPanel, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		editButton = new JButton("Edit Question");
		add(editButton, gbc);
	}

	public JComboBox<QuestionDTO> getQuestionsCombobox() {
		return questionsCmb;
	}

	public JButton getEditButton() {
		return editButton;
	}

	public void setTitle(String title) {
		questionTitleTf.setText(title);
	}

	public void setContent(String correctAnswer) {
		questionAnswerTa.setText(correctAnswer);
	}

	public String getTitle() {
		return questionTitleTf.getText();
	}

	public String getAnswer() {
		return questionAnswerTa.getText();
	}
}
