package lotto.ui;

import lotto.model.BadLimitException;
import lotto.model.LottoCombination;
import utilities.ConsoleGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class VerifyDialog extends JDialog {

	private JTextArea area;
	private LottoCombination combinatie;
	private Collection combinations;
	private JButton generateButton, verifyButton;

	private JLabel infoLabel;
	private JScrollPane pane;
	private LottoGui parent;

	private ArrayList textFields;

	private class GenerateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// code for the Generate button behaviour
			try {
				combinatie = new LottoCombination(new Random(),
						parent.getMin(), parent.getMax(), parent
								.getAmountInCombination());
			} catch (BadLimitException exc) {
				ConsoleGUI.write(exc.getMessage());
			}
			for (int i = 0; i < parent.getAmountInCombination(); i++) {
				((JTextField) textFields.get(i)).setText(Integer
						.toString(combinatie.getCombination()[i]));
			}
		}
	} // end inner class GenerateListener

	private class VerifyListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// code for the Verify button behaviour
			try {
				getCombination();
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(VerifyDialog.this,
						"Fill all the fields with a number between "
								+ parent.getMin() + " and " + parent.getMax()
								+ " or press the Generate button", "Error!",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (checkCombination((ArrayList) combinations, combinatie))
				JOptionPane.showMessageDialog(VerifyDialog.this, "Gewonnen");
			else
				JOptionPane.showMessageDialog(VerifyDialog.this, "Verloren");
		}
	} // end inner class VerifyListener

	public VerifyDialog(LottoGui parent, Collection combinations) {
		super(parent, "Verify combinations");

		this.parent = parent;
		this.combinations = combinations;
		parent.getInput().fillUp(new ArrayList(combinations));
		this.textFields = new ArrayList();
		initializeComponents();
		addActionListeners();
		setSize(600, 350);
		// pack();
	}

	public JTextArea showNonUniqueCombinations() {
		JTextArea area = null;

		if (!parent.getInput().getUniek().isEmpty()) {
			area = new JTextArea(parent.getInput().getUniek().size()
					+ " combinations are not unique!\n\n");
			area.append("Combinations\t\t#\n");
			area.append("____________\t\t_\n\n");
			LottoCombination actueelElement;
			for (Iterator enumeration = parent.getInput().getUniek().iterator(); enumeration
					.hasNext();) {
				actueelElement = (LottoCombination) enumeration.next();
				area.append(actueelElement.toString()
						+ "\t"
						+ ((Integer) parent.getInput().getCount().get(
								parent.getInput().getUniek().indexOf(
										actueelElement))).intValue() + "\n");
			}
			area.append("____________\t\t_\n");
		} else
			area = new JTextArea(
					"\nNone of the combinations exists more than ones!");
		return area;
	}

	private boolean testCombination() {
		String number = null;
		for (int i = 0; i < parent.getAmountInCombination(); i++) {
			number = ((JTextField) textFields.get(i)).getText();
			try {
				return (Integer.parseInt(number) >= LottoGui.MIN_COMBINATIE_LIMIET)
						&& (Integer.parseInt(number) <= LottoGui.MAX_COMBINATIE_LIMIET);
			} catch (NumberFormatException e) {

			}
		}
		return false;
	}

	private void addActionListeners() {
		generateButton.addActionListener(new GenerateListener());
		verifyButton.addActionListener(new VerifyListener());
	}

	private boolean checkCombination(ArrayList list, LottoCombination combinatie) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				combinatie.sort();
				if (list.get(i).equals(combinatie)) {
					return true;
				}
			}
		}
		return false;
	}

	private void getCombination() throws NumberFormatException {
		Object[] cijfers = textFields.toArray();
		for (int i = 0; i < cijfers.length; i++) {
			combinatie.setCombination(i, Integer
					.parseInt(((JTextField) cijfers[i]).getText()));
		}
	}

	private void initializeComponents() {
		JPanel content = (JPanel) getContentPane();
		content.setLayout(new BorderLayout());

		JPanel northPanel = new JPanel(new FlowLayout());
		JPanel westPanel = new JPanel(new GridLayout(6, 0));
		JPanel southPanel = new JPanel(new FlowLayout());

		infoLabel = new JLabel("Fill all the fields with a number between "
				+ parent.getMin() + " and " + parent.getMax()
				+ " or press the Generate button");
		northPanel.add(infoLabel);

		// generate a textfield for each number in the combination
		for (int i = 0; i < parent.getAmountInCombination(); i++) {
			JPanel panel = new JPanel(new FlowLayout());
			JTextField field = new JTextField(2);
			textFields.add(field);
			panel.add(field);
			westPanel.add(panel);
		}

		generateButton = new JButton("Generate");
		verifyButton = new JButton("Verify");

		southPanel.add(generateButton);
		southPanel.add(verifyButton);

		area = showNonUniqueCombinations();
		pane = new JScrollPane(area);

		// add to main panel
		content.add(northPanel, BorderLayout.NORTH);
		content.add(southPanel, BorderLayout.SOUTH);
		content.add(westPanel, BorderLayout.WEST);
		content.add(pane, BorderLayout.CENTER);
	}
}