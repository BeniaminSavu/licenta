package ace.ucv.licenta.core.ui.renderer;

import java.awt.Component;
import java.io.File;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import ace.ucv.licenta.converter.constants.Status;

public class TableRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		Icon icon = null;
		String tooltipText = null;
		String labelText = "";

		JLabel tableCellRendererComponent = (JLabel) super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, column);

		if (value instanceof Status) {
			Status status = (Status) value;
			labelText = status.toString();
			tooltipText = status.toString();
		} else if (value instanceof String) {
			tooltipText = labelText = (String) value;
			File file = new File(labelText);
			if(file.exists()) {
				tooltipText = tooltipText.replace("\\", "/");
				String fileName = tooltipText.substring(tooltipText.lastIndexOf('/') + 1);
				labelText = fileName;
			}
		}

		tableCellRendererComponent.setIcon(icon);
		tableCellRendererComponent.setToolTipText(tooltipText);
		tableCellRendererComponent.setText(labelText);

		return tableCellRendererComponent;
	}
}
