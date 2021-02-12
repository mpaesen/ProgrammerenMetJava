import java.awt.event.KeyEvent;

public class KeyHelper
{
    // returns true if a character was pressed, and false
    // if something else was done, such as a control key
    // or shift key or delete key pressed.
    public static boolean wasCharacterTyped(KeyEvent evt)
    {
        boolean charTyped = true;
        int keyCode = evt.getKeyCode();

        if (evt.isAltDown()                ||
            evt.isControlDown()            ||
	         keyCode == KeyEvent.VK_ALT     ||
			   keyCode == KeyEvent.VK_CONTROL ||
			   keyCode == KeyEvent.VK_DOWN    ||
			   keyCode == KeyEvent.VK_END     ||
			   keyCode == KeyEvent.VK_ENTER   ||
			   keyCode == KeyEvent.VK_HOME    ||
			   keyCode == KeyEvent.VK_INSERT  ||
			   keyCode == KeyEvent.VK_LEFT    ||
			   keyCode == KeyEvent.VK_RIGHT   ||
			   keyCode == KeyEvent.VK_SHIFT   ||
			   keyCode == KeyEvent.VK_UP      ||
			   keyCode == KeyEvent.VK_TAB     ||
			   keyCode == KeyEvent.VK_BACK_SPACE ||
			   keyCode == KeyEvent.VK_DELETE)
	       charTyped = false;
        return charTyped;
    } // end wasCharTyped method
} // end KeyHelper class
