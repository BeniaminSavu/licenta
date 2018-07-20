package ace.ucv.licenta.core.ui.security;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ace.ucv.licenta.core.constants.UIConstants;

public class LoginPanel extends JDialog {

	private static final long serialVersionUID = 1L;

	private JLabel usernameLbl;
	private JTextField usernameTxtField;
	private JLabel passwordLbl;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton cancelButton;
	private JLabel registerLbl;
	
	public void init() {
		getContentPane().removeAll();
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		createGui(gbc);
		
		setTitle("Login");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(UIConstants.LOGIN_WIDTH, UIConstants.LOGIN_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void createGui(GridBagConstraints gbc) {
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 3;
		registerLbl = new JLabel("<html>Don't have an account? <span color='blue'>Register</span></html>");
		registerLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(registerLbl, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		usernameLbl = new JLabel("Username: ");
		getContentPane().add(usernameLbl, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		usernameTxtField = new JTextField();
		getContentPane().add(usernameTxtField, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		passwordLbl = new JLabel("Password: ");
		getContentPane().add(passwordLbl, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		passwordField = new JPasswordField();
		getContentPane().add(passwordField, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 2;
		loginButton = new JButton("Login");
		getContentPane().add(loginButton, gbc);
		
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		cancelButton = new JButton("Cancel");
		getContentPane().add(cancelButton, gbc);
	}
	
	public JLabel getRegisterLabel() {
		return registerLbl;
	}
	
	public JButton getLoginButton() {
		return loginButton;
	}
	
	public JButton getCancelButton() {
		return cancelButton;
	}
	
	public String getUsername() {
		return usernameTxtField.getText();
	}
	
	public String getPassword() {
		return new String(passwordField.getPassword());
	}
	

}
