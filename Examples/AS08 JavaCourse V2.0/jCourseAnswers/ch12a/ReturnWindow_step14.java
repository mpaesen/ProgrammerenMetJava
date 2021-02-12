import java.awt.*;

public class ReturnWindow extends Dialog implements CommonButtonInterface
{
    private CommonButtons buttons;
    private FrameListener closer;
    private Label         plateLabel;
    private PlateEntry    plateEntry;
    private LabeledComponent labeledPlateEntry;
    private InfoArea      infoArea;
    private RentalGUI     mainWindow;
    private RentalMethods rental;

    public ReturnWindow(Frame parent)
    {
        super(parent, "Return A Car", true);
        mainWindow = (RentalGUI)parent;
        rental = mainWindow.getRentalObject();
        setLayout(new BorderLayout());

        plateLabel = new Label("Plate number");
        plateEntry = new PlateEntry();
        labeledPlateEntry = new LabeledComponent(plateLabel, plateEntry);
        add(labeledPlateEntry, "Center");

        buttons = new CommonButtons(this);
        buttons.setOKButtonText("Return");
        infoArea = new InfoArea();
        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new GridLayout(2,1));
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);
        add(bottomPanel,"South");
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
                mainWindow.getInfoArea().setText("Car returned. Rented for " + delta);
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
          }
    }

    public void cancelPressed()
    {
        closer.closeWindow();
    }

} // End returnwindow
