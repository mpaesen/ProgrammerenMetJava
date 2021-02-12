import java.awt.*;

public class RentWindow extends Dialog implements CommonButtonInterface
{
    private CommonButtons buttons;
    private FrameListener closer;
    public static final String makes[] = {"*ANY","Ford","GM","Chrysler","Toyota","Nissan","Honda","Volkswagen"};
    public static final String colors[] = {"*ANY","Blue","Red","Green","Purple","Pearl","Grey","Silver","White","Black"};
    private CheckboxGroup cbg;
    private Checkbox economyRB;
    private Checkbox midsizeRB;
    private Checkbox luxuryRB;
    private Label colorLabel;
    private Label makeLabel;
    private Choice colorChoice;
    private Choice makeChoice;
    private LabeledComponent colorSelection;
    private LabeledComponent makeSelection;

    public RentWindow(Frame parent)
    {
        super(parent, "Rent A Car", true);
        setLayout(new BorderLayout());

        buttons = new CommonButtons(this);
        buttons.setOKButtonText("Rent");
        add(buttons,"South");

        Panel mainPanel = new Panel();
        mainPanel.setLayout(new GridLayout(3,1));

        cbg = new CheckboxGroup();
        economyRB = new Checkbox("Economy",cbg,true);
        midsizeRB = new Checkbox("Midsize",cbg,false);
        luxuryRB  = new Checkbox("Luxury",cbg,false);
        Panel rbPanel = new Panel();
        rbPanel.add(economyRB);
        rbPanel.add(midsizeRB);
        rbPanel.add(luxuryRB);
        mainPanel.add(rbPanel);

        colorLabel = new Label("Color");
        makeLabel = new Label("Make");
        colorChoice = new Choice();
        for (int idx=0; idx<colors.length; idx++)
           colorChoice.addItem(colors[idx]);
        makeChoice = new Choice();
        for (int idx=0; idx<makes.length; idx++)
           makeChoice.addItem(makes[idx]);
        colorSelection = new LabeledComponent(colorLabel,colorChoice);
        makeSelection = new LabeledComponent(makeLabel,makeChoice);
        mainPanel.add(colorSelection);
        mainPanel.add(makeSelection);

        add(mainPanel,"Center");

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
