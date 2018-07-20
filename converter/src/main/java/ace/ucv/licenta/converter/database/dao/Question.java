package ace.ucv.licenta.converter.database.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String title;
	private String correctAnswer;

	@ManyToOne
	private User professor;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "from")
	private List<Answer> studentAnswer = new ArrayList<>();

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

	public User getProfessor() {
		return professor;
	}

	public void setProfessor(User professor) {
		this.professor = professor;
	}

	public List<Answer> getStudentAnswer() {
		return studentAnswer;
	}

	public void setStudentAnswer(List<Answer> studentAnswer) {
		this.studentAnswer = studentAnswer;
	}

}
