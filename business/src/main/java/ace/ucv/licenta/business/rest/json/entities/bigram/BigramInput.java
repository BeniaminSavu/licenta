package ace.ucv.licenta.business.rest.json.entities.bigram;

public class BigramInput {

	private int from;
	private int size;
	private BigramQuery query;

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

	public BigramQuery getQuery() {
		return query;
	}

	public void setQuery(BigramQuery query) {
		this.query = query;
	}

}
