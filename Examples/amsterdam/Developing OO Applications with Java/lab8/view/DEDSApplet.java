/*
 * Created on Jun 1, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab8.view;

import lab8.model.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DEDSApplet extends JApplet {
	private JFrame frame;
	private Container framePane;

	/**
	 * 
	 */
	public DEDSApplet() {
		super();
		setName(Constants.APPNAME+Constants.APPVERSION);
		frame = new JFrame("Parameter List");
		framePane = frame.getContentPane();
	}

	public void init() {
		super.init();
		String parameter = getParameter("Param1");
		if(parameter == null){
			parameter = "No Parameter located";
		}
		framePane.add(new JLabel(parameter));
		frame.setSize(250, 250);
		frame.setLocation(350, 200);
		frame.setVisible(true);
		
		Container contentPane = getContentPane();
		contentPane.removeAll();
		
		DEDSView view = new DEDSView();
		view.init(contentPane);
	}
	public void destroy() {
		frame.dispose();
		frame = null;
		framePane = null;
	}
}
