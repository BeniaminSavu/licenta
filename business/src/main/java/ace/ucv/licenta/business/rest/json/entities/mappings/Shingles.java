package ace.ucv.licenta.business.rest.json.entities.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Shingles {

	@JsonProperty(value = "type")
	private String type;

	@JsonProperty(value = "analyzer")
	private String analyzer;

	public Shingles(String type, String analyzer) {
		this.type = type;
		this.analyzer = analyzer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(String analyzer) {
		this.analyzer = analyzer;
	}

}
