package samples;


/* ***********************************************

   * Example of GridBagLayout                    *

   *                                             *

   * Written by Dom Faidherbe                    *

   *                                             *

   * <C> IBM Object Technology University 1996   *

   *                                             *

   *********************************************** */


import java.applet.Applet;
import java.awt.*;



public class PhoneDial extends Applet

{

	// overide the init() of Applet

	public void init()

	{

		setSize( 300, 200 );



		/* set the layout as gridLayout of 4x3

		   cells, horizontal gap of 5 and vertical

		   gap of 5 */

		GridLayout gridLt = new GridLayout( 4, 3, 5, 5 );

		setLayout( gridLt );



		String[] stringList = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "#", "0", "R" };



		for (int i=0; i < stringList.length ; i++ )

		{

		   add( new Button( stringList[ i ] ) );

		}

	}
}