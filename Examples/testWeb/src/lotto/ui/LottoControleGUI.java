/*
 * Created on Oct 26, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lotto.ui;

import lotto.db.LottoSerializedFileIn;
import lotto.model.BadLimitException;
import lotto.model.LottoCombination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * @author bempn
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LottoControleGUI extends JFrame {
	private JTextArea lottoCombinaties;
	private JTextField cijfers[] = new JTextField[6];
	private JButton validate = new JButton("Validate");
	private JButton exit = new JButton("Exit");
	private JPanel topPanel, figurePanel, buttonPanel;
	private JScrollPane scroller;
	private Container container;
	private JLabel trekking = new JLabel("Trekking!");

	private LottoSerializedFileIn input;
	private File fileName;
	private ArrayList list;
	private DecimalFormat twoDigits = new DecimalFormat("00");
	private LottoCombination combinatie;
	private boolean stop;

	// set up GUI
	public LottoControleGUI() throws BadLimitException {
		super("Lotto Controller");
		combinatie = new LottoCombination(new Random(), 42);
		initializeVisableComponents();
	}

	private void initializeVisableComponents() {
		container = getContentPane();
		topPanel = createFigures();
		container.add(topPanel, BorderLayout.NORTH);
		scroller = createResultArea();
		container.add(scroller, BorderLayout.CENTER);
		buttonPanel = createButtons();
		container.add(buttonPanel, BorderLayout.SOUTH);
		registerWindowListener();
	}

	private JPanel createFigures() {
		figurePanel = new JPanel(); // set up panel for figures
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		figurePanel.setLayout(new GridLayout(1, 6));
		topPanel.add(trekking, BorderLayout.NORTH);
		topPanel.add(figurePanel, BorderLayout.CENTER);
		for (int i = 0; i < cijfers.length; i++) {
			cijfers[i] = new JTextField(2);
			cijfers[i].setFont(new Font("Arial", Font.BOLD, 14));
			cijfers[i].setBackground(Color.cyan);
			cijfers[i].setText(Integer.toString(combinatie.getCombination(i)));
			figurePanel.add(cijfers[i]);
		}
		return topPanel;
	}

	private JScrollPane createResultArea() {
		// set up display area
		lottoCombinaties = new JTextArea();
		lottoCombinaties.setEditable(false);
		return new JScrollPane(lottoCombinaties);
	}

	private JPanel createButtons() {
		// register validate listener
		validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				geefCombinatie();
				if (checkFigure(list, combinatie))
					JOptionPane.showMessageDialog(container, "Gewonnen");
				else
					JOptionPane.showMessageDialog(container, "Verloren");
			}
		});
		// register exit listener
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				closeFile();
			}
		} // end anonymous inner class
				);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(validate);
		buttonPanel.add(exit);
		return buttonPanel;
	}

	private void registerWindowListener() {
		// register window listener
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				closeFile();
			}
		} // end anonymous inner class
		); // end call to addWindowListener
	}

	// close file before application terminates
	private void closeFile() {
		// close file
		try {
			if (input != null)
				input.close();
		}
		// process exception from closing file
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(this, "Error closing file", "Error",
					JOptionPane.ERROR_MESSAGE);

		} finally {
			dispose();
			stop = true;
			System.exit(0);
		}
	}

	private boolean checkFigure(ArrayList list, LottoCombination combinatie) {
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

	private void geefCombinatie() throws NumberFormatException {
		for (int i = 0; i < cijfers.length; i++) {
			combinatie
					.setCombination(i, Integer.parseInt(cijfers[i].getText()));
		}
	}

	private ArrayList getInputStreamList() {
		ArrayList list = null;
		try {
			list = input.getSerializedList(fileName.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;

	}

	public void run() {
		openSerializedFile();
		list = getInputStreamList();
		lottoCombinaties.append("Uw cijfers!\n");
		Iterator en = list.iterator();
		while (en.hasNext())
			lottoCombinaties.append(en.next().toString() + "\n");
		lottoCombinaties.append("\nEinde!");
		pack(); // pack components and display window
		setSize(160, 350);
		setVisible(true);
		while (!stop)
			;

	}

	// enable user to choose file to open
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

		try {

			if (input != null)
				input.close();
			input = new LottoSerializedFileIn();
		} catch (IOException ioException) {
			JOptionPane.showMessageDialog(this, "File does not exist",
					"Invalid File Name", JOptionPane.ERROR_MESSAGE);
		}

	} // end method openFile

}
