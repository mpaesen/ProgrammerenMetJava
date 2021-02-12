package samples;



// Example of how easy Images are in Java!         PDB 6/12/97

import java.applet.Applet;
import java.awt.*;

public class GrandCanyon extends Applet
{

Image   thePicture;
boolean thePictureIsReady;

   public void init() {
		  thePicture = getImage(getCodeBase(), "grandc3.jpg");
		  thePictureIsReady = true;
   }      
   public void paint(Graphics g) {
		  if(thePictureIsReady)
			 g.drawImage(thePicture, 0, 0, this);
   }      
}