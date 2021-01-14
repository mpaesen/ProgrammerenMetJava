package view;

import model.Board;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import utilities.Constants;

//import model.Cell;
/**
 * @author bempn
 * 
 */
public class TestBoard
{

	/**
	 * @param args
	 */
	public static void main(final String... args)
	{
		BasicConfigurator.configure();
		//Constants.logger.setLevel(Level.ERROR);
		Constants.logger.setLevel(Level.INFO);
		//Constants.logger.setLevel(Level.OFF);
		final Board board = new Board();
		board.generateBoard();
		Constants.logger.info(board);

		final Board copy = Board.clone(board);
		copy.setCell(Constants.getRandom().nextInt((int) Math.pow(Constants.DIMENSION, 2.0)),//i
				Constants.getRandom().nextInt((int) Math.pow(Constants.DIMENSION, 2.0)), //j
				Constants.getRandom().nextInt((int) Math.pow(Constants.DIMENSION, 2.0))); //value
		Constants.logger.info(copy);
		System.out.print("\nBoard and Copy are equal : " + board.compareTo(copy));
	}
}
