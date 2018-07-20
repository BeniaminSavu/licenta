package ace.ucv.licenta.business.service.persistence;

import java.util.List;

import ace.ucv.licenta.converter.core.dto.UserDTO;
import ace.ucv.licenta.converter.database.dao.User;

public interface UserService {
	
	UserDTO saveUser(UserDTO user);

	UserDTO findByUsername(String username);

	List<UserDTO> findAllProfessors();
}
