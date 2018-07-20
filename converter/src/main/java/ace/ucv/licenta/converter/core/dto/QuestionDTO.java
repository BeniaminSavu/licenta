package ace.ucv.licenta.converter.core.dto;

import java.util.ArrayList;
import java.util.List;

public class QuestionDTO {

	private Integer id;
	private String title;
	private String correctAnswer;
	private UserDTO professor;
	private List<AnswerDTO> answers = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public UserDTO getProfessor() {
		return professor;
	}

	public void setProfessor(UserDTO professor) {
		this.professor = professor;
	}

	public List<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDTO> answers) {
		this.answers = answers;
	}

}
