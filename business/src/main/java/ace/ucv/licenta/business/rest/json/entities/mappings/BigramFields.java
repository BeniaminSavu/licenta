package ace.ucv.licenta.business.rest.json.entities.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BigramFields {

	@JsonProperty(value = "shingles")
	private Shingles shingles;

	public BigramFields(Shingles shingles) {
		this.shingles = shingles;
	}

	public Shingles getShingles() {
		return shingles;
	}

	public void setShingles(Shingles shingles) {
		this.shingles = shingles;
	}

}
