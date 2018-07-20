package ace.ucv.licenta.business.service;

import java.io.IOException;
import java.util.List;

import ace.ucv.licenta.converter.business.dto.ScoreKeeperDTO;

public interface ProcessService {

	List<ScoreKeeperDTO> process(String content) throws IOException;
}
