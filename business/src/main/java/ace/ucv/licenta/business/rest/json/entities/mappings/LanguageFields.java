package ace.ucv.licenta.business.rest.json.entities.mappings;

public class LanguageFields {

	private LanguageType english;

	public LanguageFields(LanguageType english) {
		super();
		this.english = english;
	}

	public LanguageType getEnglish() {
		return english;
	}

	public void setEnglish(LanguageType english) {
		this.english = english;
	}

}
