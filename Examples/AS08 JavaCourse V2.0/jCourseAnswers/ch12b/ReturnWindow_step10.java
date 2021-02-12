import javax.swing.*;
import java.awt.*;

public class ReturnWindow extends JDialog implements CommonButtonInterface
{
    private CommonButtons buttons;
    private FrameListener closer;

    public ReturnWindow(JFrame parent)
    {
        super(parent, "Return A Car", true);
        getContentPane().setLayout(new BorderLayout());

        buttons = new CommonButtons(this);
        buttons.setOKButtonText("Return");
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

} // End returnwindow
