/*
 * Created on May 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab9.view;

import lab9.control.TestController;
import lab9.model.CertTest;
import lab9.model.Constants;
import lab9.model.Testable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.Naming;
import java.rmi.RemoteException;
/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DEDSView {

	private lab9.control.TestController controller;
	private javax.swing.JPanel bottomPanel = new JPanel();
	private javax.swing.JPanel questionPanel = new JPanel();
	private javax.swing.JPanel topPanel = new JPanel();

	/**
	 * 
	 */
	public DEDSView() {
		super();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame(Constants.APPNAME + Constants.APPVERSION);
		DEDSView view = new DEDSView();
		view.init(frame.getContentPane());
		frame.setSize(375, 300);
		frame.setLocation(350, 200);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
	}

	public void init(Container contentPane) {
		Testable test = null;
		topPanel.setLayout(new GridLayout(4, 1));
		questionPanel.setLayout(new GridLayout(5, 1));
		contentPane.add(topPanel, BorderLayout.NORTH);
		contentPane.add(questionPanel, BorderLayout.CENTER);
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		try {
			//test = Test.load(Constants.PERSIST_FILE_NAME);
			test = (Testable) Naming.lookup("//localhost/test");
			controller = new TestController(test);
			if (test instanceof CertTest) {
				topPanel.add(new JLabel("Certification Test"));
			} else {
				topPanel.add(new JLabel("Practice Test"));
			}
			topPanel.add(
				new JLabel("Number of questions: " + test.getQuestionCount()));
			topPanel.add(new JLabel("Time Limit: " + test.getLimitSeconds()));
			JLabel remaining = new JLabel();
			topPanel.add(remaining);
			controller.startWatchDog(questionPanel, remaining);
			controller.createQuestionPanel(questionPanel);
			JButton next = new JButton("Next");
			bottomPanel.add(next);
			controller.setNextButton(next);
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					try {
						controller.nextHandler(questionPanel);
						System.out.println("Next pressed");
					} catch (RemoteException e) {
						System.out.println(e.getMessage());
					}
				}
			});
		} catch (RemoteException e) {
			//display message in questionPanel using a JLabel
			String msg = e.getMessage();

		} catch (Exception e) {
			//display message in questionPanel using a JLabel
			String msg = e.getMessage() + " Did you run PersistTest?";
			System.out.println(msg);

			questionPanel.removeAll();
			questionPanel.add(new JLabel(msg));
			questionPanel.validate();
		}
	}
}
