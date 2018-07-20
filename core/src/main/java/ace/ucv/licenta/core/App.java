package ace.ucv.licenta.core;

import javax.swing.UIManager;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] contextPaths = new String[] { "applicationContext.xml" };
		new ClassPathXmlApplicationContext(contextPaths);
	}

}
