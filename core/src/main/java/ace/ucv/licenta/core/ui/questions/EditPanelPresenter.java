package ace.ucv.licenta.core.ui.questions;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;

import ace.ucv.licenta.business.service.persistence.QuestionService;
import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.converter.database.dao.Question;
import ace.ucv.licenta.core.AuthUtils;

public class EditPanelPresenter {

	@Autowired
	private EditPanel editPanel;

	@Autowired
	private QuestionService questionService;

	public void init() {
		editPanel.init();

		addItemListener();
		addButtonListeners();
	}

	public JPanel getPanel() {
		populate();
		return editPanel;
	}

	private void populate() {
		List<QuestionDTO> questions = questionService.getQuestions(AuthUtils.getCurrentUser());
		JComboBox<QuestionDTO> questionsCmb = editPanel.getQuestionsCombobox();
		questionsCmb.removeAllItems();
		for (QuestionDTO question : questions) {
			questionsCmb.addItem(question);
		}
	}

	private void addItemListener() {
		editPanel.getQuestionsCombobox().addItemListener(e -> onComboboxSelect(e));
	}

	private void onComboboxSelect(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			QuestionDTO item = (QuestionDTO) e.getItem();
			editPanel.setTitle(item.getTitle());
			editPanel.setContent(item.getCorrectAnswer());
		}
	}

	private void addButtonListeners() {
		editPanel.getEditButton().addActionListener(l -> editQuestion());
	}

	private void editQuestion() {
		QuestionDTO selectedItem = (QuestionDTO) editPanel.getQuestionsCombobox().getSelectedItem();
		selectedItem.setTitle(editPanel.getTitle());
		selectedItem.setCorrectAnswer(editPanel.getAnswer());

		QuestionDTO persistedQuestion = questionService.update(selectedItem);
		if (persistedQuestion != null) {
			JOptionPane.showMessageDialog(editPanel, "Question updated successfully");
			populate();
		} else {
			JOptionPane.showMessageDialog(editPanel, "Question could not update successfully");
		}

	}
}
