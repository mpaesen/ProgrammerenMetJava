package ch6;

public class Carlot extends Object{
	private int[] carPlates;
	private char[] carStatus;
	private int maxCars;

	public static final int PLATES_NOTSET = -999999;
	public static final char STATUS_RENTED = 'R',
		STATUS_NOTRENTED = 'A',
		STATUS_NOTSET = ' ';

	public Carlot(int maxCars) {
		super();
		this.maxCars = maxCars;
		carPlates = new int[maxCars];
		carStatus = new char[maxCars];
		for (int i = 0; i < carPlates.length; i++) {
			carPlates[i] = PLATES_NOTSET;
			carStatus[i] = STATUS_NOTSET;
		}
	}

	private int getAvailableSlot() {
		int retidx = -1;
		for (int i = 0; i < carStatus.length; i++) {
			if (carStatus[i] == STATUS_NOTSET) {
				retidx = i;
				//break;
				return i;
			}
		}
		return retidx;
	}

	private int getAvailableRental() {
		int retidx = -1;
		for (int i = 0; i < carStatus.length; i++) {
			if ((carStatus[i] == STATUS_NOTSET)
				|| (carStatus[i] == STATUS_NOTRENTED)) {
				retidx = i;
				break;
			}
		}
		return retidx;
	}

	public void addCarToLot(int plate) {
		int nextSlot = getAvailableSlot();
		carPlates[nextSlot] = plate;
		carStatus[nextSlot] = STATUS_NOTRENTED;
	}

	public int rentACar() {
		int nextRental = getAvailableRental();
		carStatus[nextRental] = STATUS_RENTED;
		return carPlates[nextRental];
	}

	public boolean returnACar(int plate) {
		int plateidx = -1;
		for (int i = 0; i < carPlates.length; i++) {
			if (carPlates[i] == plate) {
				plateidx = i;
				carStatus[plateidx] = STATUS_NOTRENTED;
				return true;
			}
		}
		return false;
	}
	/**
	 * @return
	 */
	public int[] getCarPlates() {
		return carPlates;
	}
	public int getCarPlates(int i) {
		return carPlates[i];
	}
	/**
	 * @return
	 */
	public char[] getCarStatus() {
		return carStatus;
	}
	public char getCarStatus(int i) {
		return carStatus[i];
	}

	/**
	 * @return
	 */
	public int getMaxCars() {
		return maxCars;
	}

	/**
	 * @param is
	 */
	public void setCarPlates(int[] is) {
		carPlates = is;
	}

	/**
	 * @param cs
	 */
	public void setCarStatus(char[] cs) {
		carStatus = cs;
	}

	/**
	 * @param i
	 */
	public void setMaxCars(int i) {
		maxCars = i;
	}

}

