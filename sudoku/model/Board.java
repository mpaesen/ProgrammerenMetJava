package model;

import java.util.Arrays;
import java.util.Random;

import utilities.Constants;

/**
 * @author bempn
 *
 */
public class Board implements Comparable{
	private Cell[][] board = new Cell[(int)Math.pow(Constants.DIMENSION, 2.0)][(int)Math.pow(Constants.DIMENSION, 2.0)];

	public Board() {
		for (int x = 0; x < board.length; x++) {
			board[x] = createArrayOfCells((int)Math.pow(Constants.DIMENSION, 2.0));
		}
	}

	/**
	 * creates a single dimension array of Cells
	 * 
	 * @param i
	 * @return
	 */
	private Cell[] createArrayOfCells(int i) {
		Cell[] array = new Cell[i];

		for (int x = 0; x < array.length; x++) {
			array[x] = new Cell();
		}
		return array;
	}

	/**
	 * initializes the field with random figures 1<= n <=
	 */
	public void generateBoard() {
		int generatedFigure = 0;

		int y = 0;
		int x = 0;
		while (x < board.length) {
			y = 0;
			while (y < board[x].length) {
				generatedFigure =  newFigure(getRow(x), getColumn(y),
						getFieldAsSingle(x, y), Constants.getRandom());
				if (generatedFigure < 0) {
					do {
						board[x] = createArrayOfCells((int)Math.pow(Constants.DIMENSION, 2.0));
						x += ((x > 0) ? -1 : 0);
					} while (x % ((int)Math.pow(Constants.DIMENSION, 2.0))!= 0);
					// stay on current row
					break;
				}
				board[x][y++].setValue(generatedFigure);
			}
			x++;
		}
	}

	/**
	 * looks for unique figures (help method for generateCombination
	 * 
	 * @param rnd
	 * @return a int n with 1<=n<= in respect to already existing figures
	 * @throws Exception
	 */
	private int newFigure(Cell[] rows, Cell[] columns, Cell[] field, Random rnd) {

		int generatedFigure = 0;
		int generated[] = new int[(int)Math.pow(Constants.DIMENSION, 2.0)];
		Arrays.fill(generated,  0);
		do {
			do {
				generatedFigure =  (1 + rnd.nextInt((int)Math.pow(Constants.DIMENSION, 2.0)));				
			} while (exists(generated, generatedFigure));

			if (allFiguresGenerated(generated, generatedFigure)) {
				Constants.logger.debug("Alle cijfers zijn gegenereerd"
						+ Arrays.toString(generated));
				return -1;
			}
		} while (exists(rows, generatedFigure)
				|| exists(columns, generatedFigure)
				|| exists(field, generatedFigure)
				|| generatedFigure < Constants.MIN);
		return generatedFigure;
	}

	/**
	 * @param x
	 * @return int
	 */
	private int calculateStartPositionDim1(int x) {
//		return x % (Constants.DIMENSION);
		switch (x) {
		case 0:
			return 0;
		case 1:		
			return Constants.DIMENSION;
		default:
			return 999;
		}
	}
	
