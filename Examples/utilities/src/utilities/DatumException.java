package utilities;


public class DatumException extends Exception {
	private String text;
	public DatumException(String str) {
		text = str;
	}

	public DatumException(Datum arg) {
			this(arg.toString());
	}

	@Override
	public String toString() {
		return "DatumException [Datum" + text + "] is geen correcte datum!";
	}	
	
}
