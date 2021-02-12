package samples;


/* ***********************************************

   * Example of GridBagLayout                    *

   *                                             *

   * Written by OTU Instructor                   *

   *                                             *

   * <C> IBM Object Technology University 1996,97*

   *                                             *

   *********************************************** */


import java.applet.Applet;
import java.awt.*;



public class ButtonPad extends Applet

{

	// overide the init() of Applet

	public void init()

	{

		Button    btn       = null;

		Label     label     = null;

		TextField textField = null;



		this.resize( 300, 200 );



		/* set the layout as gridLayout of 4x3

		   cells, horizontal gap of 5 and vertical

		   gap of 5 */

		GridBagLayout gridBagLayout = new GridBagLayout();

		setLayout( gridBagLayout );

		GridBagConstraints gridBagConstraints =

						 new GridBagConstraints();

		/* Create a row of three buttons

		   ----------------------------- */

		/* The layout will use the full horizontal and

		   vertical height if the display area is not filled */

		gridBagConstraints.fill = GridBagConstraints.BOTH;

		// Distribute horizontal space evenly between the buttons

		gridBagConstraints.weightx = 1.0;

		// Create and add the three buttons

		btn = new Button( "O N E" );

		gridBagLayout.setConstraints( btn, gridBagConstraints );

		this.add( btn );

		btn = new Button( "T W O" );

		gridBagLayout.setConstraints( btn, gridBagConstraints );

		this.add( btn );

		btn = new Button( "T H R E E" );

		// Fill the row.

		gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;

		gridBagLayout.setConstraints( btn, gridBagConstraints );

		this.add( btn );



		/* Create a button, a label and a button that uses

		   the remaining height area

		   ------------------------------------------------ */

		btn = new Button( "F O U R" );

		// Reset to normal

		gridBagConstraints.gridwidth = 1;

		// Force it to use the remaining height

		gridBagConstraints.weighty = 1.0;

		gridBagLayout.setConstraints( btn, gridBagConstraints );

		this.add( btn );

		label = new Label( "F I V E" );

		gridBagLayout.setConstraints( label, gridBagConstraints );

		this.add( label );

		btn = new Button( "S I X" );

		//Fill till the end of the row

		gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;

		gridBagLayout.setConstraints( btn, gridBagConstraints );

		this.add( btn );



		/* Create a normal height button with insets

		   ----------------------------------------- */

		// set the height to normal

		gridBagConstraints.weighty = 0.0;

		gridBagConstraints.gridheight = 1;

		// Use all space in row

		gridBagConstraints.weightx = 0.0;

		// Set the insets

		gridBagConstraints.insets.left  = 20;

		gridBagConstraints.insets.right = 20;

		btn = new Button( "S E V E N" );

		gridBagLayout.setConstraints( btn, gridBagConstraints );

		add( btn );



		/* Add a text field across the bottom

		   ---------------------------------- */

		// reset the insets

		gridBagConstraints.insets.left  = 0;

		gridBagConstraints.insets.right = 0;

		textField = new TextField( "E I G H T" );

		gridBagLayout.setConstraints( textField, gridBagConstraints );

		add( textField );

	}
}