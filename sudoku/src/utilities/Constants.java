package utilities;

import java.util.Random;

import org.apache.log4j.Logger;

public final class Constants {
	private static final Random random = new Random();
	
	public static final byte DIMENSION = 3;
	public static final byte MIN = 1;
	public static final Logger logger = Logger.getLogger(Constants.class);
	public enum Selection  {ROW, COL};
	
	/**
	 * @return Returns the random.
	 */
	public static Random getRandom() {
		return random;
	}

}
