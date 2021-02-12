package ch13;

import javax.swing.*;
import java.awt.*;

public class RentWindow extends JDialog implements CommonButtonInterface {
    private CommonButtons buttons;
    private FrameListener closer;
    public static final String makes[] = {"*ANY","Ford","GM","Chrysler","Toyota","Nissan","Honda","Volkswagen"};
    public static final String colors[] = {"*ANY","Blue","Red","Green","Purple","Pearl","Grey","Silver","White","Black"};
    private ButtonGroup bg;
    private JRadioButton economyRB, midsizeRB, luxuryRB;
    private JLabel colorLabel, makeLabel;
    private JComboBox colorChoice;
    private JComboBox makeChoice;
    private LabeledComponent colorSelection;
    private LabeledComponent makeSelection;
    private InfoArea infoArea;
    private RentalGUI mainWindow;
    private RentalConnection ourDB;

    /** Constructor */
    public RentWindow(JFrame parent, RentalConnection ourDB) {
        super(parent, "Rent A Car", true);
        this.ourDB = ourDB;
        mainWindow = (RentalGUI)parent;
        getContentPane().setLayout(new BorderLayout());
        buttons = new CommonButtons(this);
        buttons.setOKButtonText("Rent");
        infoArea = new InfoArea();
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        bg = new ButtonGroup();
        economyRB = new JRadioButton("Economy", true);
        midsizeRB = new JRadioButton("Midsize");
        luxuryRB = new JRadioButton("Luxury");
        bg.add(economyRB);
        bg.add(midsizeRB);
        bg.add(luxuryRB);
        JPanel rbPanel = new JPanel(new GridLayout(1, 3));
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
    } // end ctor

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
        if (carColor.equals("*ANY"))
            carColor = null;
        if (carMake.equals("*ANY"))
            carMake = null;
        infoArea.setText("Searching for car match...");
        Car car = new Car(ourDB);
        String plate = car.rentIt(carClass, carColor, carMake);
        if (plate == null)
            infoArea.setText("No car available");
        else {
            mainWindow.getInfoArea().setText("Rented: " + car.getDisplayInfo(false));
            closer.closeWindow();
        }
    }

    public void cancelPressed() {
        closer.closeWindow();
    }
} // End rentwindow
