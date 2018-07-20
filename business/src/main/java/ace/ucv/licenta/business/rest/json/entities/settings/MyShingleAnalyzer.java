package ace.ucv.licenta.business.rest.json.entities.settings;

import java.util.List;

public class MyShingleAnalyzer {

	private String type;
	private String tokenizer;
	private List<String> filter;

	public MyShingleAnalyzer(String type, String tokenizer, List<String> filter) {
		this.type = type;
		this.tokenizer = tokenizer;
		this.filter = filter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTokenizer() {
		return tokenizer;
	}

	public void setTokenizer(String tokenizer) {
		this.tokenizer = tokenizer;
	}

	public List<String> getFilter() {
		return filter;
	}

	public void setFilter(List<String> filter) {
		this.filter = filter;
	}

}
