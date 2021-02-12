package creational.singleton;


import org.apache.log4j.Priority;

// ==============================
public class StaticLogger {
    static Logger logger = Logger.initialize();

    public static void main(String[] args) {
        switch (logger.getRegisteredLevel()) {
            case Priority.ERROR_INT: {
                logger.logMsg(Priority.ERROR_INT, "Dit is een Error Test"); //40000
                break;
            }
            case Priority.INFO_INT: {
                logger.logMsg(Priority.INFO_INT, "Dit is een Info Test"); //20000
                break;
            }
            case Priority.DEBUG_INT: {
                logger.logMsg(Priority.DEBUG_INT, "Dit is een Debug Test"); //10000
                break;
            }
            case Priority.FATAL_INT: {
                logger.logMsg(Priority.FATAL_INT, "Dit is een Fatal Test"); //50000
                break;
            }
            case Priority.WARN_INT: {
                logger.logMsg(Priority.WARN_INT, "Dit is een Debug Test");//30000
                break;
            }
            default: {
                logger.logMsg(Priority.ALL_INT, "Dit is een All Test");//Integer.MIN
            }
        }
    }
}// End of class