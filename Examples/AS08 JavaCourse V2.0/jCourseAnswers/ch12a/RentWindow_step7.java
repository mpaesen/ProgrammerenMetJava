import java.awt.*;

public class RentWindow extends Dialog implements CommonButtonInterface
{
    private CommonButtons buttons;
    private FrameListener closer;

    public RentWindow(Frame parent)
    {
        super(parent, "Rent A Car", true);
        setLayout(new BorderLayout());

        buttons = new CommonButtons(this);
        buttons.setOKButtonText("Rent");
        add(buttons,"South");
        closer = new FrameListener(this,false);
        addWindowListener(closer);

        setLocation(300,200);
        pack();
    } // end ctor

    public void okPressed()
    {
        closer.closeWindow();
    }

    public void cancelPressed()
    {
        closer.closeWindow();
    }

} // End rentwindow
