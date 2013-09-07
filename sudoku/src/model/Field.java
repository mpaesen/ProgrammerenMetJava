package model;

import java.util.Random;

import utilities.Constants;

import model.Cell;

public class Field {
	private byte position;

	private Cell[][] field = new Cell[Constants.DIMENSION][Constants.DIMENSION];

	public Field(byte position) {
		this.position = position;
		for (byte i = 0; i < field.length; i++) {
			for (byte j = 0; j < field[i].length; j++) {
				field[i][j] = new Cell();
			}
		}
		generateCombination();
	}

	/**
	 * @return Returns as a 2-dimension array[][].
	 */
	public Cell[][] getField() {
		return field;
	}

	/**
	 * @return Returns a field as a 1-dimension array[].
	 */
	public Cell[] getCellArray() {
		Cell[] singleArray = new Cell[Constants.DIMENSION * Constants.DIMENSION];
		byte idx = 0;
		for (byte i = 0; i < getField().length; i++) {
			for (byte j = 0; j < getField()[i].length; j++) {
				singleArray[idx++] = getField()[i][j];
			}
		}
		return singleArray;
	}

	/**
	 * @param rowNumber
	 * @return a row from a field
	 */
	public Cell[] getRow(byte row) {
		return field[row];
	}

	/**
	 * @param columnNumber
	 * @return a column from a field
	 */
	public Cell[] getColumn(byte column) {
		Cell[] columns = new Cell[Constants.DIMENSION];

		for (byte x = 0; x < field.length; x++) {
			columns[x] = field[x][column];
		}
		return columns;
	}

	/**
	 * @return Returns one cell of a field. via the 2-dimensional array
	 */
	public Cell getCell(byte x, byte y) {
		return field[x][y];
	}

	/**
	 * @param replaces
	 *            one cell in a field
	 */
	public void setCell(Cell cell, int x, int y) {
		field[x][y] = cell;
	}

	/**
	 * @return Returns one cell of a field. via the 1-dimensional array
	 */
	public Cell getCell(byte i) {
		return getCellArray()[i];
	}

	/**
	 * @return Returns the position of a field.
	 */
	public byte getPosition() {
		return position;
	}

	/**
	 * initializes the field with random figures 1<= n <=9
	 */
	private void generateCombination() {

		for (byte x = 0; x < field.length; x++) {
			for (byte y = 0; y < field[x].length; y++) {
				field[x][y].setValue((byte) newFigure(Constants.getRandom()));
			}
		}
	}

	/**
	 * looks for unique figures (help method for generateCombination
	 * 
	 * @param rnd
	 * @return a int n with 1<=n<=9 in respect to already existing figures
	 * @throws Exception
	 */
	private int newFigure(Random rnd) {
		/** while the figure exists or =0, find a new figure */

		byte hulp = 0;
		do {
			hulp = (byte) (1 + rnd.nextInt(Constants.DIMENSION * Constants.DIMENSION));
		} while (exists(hulp) || (hulp < Constants.MIN));
		Constants.logger.debug(hulp);
		return hulp;
	}

	/**
	 * finds existing figures in the field array
	 * 
	 * @param cijfer
	 * @return
	 */
	private boolean exists(byte cijfer) {
		byte i = 0;
		Cell[] cells = getCellArray();
		while (i < cells.length && cells[i] != null) {
			if (cells[i].getValue() == cijfer)
				return true;
			i++;
		}
		return false;
	}

