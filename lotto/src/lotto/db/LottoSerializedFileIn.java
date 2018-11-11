// Zoek de meest voorkomende combinatie in100000 lottocombinaties

package lotto.db;

import lotto.model.LottoCombination;
import utilities.FileIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/** implementation of a file acces program */
public class LottoSerializedFileIn {
	private ArrayList<LottoCombination> uniek = new ArrayList<LottoCombination>();
	private ArrayList<Integer> count = new ArrayList<Integer>();
	private ObjectInputStream inputStream;
	/**
	 * @param input
	 */
	public void fillUp(ArrayList<LottoCombination> input) {
		int positie, aantal;
		for (int i = 0; i < input.size() - 1; i++) {
			for (int j = i + 1; j < input.size(); j++) {
				if (((LottoCombination) input.get(i))
					.equals((LottoCombination) input.get(j))) {
					if (!uniek.contains(input.get(i))) {
						uniek.add(input.get(i));
						count.add(2);
						//eerste unieke voorkomen van een lotto combinatie
					} else {
						positie = uniek.indexOf(input.get(i));
						aantal = ((Integer) count.get(positie)).intValue();
						count.set(positie, ++aantal);
						//volgende voorkomens
					}
				}
			}
		}
	}

	/**
	 * @param stream
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */

	@SuppressWarnings("unchecked")
	public ArrayList<LottoCombination> getSerializedList(String stream)
		throws IOException, FileNotFoundException, ClassNotFoundException {
		inputStream = FileIO.getObjectInputStream(stream);
		ArrayList<LottoCombination> v = (ArrayList<LottoCombination>) inputStream.readObject();
		this.close();
		return v;
	}

	/**
	 * @throws IOException
	 */
	public void close() throws IOException {
		if (inputStream != null)
			inputStream.close();
	}

	/**
	 * @return
	 */
	public ArrayList<Integer> getCount() {
		return count;
	}

	/**
	 * @return
	 */
	public ArrayList<LottoCombination> getUniek() {
		return uniek;
	}

	/**
	 * @param arrayList
	 */
	public void setCount(ArrayList<Integer> arrayList) {
		count = arrayList;
	}

	/**
	 * @param arrayList
	 */
	public void setUniek(ArrayList<LottoCombination> arrayList) {
		uniek = arrayList;
	}

}
