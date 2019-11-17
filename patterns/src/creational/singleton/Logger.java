package creational.singleton;

import org.apache.log4j.Priority;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Properties;

public class Logger {
    // singleton - pattern
    private static Logger logger;
    private Properties properties;

    /**
     * Private constructor
     */
    private Logger() {
        logger = this;
    }

    /**
     * this method initialises the logger, creates an object
     *
     * @return
     */
    public static Logger initialize() {
        logger = new Logger();
        logger.properties = new Properties();
        return logger;
    }

    public static Logger getLogger() {
        return logger;
    }

    /**
     * Level of logging, error or information etc
     *
     * @return level, int
     */
    public int getRegisteredLevel() {
        int i = 0;
        try {
            InputStream inputstream = getClass().getResourceAsStream(
                    "BaseLogger.properties");
            properties.load(inputstream);
            inputstream.close();
            String priority = properties.getProperty("**BaseLogger.registeredLevel**");
            i = getPriority(priority);
            if (i < 0 || i > 50000)
                i = 0;
        } catch (Exception exception) {
            System.out
                    .println("Logger: Failed in the getRegisteredLevel method");
            exception.printStackTrace();
        }
        return i;
    }

    private int getPriority(String priority) {
        if (priority.equals("ERROR_INT")) {
            return Priority.ERROR_INT;
        } else if (priority.equals("DEBUG_INT")) {
            return Priority.DEBUG_INT;
        } else if (priority.equals("FATAL_INT")) {
            return Priority.FATAL_INT;
        } else if (priority.equals("WARN_INT")) {
            return Priority.WARN_INT;
        }
        return Priority.ALL_INT;

    }

    /**
     * One file will be made daily. So, putting date time in file name.
     *
     * @param gc GregorianCalendar
     * @return String, name of file
     */
    private String getFileName(GregorianCalendar gc) {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
        String dateString = dateFormat1.format(gc.getTime());
        String fileName = "PatternsExceptionLog-"
                + dateString + ".txt";
        return fileName;
    }

    /**
     * A mechanism to log message to the file.
     *
     * @param p       Priority
     * @param message String
     */
    public void logMsg(int p, String message) {
        try {
            GregorianCalendar gc = new GregorianCalendar();
            String fileName = getFileName(gc);
            FileOutputStream fos = new FileOutputStream(fileName, true);
            PrintStream ps = new PrintStream(fos);
            SimpleDateFormat dateFormat2 = new SimpleDateFormat(
                    "EEE, MMM d, yyyy 'at' hh:mm:ss a");
            ps.println("<" + dateFormat2.format(gc.getTime()) + ">[" + message
                    + "]");
            ps.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}// End of class
