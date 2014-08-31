package keybIO;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/** standard keyboard */
public final class KeybIO {
	static private BufferedReader kb = new BufferedReader(
			new InputStreamReader(System.in));

	/** read an integer from the keyboard */
	public static int readInt() {
		try {
			return Integer.parseInt(kb.readLine());
		} catch (Exception e) {
			System.out.println(e);
			return readInt();
		}
	}

	/** read a double from the keyboard */
	public static double readDouble() {
		try {
			return Double.parseDouble(kb.readLine());
		} catch (Exception e) {
			System.out.println(e);
			return readDouble();
		}
	}

	/** read a string from the keyboard */
	public static String readString() {
		try {
			return kb.readLine();
		} catch (Exception e) {
			System.out.println(e);
			return readString();
		}
	}

	/** read a string from the keyboard */
	public static String readString(String str) {
		try {
			return kb.readLine();
		} catch (Exception e) {
			System.out.println(e);
			return readString();
		}
	}

	private static DataInputStream inc = new DataInputStream(System.in);

	/** read a character from the keyboard */
	public static char readChar() {
		try {
			return (char) inc.readByte();
		} catch (Exception e) {
			System.out.println(e);
			return readChar();
		}
	}

	/** write an object on screen */
	public static void write(Object o) {
		System.out.print(o);
	}

	/** write an object on screen with a line skip */
	public static void writeln(Object o) {
		System.out.println(o);
	}

	/** write an integer on screen */
	public static void write(int x) {
		System.out.print(x);
	}

	/** write a double on screen */
	public static void write(double x) {
		System.out.print(x);
	}

	/** write an integer on screen with a line skip */
	public static void writeln(int x) {
		System.out.println(x);
	}

	/** write a double on screen with a line skip */
	public static void writeln(double x) {
		System.out.println(x);
	}

	/** to prevent automatic closure under windows */
	public static void end() {
		write("Press \"Enter\" to end the session");
		try {
			System.in.read();
		} catch (IOException e) {
			return;
		}
	}
}