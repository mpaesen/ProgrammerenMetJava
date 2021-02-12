import java.awt.*;

public class LabeledComponent extends Panel
{
    public LabeledComponent(Label label, Component object)
    {
        super();
        setLayout(new GridLayout(1,2));
        add(label);
        add(object);
    }
}

