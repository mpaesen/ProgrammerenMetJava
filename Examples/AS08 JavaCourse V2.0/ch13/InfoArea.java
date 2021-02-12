package ch13;

import javax.swing.*;
import java.awt.*;

public class InfoArea extends JTextField {
    public InfoArea() {
        setBackground(Color.cyan);
        setEditable(false);
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public void setText(String text) {
        super.setText(text);
        setCaretPosition(0); // move cursor back to column 1
    }
}
