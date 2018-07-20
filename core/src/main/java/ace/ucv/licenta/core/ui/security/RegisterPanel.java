package ace.ucv.licenta.core.ui.security;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ace.ucv.licenta.core.constants.UIConstants;

public class RegisterPanel extends JDialog {

	private static final long serialVersionUID = 1L;

	private JLabel firstNameLbl;
	private JTextField firstNameTxtField;
	private JLabel lastNameLbl;
	private JTextField lastNameTextField;
	private JLabel usernameLbl;
	private JTextField usernameTxtField;
	private JLabel passwordLbl;
	private JPasswordField passwordField;
	private JLabel confimPasswordLbl;
	private JPasswordField confirmPasswordField;
	private JLabel roleLbl;
	private JComboBox<String> roleCmb;
	private JButton registerButton;
	private JButton cancelButton;

	public void init() {
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		createGui(gbc);

		setTitle("Register");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBackground(new Color(255, 255, 255));
		setSize(UIConstants.REGISTER_WIDTH, UIConstants.REGISTER_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void createGui(GridBagConstraints gbc) {
		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		firstNameLbl = new JLabel("First Name: ");
		getContentPane().add(firstNameLbl, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		firstNameTxtField = new JTextField();
		getContentPane().add(firstNameTxtField, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		lastNameLbl = new JLabel("Last Name: ");
		getContentPane().add(lastNameLbl, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		lastNameTextField = new JTextField();
		getContentPane().add(lastNameTextField, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
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
		gbc.gridy = 2;
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
		gbc.gridy = 3;
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
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		passwordField = new JPasswordField();
		getContentPane().add(passwordField, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		confimPasswordLbl = new JLabel("Confirm Password: ");
		getContentPane().add(confimPasswordLbl, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		confirmPasswordField = new JPasswordField();
		getContentPane().add(confirmPasswordField, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		roleLbl = new JLabel("Role: ");
		getContentPane().add(roleLbl, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		roleCmb = new JComboBox<>();
		roleCmb.addItem("Professor");
		roleCmb.addItem("Student");
		getContentPane().add(roleCmb, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 2;
		registerButton = new JButton("Register");
		getContentPane().add(registerButton, gbc);

		gbc.insets = new Insets(UIConstants.COMPONENT_TOP_PADDING, UIConstants.COMPONENT_LEFT_PADDING,
				UIConstants.COMPONENT_BOTTOM_PADDING, UIConstants.COMPONENT_RIGHT_PADDING);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		cancelButton = new JButton("Cancel");
		getContentPane().add(cancelButton, gbc);
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getRegisterButton() {
		return registerButton;
	}

	public String getUsername() {
		return usernameTxtField.getText();
	}

	public String getPassword() {
		return new String(passwordField.getPassword());
	}

	public String getConfirmPassword() {
		return new String(confirmPasswordField.getPassword());
	}

	public String getRole() {
		return (String) roleCmb.getSelectedItem();
	}

	public String getFirstName() {
		return firstNameTxtField.getText();
	}

	public String getLastName() {
		return lastNameTextField.getText();
	}
}
