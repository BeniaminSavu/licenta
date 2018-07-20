package ace.ucv.licenta.business.rest.json.entities.mappings;

public class LanguageType {

	private String type;
	private String analyzer;

	public LanguageType(String type, String analyzer) {
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
