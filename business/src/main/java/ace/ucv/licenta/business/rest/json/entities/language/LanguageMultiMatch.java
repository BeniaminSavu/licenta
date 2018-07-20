package ace.ucv.licenta.business.rest.json.entities.language;

import java.util.List;

public class LanguageMultiMatch {

	private String query;
	private String type;
	private List<String> fields;

	public LanguageMultiMatch(String query, String type, List<String> fields) {
		this.query = query;
		this.type = type;
		this.fields = fields;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

}
