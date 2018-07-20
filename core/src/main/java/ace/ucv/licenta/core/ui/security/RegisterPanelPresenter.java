package ace.ucv.licenta.core.ui.security;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;

import ace.ucv.licenta.business.service.persistence.UserService;
import ace.ucv.licenta.converter.core.dto.UserDTO;
import ace.ucv.licenta.converter.database.dao.User;
import ace.ucv.licenta.core.ui.event.LoginListener;
import ace.ucv.licenta.core.ui.event.RegisterListener;

public class RegisterPanelPresenter implements RegisterListener {

	@Autowired
	private RegisterPanel registerPanel;

	@Autowired
	private LoginListener loginListener;

	@Autowired
	private UserService userService;

	@Override
	public void openRegister() {
		registerPanel.init();

		addButtonListeners();
	}

	private void addButtonListeners() {
		registerPanel.getCancelButton().addActionListener(l -> cancelRegister());
		registerPanel.getRegisterButton().addActionListener(l -> register());
	}

	private void register() {
		if (!registerPanel.getPassword().equals(registerPanel.getConfirmPassword())) {
			JOptionPane.showMessageDialog(null, "Paswords does not match");
			return;
		}

		if (registerPanel.getUsername().isEmpty() || registerPanel.getPassword().isEmpty()
				|| registerPanel.getConfirmPassword().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in all fields");
			return;
		}
		
		UserDTO user = new UserDTO();
		user.setFirstName(registerPanel.getFirstName());
		user.setLastName(registerPanel.getLastName());
		user.setUsername(registerPanel.getUsername());
		user.setPassword(registerPanel.getPassword());
		user.setRole(registerPanel.getRole());
		
		UserDTO saveUser = userService.saveUser(user);
		if(saveUser != null) {
			JOptionPane.showMessageDialog(null, "Register Successful");
			cancelRegister();
		} else {
			JOptionPane.showMessageDialog(null, "An error occurred");
		}
	}

	private void cancelRegister() {
		registerPanel.getContentPane().removeAll();
		registerPanel.setVisible(false);
		loginListener.openLogin();
	}
}
