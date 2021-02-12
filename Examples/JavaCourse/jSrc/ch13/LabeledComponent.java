package jSrc.ch13;

import javax.swing.*;
import java.awt.*;

public class LabeledComponent extends JPanel
{
    public LabeledComponent(JLabel label, JComponent object)
    {
        super();
        setLayout(new GridLayout(1,2));
        add(label);
        add(object);
    }
}

