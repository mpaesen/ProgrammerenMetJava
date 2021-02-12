package samples;


//**************************************Copyright 1997 IBM Corporation*
//
// Java Programming
// Exercise 8 (Moving Cat Animation) Solution
// Change History:
// 03/05/97 PDB Created
// 04/11/97 BDW Adapted for V1.1 and course hardcopy
// 11/23/97 PDB Added ball to animation
//
//*********************************************************************

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
 
public class NekoBall extends Applet implements Runnable {
 
	  Image        currentImage;
	  Image[]      catImage = new Image[5];
	  Image        ballImage;
	  MediaTracker tracker = new MediaTracker(this);
	  AudioClip    catSound;
	  Thread       catThread;
	  String       soundFile, debugString;
	  String[]     catFile = new String[5];
	  int          nekoHeight, nekoWidth, xPosition, yPosition = 50;
	  int          ballX, ballY = yPosition;
	  boolean      ballShouldMoveUp;
	  boolean      nekoIsRunning, imagesAreOk, theresAProblem;
final int          ballTOP      = yPosition - 7;
final int          ballBOTTOM   = yPosition + 12;
final int          ballBump     = 4;
final int          ballDistance = 70;
final int          SLEEPTIME    = 100; // Time between repaints (ms)
 
   public void init() {

	  soundFile = getParameter("Sound");
	  if (soundFile == null) {
		 theresAProblem = true;
		 debugString = "No HTML PARAM for 'Sound'";
		 System.out.println("No HTML PARAM for 'Sound'");
		 repaint();
	  } else {
		 catSound = getAudioClip(getCodeBase(), soundFile);
	  }

	  showStatus("Loading Images"); 
	  for (int i = 1; i < 5; i++) {
		 catFile[i] = getParameter("Image" + i);
		 if (catFile[i] == null) {
			theresAProblem = true;
			debugString = "No HTML PARAM for Image" + i;
			repaint();
		 } else {
			catImage[i] = getImage(getCodeBase(), catFile[i]);
			tracker.addImage(catImage[i], 0);
		 }
	  } // end of for
	  ballImage = getImage(getCodeBase(),  "red-ball.gif");
	  tracker.addImage(ballImage, 1);

	  try {
		  tracker.waitForAll();
		  }
	  catch (InterruptedException e)
		 {
		 showStatus("Image Load Problem...");
		 }
	  if (tracker.isErrorAny())
		 {
		 showStatus("Image Load Error.");
		 System.out.println("Image Load Error.");
		 }
	   else
		 {
		 imagesAreOk = true;
		 showStatus("Image Load Completed.");
		 }

   } // end of init method       
   public void paint(Graphics g) {

	  if (theresAProblem)
		 g.drawString(debugString, xPosition, yPosition);
	  if (nekoIsRunning)
		 {
		 g.drawImage(currentImage, xPosition, yPosition, this);
		 g.drawImage(ballImage,    ballX,     ballY,     this);
		 }
   }      
   public void run() {

	  if (imagesAreOk) {
		 setBackground(Color.white);
		 while (true) {
			// Run left to right
			for (int i = 0; i < this.getSize().width; i+=10) { // 10 pixels between
			   xPosition = i; // xPosition is used in paint()
			   ballX = xPosition + ballDistance;
			   if (ballShouldMoveUp)
				  ballY -= ballBump;
				else
				  ballY += ballBump;
			   if (ballY < ballTOP)    ballShouldMoveUp = false;
			   if (ballY > ballBOTTOM) ballShouldMoveUp = true;
			   // Now swap images. Just alternating is satisfactory in this case
			   if (currentImage == catImage[1])
				  currentImage =  catImage[2];
			   else
				  currentImage =  catImage[1];
			   nekoIsRunning = true;
			   repaint(); // call paint via update
			   try { Thread.sleep(SLEEPTIME); }
			   catch (InterruptedException e) {}
			}
			// Now run right to left
			for (int i = this.getSize().width; i > 0; i-=10) { // 10 pixels between
			   xPosition = i;                 // xPosition is used in paint()
			   ballX = xPosition - ballDistance;
			   if (ballShouldMoveUp)
				  ballY -= ballBump;
				else
				  ballY += ballBump;
			   if (ballY < ballTOP)    ballShouldMoveUp = false;
			   if (ballY > ballBOTTOM) ballShouldMoveUp = true;

			   // Now swap images. Just alternating is satisfactory in this case
			   if (currentImage == catImage[3])
				  currentImage =  catImage[4];
			   else
				  currentImage =  catImage[3];
			   nekoIsRunning = true;
			   repaint(); // call paint via update
			   try { Thread.sleep(SLEEPTIME); }
			   catch (InterruptedException e) {}
			}
		 } // end of while(true)
	  } // end of if imagesAreOk

   } // end of run method      
   public void start() {
	  if (catThread == null) {
		 catThread = new Thread(this);
		 catThread.start(); // remove comment to start run()
							// after init() test.
	  }
	  if (catSound != null)
		 catSound.loop();
   }      
   public void stop() {
	  if (catThread != null) {
		 catThread.stop();
		 catThread = null;
	  }
	  if (catSound != null)
		 catSound.stop();
   }      
} // End of class