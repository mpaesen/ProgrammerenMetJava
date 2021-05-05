/*
 * Created on May 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab7.view;

import lab7.control.TestController;
import lab7.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DEDSView {

	private lab7.control.TestController controller;

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
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});					
		frame.setSize(375, 300);
		frame.setLocation(350, 200);
		frame.setVisible(true);


	}
	public void init(Container contentPane) {
		Testable test = null;
		topPanel.setLayout(new GridLayout(3, 1));
		questionPanel.setLayout(new GridLayout(5, 1));
		contentPane.add(topPanel, BorderLayout.NORTH);
		contentPane.add(questionPanel, BorderLayout.CENTER);
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		try {
			test = Test.load(Constants.PERSIST_FILE_NAME);
			controller = new TestController(test);
			if (test instanceof CertTest) {
				topPanel.add(new JLabel("Certification Test"));
			} else {
				topPanel.add(new JLabel("Practice Test"));
			}
			topPanel.add(
				new JLabel("Number of questions: " + test.getQuestionCount()));
			topPanel.add(new JLabel("Time Limit: " + test.getLimitSeconds()));
			controller.createQuestionPanel(questionPanel);
			JButton next = new JButton("Next");
			bottomPanel.add(next);
			controller.setNextButton(next);
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					controller.nextHandler(questionPanel);
					System.out.println("Next pressed");
				}
			});
		} catch (TestLoadException e) {
			//display message in questionPanel using a JLabel
			String msg = e.getMessage() + " Did you run PersistTest?";
			System.out.println(msg);
			questionPanel.removeAll();
			questionPanel.add(new JLabel(msg));
			questionPanel.validate();
		}
	}
}