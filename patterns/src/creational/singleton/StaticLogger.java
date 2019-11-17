package creational.singleton;


import org.apache.log4j.Priority;

// ==============================
public class StaticLogger {
    static Logger logger = Logger.initialize();
    public static void main(String[] args) {

        logger.logMsg(Priority.ERROR_INT, "Test");
    }
}// End of class