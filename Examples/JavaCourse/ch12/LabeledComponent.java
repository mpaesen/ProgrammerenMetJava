/* Generated by Together */
package ch12;

import javax.swing.*;
import java.awt.*;

public class LabeledComponent extends JPanel {
    public LabeledComponent(JLabel label, JComponent object) {
        setLayout(new GridLayout(1, 2));
        add(label);
        add(object);
    }
}