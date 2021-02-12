import java.awt.*;

public class DisplayWindow extends Dialog implements CommonButtonInterface
{
    private CommonButtons buttons;
    private FrameListener closer;
    private List          carList;
    private RentalGUI mainWindow;
    private RentalMethods rental;

    public DisplayWindow(Frame parent)
    {
        super(parent, "Display Rented Cars", true);
        mainWindow = (RentalGUI)parent;
        rental = mainWindow.getRentalObject();
        setLayout(new BorderLayout());

        buttons = new CommonButtons(this);
        buttons.setOKButtonText("OK");
        add(buttons,"South");

        carList = new List(10);
        EnumerateRentedCars enum = rental.getRentedEnumeration();
        while (enum.hasMoreElements())
           carList.addItem((String)enum.nextElement());
        add(carList,"Center");

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
