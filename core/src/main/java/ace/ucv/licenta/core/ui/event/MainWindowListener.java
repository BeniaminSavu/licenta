package ace.ucv.licenta.core.ui.event;

import ace.ucv.licenta.converter.core.dto.UserDTO;

public interface MainWindowListener {

	void openMainApplication(UserDTO user);

	void logout();

}