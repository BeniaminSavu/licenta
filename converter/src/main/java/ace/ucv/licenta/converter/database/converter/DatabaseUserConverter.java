package ace.ucv.licenta.converter.database.converter;

import java.util.ArrayList;
import java.util.List;

import ace.ucv.licenta.converter.core.dto.QuestionDTO;
import ace.ucv.licenta.converter.core.dto.UserDTO;
import ace.ucv.licenta.converter.database.dao.Question;
import ace.ucv.licenta.converter.database.dao.User;

public class DatabaseUserConverter {

	public User convertToEntity(UserDTO user) {
		User newUser = new User();
		newUser.setId(user.getId());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setRole(user.getRole());

		return newUser;
	}

	public UserDTO convertFrom(User user) {
		UserDTO newUser = new UserDTO();
		newUser.setId(user.getId());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setRole(user.getRole());

		return newUser;
	}

}
