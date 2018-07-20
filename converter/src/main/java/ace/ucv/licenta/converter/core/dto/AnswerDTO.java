package ace.ucv.licenta.converter.core.dto;

public class AnswerDTO {

	private UserDTO currentUser;
	private String content;
	private QuestionDTO question;

	public UserDTO getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(UserDTO currentUser) {
		this.currentUser = currentUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public QuestionDTO getQuestion() {
		return question;
	}

	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}

}
