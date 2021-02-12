/**
 *
 */
package view;

import model.Rekening;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * @author mpaesen
 */
public class TestRekening {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        char  input = 'J'; //variabele
        String userInput;
        Rekening rekening;
        final Random random = new Random();
        do {
            rekening = new Rekening(100 + Math.abs(random.nextInt(900)),
                    Math.abs(random.nextInt(500)),
                    200 + Math.abs(random.nextInt(450)),
                    Math.abs(random.nextInt(750)));
            JOptionPane.showMessageDialog(null, rekening.getCurrentStatus());
            userInput = JOptionPane.showInputDialog("Nog een Rekening? (J/N):"); //String
            input = userInput.charAt(0);
        }
        while (Character.toUpperCase(input) == 'J');
    }
}
