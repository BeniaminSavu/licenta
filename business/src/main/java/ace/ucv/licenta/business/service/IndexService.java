package ace.ucv.licenta.business.service;

import java.io.IOException;
import java.util.List;

import ace.ucv.licenta.converter.business.dto.FileStatusDTO;

public interface IndexService {

	List<FileStatusDTO> index(List<FileStatusDTO> elements) throws IOException;
}
