package ace.ucv.licenta.core.ui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ace.ucv.licenta.converter.constants.Status;
import ace.ucv.licenta.converter.core.dto.FileStatus;
import ace.ucv.licenta.converter.core.dto.ScoreKeeper;

public class TableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	public static final int COLUMN_COUNT = 6;
	public static final int FILE_STATUS_COLUMN = 0;
	public static final int FILE_AUTHOR_COLUMN = 1;
	public static final int FILE_PATH_COLUMN = 2;
	public static final int FILE_VSM_COLUMN = 3;
	public static final int FILE_BIGRAM_COLUMN = 4;
	public static final int FILE_LANGUAGE_ANALYZER_COLUMN  = 5;

	private List<FileStatus> files = new ArrayList<FileStatus>();

	public TableModel() {

	}
	
	public int getRowCount() {
		int size;
		if (files == null) {
			size = 0;
		} else {
			size = files.size();
		}
		return size;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> clazz = null;
		switch (columnIndex) {
		case FILE_STATUS_COLUMN:
			clazz = Status.class;
			break;
		case FILE_AUTHOR_COLUMN:
		case FILE_PATH_COLUMN:
		case FILE_VSM_COLUMN:
		case FILE_BIGRAM_COLUMN:
		case FILE_LANGUAGE_ANALYZER_COLUMN:
			clazz = String.class;
			break;
		default:
			clazz = String.class;
			break;
		}
		return clazz;
	}

	public int getColumnCount() {
		return COLUMN_COUNT;
	}

	@Override
	public String getColumnName(int column) {
		String columnName = "";
		switch (column) {
		case FILE_STATUS_COLUMN:
			columnName = "Status";
			break;
		case FILE_AUTHOR_COLUMN:
			columnName = "Author";
			break;
		case FILE_PATH_COLUMN:
			columnName = "File Name";
			break;
		case FILE_VSM_COLUMN:
			columnName = "VSM";
			break;
		case FILE_BIGRAM_COLUMN:
			columnName = "Bigram";
			break;
		case FILE_LANGUAGE_ANALYZER_COLUMN:
			columnName = "Langauge Analyzer";
			break;
		default:
			break;
		}
		
		return columnName;
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object object = null;
		switch (columnIndex) {
		case FILE_STATUS_COLUMN:
			object = files.get(rowIndex).getStatus();
			break;
		case FILE_AUTHOR_COLUMN:
			object = files.get(rowIndex).getAuthor();
			break;
		case FILE_PATH_COLUMN:
			object = files.get(rowIndex).getPath();
			break;
		case FILE_VSM_COLUMN:
			object = files.get(rowIndex).getVSM();
			break;
		case FILE_BIGRAM_COLUMN:
			object = files.get(rowIndex).getBigram();
			break;
		case FILE_LANGUAGE_ANALYZER_COLUMN:
			object = files.get(rowIndex).getLanguageAnalyzer();
		default:
			break;
		}
		
		return object;
	}

	public void add(FileStatus fileStatus) {
		files.add(fileStatus);
	}

	public void clear() {
		files.clear();
	}

	public List<FileStatus> getElements() {
		return files;
	}

	public void update(List<FileStatus> files) {
		this.files.clear();
		this.files.addAll(files);
	}

	public void setScore(ScoreKeeper score) {
		for (FileStatus fileStatus : files) {
			fileStatus.setStatus(score.getStatus());
			if(fileStatus.getPath().equals(score.getPath())){
				fileStatus.setVSM(score.getVsm());
				fileStatus.setBigram(score.getBigram());
				fileStatus.setLanguageAnalyzer(score.getLanguageAnalyzer());
			}
		}
	}


}