	/**
	 * prints the whole field as a single Array
	 */
	public static void printArray(Cell[] arr) {
		Constants.logger.info("\nWhole Field as single Array[");
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]);
		}
		Constants.logger.info("]\n");
	}

	/**
	 * eliminate dupplicates in each row and each column
	 * 
	 * @param Field
	 *            1,2,3,4
	 */
	public void reArrangeCellsInField(Field one, Field two, Field three,
			Field four, int field) {
		for (byte i = 0; i < this.getField().length; i++) {
			for (byte j = 0; j < this.getField()[i].length; j++) {
				switch (field) {
				case 1:
					break;
				case 2: {
					compareRowsFromOne(one, i, j);
					break;
				}
				case 3: {
					compareRowsFromOneAndTwo(one, two, three, i, j);
					break;
				}
				case 4: {
					compareColumnsFromOne(one, i, j);
					break;
				}
				case 5: {
					compareRowsFromFourColumnsFromTwo(one, two, i, j);
					break;
				}
				case 6: {
					compareRowsFourAndFiveColumnsThree(one, two, three, i, j);
					break;
				}
				case 7: {
					compareColumnsOneAndFour(one, two, i, j);
					break;
				}
				case 8: {
					compareColumnsTwoAndFiveRowsSeven(one, two, three, i, j);
					break;
				}
				case 9: {
					compareColumnsThreeAndSixRowsSevenAndEight(one, two, three,
							four, i, j);
					break;
				}
				default:
					break;
				}
			}
		}
	}

	/**
	 * @param one
	 * @param two
	 * @param three
	 * @param four
	 * @param i
	 * @param j
	 */
	private void compareColumnsThreeAndSixRowsSevenAndEight(Field three,
			Field six, Field seven, Field eight, byte i, byte j) {
		Cell[] row;
		Cell[] column;
		row = concatArray(seven.getRow(i), eight.getRow(i));
		compareAllArrayValues(row, i, j, Constants.Selection.ROW);
		column = concatArray(three.getColumn(j), six.getColumn(j));
		compareAllArrayValues(column, i, j, Constants.Selection.COL);
	}

	/**
	 * @param one
	 * @param two
	 * @param three
	 * @param i
	 * @param j
	 */
	private void compareColumnsTwoAndFiveRowsSeven(Field two, Field five,
			Field seven, byte i, byte j) {
		Cell[] column;
		column = concatArray(two.getColumn(j), five.getColumn(j));
		compareAllArrayValues(column, i, j, Constants.Selection.COL);
		compareRowsFromOne(seven, i, j);
	}

	/**
	 * @param one
	 * @param two
	 * @param i
	 * @param j
	 */
	private void compareColumnsOneAndFour(Field one, Field four, byte i, byte j) {
		Cell[] column;
		column = concatArray(one.getColumn(j), four.getColumn(j));
		compareAllArrayValues(column, i, j, Constants.Selection.COL);
	}

	/**
	 * @param one
	 * @param two
	 * @param i
	 * @param j
	 */
	private void compareRowsFourAndFiveColumnsThree(Field four, Field five,
			Field three, byte i, byte j) {
		Cell[] row;
		row = concatArray(four.getRow(i), five.getRow(i));
		compareAllArrayValues(row, i, j, Constants.Selection.ROW);
		compareColumnsFromOne(three, i, j);
	}

	/**
	 * @param one
	 * @param i
	 * @param j
	 */
	private void compareRowsFromOne(Field one, byte i, byte j) {
		Cell[] row;
		row = one.getRow(i);
		compareAllArrayValues(row, i, j, Constants.Selection.ROW);
	}

	/**
	 * @param one
	 * @param two
	 * @param i
	 * @param j
	 */
	private void compareRowsFromFourColumnsFromTwo(Field four, Field two,
			byte i, byte j) {
		Cell[] row;
		Cell[] column;
		row = four.getRow(i);
		compareAllArrayValues(row, i, j, Constants.Selection.ROW);
		column = two.getColumn(j);
		compareAllArrayValues(column, i, j, Constants.Selection.COL);
	}

	/**
	 * @param one
	 * @param i
	 * @param j
	 */
	private void compareColumnsFromOne(Field one, byte i, byte j) {
		Cell[] column;
		column = one.getColumn(j);
		compareAllArrayValues(column, i, j, Constants.Selection.COL);
	}

	/**
	 * @param one
	 * @param two
	 * @param three
	 * @param i
	 * @param j
	 */
	private void compareRowsFromOneAndTwo(Field one, Field two, Field three,
			byte i, byte j) {
		Cell[] row;
		row = concatArray(one.getRow(i), two.getRow(i));
		compareAllArrayValues(row, i, j, Constants.Selection.ROW);
		// same cell on the next row
	}

	/**
	 * Calculate index of the cell to replace only if original index is smaller
	 * then outer limit
	 * 
	 * @param int
	 *            n
	 * @return int n
	 */

	private byte getIndex(int n) {
		int originalN = n;
		if (n < Constants.DIMENSION - 1) {
			do {
				n = Constants.getRandom().nextInt(Constants.DIMENSION);
			//} while (n > Constants.FIELD_DIMENSION - 1);
			//} while ((n < originalN) || (n > Constants.FIELD_DIMENSION - 1));
			} while ((n == originalN) || (n > Constants.DIMENSION - 1));
		}
		return (byte) n;
	}

	/**
	 * Makes a row/column unique
	 * 
	 * @param arr
	 * @param i,j
	 * @param x,y
	 * @return true/false
	 */
	private void compareAllArrayValues(Cell[] arr, byte i, byte j,
			Constants.Selection sel) {

			for (int k = 0; k < arr.length; k++) {
				if (sel == Constants.Selection.COL) {
					// j doesn't change
					for (byte l = 0; l < Constants.DIMENSION; l++) {
						if (this.getCell(l, j).compareTo(arr[k]) == 0) {
							switchACellWithARandomOtherCell(l, j, sel);
						}
					}
				}
				if (sel == Constants.Selection.ROW) {
					// i doesn't change
					for (byte l = 0; l < Constants.DIMENSION; l++) {
						if (this.getCell(i, l).compareTo(arr[k]) == 0) {
							switchACellWithARandomOtherCell(i, l, sel);
						}
					}
				}
			}
	}


	/**
	 * Concatinates 2 single dimention arrays into one
	 * 
	 * @param Cell[]arr,
	 *            Cell[] arr2
	 * @return Cell[] concat
	 */
	private Cell[] concatArray(Cell[] arr1, Cell[] arr2) {
		Cell[] concat = new Cell[arr1.length + arr2.length];
		for (int k = 0; k < concat.length; k++) {
			if (k < arr1.length) {
				concat[k] = arr1[k];
			} else {
				concat[k] = arr2[k - arr1.length];
			}
		}
		return concat;
	}

	/**
	 * eliminate dupplicates
	 * 
	 * @param indexes
	 *            of the cell that has to be replaced with another
	 */
	private boolean switchACellWithARandomOtherCell(byte i, byte j,
			Constants.Selection sel) {
		Cell cell = null;
		byte x = i;
		byte y = j;
		if (sel == Constants.Selection.ROW) {
			x = getIndex(i);// take at least current line
			y = getIndex(j);// take at least first column
		}
		if (sel == Constants.Selection.COL) {
			x = getIndex(i);// take at least first line
			y = getIndex(j);// take at least current column
		}

		cell = getCell(i, j);
		setCell(getCell(x, y), i, j);
		setCell(cell, x, y);

		return (getCell(i, j).compareTo(getCell(x, y)) == 0) ? false : true;//
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("\n---------\n");
		for (byte i = 0; i < field.length; i++) {
			for (byte j = 0; j < field[i].length; j++) {
				output.append(getCell(i, j).toString());
			}
			output.append("\n");
		}
		output.append("---------\n");
		return output.toString();
	}
}
