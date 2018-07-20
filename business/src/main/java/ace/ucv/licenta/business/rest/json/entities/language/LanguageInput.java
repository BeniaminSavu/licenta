package ace.ucv.licenta.business.rest.json.entities.language;

public class LanguageInput {

	private LanguageQuery query;

	public LanguageInput(LanguageQuery query) {
		this.query = query;
	}

	public LanguageQuery getQuery() {
		return query;
	}

	public void setQuery(LanguageQuery query) {
		this.query = query;
	}

}
