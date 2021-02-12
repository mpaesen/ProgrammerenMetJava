package lab7.control;


import lab7.model.CertTest;
import lab7.model.Choice;
import lab7.model.Question;
import lab7.model.Testable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public void choiceHandler(Question question, int choiceIndex) {
	Choice choice = question.getChoice(choiceIndex);
	question.resetAllPicks();
	choice.setPicked(true);
}
public void createQuestionPanel(JPanel panel) {

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
				int cindex2 = Integer.parseInt(e.getActionCommand());
				System.out.println("Action command: " + cindex2);
				choiceHandler(question, cindex2);
			}
		});
	}
	// Re-layout box parent contents, repaint
	panel.getParent().validate();
}
public void createScorePanel(JPanel panel) {
	int score = test.computeScore();
	int threshold = test.getPassThreshold();
	int total = test.getQuestionCount();

	// Erase question panel, repaint
	panel.removeAll();
	panel.getParent().validate();

	JLabel pass = new JLabel();
	panel.add(pass);

	if(test instanceof CertTest) {
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
public void nextHandler(JPanel questionPanel) {
	if (++qindex < test.getQuestionCount()) {
		createQuestionPanel(questionPanel);
	} else {
		createScorePanel(questionPanel);
	}
}
public void setNextButton(javax.swing.JButton newNextButton) {
	nextButton = newNextButton;
}
}
