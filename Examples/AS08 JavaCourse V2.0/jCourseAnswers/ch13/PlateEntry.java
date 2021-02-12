import javax.swing.*;

public class PlateEntry extends JTextField
{
    protected PlateEntryModel model = new PlateEntryModel();

    public PlateEntry()
    {
        super(PlateEntryModel.MAXLENGTH);
        super.setDocument(model);
    }

    public boolean isValid()
    {
        return (getText().length() == PlateEntryModel.MAXLENGTH);
    }
} // end of class PlateEntry