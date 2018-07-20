package ace.ucv.licenta.core.ui.renderer;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import ace.ucv.licenta.converter.core.dto.QuestionDTO;

public class QuestionCmbRenderer extends DefaultListCellRenderer {
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		QuestionDTO question = (QuestionDTO) value;
		JLabel displayValue = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if (question != null) {
			displayValue.setText(question.getTitle());
		}

		return displayValue;
	}
}
