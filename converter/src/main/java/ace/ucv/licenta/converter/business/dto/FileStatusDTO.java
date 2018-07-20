package ace.ucv.licenta.converter.business.dto;

import ace.ucv.licenta.converter.constants.Status;

public class FileStatusDTO {

	private Status status;
	private String path;
	private String author;

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

}
