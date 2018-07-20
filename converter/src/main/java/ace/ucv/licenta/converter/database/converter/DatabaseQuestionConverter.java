package ace.ucv.licenta.converter.database.converter;

import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import ace.ucv.licenta.converter.core.dto.AnswerDTO;
import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.converter.database.dao.Answer;
import ace.ucv.licenta.converter.database.dao.Question;

public class DatabaseQuestionConverter {

	public Question convertToEntity(QuestionDTO question){
		Question newQuestion = new Question();
		newQuestion.setId(question.getId());
		newQuestion.setTitle(question.getTitle());
		newQuestion.setCorrectAnswer(question.getCorrectAnswer());
		
		DatabaseUserConverter userConverter = new DatabaseUserConverter();
		newQuestion.setProfessor(userConverter.convertToEntity(question.getProfessor()));
		
		DatabaseAnswerConverter answerConverter = new DatabaseAnswerConverter();
		List<Answer> newAnswers = new ArrayList<>();
		for(AnswerDTO answer : question.getAnswers()) {
			newAnswers.add(answerConverter.convertToEntity(answer));
		}
		newQuestion.setStudentAnswer(newAnswers);
		
		return newQuestion;
	}

	public QuestionDTO convertFrom(Question question) {
		QuestionDTO newQuestion = new QuestionDTO();
		newQuestion.setId(question.getId());
		newQuestion.setTitle(question.getTitle());
		newQuestion.setCorrectAnswer(question.getCorrectAnswer());
		
		DatabaseUserConverter userConverter = new DatabaseUserConverter();
		newQuestion.setProfessor(userConverter.convertFrom(question.getProfessor()));
		
		DatabaseAnswerConverter answerConverter = new DatabaseAnswerConverter();
		List<AnswerDTO> newAnswers = new ArrayList<>();
		for(Answer answer : question.getStudentAnswer()) {
			newAnswers.add(answerConverter.convertFrom(answer));
		}
		newQuestion.setAnswers(newAnswers);
		
		return newQuestion;
	}
}
