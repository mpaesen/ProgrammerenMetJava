/* Generated by Together */
package ch12;

import javax.swing.*;
import java.awt.*;

public class RentWindow extends JDialog implements CommonButtonInterface {
    public RentWindow(JFrame parent) {
        super(parent, "Rent A Car", true);
        mainWindow = (RentalGUI)parent;
        rental = mainWindow.getRentalObject();
        getContentPane().setLayout(new BorderLayout());
        buttons = new CommonButtons(this);
        buttons.setOKButtonText("Rent");
        infoArea = new InfoArea();
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 1));
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));
        bg = new ButtonGroup();
        economyRB = new JRadioButton("Economy", true);
        midsizeRB = new JRadioButton("Midsize");
        luxuryRB = new JRadioButton("Luxury");
        JPanel rbPanel = new JPanel();
        rbPanel.setLayout(new GridLayout(1, 3));
        bg.add(economyRB);
        bg.add(midsizeRB);
        bg.add(luxuryRB);
        rbPanel.add(economyRB);
        rbPanel.add(midsizeRB);
        rbPanel.add(luxuryRB);
        mainPanel.add(rbPanel);
        colorLabel = new JLabel("Color");
        makeLabel = new JLabel("Make");
        colorChoice = new JComboBox(colors);
        colorChoice.setEditable(false);
        makeChoice = new JComboBox(makes);
        makeChoice.setEditable(false);
        colorSelection = new LabeledComponent(colorLabel, colorChoice);
        makeSelection = new LabeledComponent(makeLabel, makeChoice);
        mainPanel.add(colorSelection);
        mainPanel.add(makeSelection);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        closer = new FrameListener(this, false);
        addWindowListener(closer);
        setLocation(300, 200);
        pack();
    }

    public void cancelPressed() { closer.closeWindow(); }

    public void okPressed() {
        String carClass = "*ANY";
        String carColor = (String)colorChoice.getSelectedItem();
        String carMake = (String)makeChoice.getSelectedItem();
        if (economyRB.isSelected())
            carClass = economyRB.getText();
        else if (midsizeRB.isSelected())
            carClass = midsizeRB.getText();
        else if (luxuryRB.isSelected())
            carClass = luxuryRB.getText();
        String plate = rental.rentCar(carClass, carColor, carMake);
        if (plate == null)
            infoArea.setText("No car available");
        else {
            mainWindow.getInfoArea().setText("Rented: " + rental.displayCarInfo(plate));
            closer.closeWindow();
        }
    }

    private FrameListener closer;
    private CommonButtons buttons;
    private ButtonGroup bg;
    private JRadioButton economyRB, midsizeRB, luxuryRB;
    private JLabel colorLabel, makeLabel;
    private JComboBox colorChoice, makeChoice;
    private LabeledComponent colorSelection, makeSelection;
    private InfoArea infoArea;
    private RentalGUI mainWindow;
    private RentalMethods rental;
    public static final String makes[] = {"*ANY","Ford","GM","Chrysler","Toyota","Nissan","Honda","Volkswagen"};
    public static final String colors[] = {"*ANY","Blue","Red","Green","Purple","Pearl","Grey","Silver","White","Black"};
}