package ace.ucv.licenta.converter;

import java.util.ArrayList;
import java.util.List;

import ace.ucv.licenta.converter.business.dto.FileStatusDTO;
import ace.ucv.licenta.converter.core.dto.FileStatus;

public class FileStatusConverter {

	public List<FileStatusDTO> convertFromModel(List<FileStatus> files) {
		List<FileStatusDTO> newDTO = new ArrayList<FileStatusDTO>();
		for (FileStatus fileStatus : files) {
			FileStatusDTO newFile = new FileStatusDTO();
			newFile.setPath(fileStatus.getPath());
			newFile.setStatus(fileStatus.getStatus());
			newFile.setAuthor(fileStatus.getAuthor());
			newDTO.add(newFile);
		}
		return newDTO;
	}

	public List<FileStatus> convertToModel(List<FileStatusDTO> files) {
		List<FileStatus> newDTO = new ArrayList<FileStatus>();
		for (FileStatusDTO fileStatus : files) {
			FileStatus newFile = new FileStatus();
			newFile.setPath(fileStatus.getPath());
			newFile.setStatus(fileStatus.getStatus());
			newFile.setAuthor(fileStatus.getAuthor());
			newFile.setVSM("0");
			newFile.setBigram("0");
			newFile.setLanguageAnalyzer("0");
			newDTO.add(newFile);
		}
		return newDTO;
	}

}
