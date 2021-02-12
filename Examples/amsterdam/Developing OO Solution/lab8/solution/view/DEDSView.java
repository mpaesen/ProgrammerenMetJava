package lab8.solution.view;

import lab8.solution.control.TestController;
import lab8.solution.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DEDSView {
	private TestController controller;
	private javax.swing.JPanel bottomPanel = new JPanel();
	private javax.swing.JPanel questionPanel = new JPanel();
	private javax.swing.JPanel topPanel = new JPanel();

public DEDSView() {
	super();
}
protected void init(Container contentPane) {
	Testable test = null;

	// Set the intermediate JPanel container layout managers
	// contentFrame defaults to BorderLayout, and bottomPanel defaults to FlowLayout
	topPanel.setLayout(new GridLayout(4,1));
	questionPanel.setLayout(new GridLayout(5,1));
	contentPane.add(topPanel, BorderLayout.NORTH);
	contentPane.add(questionPanel, BorderLayout.CENTER);
	contentPane.add(bottomPanel, BorderLayout.SOUTH);

	try {
		// Generate a test that could throw a TestLaodException
		//that was previously coded
		test = Test.load(Constants.PERSIST_FILE_NAME);
		controller = new TestController(test);

		 // Populate topPanel
		if(test instanceof CertTest) {
			topPanel.add(new JLabel("Certification Test"));
		}
		else {
			topPanel.add(new JLabel("Practice Test"));
		}
		topPanel.add(new JLabel("Number of questions: " + test.getQuestionCount()));
		topPanel.add(new JLabel("Time Limit: " + test.getLimitSeconds()));
		// Code added in Lab8 stepF
		JLabel remaining = new JLabel();
		topPanel.add(remaining);
		controller.startWatchDog(questionPanel, remaining);

		// Populate question panel
		controller.createQuestionPanel(questionPanel);

		// Next button added to bottomPanel and it's reference is passed to
		// controller to setVisible(false) when score is provided
		JButton next = new JButton("Next");
		bottomPanel.add(next);
		controller.setNextButton(next);

		// ****** Action Listener for Next button *********
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.nextHandler(questionPanel);
				System.out.println("Next pressed");
			}
		});
	} catch (TestLoadException ex) {
		String msg = ex.getMessage() + " Did you run PersistTest?";
		System.out.println(msg);

		questionPanel.removeAll();
		questionPanel.add(new JLabel(msg));
		questionPanel.validate();
	}

}

public static void main(String[] args) {

	// We need a frame
	JFrame frame = new JFrame(Constants.APPNAME + Constants.APPVERSION);

	// Add test presentation to the frame
	DEDSView view = new DEDSView();
	view.init(frame.getContentPane());

	// Size it, Locate it, Make it not resizable, Show it
	frame.setSize(375, 300);
	frame.setLocation(350,200);
	frame.setResizable(false);
	frame.setVisible(true);

	// Catch frame closing event, stop JVM when user exits
	frame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	});

}
}
