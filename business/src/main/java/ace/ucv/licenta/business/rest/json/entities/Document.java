package ace.ucv.licenta.business.rest.json.entities;

public class Document {

	private String path;
	private String content;
	private String author;
	private int id;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Document [path=" + path + ", content=" + content + ", author=" + author + ", id=" + id + "]";
	}

}
