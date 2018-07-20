package ace.ucv.licenta.business.rest.json.entities.settings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShardsSettings {

	@JsonProperty(value = "number_of_shards")
	private int numberOfShards;

	public ShardsSettings(int numberOfShards) {
		this.numberOfShards = numberOfShards;
	}

	public int getNumberOfShards() {
		return numberOfShards;
	}

	public void setNumberOfShards(int numberOfShards) {
		this.numberOfShards = numberOfShards;
	}

}
