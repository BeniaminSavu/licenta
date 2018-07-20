package ace.ucv.licenta.core.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

import ace.ucv.licenta.core.constants.UIConstants;

public class QuestionsPanel extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JToggleButton addOption;
	private JToggleButton editOption;
	private JToggleButton removeOption;
	private JPanel optionPanel;
	private ButtonGroup buttonGroup;
	
	public void init() {
		setModal(true);
		getContentPane().removeAll();
		getContentPane().setBackground(new Color(255, 255, 255));
		buttonGroup = new ButtonGroup();
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		createGui(gbc);
		
		setTitle("Questions Manager");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(UIConstants.QUESTIONS_MANAGER_WIDTH, UIConstants.QUESTIONS_MANAGER_HEIGHT);
		setLocationRelativeTo(null);
	}

	private void createGui(GridBagConstraints gbc) {
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		addOption = new JToggleButton("Add Question");
		buttonGroup.add(addOption);
		getContentPane().add(addOption, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		editOption = new JToggleButton("Edit Question");
		buttonGroup.add(editOption);
		getContentPane().add(editOption, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		removeOption = new JToggleButton("Remove Question");
		buttonGroup.add(removeOption);
		getContentPane().add(removeOption, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 3;
		optionPanel = new JPanel();
		optionPanel.setBorder(new TitledBorder("Border Layout"));
		getContentPane().add(optionPanel, gbc);
	}
	
	public void setOptionPanel(JPanel optionPanel) {
		getContentPane().remove(this.optionPanel);
		this.optionPanel = optionPanel;
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 3;
		getContentPane().add(optionPanel, gbc);
		getContentPane().revalidate();
		getContentPane().repaint();
	}

	public JToggleButton getAddOptionButton() {
		return addOption;
	}
	
	public JToggleButton getEditOptionButton() {
		return editOption;
	}
	
	public JToggleButton getRemoveOptionButton() {
		return removeOption;
	}

}
