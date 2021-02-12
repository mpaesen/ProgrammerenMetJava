import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlateEntry extends TextField implements KeyListener
{
    private static final int MAXLEN = 6;

    public PlateEntry()
    {
        super(MAXLEN);
        addKeyListener(this);
    }

    public void keyPressed(KeyEvent evt)
    {
        if (!KeyHelper.wasCharacterTyped(evt))
          return;
        char keyChar = evt.getKeyChar();

        String currText = getText().trim();
        if (currText.length() >= MAXLEN)
          evt.consume();
        else if (! ((keyChar >= '0') &&
                    (keyChar <= '9')) )
          evt.consume();
    }
    public void keyTyped(KeyEvent evt){}
    public void keyReleased(KeyEvent evt){}

    public boolean isValid()
    {
        if (getText().trim().length() != 6)
          return false;
        else
          return true;
    }
}
