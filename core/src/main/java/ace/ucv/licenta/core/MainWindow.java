package ace.ucv.licenta.core;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;

import ace.ucv.licenta.converter.core.dto.UserDTO;
import ace.ucv.licenta.core.constants.UIConstants;
import ace.ucv.licenta.core.ui.ProfessorPanelPresenter;
import ace.ucv.licenta.core.ui.StudentPanelPresenter;
import ace.ucv.licenta.core.ui.event.MainWindowListener;
import ace.ucv.licenta.core.ui.security.LoginPanelPresenter;

public class MainWindow extends JFrame implements MainWindowListener {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProfessorPanelPresenter professorPanelPresenter;

	@Autowired
	private StudentPanelPresenter studentPresenter;

	@Autowired
	private LoginPanelPresenter loginPresenter;

	public void init() {
		loginPresenter.init();
		studentPresenter.init();
		professorPanelPresenter.init();
	}

	@Override
	public void openMainApplication(UserDTO user) {
		AuthUtils.setCurrentUser(user);
		if (user.getRole().equals("Student")) {
			setTitle("Student");
			studentPresenter.populate();
			add(studentPresenter.getView());
		} else if (user.getRole().equals("Professor")) {
			setTitle("Professor");
			deletePreviousAnswers();
			try {
				professorPanelPresenter.populate();
			} catch (IOException e) {
				e.printStackTrace();
			}

			add(professorPanelPresenter.getView());
		}
		setBackground(new Color(255, 255, 255));
		setSize(UIConstants.WINDOW_WIDTH, UIConstants.WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	private void deletePreviousAnswers() {
		File directory = new File("src/main/resources/data/answers");
		for (File file : directory.listFiles()) {
			if (!file.isDirectory()) {
				file.delete();
			}
		}
	}

	@Override
	public void logout() {
		remove(studentPresenter.getView());
		remove(professorPanelPresenter.getView());
		setVisible(false);
		loginPresenter.openLogin();
	}
}
