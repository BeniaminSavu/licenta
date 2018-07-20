package ace.ucv.licenta.business.constants;

public class ElasticSearchConstants {

	public static final String ADDRESS = "http://localhost:9200";
	public static final String TF_IDF_INDEX = "tfidf";
	public static final String BIGRAM_INDEX = "bigram";
	public static final String LANGUAGE_INDEX = "language";
	public static final String INDEX_TYPE = "document";
	public static final String SEARCH_API = "_search?scroll=10m&size=905";
	public static final String MAPPING_API = "_mapping";
}
