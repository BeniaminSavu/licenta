package ace.ucv.licenta.business.rest.json.entities.bigram;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BigramMatch {

	@JsonProperty(value = "content.shingles")
	private String content;

	@JsonProperty(value = "content.shingles")
	public String getContent() {
		return content;
	}

	@JsonProperty(value = "content.shingles")
	public void setContent(String content) {
		this.content = content;
	}

}
