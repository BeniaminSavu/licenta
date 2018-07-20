package ace.ucv.licenta.core.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableRowSorter;

import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.core.constants.UIConstants;
import ace.ucv.licenta.core.ui.model.TableModel;
import ace.ucv.licenta.core.ui.renderer.QuestionCmbRenderer;
import ace.ucv.licenta.core.ui.renderer.TableRenderer;

public class ProfessorPanel extends JPanel {

	private final class StringNumberComparator implements Comparator<String> {
		@Override
		public int compare(String value1, String value2) {
			Double v1 = Double.parseDouble(value1);
			Double v2 = Double.parseDouble(value2);

			if (v1 == v2) {
				return 0;
			} else if (v1 < v2) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	private static final long serialVersionUID = 1L;

	private JLabel selectQuestionLbl;
	private JComboBox<QuestionDTO> questionsCmb;
	private JButton manageQuestionsBtn;
	private JScrollPane tableScrollPane;
	private JTable table;
	private JTextArea relevanceTextArea;
	private JScrollPane textAreaScrollPane;
	private JButton indexBtn;
	private JButton processBtn;
	private JButton logoutBtn;
	private JButton chartsBtn;

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
		selectQuestionLbl = new JLabel("Select question: ");
		add(selectQuestionLbl, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
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
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		manageQuestionsBtn = new JButton("Manage Questions");
		add(manageQuestionsBtn, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridwidth = 4;
		relevanceTextArea = new JTextArea();
		relevanceTextArea.setEditable(false);
		relevanceTextArea.setLineWrap(true);
		textAreaScrollPane = new JScrollPane(relevanceTextArea);
		textAreaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textAreaScrollPane.getViewport().setBackground(Color.WHITE);
		add(textAreaScrollPane, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridwidth = 4;
		table = new JTable(new TableModel());
		table.setShowGrid(false);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultRenderer(Object.class, new TableRenderer());
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>((TableModel) table.getModel());
		sorter.setComparator(TableModel.FILE_VSM_COLUMN, new StringNumberComparator());
		sorter.setComparator(TableModel.FILE_BIGRAM_COLUMN, new StringNumberComparator());
		sorter.setComparator(TableModel.FILE_LANGUAGE_ANALYZER_COLUMN, new StringNumberComparator());
		table.setRowSorter(sorter);
		tableScrollPane = new JScrollPane(table);
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		tableScrollPane.getViewport().setBackground(Color.WHITE);
		add(tableScrollPane, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		logoutBtn = new JButton("Log out");
		add(logoutBtn, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		chartsBtn = new JButton("Charts");
		add(chartsBtn, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		indexBtn = new JButton("Index");
		add(indexBtn, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		processBtn = new JButton("Process");
		add(processBtn, gbc);
	}

	public JButton getIndexBtn() {
		return indexBtn;
	}

	public JButton getProcessButton() {
		return processBtn;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getLogoutButton() {
		return logoutBtn;
	}

	public JTextArea getRelevanceTextArea() {
		return relevanceTextArea;
	}

	public JButton getChartsButton() {
		return chartsBtn;
	}

	public JButton getManageQuestionButton() {
		return manageQuestionsBtn;
	}

	public JComboBox<QuestionDTO> getQuestionsCombobox() {
		return questionsCmb;
	}
}
