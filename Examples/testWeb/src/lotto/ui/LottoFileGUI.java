package lotto.ui;

import lotto.model.LottoCombination;
import utilities.ConsoleGUI;
import utilities.FileIO;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

/** implementation of a file acces program */
public class LottoFileGUI {
	private static Random rnd = new Random(); // random generator
	private String fileIn, fileOut;
	private int maximum, numberOfElements;
	private BufferedWriter out;
	private BufferedReader in;

	public int giveANumberBetweenMinAndMax(String str, int min, int max) {
		int number = 0;
		do {
			number = ConsoleGUI.readInt(str);
		} while (number < min || number > max);
		// number of elements must be greater then min and lesser than max
		return number;
	}

	public void run() {
		maximum = giveANumberBetweenMinAndMax(
				"Welk is het maximum te genereren getal? (min 10, max 42) ",
				10, 42);
		numberOfElements = giveANumberBetweenMinAndMax(
				"Hoeveel combinaties wenst u te genereren? (min 1) ", 1,
				Integer.MAX_VALUE);
		generateTextFile();
		showFileContent(fileIn);
	}

	private void showFileContent(String file) {

		try {
			in = FileIO.getInputFileByName(file);

			JTextArea output = new JTextArea("Er werden " + numberOfElements
					+ " combinaties gegenereerd:\n");
			output.setFont(new Font("Verdana", Font.PLAIN, 12));
			output.append("\n");
			String combinatie;
			StringBuffer line = null;
			for (int i = 0; i < numberOfElements; i++) {
				combinatie = in.readLine();
				line = drawLine(combinatie, line);
				output.append(combinatie + "\n");
			}
			output.append(line + "\n");
			ConsoleGUI.write(output, "LottoCombinaties");
			in.close();
		} catch (FileNotFoundException exception) {
			ConsoleGUI.write("File not found");
		} catch (IOException exception) {
			ConsoleGUI.write("No elements found!");
		} catch (Exception exception) {
			ConsoleGUI.write("Unexpeced exeption found!");
		}
	}

	private StringBuffer drawLine(String combinatie, StringBuffer line) {
		if (line == null) {
			line = new StringBuffer(combinatie.length());
			for (int j = 0; j < combinatie.length(); j++, line.append("_"))
				;
		}
		return line;
	}

	private void generateTextFile() {

		try {
			fileIn = fileOut = ConsoleGUI.readString("Output File name");
			out = FileIO.getOutputFileByName(fileOut);

			for (int i = 0; i < numberOfElements; i++) {
				out.write(new LottoCombination(rnd, maximum).toString() + "\n");
			}
			out.close();

		} catch (FileNotFoundException e) {
			ConsoleGUI.write("File not found");
		} catch (IOException e) {
			ConsoleGUI.write("No elements found!");
		} catch (Exception e) {
			ConsoleGUI.write("Unexpeced exeption found!");
		}

	}

}
