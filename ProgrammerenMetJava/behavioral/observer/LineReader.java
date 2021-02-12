package behavioral.observer;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class LineReader implements LineSubject {
	private final Scanner in;
	private final HashMap<LineObserver, LineObserver> observers;
	private final int maxLines;
	private String line;

	public LineReader(InputStream is, int maxLines) throws IOException {
		in = new Scanner(is);
		this.maxLines = maxLines;
		observers = new HashMap<LineObserver, LineObserver>();
	}

	@Override
	public void addObserver(LineObserver observer) {
		observers.put(observer, observer);

	}

	@Override
	public String getLine() {

		return line;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void notifyObservers() {
		Iterator<LineObserver> it = (observers.values()).iterator();
		LineObserver observer;
		while (it.hasNext()) {
			observer = it.next();
			observer.handleLine(this);
		}

	}

	@Override
	public void removeObserver(LineObserver observer) {
		observers.remove(observer);
	}

	public void start(int max) throws IOException {
		// read from the console and notify the listeners
		int count = 0;
		do {
			line = in.nextLine();
			count++;
			if (line != null) {
				notifyObservers();
			}
		} while (count <= max);
	}
}