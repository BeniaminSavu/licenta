package ace.ucv.licenta.business.rest.json.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	private Hits hits;

	public Hits getHits() {
		return hits;
	}

	public void setHits(Hits hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "Response [hits=" + hits + "]";
	}

}
