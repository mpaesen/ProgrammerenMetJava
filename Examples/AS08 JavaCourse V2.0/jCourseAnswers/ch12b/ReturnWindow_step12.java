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

    public ReturnWindow(JFrame parent)
    {
        super(parent, "Return A Car", true);
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
          closer.closeWindow();
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
