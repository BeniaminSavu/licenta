package ace.ucv.licenta.business.rest.json.entities.language;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageQuery {

	@JsonProperty(value = "multi_match")
	private LanguageMultiMatch multiMatch;

	public LanguageQuery(LanguageMultiMatch multiMatch) {
		this.multiMatch = multiMatch;
	}

	public LanguageMultiMatch getMultiMatch() {
		return multiMatch;
	}

	public void setMultiMatch(LanguageMultiMatch multiMatch) {
		this.multiMatch = multiMatch;
	}
}
