package ace.ucv.licenta.converter.database.converter;

import ace.ucv.licenta.converter.core.dto.AnswerDTO;
import ace.ucv.licenta.converter.database.dao.Answer;

public class DatabaseAnswerConverter {

	private DatabaseUserConverter userConverter = new DatabaseUserConverter();
	
	public Answer convertToEntity(AnswerDTO answer) {
		Answer newAnswer = new Answer();
		newAnswer.setContent(answer.getContent());
		newAnswer.setFrom(userConverter.convertToEntity(answer.getCurrentUser()));
		
		return newAnswer;
	}

	public AnswerDTO convertFrom(Answer persistedEntity) {
		AnswerDTO newAnswer = new AnswerDTO();
		newAnswer.setContent(persistedEntity.getContent());
		newAnswer.setCurrentUser(userConverter.convertFrom(persistedEntity.getFrom()));
		
		return newAnswer;
	}

}
