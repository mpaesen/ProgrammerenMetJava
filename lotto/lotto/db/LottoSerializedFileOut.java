// Voeg aan de klasse LottoCombinatie de volgende methoden toe:
// Schrijf 100000 willekeurige lottocombinaties naar een bestand en lees ze terug in
// Zoek de meer dan eens voorkomende combinatie(s)

package lotto.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import lotto.model.LottoCombination;
import lotto.ui.BadLimitException;
import utilities.FileIO;

/** implementation of a file acces program */
/**
 * @author bempn
 *
 */
public class LottoSerializedFileOut {
	private final int MAX_FIGURE; //max figure for each combination
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
	 * @param numberOfElements
	 * @param MAX_FIGURE
	 */
	public LottoSerializedFileOut(int numberOfElements, int MAX_FIGURE) {
		this(numberOfElements, MAX_FIGURE, 6);
	}

	/**
	 * @param numberOfElements
	 * @param MAX_FIGURE
	 * @param MAX_COMBINATION
	 */
	public LottoSerializedFileOut(
		int numberOfElements,
		int MAX_FIGURE,
		int MAX_COMBINATION) {
		super();
		this.numberOfElements = numberOfElements;
		this.MAX_FIGURE = MAX_FIGURE; //max figure for each combination
	}

	/**
	 * @throws InvalidClassException
	 * @throws NotSerializableException
	 * @throws IOException
	 * @throws BadLimitException
	 */
	@SuppressWarnings("unchecked")
	public void streamSerializedList()
		throws
			InvalidClassException,
			NotSerializableException,
			IOException,
			BadLimitException {
		List out = new ArrayList(numberOfElements);

		for (int i = 0; i < numberOfElements; i++) {
			out.add(new LottoCombination(rnd, MAX_FIGURE));
		}

		Collections.sort(out);

		outputStream.writeObject(out);
		this.close();
	}
	
	/**
	 * @param list
	 * @throws InvalidClassException
	 * @throws NotSerializableException
	 * @throws IOException
	 * @throws BadLimitException
	 */
	@SuppressWarnings("unchecked")
	public void streamSerializedList(List list)
		throws
			InvalidClassException,
			NotSerializableException,
			IOException,
			BadLimitException {

		Collections.sort(list);

		outputStream.writeObject(list);
		this.close();
	}

	/**
	 * @throws IOException
	 */
	private void close() throws IOException {
		outputStream.close();
	}

	/**
	 * @param outputStreamFile
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws BadLimitException
	 */
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
