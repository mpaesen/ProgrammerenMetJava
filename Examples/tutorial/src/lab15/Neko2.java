package lab15;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Neko2 extends Applet implements MouseListener {

public void init() {
   catImage = getImage(getCodeBase(), "Neko1.gif");
   catImage2 = getImage(getCodeBase(), "Neko2.gif");
   mt.addImage(catImage, 0);
   mt.addImage(catImage2, 0);
   try {
      mt.waitForAll(); // wait for image load to complete so can measure size
      if (mt.isErrorAny())
         System.out.println("Image Load Error");
   } catch (Exception e) {
      System.out.println(e);
   }
   catWidth = catImage.getWidth(this);
   catHeight = catImage.getHeight(this);
   System.out.println("Cat picture dimentions: " + catWidth + " x " + catHeight);
   addMouseListener(this); // register to be notified of Mouse events.
   setBackground(Color.white);
}

public void mouseClicked(MouseEvent me) {
}

public void mouseEntered (MouseEvent me) {
}

public void mouseExited  (MouseEvent me) {
}

public void mousePressed(MouseEvent mickey)
{
}

public void mouseReleased(MouseEvent me) {
   x = me.getX(); // get mouse coordinates
   y = me.getY(); // at time of click.
   System.out.println("Mouse clicked at " + x + ", " + y);
}

private Image catImage;
private Image catImage2;
private MediaTracker mt = new MediaTracker(this);
private int catWidth, catHeight;
private int x, y;
}
