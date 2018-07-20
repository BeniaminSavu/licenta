package ace.ucv.licenta.business.rest.json.entities.settings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Filter {

	@JsonProperty(value = "my_shingle_filter")
	private MyShingleFilter myShingleFilter;

	public Filter(MyShingleFilter myShingleFilter) {
		this.myShingleFilter = myShingleFilter;
	}

	public MyShingleFilter getMyShingleFilter() {
		return myShingleFilter;
	}

	public void setMyShingleFilter(MyShingleFilter myShingleFilter) {
		this.myShingleFilter = myShingleFilter;
	}

}
