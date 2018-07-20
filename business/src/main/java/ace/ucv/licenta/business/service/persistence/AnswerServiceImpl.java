package ace.ucv.licenta.business.service.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ace.ucv.licenta.converter.core.dto.AnswerDTO;
import ace.ucv.licenta.converter.core.dto.UserDTO;
import ace.ucv.licenta.converter.database.converter.DatabaseAnswerConverter;
import ace.ucv.licenta.converter.database.dao.Answer;
import ace.ucv.licenta.converter.database.dao.AnswerRepository;
import ace.ucv.licenta.converter.database.dao.Question;
import ace.ucv.licenta.converter.database.dao.QuestionRepository;
import ace.ucv.licenta.converter.database.dao.User;
import ace.ucv.licenta.converter.database.dao.UserRepository;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public AnswerDTO save(AnswerDTO answer) {
		DatabaseAnswerConverter converter = new DatabaseAnswerConverter();
		Answer answerEntity = converter.convertToEntity(answer);
		User from = userRepository.findByUsername(answer.getCurrentUser().getUsername());
		Question question = questionRepository.findByTitle(answer.getQuestion().getTitle());
		answerEntity.setFrom(from);
		answerEntity.setQuestion(question);
		
		Answer persistedEntity = answerRepository.save(answerEntity);
		
		return converter.convertFrom(persistedEntity);
	}

	@Override
	public List<AnswerDTO> findByPorfessor(UserDTO currentUser) {
		User professor = userRepository.findByUsername(currentUser.getUsername());
		//List<Answer> persistedProfesorAnswers = answerRepository.findByProfessor(professor);
		List<AnswerDTO> profesorAnswers = new ArrayList<>();
		
		DatabaseAnswerConverter converter = new DatabaseAnswerConverter();
		//for (Answer answer : persistedProfesorAnswers) {
		//	profesorAnswers.add(converter.convertFrom(answer));
		//}
		
		return profesorAnswers;
	}

}
