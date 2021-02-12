package lab14.solution;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Neko1 extends java.applet.Applet implements MouseListener {
   Image catPicture;

public Neko1() {
   addMouseListener(this);
}

public void init() {
   setBackground(Color.white);
   catPicture = getImage(getCodeBase(), "Neko1.gif");
}

public void mouseClicked(MouseEvent mickey) {
}

public void mouseEntered(MouseEvent mickey) {
}

public void mouseExited(MouseEvent mickey) {
}

public void mousePressed(MouseEvent mickey) {
}

public void mouseReleased(MouseEvent mickey) {
   int x = mickey.getX();
   int y = mickey.getY();
   String msg = "Mouse Click at " + x + ", " + y;
   System.err.println(msg);
   Graphics g = getGraphics();
   g.drawString(msg, x, y);
   g.drawImage(catPicture, x, y, this);
}
}
