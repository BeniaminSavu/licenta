package ace.ucv.licenta.business.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import ace.ucv.licenta.business.constants.ElasticSearchConstants;
import ace.ucv.licenta.business.rest.json.entities.Document;
import ace.ucv.licenta.business.rest.json.entities.IndexType;
import ace.ucv.licenta.business.rest.json.entities.mappings.BigranContent;
import ace.ucv.licenta.business.rest.json.entities.mappings.BigramFields;
import ace.ucv.licenta.business.rest.json.entities.mappings.BigramIndexType;
import ace.ucv.licenta.business.rest.json.entities.mappings.LanguageContent;
import ace.ucv.licenta.business.rest.json.entities.mappings.LanguageFields;
import ace.ucv.licenta.business.rest.json.entities.mappings.LanguageIndexType;
import ace.ucv.licenta.business.rest.json.entities.mappings.LanguageProperties;
import ace.ucv.licenta.business.rest.json.entities.mappings.LanguageType;
import ace.ucv.licenta.business.rest.json.entities.mappings.MappingImpl;
import ace.ucv.licenta.business.rest.json.entities.mappings.BigramProperties;
import ace.ucv.licenta.business.rest.json.entities.mappings.Shingles;
import ace.ucv.licenta.business.rest.json.entities.settings.Analysis;
import ace.ucv.licenta.business.rest.json.entities.settings.Analyzer;
import ace.ucv.licenta.business.rest.json.entities.settings.Filter;
import ace.ucv.licenta.business.rest.json.entities.settings.IndexSettings;
import ace.ucv.licenta.business.rest.json.entities.settings.MyShingleAnalyzer;
import ace.ucv.licenta.business.rest.json.entities.settings.MyShingleFilter;
import ace.ucv.licenta.business.rest.json.entities.settings.Settings;
import ace.ucv.licenta.business.rest.json.entities.settings.ShardsSettings;
import ace.ucv.licenta.converter.business.dto.FileStatusDTO;
import ace.ucv.licenta.converter.constants.Status;
import ace.ucv.licenta.utils.CustomFileReader;

@Service
public class IndexServiceImpl implements IndexService {

	public List<FileStatusDTO> index(List<FileStatusDTO> files) throws IOException {
		deleteOldIndexes();
		createTfIdfIndex(files);
		createBigramIndex(files);
		createLanguageIndex(files);
		List<FileStatusDTO> updatedFiles = updateFileStatus(files);
		return updatedFiles;
	}

	private void createLanguageIndex(List<FileStatusDTO> files) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		
		ShardsSettings settings = new ShardsSettings(1);
		restTemplate.put(ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.LANGUAGE_INDEX, settings);
		
		LanguageType english = new LanguageType("text", "english");
		LanguageFields fields = new LanguageFields(english);
		LanguageContent content = new LanguageContent("text", fields);
		LanguageProperties properties = new LanguageProperties(content);
		IndexType indexType = new LanguageIndexType(properties);
		MappingImpl mapping = new MappingImpl(indexType);
		restTemplate.put(ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.LANGUAGE_INDEX + "/"
				+ ElasticSearchConstants.MAPPING_API + "/" + ElasticSearchConstants.INDEX_TYPE, mapping);
		
		int index = 0;
		for (FileStatusDTO fileStatusDTO : files) {
			CustomFileReader fileReader = new CustomFileReader(fileStatusDTO.getPath());
			Document document = new Document();
			document.setPath(fileStatusDTO.getPath());
			document.setAuthor(fileStatusDTO.getAuthor());
			document.setContent(fileReader.getContent());
			document.setId(index);
			restTemplate.put(ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.LANGUAGE_INDEX + "/"
					+ ElasticSearchConstants.INDEX_TYPE + "/" + index, document);
			index++;
		}
		
	}
	
	private void createBigramIndex(List<FileStatusDTO> files) throws IOException {
		RestTemplate restTemplate = new RestTemplate();

		MyShingleFilter shingleFilter = new MyShingleFilter("shingle", 2, 2, false);
		Filter filter = new Filter(shingleFilter);
		List<String> analyzerFilters = new ArrayList<>();
		analyzerFilters.add("lowercase");
		analyzerFilters.add("my_shingle_filter");
		MyShingleAnalyzer shingleAnalyzer = new MyShingleAnalyzer("custom", "standard", analyzerFilters);
		Analyzer analyzer = new Analyzer(shingleAnalyzer);
		Analysis analysis = new Analysis(filter, analyzer);
		Settings settings = new Settings();
		settings.setNumberOfShards(1);
		settings.setAnalysis(analysis);
		IndexSettings indexSettings = new IndexSettings(settings);
		restTemplate.put(ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.BIGRAM_INDEX, indexSettings);

		Shingles shingles = new Shingles("text", "my_shingle_analyzer");
		BigramFields fields = new BigramFields(shingles);
		BigranContent content = new BigranContent("text", fields);
		BigramProperties properties = new BigramProperties(content);
		IndexType indexType = new BigramIndexType(properties);
		MappingImpl mapping = new MappingImpl(indexType);
		restTemplate.put(ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.BIGRAM_INDEX + "/"
				+ ElasticSearchConstants.MAPPING_API + "/" + ElasticSearchConstants.INDEX_TYPE, mapping);
		
		int index = 0;
		for (FileStatusDTO fileStatusDTO : files) {
			CustomFileReader fileReader = new CustomFileReader(fileStatusDTO.getPath());
			Document document = new Document();
			document.setPath(fileStatusDTO.getPath());
			document.setAuthor(fileStatusDTO.getAuthor());
			document.setContent(fileReader.getContent());
			document.setId(index);
			restTemplate.put(ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.BIGRAM_INDEX + "/"
					+ ElasticSearchConstants.INDEX_TYPE + "/" + index, document);
			index++;
		}

	}

	private void createTfIdfIndex(List<FileStatusDTO> files) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		ShardsSettings settings = new ShardsSettings(1);

		restTemplate.put(ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.TF_IDF_INDEX, settings);

		int index = 0;
		for (FileStatusDTO fileStatusDTO : files) {
			CustomFileReader fileReader = new CustomFileReader(fileStatusDTO.getPath());
			Document document = new Document();
			document.setPath(fileStatusDTO.getPath());
			document.setAuthor(fileStatusDTO.getAuthor());
			document.setContent(fileReader.getContent());
			document.setId(index);
			restTemplate.put(ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.TF_IDF_INDEX + "/"
					+ ElasticSearchConstants.INDEX_TYPE + "/" + index, document);
			index++;
		}

	}

	private List<FileStatusDTO> updateFileStatus(List<FileStatusDTO> files) {
		List<FileStatusDTO> updatedFiles = new ArrayList<>();
		updatedFiles.addAll(files);
		for (FileStatusDTO fileStatusDTO : updatedFiles) {
			fileStatusDTO.setStatus(Status.INDEXED);
		}

		return updatedFiles;
	}

	private void deleteOldIndexes() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			restTemplate.delete(ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.TF_IDF_INDEX);
		} catch (HttpClientErrorException e) {

		}

		try {
			restTemplate.delete(ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.BIGRAM_INDEX);
		} catch (HttpClientErrorException e) {

		}
		
		try {
			restTemplate.delete(ElasticSearchConstants.ADDRESS + "/" + ElasticSearchConstants.LANGUAGE_INDEX);
		} catch (HttpClientErrorException e) {

		}
	}

}
