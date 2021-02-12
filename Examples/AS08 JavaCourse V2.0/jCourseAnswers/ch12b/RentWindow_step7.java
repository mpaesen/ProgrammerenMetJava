import javax.swing.*;
import java.awt.*;

public class RentWindow extends JDialog implements CommonButtonInterface
{
    private CommonButtons buttons;
    private FrameListener closer;

    public RentWindow(JFrame parent)
    {
        super(parent, "Rent A Car", true);
        getContentPane().setLayout(new BorderLayout());

        buttons = new CommonButtons(this);
        buttons.setOKButtonText("Rent");
        getContentPane().add(buttons, BorderLayout.SOUTH);
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
