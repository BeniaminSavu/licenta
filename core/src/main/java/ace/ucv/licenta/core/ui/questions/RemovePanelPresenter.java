package ace.ucv.licenta.core.ui.questions;

import java.awt.event.ItemEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;

import ace.ucv.licenta.business.service.persistence.QuestionService;
import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.core.AuthUtils;

public class RemovePanelPresenter {

	@Autowired
	private RemovePanel removePanel;

	@Autowired
	private QuestionService questionService;

	public void init() {
		removePanel.init();
		
		addItemListener();
		addButtonListeners();
	}

	public JPanel getPanel() {
		populate();
		return removePanel;
	}

	private void populate() {
		List<QuestionDTO> questions = questionService.getQuestions(AuthUtils.getCurrentUser());
		JComboBox<QuestionDTO> questionsCmb = removePanel.getQuestionsCombobox();
		questionsCmb.removeAllItems();
		for (QuestionDTO question : questions) {
			questionsCmb.addItem(question);
		}
	}

	private void addItemListener() {
		removePanel.getQuestionsCombobox().addItemListener(e -> onComboboxSelect(e));
	}

	private void addButtonListeners() {
		removePanel.getRemoveButtin().addActionListener(l -> deleteQuestion());
	}
	
	private void deleteQuestion() {
		QuestionDTO question = (QuestionDTO) removePanel.getQuestionsCombobox().getSelectedItem();
		questionService.delete(question);
		
		removePanel.clearFields();
		populate();
	}

	private void onComboboxSelect(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			QuestionDTO item = (QuestionDTO) e.getItem();
			removePanel.setTitle(item.getTitle());
			removePanel.setContent(item.getCorrectAnswer());
		}
	}

}
