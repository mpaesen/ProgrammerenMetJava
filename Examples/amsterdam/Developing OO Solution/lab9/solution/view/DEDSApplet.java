package lab9.solution.view;

import lab9.solution.model.Constants;

import javax.swing.*;
import java.awt.*;

public class DEDSApplet extends JApplet {
private JFrame frame;
private Container framePane;

public DEDSApplet() {

	// set Title and rectangle size
	setName(Constants.APPNAME + Constants.APPVERSION);
	setSize(375,300);

	frame = new JFrame("Parameter List");
	framePane = frame.getContentPane();
}

public void destroy() {
	frame.dispose();

}

public void init() {

	// retreive parameters from HTML
	String parameter = getParameter("Param1");
	if(parameter == null)
		parameter = "No Parameters located.";
	framePane.add(new JLabel(parameter));
	frame.setSize(250,250);
	frame.setLocation(350,200);
	frame.setVisible(true);


	// Clear old test in case we've been restarted
	Container contentPane = getContentPane();
	contentPane.removeAll();

	// Add test presentation to self: the applet
	DEDSView view = new DEDSView();
	view.init(contentPane);
}
}
