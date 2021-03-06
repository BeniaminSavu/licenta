package ace.ucv.licenta.converter.core.dto;

import ace.ucv.licenta.converter.constants.Status;

public class ScoreKeeper {

	private String vsm;
	private String bigram;
	private String languageAnalyzer;
	private String path;
	private String author;
	private Status status;

	public String getVsm() {
		return vsm;
	}

	public void setVsm(String vsm) {
		this.vsm = vsm;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
