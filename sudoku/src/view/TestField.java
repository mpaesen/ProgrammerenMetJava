/**
 * 
 */
package view;

import junit.framework.JUnit4TestAdapter;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import model.Field;

import org.apache.log4j.Level;
import org.apache.log4j.BasicConfigurator;

import utilities.Constants;

/**
 * @author bempn
 * 
 */
public class TestField{
	private Field field = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Constants.logger.setLevel(Level.DEBUG);
		BasicConfigurator.configure();		
		junit.textui.TestRunner.run(suite());
	}
	@Before	public void setUp() {
		field = new Field((byte) 9);
	}
	
	@After public void end(){
		field = null;
	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(TestField.class);
	}

	@Test public void doIt(){
		print();		
		//getRows();
		//getColumns();
	}
	
		
	public void print() {
		Constants.logger.info("\nWhole Field as Matrix\n"+field);		
	}

	
	public void getRows() {
		Constants.logger.info("Rows:");
		for (int i = 0; i < field.getField().length; i++) {
			Constants.logger.info("\trow :"+i+"\n");
			for (int j=0; j < field.getRow((byte) i).length; j++){
				Constants.logger.info(field.getRow((byte) i)[j]);		
			}					
		}
	}

	
	public void getColumns() {
		Constants.logger.info("Columns:");
		for (int i = 0; i < field.getField().length; i++) {
			Constants.logger.info("\tcolumn :"+i+"\n");
			for (int j=0; j < field.getColumn((byte) i).length; j++){
				Constants.logger.info(field.getColumn((byte) i)[j]);		
			}
		}
	}
}
