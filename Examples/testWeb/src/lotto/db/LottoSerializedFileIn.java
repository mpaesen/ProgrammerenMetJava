// Zoek de meest voorkomende combinatie in100000 lottocombinaties

package lotto.db;

import utilities.FileIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/** implementation of a file acces program */
public class LottoSerializedFileIn {
	private ArrayList uniek = new ArrayList();
	private ArrayList count = new ArrayList();
	private ObjectInputStream inputStream;

	public void fillUp(ArrayList input) {
		int positie, aantal;
		for (int i = 0; i < input.size() - 1; i++) {
			for (int j = i + 1; j < input.size(); j++) {
				if (input.get(i)
						.equals(input.get(j))) {
					if (!uniek.contains(input.get(i))) {
						uniek.add(input.get(i));
						count.add(new Integer(2));
						// eerste unieke voorkomen van een lotto combinatie
					} else {
						positie = uniek.indexOf(input.get(i));
						aantal = ((Integer) count.get(positie)).intValue();
						count.set(positie, new Integer(++aantal));
						// volgende voorkomens
					}
				}
			}
		}
	}

	public ArrayList getSerializedList(String stream) throws IOException,
			FileNotFoundException, ClassNotFoundException {
		inputStream = FileIO.getObjectInputStream(stream);
		ArrayList v = (ArrayList) inputStream.readObject();
		this.close();
		return v;
	}

	public void close() throws IOException {
		if (inputStream != null)
			inputStream.close();
	}

	/**
	 * @return
	 */
	public ArrayList getCount() {
		return count;
	}

	/**
	 * @return
	 */
	public ArrayList getUniek() {
		return uniek;
	}

	/**
	 * @param vector
	 */
	public void setCount(ArrayList vector) {
		count = vector;
	}

	/**
	 * @param vector
	 */
	public void setUniek(ArrayList vector) {
		uniek = vector;
	}

}
