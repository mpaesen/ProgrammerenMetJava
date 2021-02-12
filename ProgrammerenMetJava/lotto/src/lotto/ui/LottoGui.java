package lotto.ui;

import lotto.db.LottoSerializedFileIn;
import lotto.db.LottoSerializedFileOut;
import lotto.model.LottoCombination;
import utilities.ConsoleGUI;
import utilities.FileIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class LottoGui extends JFrame {
	/*
	 * constants
	 */
	private static final long serialVersionUID = 1L;
	private static final int MAX_BOVEN_LIMIET = 50;
	public static final int MAX_COMBINATIE_LIMIET = 10;
	private static final int MAX_COMBINATIES_LIMIET = 10000;
	private static final int MAX_ONDER_LIMIET = 10;
	private static final int MIN_BOVEN_LIMIET = 15;
	public static final int MIN_COMBINATIE_LIMIET = 4;
	private static final int MIN_COMBINATIES_LIMIET = 20;
	private static final int MIN_ONDER_LIMIET = 1;
	/*
	 * displayfields
	 */
	private JTextField minField, maxField, elementsInCombinationField,
			numberOfCombinationsField;
	private JLabel minLabel, maxLabel, elementsInCombinationLabel,
			numberOfCombinationsLabel;
	private JTextArea area;
	private ArrayList <LottoCombination>list;
	private JButton generateButton, saveButton, loadButton, verifyButton;
	private JScrollPane pane;
	/*
	 * variables
	 */
	private final Random rnd = new Random();
	private int min, max, elementsInCombination, numberOfCombinations;
	private File fileName;
	private LottoSerializedFileIn input;
	private LottoSerializedFileOut output;
	
	// INNER CLASSES
	/**
	 * @author bempn
	 *
	 */
	private class GenerateListener implements ActionListener {
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent arg0)  {
			// Write the code that should be performed when
			// the generate button is pressed here
			if (validateData()) {
				area.setText("");
				area.append("Generate button pressed\n");
				numberOfCombinations = Integer
						.parseInt(numberOfCombinationsField.getText());
				max = Integer.parseInt(maxField.getText());
				LottoCombination combination = null;
				list = new ArrayList<LottoCombination>(numberOfCombinations);
				try {
					for (int i = 0; i < numberOfCombinations; i++) {
						combination = new LottoCombination(rnd, getMin(),
								getMax(), elementsInCombination);
						list.add(combination);

					}
				}catch(BadLimitException e){
					e.printStackTrace();
				}
				Collections.sort(list);
				for (int i = 0; i < numberOfCombinations; i++) {
					area.append(list.get(i) + "\n");
				}
				area.append("\n" + list.size()
						+ " combinations have been generated!");
			}
			setInput();
		}
	}

	/**
	 * @author bempn
	 * 
	 */
	private class LoadListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// Write the code that should be performed when
			// the load button is pressed here
			area.setText("");
			resetScreenFields();
			area.append("Load button pressed\n");
			openSerializedFile();
			list = getInputStreamList();
			if (list == null) {
				area.append("\nList not loaded, please try again!");
			}
			else{

				area.append("Uw cijfers!\n");
				Iterator<LottoCombination> it = list.iterator();
				Object obj = null;
				while (it.hasNext()) {
					obj = it.next();
					if (!validData())
						fillScreenFields((LottoCombination) obj);
					area.append(obj.toString() + "\n");
				}

				area.append(list.size() + " combinations have been read from disk:\n");
			}
		}
	}

	/**
	 * @author bempn
	 * 
	 */
	private class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// Write the code that should be performed when
			// the save button is pressed here
			if (listEmpty()) {
				LottoGui.this
						.errorMessage(
								"First load or generate the combinations!",
								"Combinations");
				return;
			}
			// area.setText("");
			area.append("\nSave button pressed\n");
			saveSerializedFile(list);
			area.append(list.size()
					+ " combinations have been written to disk:\n");
		}
	}



	/**
	 * @author bempn
	 * 
	 */
	private class VerifyListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// make sure min, max, numbersInCombination and a valid collection
			// are specified
			validateData();
			if (listEmpty()) {
				LottoGui.this
						.errorMessage(
								"First load or generate the combinations!",
								"Combinations");
			}
			VerifyDialog dialog = new VerifyDialog(LottoGui.this, list);
			dialog.setModal(true);
			dialog.setVisible(true);
		}
	}

	// constructors
	public LottoGui() {
		super();
		initializeComponents();
		addActionListeners();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 480);
		setVisible(true);
	}

	public LottoGui(String title) {
		super(title);
		initializeComponents();
		addActionListeners();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 480);
		setVisible(true);
	}

	private void addActionListeners() {
		generateButton.addActionListener(new GenerateListener());
		saveButton.addActionListener(new SaveListener());
		loadButton.addActionListener(new LoadListener());
		verifyButton.addActionListener(new VerifyListener());
	}

	private JScrollPane createResultArea() {
		// set up display area
		area = new JTextArea();
		area.setEditable(false);
		return new JScrollPane(area);
	}

	private void errorMessage(String text, String titel) {
		JOptionPane.showMessageDialog(LottoGui.this, text, titel,
				JOptionPane.ERROR_MESSAGE);
	}

	public int getAmountInCombination() {
		// return amountInCombination;
		return elementsInCombination;
	}

	private ArrayList<LottoCombination> getInputStreamList() {
		ArrayList<LottoCombination> list = null;
		try {
			list = input.getSerializedList(fileName.getName());
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Error on reading "
					+ fileName.getName(), "File Not Found",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane
					.showMessageDialog(this, "Error on reading "
							+ fileName.getName(), "IO Error",
							JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Error on reading "
					+ fileName.getName(), "Class Not Found",
					JOptionPane.ERROR_MESSAGE);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(this, "Error on reading "
							, "No serialized file selected!",
					JOptionPane.ERROR_MESSAGE);
		}
		return list;

	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

	// public methods
	/**
	 * @return
	 */
	public int getNumberOfCombinations() {
		return numberOfCombinations;
	}

	private void initializeComponents() {
		// main panel
		JPanel content = (JPanel) this.getContentPane();
		// use a borderlayout for the main panel
		content.setLayout(new BorderLayout());

		// two panels with flowlayout
		JPanel northPanel = new JPanel(new FlowLayout());
		JPanel southPanel = new JPanel(new FlowLayout());

		// labels
		minLabel = new JLabel("Minimum value: ");
		maxLabel = new JLabel("Maximum value: ");
		elementsInCombinationLabel = new JLabel("Elements in a combination:");
		numberOfCombinationsLabel = new JLabel("Number of combinations: ");

		// textfields
		minField = new JTextField(2);
		maxField = new JTextField(2);
		elementsInCombinationField = new JTextField(4);
		numberOfCombinationsField = new JTextField(4);

		// textarea
		// area = new JTextArea();

		// scrollpane so that the textarea allows scrolling
		pane = new JScrollPane(createResultArea());

		// buttons
		generateButton = new JButton("Generate combinations");
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		verifyButton = new JButton("Verify");

		// fill the northPanel
		northPanel.add(minLabel);
		northPanel.add(minField);
		northPanel.add(maxLabel);
		northPanel.add(maxField);
		northPanel.add(elementsInCombinationLabel);
		northPanel.add(elementsInCombinationField);
		northPanel.add(numberOfCombinationsLabel);
		northPanel.add(numberOfCombinationsField);

		// fill the southPanel
		southPanel.add(generateButton);
		southPanel.add(saveButton);
		southPanel.add(loadButton);
		southPanel.add(verifyButton);

		// add the panels and the textarea to the main panel
		content.add(northPanel, BorderLayout.NORTH);
		content.add(southPanel, BorderLayout.SOUTH);
		content.add(pane, BorderLayout.CENTER);
	}

	// private methods
	/**
	 * @return
	 */
	private boolean listEmpty() {
		return list == null;
	}

	
	/**
	 * enable user to choose file to open 
	 */
	private void openSerializedFile() {
		// display dialog, so user can choose file
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int result = fileChooser.showOpenDialog(this);

		// if user clicked Cancel button on dialog, return
		if (result == JFileChooser.CANCEL_OPTION)
			return;

		fileName = fileChooser.getSelectedFile(); // obtain selected file

		if (fileName == null || fileName.getName().equals(""))
			JOptionPane.showMessageDialog(this, "Invalid File Name",
					"Invalid File Name", JOptionPane.ERROR_MESSAGE);

		setInput();

	}

	/**
	 * 
	 */
	private void setInput() {
		try {

			if (input != null)
				input.close();
			input = new LottoSerializedFileIn();
		} catch (IOException ioException) {
			JOptionPane.showMessageDialog(this, "File does not exist",
					"Invalid File Name", JOptionPane.ERROR_MESSAGE);
		}
	} // end method openFile

	// enable user to choose file to open
	/**
	 * @param list
	 */

	private void saveSerializedFile(ArrayList <LottoCombination>list) {
		// display dialog, so user can choose file
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		  int result = fileChooser.showOpenDialog(this);

		  // if user clicked Cancel button on dialog, return
		  if (result == JFileChooser.CANCEL_OPTION)
		   return;
		fileName = fileChooser.getSelectedFile(); // obtain selected file

		try {
			output = new LottoSerializedFileOut();
			output.setOutput(FileIO.getObjectOutputStream(fileName.getName()));
			output.streamSerializedList(list);
		} catch (NullPointerException e) {
			ConsoleGUI.write(e.getMessage());

		} catch (IOException e) {
			ConsoleGUI.write(e.getMessage());
		} catch (BadLimitException e) {
			ConsoleGUI.write(e.getMessage());
		}

	} // end method openFile

	/**
	 * @param i
	 */
	public void setNumberOfCombinations(int i) {
		numberOfCombinations = i;
	}

	/**
	 * @return
	 */
	public boolean testElementsInCombinationField() {
		String number = elementsInCombinationField.getText();
		try {
			elementsInCombination = Integer.parseInt(number);
			return (elementsInCombination >= MIN_COMBINATIE_LIMIET)
					&& (elementsInCombination <= MAX_COMBINATIE_LIMIET);
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * @return
	 */
	public boolean testMaxField() {
		String number = maxField.getText();
		try {
			max = Integer.parseInt(number);
			return (max >= MIN_BOVEN_LIMIET) && (max <= MAX_BOVEN_LIMIET);
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * @return
	 */
	public boolean testMinField() {
		String number = minField.getText();
		try {
			min = Integer.parseInt(number);
			return (min >= MIN_ONDER_LIMIET) && (min <= MAX_ONDER_LIMIET);
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * @return
	 */
	public boolean testNumbersInCombination() {
		String number = numberOfCombinationsField.getText();
		try {
			numberOfCombinations = Integer.parseInt(number);
			return (numberOfCombinations >= MIN_COMBINATIES_LIMIET)
					&& (numberOfCombinations <= MAX_COMBINATIES_LIMIET);
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * @param obj
	 */
	private void fillScreenFields(LottoCombination obj) {

		elementsInCombinationField.setText(Integer.toString(obj
				.getElementsInCombination()));
		numberOfCombinationsField.setText(Integer.toString(list.size()));
		minField.setText(Integer.toString(obj.getMinimumValue()));
		maxField.setText(Integer.toString(obj.getMaximumValue()));
	}

	private void resetScreenFields() {

		elementsInCombinationField.setText("");
		numberOfCombinationsField.setText("");
		minField.setText("");
		maxField.setText("");
	}
	/**
	 * @return
	 */
	public boolean validData() {
		if (!testMinField()) {
			return false;
		}

		if (!testMaxField()) {
			return false;
		}

		if (!testElementsInCombinationField()) {
			return false;
		}

		return testNumbersInCombination();
	}

	/**
	 * @return
	 */
	public boolean validateData() {
		if (!testMinField()) {
			errorMessage("Min is a positive figure between "
					+ MIN_ONDER_LIMIET + " en " + MAX_ONDER_LIMIET,
					"Minimum control");
			minField.setText("");
			minField.grabFocus();
			return false;
		}

		if (!testMaxField()) {
			errorMessage("Max is a positive figure between "
					+ MIN_BOVEN_LIMIET + " en " + MAX_BOVEN_LIMIET,
					"Maximum control");
			maxField.setText("");
			maxField.grabFocus();
			return false;
		}

		if (!testElementsInCombinationField()) {
			errorMessage("Elements is a positive figure between "
					+ MIN_COMBINATIE_LIMIET + " en " + MAX_COMBINATIE_LIMIET,
					"Elements control");
			elementsInCombinationField.setText("");
			elementsInCombinationField.grabFocus();
			return false;
		}

		if (!testNumbersInCombination()) {
			errorMessage("Combination is a positive figure between "
					+ MIN_COMBINATIES_LIMIET + " en " + MAX_COMBINATIES_LIMIET,
					"Combinatie control");
			numberOfCombinationsField.setText("");
			numberOfCombinationsField.grabFocus();
			return false;
		}

		return true;
	}

	/**
	 * @return
	 */
	public LottoSerializedFileIn getInput() {
		return input;
	}

	/**
	 * @return
	 */
	public LottoSerializedFileOut getOutput() {
		return output;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LottoGui();
	}

}
