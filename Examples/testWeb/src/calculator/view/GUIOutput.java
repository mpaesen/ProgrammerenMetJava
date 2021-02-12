package calculator.view;

import javax.swing.*;

public class GUIOutput
{
	public GUIOutput() {
	}
	
	public void showResult(String result) {
		JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.PLAIN_MESSAGE);
	}
}