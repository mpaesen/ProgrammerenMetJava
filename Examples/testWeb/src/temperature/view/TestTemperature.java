package temperature.view;

import temperature.model.Conversion;
import temperature.model.Temperature;

import javax.swing.*;

/**
 * @purpose all user dialogs
 * @autor Mathy Paesen
 * @version 1.0
 */
public class TestTemperature {
	public static void main(String[] args) {
		char inputValue;
		Temperature temp1, temp2, result;
		do {
			inputValue = TestTemperature
					.getChoice("What do you want to do?\nC(Converion)\nA(Addition)\n\nQ(Quit)");
			if (inputValue == Temperature.CONVERSION) {
				inputValue = TestTemperature
						.getSymbolInput("Temperature in \nK(Kelvin)\nF(Farenheit)\nC(elcius)\n\nQ(Quit)");
				temp1 = Conversion.getInitialTemperature(inputValue);
				inputValue = TestTemperature
						.getSymbolInput("Conversion to \nK(Kelvin)\nF(Farenheit)\nC(elcius)\n\nQ(Quit)");
				temp2 = Conversion.convertInitialTemperature(temp1, inputValue);
				JOptionPane.showMessageDialog(null, temp1.toString() + " = "
						+ temp2.toString(), "Temperature",
						JOptionPane.ERROR_MESSAGE);
			} else {
				inputValue = TestTemperature
						.getSymbolInput("First Temperature in \nK(Kelvin)\nF(Farenheit)\nC(elcius)\n\nQ(Quit)");
				temp1 = Conversion.getInitialTemperature(inputValue);
				inputValue = TestTemperature
						.getSymbolInput("Second Temperature in \nK(Kelvin)\nF(Farenheit)\nC(elcius)\n\nQ(Quit)");
				temp2 = Conversion.getInitialTemperature(inputValue);
				inputValue = TestTemperature
						.getSymbolInput("Result Temperature in \nK(Kelvin)\nF(Farenheit)\nC(elcius)\n\nQ(Quit)");
				result = Conversion.add(temp1, temp2, inputValue);
				JOptionPane.showMessageDialog(null, temp1.toString() + " + "
						+ temp2.toString() + " = " + result.toString(),
						"Temperature", JOptionPane.ERROR_MESSAGE);
			}
		} while (true);
	}

	/**
	 * @purpose let the user choose between Conversion & Addition
	 * @autor Mathy paesen
	 * @param String
	 *            (user's choices)
	 * @return char
	 */
	public static char getChoice(String choice) {
		char inputValue;
		do {
			inputValue = Character.toUpperCase((JOptionPane
					.showInputDialog(choice)).charAt(0));
		} while ((inputValue != Temperature.CONVERSION)
				&& (inputValue != Temperature.ADDITION) && (inputValue != 'Q'));
		if (inputValue == 'Q')
			System.exit(0);
		return inputValue;
	}

	/**
	 * @purpose get the temperature (symbol) choice
	 * @autor Mathy paesen
	 * @param String
	 *            (user's choices)
	 * @return char
	 */
	public static char getSymbolInput(String choice) {
		char inputValue;
		do {
			inputValue = Character.toUpperCase((JOptionPane
					.showInputDialog(choice)).charAt(0));
		} while ((inputValue != Temperature.CELCIUS)
				&& (inputValue != Temperature.FARENHEIT)
				&& (inputValue != Temperature.KELVIN) && (inputValue != 'Q'));
		if (inputValue == 'Q')
			System.exit(0);
		return inputValue;
	}

	/**
	 * @purpose get the temperature value
	 * @autor Mathy paesen
	 * @param String
	 *            (temperature)
	 * @return String
	 */
	public static double getTemperatureInput(String temperature) {
		String stringValue;
		double doubleValue = 0.0;
		boolean isNumber = false;
		do {
			stringValue = JOptionPane.showInputDialog(temperature);
			try {
				doubleValue = Double.parseDouble(stringValue);
				isNumber = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Give a number please!",
						"No Number!", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (!isNumber);
		return doubleValue;
	}
}