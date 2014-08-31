// Zoek de meest voorkomende combinatie in100000 lottocombinaties

package lotto.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import lotto.model.LottoCombination;
import utilities.FileIO;

/** implementation of a file acces program */
public class LottoSerializedFileIn {
	@SuppressWarnings("unchecked")
	private ArrayList uniek = new ArrayList();
	@SuppressWarnings("unchecked")
	private ArrayList count = new ArrayList();
	private ObjectInputStream inputStream;
	/**
	 * @param input
	 */
	@SuppressWarnings("unchecked")
	public void fillUp(ArrayList input) {
		int positie, aantal;
		for (int i = 0; i < input.size() - 1; i++) {
			for (int j = i + 1; j < input.size(); j++) {
				if (((LottoCombination) input.get(i))
					.equals((LottoCombination) input.get(j))) {
					if (!uniek.contains(input.get(i))) {
						uniek.add(input.get(i));
						count.add(new Integer(2));
						//eerste unieke voorkomen van een lotto combinatie
					} else {
						positie = uniek.indexOf(input.get(i));
						aantal = ((Integer) count.get(positie)).intValue();
						count.set(positie, new Integer(++aantal));
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
	public ArrayList getSerializedList(String stream)
		throws IOException, FileNotFoundException, ClassNotFoundException {
		inputStream = FileIO.getObjectInputStream(stream);
		ArrayList v = (ArrayList) inputStream.readObject();
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
	@SuppressWarnings("unchecked")
	public ArrayList getCount() {
		return count;
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList getUniek() {
		return uniek;
	}

	/**
	 * @param arrayList
	 */
	@SuppressWarnings("unchecked")
	public void setCount(ArrayList arrayList) {
		count = arrayList;
	}

	/**
	 * @param arrayList
	 */
	@SuppressWarnings("unchecked")
	public void setUniek(ArrayList arrayList) {
		uniek = arrayList;
	}

}
