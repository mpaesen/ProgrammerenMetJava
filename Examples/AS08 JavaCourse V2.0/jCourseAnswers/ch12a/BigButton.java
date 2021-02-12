import java.awt.*;

public class BigButton extends Button
{
    public BigButton(String text)
    {
        super(text);
        Font myFont = new Font("SansSerif",Font.BOLD,18);
        setFont(myFont);
    }
}
