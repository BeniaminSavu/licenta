package ace.ucv.licenta.core.ui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.springframework.beans.factory.annotation.Autowired;

import ace.ucv.licenta.core.ui.questions.AddPanelPresenter;
import ace.ucv.licenta.core.ui.questions.EditPanelPresenter;
import ace.ucv.licenta.core.ui.questions.RemovePanelPresenter;

public class QuestionsPanelPresenter {

	@Autowired
	private QuestionsPanel questionsPanel;

	@Autowired
	private AddPanelPresenter addPanelPresenter;

	@Autowired
	private EditPanelPresenter editPanelPresenter;

	@Autowired
	private RemovePanelPresenter removePanelPresenter;

	public void init() {
		questionsPanel.init();
		addPanelPresenter.init();
		editPanelPresenter.init();
		removePanelPresenter.init();
		openOption(OptionType.ADD);
		addButtonListeners();
	}

	public void showDialog() {
		questionsPanel.setVisible(true);
	}

	private void addButtonListeners() {
		questionsPanel.getAddOptionButton().addActionListener(l -> openOption(OptionType.ADD));
		questionsPanel.getEditOptionButton().addActionListener(l -> openOption(OptionType.EDIT));
		questionsPanel.getRemoveOptionButton().addActionListener(l -> openOption(OptionType.REMOVE));
	}

	private void openOption(OptionType optionType) {
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Border Layout"));
		
		if (optionType == OptionType.ADD) {
			panel = addPanelPresenter.getPanel();
		} else if (optionType == OptionType.EDIT) {
			panel = editPanelPresenter.getPanel();
		} else if (optionType == OptionType.REMOVE) {
			panel = removePanelPresenter.getPanel();
		}

		questionsPanel.setOptionPanel(panel);
	}

	private enum OptionType {
		ADD, EDIT, REMOVE;
	}

}
