package ace.ucv.licenta.business.service.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ace.ucv.licenta.converter.core.dto.AnswerDTO;
import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.converter.core.dto.UserDTO;
import ace.ucv.licenta.converter.database.converter.DatabaseAnswerConverter;
import ace.ucv.licenta.converter.database.converter.DatabaseQuestionConverter;
import ace.ucv.licenta.converter.database.dao.Answer;
import ace.ucv.licenta.converter.database.dao.AnswerRepository;
import ace.ucv.licenta.converter.database.dao.Question;
import ace.ucv.licenta.converter.database.dao.QuestionRepository;
import ace.ucv.licenta.converter.database.dao.User;
import ace.ucv.licenta.converter.database.dao.UserRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AnswerRepository answerRepository;
	
	@Override
	public QuestionDTO save(QuestionDTO question) {
		DatabaseQuestionConverter converter = new DatabaseQuestionConverter();
		Question questionEntity = converter.convertToEntity(question);
		User professorEntity = userRepository.findByUsername(questionEntity.getProfessor().getUsername());
		questionEntity.setProfessor(professorEntity);

		Question persistedQuestion = questionRepository.save(questionEntity);
		return converter.convertFrom(persistedQuestion);
	}

	@Override
	public List<QuestionDTO> getQuestions(UserDTO currentUser) {
		User professorEntity = userRepository.findByUsername(currentUser.getUsername());
		List<Question> questionsEntity = questionRepository.findByProfessor(professorEntity);
		

		DatabaseAnswerConverter answerConverter = new DatabaseAnswerConverter();
		DatabaseQuestionConverter converter = new DatabaseQuestionConverter();
		List<QuestionDTO> questions = new ArrayList<>();
		for (Question questionEntity : questionsEntity) {
			List<AnswerDTO> persisedAnswers = new ArrayList<>();
			List<Answer> answers = answerRepository.findByQuestion(questionEntity);
			for (Answer answer : answers) {
				persisedAnswers.add(answerConverter.convertFrom(answer));
			}
			QuestionDTO persistedQuestion = converter.convertFrom(questionEntity);
			persistedQuestion.setAnswers(persisedAnswers);
			questions.add(persistedQuestion);
		}

		return questions;
	}

	@Override
	public QuestionDTO update(QuestionDTO question) {
		DatabaseQuestionConverter converter = new DatabaseQuestionConverter();
		Question questionEntity = converter.convertToEntity(question);
		Question persistedQuestion = questionRepository.save(questionEntity);

		return converter.convertFrom(persistedQuestion);
	}

	@Override
	public void delete(QuestionDTO question) {
		DatabaseQuestionConverter converter = new DatabaseQuestionConverter();
		Question questionEntity = converter.convertToEntity(question);
		List<Answer> answerEntities = answerRepository.findByQuestion(questionEntity);
		for (Answer answer : answerEntities) {
			answerRepository.delete(answer);
		}
		
		questionRepository.delete(questionEntity);
	}

}
