package tools;

import java.text.DateFormat;
import java.util.Date;

public class Trace {
	public static final int NONE = 0;
	public static final int MINIMUM = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	public static final int DEFAULT = MINIMUM;
	private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
	private static DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT);
	private static boolean isWrittenTo = false;	
	private static int traceLevel = DEFAULT;

	private Trace() {
	}
	
	public static void message(String message) {
		message(message, DEFAULT);
	}
	
	public static void message(String message, int level) {
		// make sure levels are in range
		if (level < MINIMUM) {
			level = MINIMUM;
		} else if (level > HIGH) {
			level = HIGH;
		}
		
		// if needed, output the trace message
		if (level <= traceLevel) {
			Date current = new Date();	
			System.err.println(	
								dateFormat.format(current) + " " +
								timeFormat.format(current) + "; " +
								message
							   );
		}
	}
	
	public static void display(String message) {
		System.out.println(message);
		isWrittenTo = true;
	}
	
	public static void display() {
		System.out.println();
		isWrittenTo = true;
	}
	
	public static void error(String message) {
		if (isWrittenTo) {
			isWrittenTo = false;
			System.out.flush();
		}
		System.err.println(message);
	}
	
	public static void error(String message, Exception exception) {
		error(message);
		error(exception);
	}
	
	public static void error(Exception exception) {
		if (isWrittenTo) {
			isWrittenTo = false;
			System.out.flush();
		}
		if (traceLevel == HIGH) {
			exception.printStackTrace(System.err);
		} else {
			error(exception.getMessage());
		}
	}
	/**
	 * Gets the traceLevel
	 * @return Returns a int
	 */
	public static int getTraceLevel() {
		return traceLevel;
	}
	/**
	 * Sets the traceLevel
	 * @param traceLevel The traceLevel to set
	 */
	public static void setTraceLevel(int traceLevel) {
		Trace.traceLevel = traceLevel;
	}

}

