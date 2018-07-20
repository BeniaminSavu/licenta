package ace.ucv.licenta.business.rest.json.entities.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import ace.ucv.licenta.business.rest.json.entities.IndexType;

public class BigramIndexType implements IndexType {

	@JsonProperty(value = "properties")
	private BigramProperties properties;

	public BigramIndexType(BigramProperties properties) {
		this.properties = properties;
	}

	public BigramProperties getProperties() {
		return properties;
	}

	public void setProperties(BigramProperties properties) {
		this.properties = properties;
	}

}
