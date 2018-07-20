package ace.ucv.licenta.business.rest.json.entities.settings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyShingleFilter {

	private String type;

	@JsonProperty(value = "min_shingle_size")
	private int minShingleSize;

	@JsonProperty(value = "max_shingle_size")
	private int maxShingleSize;

	@JsonProperty(value = "output_unigrams")
	private boolean outputUnigrams;

	public MyShingleFilter(String type, int minShingleSize, int maxShingleSize, boolean outputUnigrams) {
		this.type = type;
		this.minShingleSize = minShingleSize;
		this.maxShingleSize = maxShingleSize;
		this.outputUnigrams = outputUnigrams;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMinShingleSize() {
		return minShingleSize;
	}

	public void setMinShingleSize(int minShingleSize) {
		this.minShingleSize = minShingleSize;
	}

	public int getMaxShingleSize() {
		return maxShingleSize;
	}

	public void setMaxShingleSize(int maxShingleSize) {
		this.maxShingleSize = maxShingleSize;
	}

	public boolean isOutputUnigrams() {
		return outputUnigrams;
	}

	public void setOutputUnigrams(boolean outputUnigrams) {
		this.outputUnigrams = outputUnigrams;
	}

}
