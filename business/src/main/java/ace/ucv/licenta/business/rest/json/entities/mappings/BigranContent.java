package ace.ucv.licenta.business.rest.json.entities.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BigranContent {

	@JsonProperty(value = "type")
	private String type;
	
	@JsonProperty(value = "fields")
	private BigramFields fields;

	public BigranContent(String type, BigramFields fields) {
		this.type = type;
		this.fields = fields;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigramFields getFields() {
		return fields;
	}

	public void setFields(BigramFields fields) {
		this.fields = fields;
	}

}
