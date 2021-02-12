/*
 * Created on Oct 20, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lotto.ui;

import lotto.db.LottoSerializedFileOut;
import utilities.ConsoleGUI;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author bempn
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LottoSerializedFileOutGUI {

	public void run() throws NumberFormatException {
		int numberOfElements, MAX;

		numberOfElements = ConsoleGUI.readInt("Aantal Elementen:");
		MAX = ConsoleGUI.readInt("Max te genereren getal:");

		LottoSerializedFileOut output = new LottoSerializedFileOut(
				numberOfElements, MAX);
		try {
			output.generateSerializedList(ConsoleGUI.readString("\nFile: "));
			ConsoleGUI.write("\n" + output.getNumberOfElements()
					+ " combinations have been written to disk:\n");
		} catch (FileNotFoundException e) {
			ConsoleGUI.write("File not found");
		} catch (IOException e) {
			ConsoleGUI.write(e.getMessage());
		} catch (Exception e) {
			ConsoleGUI.write("no elements found");
		}
	}

}
