package ch13;

import ch13.dates.DateDelta;

import javax.swing.*;
import java.awt.*;

public class ReturnWindow extends JDialog implements CommonButtonInterface {
    private CommonButtons buttons;
    private FrameListener closer;
    private JLabel plateLabel;
    private PlateEntry plateEntry;
    private LabeledComponent labeledPlateEntry;
    private InfoArea infoArea;
    private RentalGUI mainWindow;
    private RentalConnection ourDB;

    /** Constructor */
    public ReturnWindow(JFrame parent, RentalConnection ourDB) {
        super(parent, "Return A Car", true);
        this.ourDB = ourDB;
        mainWindow = (RentalGUI)parent;
        getContentPane().setLayout(new BorderLayout());
        plateLabel = new JLabel("Plate number");
        plateEntry = new PlateEntry();
        labeledPlateEntry = new LabeledComponent(plateLabel, plateEntry);
        getContentPane().add(labeledPlateEntry, BorderLayout.CENTER);
        buttons = new CommonButtons(this);
        buttons.setOKButtonText("Return");
        infoArea = new InfoArea();
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 1));
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        closer = new FrameListener(this, false);
        addWindowListener(closer);
        setLocation(300, 200);
        pack();
    } // end ctor

    public void okPressed() {
        if (plateEntry.isValid()) {
            Car car = new Car(ourDB);
            infoArea.setText("Attempting return...");
            boolean found = car.read(plateEntry.getText().trim());
            if (!found) {
                infoArea.setText("Error: Car not found");
                plateEntry.requestFocus();
            }
            else if (!car.isRented()) {
                infoArea.setText("Error: Car not currently rented");
                plateEntry.requestFocus();
            }
            else {
                DateDelta delta = car.returnIt();
                if (delta != null) {
                    mainWindow.getInfoArea().setText("Car returned. Rented for " + delta);
                    closer.closeWindow();
                }
                else {
                    infoArea.setText("Error: Unexpected failure returning car.");
                    plateEntry.requestFocus();
                }
                System.out.println("Returned: " + car.getDisplayInfo(true));
            } // end else car found
        } // end if plateEntry.isValid
        else {
            infoArea.setText("Invalid plate number");
            plateEntry.requestFocus();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void cancelPressed() {
        closer.closeWindow();
    }
} 