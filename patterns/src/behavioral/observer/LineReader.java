package behavioral.observer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class LineReader implements LineSubject {
	private Scanner in;
	private HashMap<LineObserver, LineObserver> observers;
	private int maxLines;
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

	public void start() throws IOException {
		// read from the console and notify the listeners
		do {
			line = in.nextLine();
			if (line != null) {
				notifyObservers();
			}
		} while (line != null);
	}
}