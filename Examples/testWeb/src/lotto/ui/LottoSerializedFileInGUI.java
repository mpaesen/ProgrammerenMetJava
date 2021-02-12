/*
 * Created on Oct 20, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lotto.ui;

import lotto.db.LottoSerializedFileIn;
import lotto.model.LottoCombination;
import utilities.ConsoleGUI;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author bempn
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LottoSerializedFileInGUI {
	public static void showInput(LottoSerializedFileIn in) throws IOException,
			FileNotFoundException, ClassNotFoundException {
		String inputStream = ConsoleGUI.readString("\nInput File: ");
		ArrayList serializedList = in.getSerializedList(inputStream);
		ConsoleGUI.write("\n" + serializedList.size()
				+ " lottocombinations have been read from disk:\n");
		in.fillUp(serializedList);
		JTextArea output;
		if (!in.getUniek().isEmpty()) {
			output = new JTextArea("Combinations found more than ones:\n");
			output.append("Combinations\t\t#\n");
			LottoCombination actueelElement;
			for (Iterator enumeration = in.getUniek().iterator(); enumeration
					.hasNext();) {
				actueelElement = (LottoCombination) enumeration.next();
				output.append(actueelElement.toString()
						+ "\t"
						+ ((Integer) in.getCount().get(
								in.getUniek().indexOf(actueelElement)))
								.intValue() + "\n");
			}
			ConsoleGUI.write(output, "Unieke combinaties");
		} else
			ConsoleGUI.write("None of the combinations exists more than ones");
	}

	public void run() {
		LottoSerializedFileIn in = new LottoSerializedFileIn();
		try {
			showInput(in);
		} catch (FileNotFoundException e) {
			ConsoleGUI.write("File not found");
		} catch (IOException e) {
			ConsoleGUI.write("IO ERROR!");
		} catch (Exception e) {
			ConsoleGUI.write("no elements found");
		}
	}

}
