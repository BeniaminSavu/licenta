package ace.ucv.licenta.business.service.persistence;

import java.util.List;

import ace.ucv.licenta.converter.core.dto.AnswerDTO;
import ace.ucv.licenta.converter.core.dto.UserDTO;

public interface AnswerService {

	AnswerDTO save(AnswerDTO answer);

	List<AnswerDTO> findByPorfessor(UserDTO currentUser);

}
