package ace.ucv.licenta.core.ui.security;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;

import ace.ucv.licenta.business.service.persistence.UserService;
import ace.ucv.licenta.converter.core.dto.UserDTO;
import ace.ucv.licenta.core.ui.event.LoginListener;
import ace.ucv.licenta.core.ui.event.MainWindowListener;
import ace.ucv.licenta.core.ui.event.RegisterListener;

public class LoginPanelPresenter implements LoginListener {

	@Autowired
	private LoginPanel loginPanel;
	
	@Autowired
	private RegisterListener registerListener;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MainWindowListener mainWindowListener;
	
	public void init() {
		loginPanel.init();
		
		addRegisterListener();
		addButtonListeners();
	}

	private void addButtonListeners() {
		loginPanel.getCancelButton().addActionListener(l -> cancelLogin());
		loginPanel.getLoginButton().addActionListener(l -> login());
	}

	private void login() {
		String username = loginPanel.getUsername();
		UserDTO user = userService.findByUsername(username);
		if(user != null && user.getPassword().equals(loginPanel.getPassword())) {
			loginPanel.setVisible(false);
			mainWindowListener.openMainApplication(user);
		} else {
			JOptionPane.showMessageDialog(null, "User or password incorrect");
		}
	}

	private void cancelLogin() {
		System.exit(1);
	}

	private void addRegisterListener() {
		loginPanel.getRegisterLabel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginPanel.setVisible(false);
				registerListener.openRegister();
			}
		});
	}

	@Override
	public void openLogin() {
		loginPanel.setVisible(true);
	}
	
	
}
