package ace.ucv.licenta.business.rest.json.entities.mappings;

import ace.ucv.licenta.business.rest.json.entities.IndexType;

public class LanguageIndexType implements IndexType{

	private LanguageProperties properties;

	public LanguageIndexType(LanguageProperties properties) {
		this.properties = properties;
	}

	public LanguageProperties getProperties() {
		return properties;
	}

	public void setProperties(LanguageProperties properties) {
		this.properties = properties;
	}

}
