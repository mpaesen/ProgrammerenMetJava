// Fig. 25.30: JdbcRowSetTest.java
// Displaying the contents of the authors table using JdbcRowSet.

import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JdbcRowSetTest 
{
   // JDBC driver name and database URL                              
   static final String DRIVER = "com.mysql.jdbc.Driver";
   static final String DATABASE_URL = "jdbc:mysql://localhost/books";
   static final String USERNAME = "root";
   static final String PASSWORD = "Ann-Sophie";
   
   // constructor connects to database, queries database, processes 
   // results and displays results in window
   public JdbcRowSetTest() 
   {
      // connect to database books and query database
      try 
      {
         Class.forName( DRIVER );
   
         // specify properties of JdbcRowSet                       
         JdbcRowSet rowSet = new JdbcRowSetImpl();                 
         rowSet.setUrl( DATABASE_URL ); // set database URL        
         rowSet.setUsername( USERNAME ); // set username           
         rowSet.setPassword( PASSWORD ); // set password           
         rowSet.setCommand( "SELECT * FROM authors" ); // set query
         rowSet.execute(); // execute query                        

         // process query results
         ResultSetMetaData metaData = rowSet.getMetaData();
         int numberOfColumns = metaData.getColumnCount();
         System.out.println( "Authors Table of Books Database:\n" );

         // display rowset header
         for ( int i = 1; i <= numberOfColumns; i++ )
            System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
         System.out.println();
         
         // display each row
         while ( rowSet.next() ) 
         {
            for ( int i = 1; i <= numberOfColumns; i++ )
               System.out.printf( "%-8s\t", rowSet.getObject( i ) );
            System.out.println();
         } // end while

         // close the underlying ResultSet, Statement and Connection
         rowSet.close();
      } // end try
      catch ( SQLException sqlException ) 
      {
         sqlException.printStackTrace();
         System.exit( 1 );
      } // end catch
      catch ( ClassNotFoundException classNotFound ) 
      {
         classNotFound.printStackTrace();            
         System.exit( 1 );
      } // end catch                                 
   } // end DisplayAuthors constructor
   
   // launch the application
   public static void main( String args[] )
   {
      JdbcRowSetTest application = new JdbcRowSetTest();      
   } // end main
} // end class JdbcRowSetTest


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
