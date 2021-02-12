/*
 * Created on Oct 19, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lotto;

import lotto.model.BadLimitException;
import lotto.ui.*;
import utilities.ConsoleGUI;

/**
 * @author bempn
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LottoTest {

	public static void main(String[] args) {
		int choice;

		do {
			choice = ConsoleGUI
					.readInt("Wat wil je doen?\n\t1=Textfile genereren\n\t2=File Serialiseren\n\t3=Geserialiseerde File Inlezen\n\t (en unieke combinaties zoeken\n\t  die meer dan eens voorkomen)\n\t4=Kontroleer uw combinatie \n  met de trekking!");
			switch (choice) {
			case 1: {
				new LottoTextFileOutGUI().run();
				break;
			}
			case 2: {
				new LottoSerializedFileOutGUI().run();
				break;
			}
			case 3: {
				new LottoSerializedFileInGUI().run();
				break;
			}
			case 4: {
				try {
					new LottoControleGUI().run();
				} catch (BadLimitException e) {
					ConsoleGUI.write(e.getMessage());
				}
				break;
			}
			case 5: {
				new LottoGui();
				break;
			}

			}
		} while (ConsoleGUI.nog("Nogmaals?") == 0);
		System.exit(0);
	}
}
