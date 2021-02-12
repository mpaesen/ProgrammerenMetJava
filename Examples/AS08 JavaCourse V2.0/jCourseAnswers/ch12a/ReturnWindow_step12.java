import java.awt.*;

public class ReturnWindow extends Dialog implements CommonButtonInterface
{
    private CommonButtons buttons;
    private FrameListener closer;
    private Label         plateLabel;
    private PlateEntry    plateEntry;
    private LabeledComponent labeledPlateEntry;
    private InfoArea      infoArea;

    public ReturnWindow(Frame parent)
    {
        super(parent, "Return A Car", true);
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
          closer.closeWindow();
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