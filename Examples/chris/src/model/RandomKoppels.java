package model;

import java.util.Random;

public class RandomKoppels {
	private static String leerlingen[] = { "a", "b", "c", "d", "e", "f", "g",
			"h", "i", "j", "k", "l", "m", "n" };

	/**
	 * @return the leerlingen
	 */
	public static String[] getLeerlingen() {
		return leerlingen;
	}

	/**
	 * @param leerlingen the leerlingen to set
	 */
	public static void setLeerlingen(String[] leerlingen) {
		RandomKoppels.leerlingen = leerlingen;
	}

	public static String genereerKoppel(int i) {
		Random random = new Random();
		StringBuffer buffer;
		int j = 0;
		do {
			j = random.nextInt(leerlingen.length);
		} while (j == i);

		if (leerlingen[i].charAt(0) < leerlingen[j].charAt(0)) {
			buffer = new StringBuffer(leerlingen[i]);
			buffer.append(" ");
			buffer.append(leerlingen[j]);
		} else {
			buffer = new StringBuffer(leerlingen[j]);
			buffer.append(" ");
			buffer.append(leerlingen[i]);
		}
		return buffer.toString();
	}


}
