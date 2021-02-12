package be.mySchool;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class log4jExample
{

	/* Get actual class name to be printed on */
	static Logger log = Logger.getLogger(log4jExample.class.getName());

	public static void main(final String[] args) throws IOException, SQLException
	{
		//	BasicConfigurator.configure();
		log.debug("Hello this is a debug message");
		log.info("Hello this is an info message");
	}
}