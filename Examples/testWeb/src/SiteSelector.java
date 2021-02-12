//package be;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.applet.AppletContext;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Vector;

public class SiteSelector extends JApplet {
	private HashMap sites; // site names and URLs
	private Vector siteNames; // site names
	private JList siteChooser; // list of sites to choose from

	// read HTML parameters and set up GUI
	public void init() {
		// create HashMap and Vector
		sites = new HashMap();
		siteNames = new Vector();

		// obtain parameters from HTML document
		getSitesFromHTMLParameters();

		// create GUI components and layout interface
		Container container = getContentPane();
		container
				.add(new JLabel("Choose a site to browse"), BorderLayout.NORTH);

		siteChooser = new JList(siteNames);
		siteChooser.addListSelectionListener(

		new ListSelectionListener() {

			// go to site user selected
			public void valueChanged(ListSelectionEvent event) {
				// get selected site name
				Object object = siteChooser.getSelectedValue();

				// use site name to locate corresponding URL
				URL newDocument = (URL) sites.get(object);

				// get reference to applet container
				AppletContext browser = getAppletContext();

				// tell applet container to change pages
				browser.showDocument(newDocument);
			}

		} // end inner class

				); // end call to addListSelectionListener

		container.add(new JScrollPane(siteChooser), BorderLayout.CENTER);

	} // end method init

	// obtain parameters from HTML document
	private void getSitesFromHTMLParameters() {
		// look for applet parameters in HTML document and add to HashMap
		String title, location;
		URL url;
		int counter = 0;

		title = getParameter("title" + counter); // get first site title

		// loop until no more parameters in HTML document
		while (title != null) {

			// obtain site location
			location = getParameter("location" + counter);

			// place title/URL in HashMap and title in Vector
			try {
				url = new URL(location); // convert location to URL
				sites.put(title, url); // put title/URL in HashMap
				siteNames.add(title); // put title in Vector
			}

			// process invalid URL format
			catch (MalformedURLException urlException) {
				urlException.printStackTrace();
			}

			++counter;
			title = getParameter("title" + counter); // get next site title

		} // end while

	} // end method getSitesFromHTMLParameters

} // end class SiteSelector

/*******************************************************************************
 * (C) Copyright 1992-2003 by Deitel & Associates, Inc. and * Prentice Hall. All
 * Rights Reserved. * * DISCLAIMER: The authors and publisher of this book have
 * used their * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs * to
 * determine their effectiveness. The authors and publisher make * no warranty
 * of any kind, expressed or implied, with regard to these * programs or to the
 * documentation contained in these books. The authors * and publisher shall not
 * be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 ******************************************************************************/
