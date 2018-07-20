package ace.ucv.licenta.business.rest.json.entities.settings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Analysis {

	@JsonProperty(value = "filter")
	private Filter filter;

	@JsonProperty(value = "analyzer")
	private Analyzer analyzer;

	public Analysis(Filter filter, Analyzer analyzer) {
		this.filter = filter;
		this.analyzer = analyzer;
	}

	public Filter getFiler() {
		return filter;
	}

	public void setFiler(Filter filer) {
		this.filter = filer;
	}

	public Analyzer getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(Analyzer analyzer) {
		this.analyzer = analyzer;
	}

}
