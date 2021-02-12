// Voeg aan de klasse LottoCombinatie de volgende methoden toe:
// Schrijf 100000 willekeurige lottocombinaties naar een bestand en lees ze terug in
// Zoek de meer dan eens voorkomende combinatie(s)

package lotto.db;

import lotto.model.BadLimitException;
import lotto.model.LottoCombination;
import utilities.FileIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/** implementation of a file acces program */
public class LottoSerializedFileOut {
	private final int MAX_FIGURE; // max figure for each combination
	private final int MAX_COMBINATION; // max length for each combination
	private Random rnd = new Random();
	private int numberOfElements;
	private ObjectOutputStream outputStream;

	/**
	 * 
	 */
	public LottoSerializedFileOut() {
		this(50, 42, 6);
	}

	/**
	 * 
	 */
	public LottoSerializedFileOut(int numberOfElements, int MAX_FIGURE) {
		this(numberOfElements, MAX_FIGURE, 6);
	}

	public LottoSerializedFileOut(int numberOfElements, int MAX_FIGURE,
			int MAX_COMBINATION) {
		super();
		this.numberOfElements = numberOfElements;
		this.MAX_FIGURE = MAX_FIGURE; // max figure for each combination
		this.MAX_COMBINATION = MAX_COMBINATION;
	}

	public void streamSerializedList() throws
            IOException, BadLimitException {
		List out = new ArrayList(numberOfElements);

		for (int i = 0; i < numberOfElements; i++) {
			out.add(new LottoCombination(rnd, MAX_FIGURE));
		}

		Collections.sort(out);

		outputStream.writeObject(out);
		this.close();
	}

	public void streamSerializedList(List list) throws
            IOException, BadLimitException {

		Collections.sort(list);

		outputStream.writeObject(list);
		this.close();
	}

	private void close() throws IOException {
		outputStream.close();
	}

	public void generateSerializedList(String outputStreamFile)
			throws IOException, FileNotFoundException, BadLimitException {
		outputStream = FileIO.getObjectOutputStream(outputStreamFile);
		/** serialize an object and write it to disk */
		this.streamSerializedList();
	}

	/**
	 * @return
	 */
	public int getNumberOfElements() {
		return numberOfElements;
	}

	/**
	 * @param i
	 */
	public void setNumberOfElements(int i) {
		numberOfElements = i;
	}

	/**
	 * @return
	 */
	public Random getRnd() {
		return rnd;
	}

	/**
	 * @param random
	 */
	public void setRnd(Random random) {
		rnd = random;
	}

	/**
	 * @param stream
	 */
	public void setOutput(ObjectOutputStream stream) {
		outputStream = stream;
	}

}
