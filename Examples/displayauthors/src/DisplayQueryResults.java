// Fig. 25.29: DisplayQueryResults.java
// Display the contents of the Authors table in the books database.

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

public class DisplayQueryResults extends JFrame
{
	// JDBC database URL, username and password
	//	   static final String DRIVER = "com.mysql.jdbc.Driver";
	//	   static final String DATABASE_URL = "jdbc:mysql://localhost/books";
	//	   static final String USERNAME = "root";
	//	   static final String PASSWORD = "Ann-Sophie";
	static final String DRIVER = "org.apache.derby.jdbc.ClientDriver40";
	static final String DATABASE_URL = "jdbc:derby://localhost/../Cloudscape_db/booksDB";
	static final String USERNAME = "app";
	static final String PASSWORD = "app";

	// default query retrieves all data from authors table
	static final String DEFAULT_QUERY = "SELECT * FROM authors";

	private ResultSetTableModel tableModel;
	private JTextArea queryArea;

	// create ResultSetTableModel and GUI
	public DisplayQueryResults()
	{
		super("Displaying Query Results");

		// create ResultSetTableModel and display database table
		try
		{
			// create TableModel for results of query SELECT * FROM authors
			tableModel = new ResultSetTableModel(DRIVER, DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);

			// set up JTextArea in which user types queries
			queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
			queryArea.setWrapStyleWord(true);
			queryArea.setLineWrap(true);

			final JScrollPane scrollPane = new JScrollPane(queryArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			// set up JButton for submitting queries
			final JButton submitButton = new JButton("Submit Query");

			// create Box to manage placement of queryArea and 
			// submitButton in GUI
			final Box boxNorth = Box.createHorizontalBox();
			boxNorth.add(scrollPane);
			boxNorth.add(submitButton);

			// create JTable delegate for tableModel 
			final JTable resultTable = new JTable(tableModel);

			final JLabel filterLabel = new JLabel("Filter:");
			final JTextField filterText = new JTextField();
			final JButton filterButton = new JButton("Apply Filter");
			final Box boxSouth = boxNorth.createHorizontalBox();

			boxSouth.add(filterLabel);
			boxSouth.add(filterText);
			boxSouth.add(filterButton);

			// place GUI components on content pane
			add(boxNorth, BorderLayout.NORTH);
			add(new JScrollPane(resultTable), BorderLayout.CENTER);
			add(boxSouth, BorderLayout.SOUTH);

			// create event listener for submitButton
			submitButton.addActionListener(

			new ActionListener() {
				// pass query to table model
				public void actionPerformed(final ActionEvent event)
				{
					// perform a new query
					try
					{
						tableModel.setQuery(queryArea.getText());
					} // end try
					catch (final SQLException sqlException)
					{
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);

						// try to recover from invalid user query 
						// by executing default query
						try
						{
							tableModel.setQuery(DEFAULT_QUERY);
							queryArea.setText(DEFAULT_QUERY);
						} // end try
						catch (final SQLException sqlException2)
						{
							JOptionPane.showMessageDialog(null, sqlException2.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);

							// ensure database connection is closed
							tableModel.disconnectFromDatabase();

							System.exit(1); // terminate application
						} // end inner catch                   
					} // end outer catch
				} // end actionPerformed
			} // end ActionListener inner class          
					); // end call to addActionListener

			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
			resultTable.setRowSorter(sorter);
			setSize(500, 250); // set window size
			setVisible(true); // display window  

			// create listener for filterButton
			filterButton.addActionListener(new ActionListener() {
				// pass filter text to listener
				public void actionPerformed(final ActionEvent e)
				{
					final String text = filterText.getText();

					if (text.length() == 0)
						sorter.setRowFilter(null);
					else
					{
						try
						{
							sorter.setRowFilter(RowFilter.regexFilter(text));
						} // end try
						catch (final PatternSyntaxException pse)
						{
							JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern", JOptionPane.ERROR_MESSAGE);
						} // end catch
					} // end else
				} // end method actionPerfomed
			} // end annonymous inner class
					); // end call to addActionLister
		} // end try
		catch (final ClassNotFoundException classNotFound)
		{
			JOptionPane.showMessageDialog(null, "Database Driver not found", "Driver not found", JOptionPane.ERROR_MESSAGE);

			System.exit(1); // terminate application
		} // end catch
		catch (final SQLException sqlException)
		{
			JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);

			// ensure database connection is closed
			tableModel.disconnectFromDatabase();

			System.exit(1); // terminate application
		} // end catch

		// dispose of window when user quits application (this overrides
		// the default of HIDE_ON_CLOSE)
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// ensure database connection is closed when user quits application
		addWindowListener(

		new WindowAdapter() {
			// disconnect from database and exit when window has closed
			@Override
			public void windowClosed(final WindowEvent event)
			{
				tableModel.disconnectFromDatabase();
				System.exit(0);
			} // end method windowClosed
		} // end WindowAdapter inner class
		); // end call to addWindowListener
	} // end DisplayQueryResults constructor

	// execute application
	public static void main(final String args[])
	{
		new DisplayQueryResults();
	} // end main
} // end class DisplayQueryResults

/**************************************************************************
 * (C) Copyright 1992-2007  by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
