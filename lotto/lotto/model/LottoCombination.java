package lotto.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import lotto.ui.BadLimitException;

@SuppressWarnings("unchecked")
public class LottoCombination implements Serializable, Comparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5375157488915775867L;

	private int[] combination;

	private int maximumValue;

	private int minimumValue;

	private int elementsInCombination;

	/**
	 * 
	 */
	public LottoCombination() {
		this(43);
	}

	/**
	 * @param rnd
	 * @param maximumValue
	 * @throws BadLimitException
	 */
	public LottoCombination(Random rnd, int maximumValue)
			throws BadLimitException {
		this(rnd, 1, maximumValue, 6);
	}

	/**
	 * @param rnd
	 * @param minimumValue
	 * @param maximumValue
	 * @param elementsInCombination
	 * @throws BadLimitException
	 */
	public LottoCombination(Random rnd, int minimumValue, int maximumValue,
			int elementsInCombination) throws BadLimitException {
		this(minimumValue, maximumValue, elementsInCombination);
		quickPick(rnd);
		this.sort();
	}

	/**
	 * @param maximumValue
	 */
	public LottoCombination(int maximumValue) {
		this(1, maximumValue, 6);
	}

	/**
	 * @param minimumValue
	 * @param maximumValue
	 * @param elementsInCombination
	 */
	public LottoCombination(int minimumValue, int maximumValue,
			int elementsInCombination) {
		super();
		this.elementsInCombination = elementsInCombination;
		this.minimumValue = minimumValue;
		initializeCombination();
		this.maximumValue = maximumValue;
	}

	/**
	 * 
	 */
	private void initializeCombination() {
		combination = new int[getElementsInCombination()];
		for (int i = 0; i < combination.length; i++)
			combination[i] = 0;
	}

	/**
	 * @param rnd
	 * @throws BadLimitException
	 */
	public void quickPick(Random rnd) throws BadLimitException {
		for (int i = 0; i < combination.length; i++) {
			combination[i] = nieuwCijfer(rnd);
		}
	}

	/**
	 * @param rnd
	 * @return
	 * @throws BadLimitException
	 */
	public int nieuwCijfer(Random rnd) throws BadLimitException {
		/** zolang het getal bestaat of het getal = 0: zoek een nieuw getal */

		int hulp, iteraties = 0;
		do {
			iteraties++;
			if (iteraties > 500)
				throw new BadLimitException(this.maximumValue,
						this.elementsInCombination);
			hulp = rnd.nextInt(maximumValue + 1);
		} while (exists(hulp) || (hulp < minimumValue));
		return hulp;
	}

	/**
	 * @param cijfer
	 * @return
	 */
	public boolean exists(int cijfer) {
		int i = 0;
		while (i < combination.length) {
			if (combination[i] == cijfer)
				return true;
			i++;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		ArrayList v = new ArrayList(combination.length);
		DecimalFormat twoDigits = new DecimalFormat("00");
		for (int i = 0; i < combination.length; i++) {
			v.add(twoDigits.format(combination[i]));
		}
		return v.toString();
	}

	/**
	 * @return
	 */
	public int getMaximumValue() {
		return maximumValue;
	}

	/**
	 * @param seed
	 */
	public void setMaximumValue(int seed) {
		this.maximumValue = seed;
	}

	/**
	 * @return
	 */
	public int[] getCombination() {
		return combination;
	}

	/**
	 * @param i
	 * @return
	 */
	public int getCombination(int i) {
		return combination[i];
	}

	/**
	 * @param is
	 */
	public void setCombination(int index, int is) {
		combination[index] = is;
	}

	/**
	 * @return
	 */
	public int getElementsInCombination() {
		return elementsInCombination;
	}

	/**
	 * @param i
	 */
	public void setElementsInCombination(int i) {
		elementsInCombination = i;
	}

	/**
	 * @return
	 */
	public int getMinimumValue() {
		return minimumValue;
	}

	/**
	 * @param i
	 */
	public void setMinimumValue(int i) {
		minimumValue = i;
	}

	/**
	 * @param arr
	 * @return
	 */
	public boolean equals(int[] arr) {
		return Arrays.equals(this.getCombination(), arr);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object l) {
		return equals(((LottoCombination) l).getCombination());
	}

	/**
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	private int compare(int[] arr1, int[] arr2) {
		if (arr1.equals(arr2))
			return 0;
		if (arr1.length > arr2.length)
			return 1;
		if (arr1.length < arr2.length)
			return -1;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] > arr2[i])
				return 1;
			if (arr1[i] < arr2[i])
				return -1;
		}
		return 0;
	}

	/**
	 * @param combination
	 * @return
	 */
	public int compareTo(Object combination) {
		return compare(this.getCombination(), ((LottoCombination) combination)
				.getCombination());
	}

	/**
	 * 
	 */
	public void sort() {
		Arrays.sort(getCombination());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int code = 0;
		for (int i = 0; i < getCombination().length; i++)
			code += getCombination(i);
		return (code % 97);
	}

}
