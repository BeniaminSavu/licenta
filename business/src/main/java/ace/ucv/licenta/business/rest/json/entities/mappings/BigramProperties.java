package ace.ucv.licenta.business.rest.json.entities.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BigramProperties {

	@JsonProperty(value = "content")
	private BigranContent content;

	public BigramProperties(BigranContent content) {
		this.content = content;
	}

	public BigranContent getContent() {
		return content;
	}

	public void setContent(BigranContent content) {
		this.content = content;
	}

}
