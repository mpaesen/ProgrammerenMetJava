package jSrc.ch12b;

import javax.swing.*;
import java.awt.*;

public class DisplayWindow extends JDialog
                           implements CommonButtonInterface
{
    private CommonButtons buttons;
    private FrameListener closer;
    private JList         carList;
    private DefaultListModel listModel;
    private RentalGUI     mainWindow;
    private RentalMethods rental;

    public DisplayWindow(JFrame parent)
    {
        super(parent, "Display Rented Cars", true);
        mainWindow = (RentalGUI)parent;
        rental = mainWindow.getRentalObject();
        getContentPane().setLayout(new BorderLayout());

        buttons = new CommonButtons(this);
        buttons.setOKButtonText("OK");
        getContentPane().add(buttons,BorderLayout.SOUTH);

        listModel = new DefaultListModel();
        carList = new JList(listModel);
        carList.setVisibleRowCount(10);
        EnumerateRentedCars enum = rental.getRentedEnumeration();
        while (enum.hasMoreElements())
           listModel.addElement((String)enum.nextElement())
        getContentPane().add(new JScrollPane(carList),
                             BorderLayout.CENTER);

        closer = new FrameListener(this,false);
        addWindowListener(closer);
        setLocation(300,200);
        pack();
    }

    public void okPressed()
    {
        closer.closeWindow();
    }

    public void cancelPressed()
    {
        closer.closeWindow();
    }

} // end DisplayWindow class
