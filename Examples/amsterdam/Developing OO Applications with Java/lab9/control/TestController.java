package lab9.control;

import lab9.model.Choice;
import lab9.model.Constants;
import lab9.model.Question;
import lab9.model.Testable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
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
	public void choiceHandler(int qindex, int cindex) throws RemoteException {
		test.setPick(qindex, cindex);
	}
	public void createQuestionPanel(JPanel panel) throws RemoteException {

		final Question question = test.getQuestion(qindex);

		// Erase question panel, repaint
		panel.removeAll();
		panel.getParent().validate();

		panel.add(new JLabel("(" + (qindex + 1) + ") " + question.getText()));

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
					try {
						int cindex2 = Integer.parseInt(e.getActionCommand());
						System.out.println("Action command: " + cindex2);
						choiceHandler(qindex, cindex2);

					} catch (RemoteException e1) {
						System.out.println(e1);
					}
				}
			});
		}
		// Re-layout box parent contents, repaint
		panel.getParent().validate();
	}
	public void createScorePanel(JPanel panel) throws RemoteException {
		int score = test.computeScore();
		int threshold = test.getPassThreshold();
		int total = test.getQuestionCount();

		// Erase question panel, repaint
		panel.removeAll();
		panel.getParent().validate();

		JLabel pass = new JLabel();
		panel.add(pass);

		if (test.isCertTest()) {
			panel.add(
				new JLabel("You needed " + threshold + " correct choices."));
			panel.add(new JLabel("You scored " + score + "."));

			// Pass/fail
			if (score >= threshold)
				pass.setText("PASS! Congratulations.");
			else
				pass.setText("Sorry. More correct choices needed.");
		} else {
			panel.add(new JLabel("Thanks for taking the Practice Test."));
		}
		// Remove next button
		nextButton.setVisible(false);

		// Re-layout box parent contents, repaint
		panel.getParent().validate();
	}
	public void nextHandler(JPanel questionPanel) throws RemoteException {
		if (++qindex < test.getQuestionCount()) {
			createQuestionPanel(questionPanel);
		} else {
			createScorePanel(questionPanel);
		}
	}
	public void setNextButton(javax.swing.JButton newNextButton) {
		nextButton = newNextButton;
	}
	public void startWatchDog(JPanel panel, JLabel remaining)
		throws RemoteException {
		final JPanel questionPanel = panel;
		JButton score = new JButton("Score");
		score.setBounds(0, 0, 0, 0);
		score.setVisible(false);
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				try {
					createScorePanel(questionPanel);
					System.out.println("Time limit exeeded");
				} catch (RemoteException e) {
					System.out.println(e);
				}
			}
		});
		TimeLimitThreadImpl watchDog =
			new TimeLimitThreadImpl(getStopTime(), remaining, score);
		Thread thread = new Thread(watchDog);
		thread.setName("DEDS Timer");
		thread.start();
	}
	public java.util.Date getStopTime() throws RemoteException {
		return new Date(
			System.currentTimeMillis()
				+ test.getLimitSeconds() * Constants.SECONDMILLIS);
	}
}
