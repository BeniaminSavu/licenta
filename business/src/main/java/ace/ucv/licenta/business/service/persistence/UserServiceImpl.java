package ace.ucv.licenta.business.service.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.converter.core.dto.UserDTO;
import ace.ucv.licenta.converter.database.converter.DatabaseQuestionConverter;
import ace.ucv.licenta.converter.database.converter.DatabaseUserConverter;
import ace.ucv.licenta.converter.database.dao.Question;
import ace.ucv.licenta.converter.database.dao.QuestionRepository;
import ace.ucv.licenta.converter.database.dao.User;
import ace.ucv.licenta.converter.database.dao.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public UserDTO saveUser(UserDTO user) {
		DatabaseUserConverter userConverter = new DatabaseUserConverter();
		User userEntity = userConverter.convertToEntity(user);
		User persistedEntityUser = userRepository.save(userEntity);
		UserDTO persistedUser = userConverter.convertFrom(persistedEntityUser);
		
		return persistedUser;
	}

	@Override
	public UserDTO findByUsername(String username) {
		User user = userRepository.findByUsername(username);
		List<Question> professorQuestions = questionRepository.findByProfessor(user);
		user.setQuestions(professorQuestions);
		UserDTO persistedUser = null;
		if(user != null) {
			DatabaseUserConverter userConverter = new DatabaseUserConverter();
			persistedUser = userConverter.convertFrom(user);
			
			DatabaseQuestionConverter questionConverter = new DatabaseQuestionConverter();
			List<QuestionDTO> persistedQuestions = new ArrayList<>();
			for(Question question : professorQuestions) {
				persistedQuestions.add(questionConverter.convertFrom(question));
			}
			persistedUser.setQuestions(persistedQuestions);
		}
		return persistedUser;
	}

	@Override
	public List<UserDTO> findAllProfessors() {
		List<User> professorEntities = userRepository.findByRole("Professor");
		List<UserDTO> professors = new ArrayList<>();
		DatabaseUserConverter userConverter = new DatabaseUserConverter();
		for (User professorEntity : professorEntities) {
			UserDTO professor = userConverter.convertFrom(professorEntity);
			professors.add(professor);
		}
		
		return professors;
	}
	
	


}
