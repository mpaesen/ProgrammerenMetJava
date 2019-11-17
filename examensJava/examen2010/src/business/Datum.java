package business;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Datum {
	private GregorianCalendar date;
	
	
	public Datum() {
		this(new GregorianCalendar());		
	}
	
	public Datum(GregorianCalendar date) {
		super();
		this.date = date;
	}
	public GregorianCalendar getDate() {
		return date;
	}
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	public String getFormattedDate(){
		SimpleDateFormat format = new SimpleDateFormat("d MMM yyyy HH:mm");
		return format.format(getDate().getTime());
	}

	public void add(int veld, int hoeveelheid){
		date.add(veld, hoeveelheid);
	}
	
	public boolean voor(Datum datum){
		return(this.getDate().before(datum));
	}
	@Override
	public String toString() {
		return " [Datum ="
				+ getFormattedDate() + "]";
	}
}
