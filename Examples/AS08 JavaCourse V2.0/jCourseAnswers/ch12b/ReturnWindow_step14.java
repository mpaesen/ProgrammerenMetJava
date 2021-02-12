import javax.swing.*;
import java.awt.*;

public class ReturnWindow extends JDialog implements CommonButtonInterface
{
    private CommonButtons buttons;
    private FrameListener closer;
    private JLabel        plateLabel;
    private PlateEntry    plateEntry;
    private LabeledComponent labeledPlateEntry;
    private InfoArea      infoArea;
    private RentalGUI     mainWindow;
    private RentalMethods rental;

    public ReturnWindow(JFrame parent)
    {
        super(parent, "Return A Car", true);

        mainWindow = (RentalGUI)parent;
        rental = mainWindow.getRentalObject();

        getContentPane().setLayout(new BorderLayout());

        plateLabel = new JLabel("Plate number");
        plateEntry = new PlateEntry();
        labeledPlateEntry = new LabeledComponent(plateLabel, plateEntry);
        getContentPane().add(labeledPlateEntry, BorderLayout.CENTER);

        buttons = new CommonButtons(this);
        buttons.setOKButtonText("Return");
        JPanel bottomPanel = new JPanel(new GridLayout(2,1));
        infoArea = new InfoArea();
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        closer = new FrameListener(this,false);
        addWindowListener(closer);

        setLocation(300,200);
        pack();
    } // end ctor

    public void okPressed()
    {
        if (plateEntry.isValid())
          {
            DateDelta delta = rental.returnCar(plateEntry.getText().trim());
            if (delta != null)
              {
                mainWindow.getInfoArea().setText(
                 "Car returned. Rented for " + delta);
                closer.closeWindow();
              }
            else
              {
                infoArea.setText("Car not found or not rented");
                plateEntry.requestFocus();
              }
          }
        else
          {
             infoArea.setText("Invalid plate number");
             plateEntry.requestFocus();
             Toolkit.getDefaultToolkit().beep();
          }
    }

    public void cancelPressed()
    {
        closer.closeWindow();
    }

} // End returnwindow