	/**
	 * @param x
	 * @return int
	 */
	private int calculateStartPositionDim2(int x) {
//		return x % (Constants.DIMENSION);
		switch (x) {
		case 0:
		case 1:
			return 0;
		case 2:
		case 3:
			return Constants.DIMENSION;
	default:
			return 999;
		}
	}
	/**
	 * @param x
	 * @return int
	 */
	private int calculateStartPositionDim3(int x) {
//		return x % (Constants.DIMENSION);
		switch (x) {
		case 0:
		case 1:
		case 2:
			return 0;
		case 3:
		case 4:
		case 5:
			return Constants.DIMENSION;
		case 6:
		case 7:
		case 8:
			return Constants.DIMENSION * 2;			
		default:
			return 999;
		}
	}
	/**
	 * @param x
	 * @return int
	 */
	private int calculateStartPositionDim4(int x) {//		
		switch (x) {
		case 0:
		case 1:
		case 2:
		case 3:
			return 0;
		case 4:
		case 5:
		case 6:
		case 7:
			return Constants.DIMENSION;
		case 8:
		case 9:
		case 10:
		case 11:
			return Constants.DIMENSION * 2;
		case 12:
		case 13:
		case 14:
		case 15:
			return Constants.DIMENSION * 3;
		default:
			return 999;
		}
	}
	/**
	 * @param x
	 * @return int
	 */
	private int calculateStartPositionDim5(int x) {
		switch (x) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			return 0;
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			return Constants.DIMENSION;
		case 10:
		case 11:
		case 12:
		case 13:
		case 14:
			return Constants.DIMENSION * 2;
		case 15:
		case 16:
		case 17:
		case 18:
		case 19:
			return Constants.DIMENSION * 3;
		case 20:
		case 21:
		case 22:
		case 23:
		case 24:
			return Constants.DIMENSION * 4;			
		default:
			return 999;
		}
	}

	private int getDimension(int x) {
		switch (Constants.DIMENSION) {		
		case 1:
			return calculateStartPositionDim1(x);
		case 2:
			return calculateStartPositionDim2(x);
		case 3:
			return calculateStartPositionDim3(x);
		case 4:
			return calculateStartPositionDim4(x);
		case 5:
			return calculateStartPositionDim5(x);
		default:
			return 999;
		}
	}
	/**
	 * @param x
	 * @param y
	 * @return cell[]
	 */
	private Cell[] getFieldAsSingle(int x, int y) {
		int startX = getDimension(x);
		int startY = getDimension(y);		

		Cell[][] field = new Cell[Constants.DIMENSION][Constants.DIMENSION];
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				field[i][j] = board[startX + i][startY + j];
			}
		}

		Cell[] fieldAsSingle = new Cell[(int)Math.pow(Constants.DIMENSION, 2.0)];
		int index = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				fieldAsSingle[index++] = field[i][j];
			}
		}
		return fieldAsSingle;
	}

	/**
	 * @param generated
	 * @param generatedFigure
	 * @return true/false
	 */
	private boolean allFiguresGenerated(int[] generated, int generatedFigure) {
		/** generatedFigure is not yet used */
		if (Arrays.binarySearch(generated, generatedFigure) < 0) {
			int index = 0;
			while (index < ((int)Math.pow(Constants.DIMENSION, 2.0))) {
				if (generated[index] == 0) {
					generated[index] = generatedFigure;
					return false;
				}
				index++;
			}
			return true;
		} else {
			/** not all the figures between 1 and MAX have been used already */
			if (Arrays.binarySearch(generated,  0) < 0) {
				return true;
			}
			return false;
		}
	}

	/**
	 * finds existing figures in the field array
	 * 
	 * @param cijfer
	 * @return
	 */
	private boolean exists(Cell[] cells, int figure) {
		int i = 0;
		Cell[] copy = new Cell[cells.length];
		System.arraycopy(cells, 0, copy, 0, cells.length);
		while (i < copy.length - 1 && cells[i] != null) {
			if (cells[i].getValue() == figure)
				return true;
			i++;
		}
		return false;
	}

	/**
	 * finds existing figures in the field array
	 * 
	 * @param cijfer
	 * @return
	 */
	private boolean exists(int[] cells, int figure) {
		int i = 0;
		int[] copy = new int[cells.length];
		System.arraycopy(cells, 0, copy, 0, cells.length);
		while (i < copy.length - 1 && cells[i] != 0) {
			if (cells[i] == figure)
				return true;
			i++;
		}
		return false;
	}

	/**
	 * prints the whole field as a single Array
	 */
	public static void printArray(Cell[] arr) {
		System.out.print("[");
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]);
		}
		System.out.print("]\n");
	}

	/**
	 * @return Returns the board.
	 */
	public Cell[][] getBoard() {
		return board;
	}

	/**
	 * Returns an array of all the Cells of a row from the board
	 * 
	 * @param index
	 * @return Cell[]
	 */
	public Cell[] getRow(int index) {

		return board[index];
	}

	/**
	 * Returns an array of all the Cells of a column from the board
	 * 
	 * @param index
	 * @return Cell[]
	 */
	public Cell[] getColumn(int index) {
		Cell[] column = new Cell[(int)Math.pow(Constants.DIMENSION, 2.0)];

		for (int i = 0; i < board.length; i++) {
			column[i] = board[i][index];
		}
		return column;
	}

	/**
	 * @param i,j
	 *            identify a field on the board x,y identify a cell on a field
	 * @return a specific Cell from a field on the board
	 */
	public Cell getCell(int i, int j) {
		return board[i][j];
	}

	
	public void setCell(int i, int j, int value){			
		getCell(i,j).setValue(value);
	}
	/**
	 * 
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("\n--------- --------- ---------\n");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				output.append(board[i][j]);
				output.append((j == 2) ? " " : "");
				output.append((j == 5) ? " " : "");
			}
			switch (i) {
			case 2:
			case 5:
				output.append("\n\n");
				break;
			default:
				output.append("\n");

			}

		}
		output.append("--------- --------- ---------\n");
		return output.toString();
	}
	/**
	 * @param board
	 * @return -1, 0, 1 (smaller, equal, bigger)
	 */
	public int compareTo(Object board){
		for(int i = 0; i< this.getBoard().length; i++){
			for(int j = 0; j<this.getRow(i).length; j++){
				if(this.getCell(i,j).compareTo(((Board)board).getCell(i,j)) != 0){					
					return this.getCell(i,j).compareTo(((Board)board).getCell(i,j));
				}			
			}
		}
		return 0;
	}
	
	/**
	 * @param board
	 * @return deep copy of board
	 */
	public static Board clone(Board board){
		Board copy = new Board();
		for(int i = 0; i< board.getBoard().length; i++){
			for(int j = 0; j< board.getRow(i).length; j++){				
					copy.setCell(i,j,((Board)board).getCell(i,j).getValue());				
			}
		}
		return copy;
	}
}
