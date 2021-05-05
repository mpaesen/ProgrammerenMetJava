package lab15.solution;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Neko2 extends Applet implements MouseListener, Runnable {

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
   Thread t = new Thread(this);
   t.start();
}

public void run() {
   Graphics g = getGraphics(); // Get reference to screen.
   int x = this.x; // Copy instance variables to local
   int y = this.y; // variables with the same names.
   Image cat = null; // the last imag drawn by this thread.
   while (x < getSize().width) {
      g.clearRect(x, y, catWidth, catHeight); // erase last image
      x += 10; // bump draw location
      if (cat == catImage)

         // swap image pointer
         cat = catImage2;
      else
         cat = catImage;
      g.drawImage(cat,x,y,this);
      try {
         Thread.sleep(100);
      } // wait for user to see the image
      catch (InterruptedException e) {
      }
   }
}

private Image catImage;
private Image catImage2;
private MediaTracker mt = new MediaTracker(this);
private int catWidth, catHeight;
private int x, y;
}