package ace.ucv.licenta.business.rest.json.entities.settings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Settings {

	@JsonProperty(value = "number_of_shards")
	private int numberOfShards;

	private Analysis analysis;

	public int getNumberOfShards() {
		return numberOfShards;
	}

	public void setNumberOfShards(int numberOfShards) {
		this.numberOfShards = numberOfShards;
	}

	public Analysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}

}
