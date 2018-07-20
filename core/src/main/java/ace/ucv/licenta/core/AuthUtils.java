package ace.ucv.licenta.core;

import ace.ucv.licenta.converter.core.dto.UserDTO;

public class AuthUtils {

	private static UserDTO currentUser;
	
	public static void setCurrentUser(UserDTO user) {
		currentUser = user;
	}
	
	public static UserDTO getCurrentUser() {
		return currentUser;
	}

}
