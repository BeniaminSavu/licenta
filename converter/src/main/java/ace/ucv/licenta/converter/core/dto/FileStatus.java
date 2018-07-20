package ace.ucv.licenta.converter.core.dto;

import ace.ucv.licenta.converter.constants.Status;

public class FileStatus {

	private Status status;
	private String path;
	private String author;
	private String VSM;
	private String bigram;
	private String languageAnalyzer;

	public FileStatus(String path) {
		this.path = path;
		this.status = Status.NOT_PROCESSED;
		this.VSM = "0";
		this.bigram = "0";
		this.languageAnalyzer = "0";
	}

	public FileStatus() {
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getVSM() {
		return VSM;
	}

	public void setVSM(String vSM) {
		VSM = vSM;
	}

	public String getBigram() {
		return bigram;
	}

	public void setBigram(String bigram) {
		this.bigram = bigram;
	}

	public String getLanguageAnalyzer() {
		return languageAnalyzer;
	}

	public void setLanguageAnalyzer(String languageAnalyzer) {
		this.languageAnalyzer = languageAnalyzer;
	}

}
