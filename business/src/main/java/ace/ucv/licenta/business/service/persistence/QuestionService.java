package ace.ucv.licenta.business.service.persistence;

import java.util.List;

import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.converter.core.dto.UserDTO;

public interface QuestionService {

	QuestionDTO save(QuestionDTO question);

	List<QuestionDTO> getQuestions(UserDTO currentUser);

	QuestionDTO update(QuestionDTO question);

	void delete(QuestionDTO question);

}
