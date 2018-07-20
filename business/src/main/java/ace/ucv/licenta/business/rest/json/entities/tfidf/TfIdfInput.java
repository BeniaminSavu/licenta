package ace.ucv.licenta.business.rest.json.entities.tfidf;

public class TfIdfInput {

	private int from;
	private int size;
	private TfIdfQuery query;

	public TfIdfQuery getQuery() {
		return query;
	}

	public void setQuery(TfIdfQuery query) {
		this.query = query;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "TfIdfInput [from=" + from + ", size=" + size + ", query=" + query + "]";
	}

}
