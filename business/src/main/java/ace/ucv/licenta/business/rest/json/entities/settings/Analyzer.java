package ace.ucv.licenta.business.rest.json.entities.settings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Analyzer {

	@JsonProperty(value = "my_shingle_analyzer")
	private MyShingleAnalyzer myShingleAnalyzer;

	public Analyzer(MyShingleAnalyzer myShingleAnalyzer) {
		this.myShingleAnalyzer = myShingleAnalyzer;
	}

	public MyShingleAnalyzer getMyShingleAnalyzer() {
		return myShingleAnalyzer;
	}

	public void setMyShingleAnalyzer(MyShingleAnalyzer myShingkeAnalyzer) {
		this.myShingleAnalyzer = myShingkeAnalyzer;
	}

}
