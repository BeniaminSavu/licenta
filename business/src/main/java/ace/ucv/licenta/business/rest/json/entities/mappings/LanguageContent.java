package ace.ucv.licenta.business.rest.json.entities.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageContent {

	@JsonProperty(value = "type")
	private String type;

	@JsonProperty(value = "fields")
	private LanguageFields fields;

	public LanguageContent(String type, LanguageFields fields) {
		this.type = type;
		this.fields = fields;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LanguageFields getFields() {
		return fields;
	}

	public void setFields(LanguageFields fields) {
		this.fields = fields;
	}

}
