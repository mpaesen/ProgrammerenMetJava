package lab9.solution.control;


import lab9.solution.model.Choice;
import lab9.solution.model.Constants;
import lab9.solution.model.Question;
import lab9.solution.model.Testable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;

public class TestController {
	private Testable test;
	private javax.swing.JButton nextButton;
	private int qindex = 0;

public TestController(Testable aTest) {
	super();
	qindex = 0; // Current question index
	test = aTest; // Current text
}
public void choiceHandler(int qindex, int cindex) throws java.rmi.RemoteException{
	test.setPick(qindex, cindex);
}
public void createQuestionPanel(JPanel panel) throws java.rmi.RemoteException{

	final Question question = test.getQuestion(qindex);

	// Erase question panel, repaint
	panel.removeAll();
	panel.getParent().validate();

	panel.add(new JLabel("("+ (qindex + 1) + ") " + question.getText()));


	// Create choice buttons
	ButtonGroup choiceGroup = new ButtonGroup();
	Iterator it = question.getChoices().iterator();
	int cindex = 0;
	while (it.hasNext()) {
		JRadioButton rb = new JRadioButton();
		rb.setActionCommand(Integer.toString(cindex++));
		Choice choice = (Choice) it.next();
		rb.setText(choice.getText());

		choiceGroup.add(rb);
		panel.add(rb);

		// ******** Action Listener *********
		rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int cindex2 = Integer.parseInt(e.getActionCommand());
					System.out.println("Action command: " + cindex2);
					choiceHandler(qindex, cindex2);
				}catch(java.rmi.RemoteException ex) {
					System.out.println(ex);
				}
			}
		});
	}
	// Re-layout box parent contents, repaint
	panel.getParent().validate();
}
public void createScorePanel(JPanel panel) throws java.rmi.RemoteException{
	int score = test.computeScore();
	int threshold = test.getPassThreshold();
	int total = test.getQuestionCount();

	// Erase question panel, repaint
	panel.removeAll();
	panel.getParent().validate();

	JLabel pass = new JLabel();
	panel.add(pass);

	if(test.isCertTest()) {
		panel.add(new JLabel("You needed " + threshold + " correct choices."));
		panel.add(new JLabel("You scored " + score + "."));

	// Pass/fail
 		if (score >= threshold)
			pass.setText("PASS! Congratulations.");
		else
			pass.setText("Sorry. More correct choices needed.");
	}
	else {
		panel.add(new JLabel("Thanks for taking the Practice Test."));
	}
	// Remove next button
	nextButton.setVisible(false);

	// Re-layout box parent contents, repaint
	panel.getParent().validate();
}
public Date getStopTime() throws java.rmi.RemoteException{
	return new Date(
		new Date().getTime() + test.getLimitSeconds() * Constants.SECONDMILLIS);
}
public void nextHandler(JPanel questionPanel) throws java.rmi.RemoteException{
	if (++qindex < test.getQuestionCount()) {
		createQuestionPanel(questionPanel);
	} else {
		createScorePanel(questionPanel);
	}
}
public void setNextButton(javax.swing.JButton newNextButton) {
	nextButton = newNextButton;
}
public void startWatchDog(JPanel panel, JLabel remaining) throws java.rmi.RemoteException{
	final JPanel questionPanel = panel;

	// Create invisible button "clicked" by the watchdog thread
	JButton score = new JButton("Score");
	score.setBounds(0, 0, 0, 0);
	score.setVisible(false);

	// ******* Time-limit-exceeded handler
	score.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				createScorePanel(questionPanel);
				System.out.println("Time limit exeeded");
			}catch(java.rmi.RemoteException ex) {
				System.out.println(ex);
			}
		}
	});

	TimeLimitThreadImpl watchdog =
		new TimeLimitThreadImpl(getStopTime(),remaining, score);

	// Start the watchdog thread
	Thread thread = new Thread(watchdog);
	thread.setName("OEDS Timer");
	thread.start();
}

}
