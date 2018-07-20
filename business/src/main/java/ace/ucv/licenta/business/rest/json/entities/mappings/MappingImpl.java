package ace.ucv.licenta.business.rest.json.entities.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import ace.ucv.licenta.business.rest.json.entities.IndexType;
import ace.ucv.licenta.business.rest.json.entities.Mapping;

public class MappingImpl implements Mapping {

	@JsonProperty(value = "document")
	private IndexType document;

	public MappingImpl(IndexType document) {
		this.document = document;
	}

	public IndexType getDocument() {
		return document;
	}

	public void setDocument(IndexType document) {
		this.document = document;
	}

}
