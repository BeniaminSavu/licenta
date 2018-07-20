package ace.ucv.licenta.business.rest.json.entities.bigram;

public class BigramBool {

	private BigramMust must;
	private BigramShould should;

	public BigramMust getMust() {
		return must;
	}

	public void setMust(BigramMust must) {
		this.must = must;
	}

	public BigramShould getShould() {
		return should;
	}

	public void setShould(BigramShould should) {
		this.should = should;
	}

}
