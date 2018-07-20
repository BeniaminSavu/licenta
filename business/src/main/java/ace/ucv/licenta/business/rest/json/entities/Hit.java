package ace.ucv.licenta.business.rest.json.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hit {

	@JsonProperty(value = "_id")
	private int id;

	@JsonProperty(value = "_score")
	private String score;

	@JsonProperty(value = "_source")
	private Document source;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Document getSource() {
		return source;
	}

	public void setSource(Document source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Hit [id=" + id + ", score=" + score + ", source=" + source + "]";
	}

}
