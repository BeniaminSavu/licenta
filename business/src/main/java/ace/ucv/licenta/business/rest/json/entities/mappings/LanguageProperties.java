package ace.ucv.licenta.business.rest.json.entities.mappings;

public class LanguageProperties {

	private LanguageContent content;

	public LanguageProperties(LanguageContent content) {
		this.content = content;
	}

	public LanguageContent getContent() {
		return content;
	}

	public void setContent(LanguageContent content) {
		this.content = content;
	}

}
