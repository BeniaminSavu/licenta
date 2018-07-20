package ace.ucv.licenta.business.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ace.ucv.licenta.business.constants.ElasticSearchConstants;
import ace.ucv.licenta.business.rest.json.entities.Hit;
import ace.ucv.licenta.business.rest.json.entities.Response;
import ace.ucv.licenta.business.rest.json.entities.bigram.BigramBool;
import ace.ucv.licenta.business.rest.json.entities.bigram.BigramInput;
import ace.ucv.licenta.business.rest.json.entities.bigram.BigramMatch;
import ace.ucv.licenta.business.rest.json.entities.bigram.BigramMust;
import ace.ucv.licenta.business.rest.json.entities.bigram.BigramQuery;
import ace.ucv.licenta.business.rest.json.entities.bigram.BigramShould;
import ace.ucv.licenta.business.rest.json.entities.bigram.NormalBigramMatch;
import ace.ucv.licenta.business.rest.json.entities.language.LanguageInput;
import ace.ucv.licenta.business.rest.json.entities.language.LanguageMultiMatch;
import ace.ucv.licenta.business.rest.json.entities.language.LanguageQuery;
import ace.ucv.licenta.business.rest.json.entities.tfidf.TfIdfInput;
import ace.ucv.licenta.business.rest.json.entities.tfidf.TfIdfMatch;
import ace.ucv.licenta.business.rest.json.entities.tfidf.TfIdfQuery;
import ace.ucv.licenta.converter.business.dto.ScoreKeeperDTO;
import ace.ucv.licenta.converter.constants.Status;

@Service
public class ProcessServiceImpl implements ProcessService {

	@Override
	public List<ScoreKeeperDTO> process(String content) throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		List<Hit> mathcedTfIdfDocuments = getTfIdfDocumentsMatchInput(restTemplate, content);
		List<Hit> matchedBigramDocuments = getBigramDocumentsMatchInput(restTemplate, content);
		List<Hit> matchedLanguageDocuments = getLanguageDocumentsMatchInput(restTemplate, content);

		List<ScoreKeeperDTO> scores = new ArrayList<>();
		for (int i = 0; i < indexSize(restTemplate); i++) {
			ScoreKeeperDTO score = new ScoreKeeperDTO(i);
			getScoreFromTfIdfDocuments(score, mathcedTfIdfDocuments);
			getScoreFromBigramDocuments(score, matchedBigramDocuments);
			getScoreFormLanguageDocuments(score, matchedLanguageDocuments);
			score.setStatus(Status.PROCESSED);
			scores.add(score);
		}

		return scores;
	}


	private void getScoreFormLanguageDocuments(ScoreKeeperDTO score, List<Hit> matchedLanguageDocuments) {
		for (Hit hit : matchedLanguageDocuments) {
			if (score.getId() == hit.getSource().getId()) {
				score.setLanguageAnalyzer(hit.getScore());
				score.setPath(hit.getSource().getPath());
				score.setAuthor(hit.getSource().getAuthor());
				return;
			}
		}
	}


	private void getScoreFromBigramDocuments(ScoreKeeperDTO score, List<Hit> matchedBigramDocuments) {
		for (Hit hit : matchedBigramDocuments) {
			if (score.getId() == hit.getSource().getId()) {
				score.setBigram(hit.getScore());
				score.setPath(hit.getSource().getPath());
				score.setAuthor(hit.getSource().getAuthor());
				return;
			}
		}
	}

	private List<Hit> getLanguageDocumentsMatchInput(RestTemplate restTemplate, String content) throws IOException {
		LanguageInput input = createLanguageQuery(content);
		Response response = restTemplate.postForObject(
				ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.LANGUAGE_INDEX + "/"
						+ ElasticSearchConstants.INDEX_TYPE + "/" + ElasticSearchConstants.SEARCH_API,
				input, Response.class);
		return response.getHits().getHits();
	}
	
	private LanguageInput createLanguageQuery(String content) {
		List<String> fields = new ArrayList<>();
		fields.add("content");
		fields.add("content.english");
		LanguageMultiMatch multiMatch = new LanguageMultiMatch(content, "most_fields", fields);
		LanguageQuery query = new LanguageQuery(multiMatch);
		LanguageInput input = new LanguageInput(query);
		return input;
	}


	private List<Hit> getBigramDocumentsMatchInput(RestTemplate restTemplate, String content) throws IOException {
		BigramInput input = createBigramQuery(content);
		Response response = restTemplate.postForObject(
				ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.BIGRAM_INDEX + "/"
						+ ElasticSearchConstants.INDEX_TYPE + "/" + ElasticSearchConstants.SEARCH_API,
				input, Response.class);
		return response.getHits().getHits();
	}

	private BigramInput createBigramQuery(String content) {
		BigramMatch bigramMatch = new BigramMatch();
		bigramMatch.setContent(content);
		NormalBigramMatch normalBigramMatch = new NormalBigramMatch();
		normalBigramMatch.setContent(content);
		BigramMust must = new BigramMust();
		must.setMatch(normalBigramMatch);
		BigramShould should = new BigramShould();
		should.setMatch(bigramMatch);
		BigramBool bool = new BigramBool();
		bool.setMust(must);
		bool.setShould(should);
		BigramQuery query = new BigramQuery();
		query.setBool(bool);
		BigramInput input = new BigramInput();
		input.setQuery(query);
		input.setFrom(0);
		input.setSize(100);
		
		return input;
	}

	private void getScoreFromTfIdfDocuments(ScoreKeeperDTO score, List<Hit> mathcedDocuments) {
		for (Hit hit : mathcedDocuments) {
			if (score.getId() == hit.getSource().getId()) {
				score.setVsm(hit.getScore());
				score.setPath(hit.getSource().getPath());
				score.setAuthor(hit.getSource().getAuthor());
				return;
			}
		}
	}

	private int indexSize(RestTemplate restTemplate) {
		return getDocumentsInIndex(restTemplate).size();
	}

	private List<Hit> getTfIdfDocumentsMatchInput(RestTemplate restTemplate, String content) throws IOException {
		TfIdfInput input = createTdfIdfQuery(content);
		Response response = restTemplate.postForObject(
				ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.TF_IDF_INDEX + "/"
						+ ElasticSearchConstants.INDEX_TYPE + "/" + ElasticSearchConstants.SEARCH_API,
				input, Response.class);
		return response.getHits().getHits();
	}

	private List<Hit> getDocumentsInIndex(RestTemplate restTemplate) {
		Response response = restTemplate
				.getForObject(
						ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.TF_IDF_INDEX + "/"
								+ ElasticSearchConstants.INDEX_TYPE + "/" + ElasticSearchConstants.SEARCH_API,
						Response.class);
		return response.getHits().getHits();
	}

	private TfIdfInput createTdfIdfQuery(String content) {
		TfIdfInput input = new TfIdfInput();
		TfIdfQuery query = new TfIdfQuery();
		TfIdfMatch match = new TfIdfMatch();
		match.setContent(content);
		query.setMatch(match);
		input.setQuery(query);
		input.setFrom(0);
		input.setSize(100);

		return input;
	}

}
