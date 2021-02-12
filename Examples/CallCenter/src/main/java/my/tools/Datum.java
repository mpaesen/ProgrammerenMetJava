/**
 * @author Vincent Regent
 * @version v1.00
 * Deze klasse wordt gebruikt om datumstrings te manipuleren (vb. naar een gepast formaat voor de database).
 */
package my.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Datum {
	//datamembers
	private int dag;
	private int maand;
	private int jaar;
	Calendar gregCal = new GregorianCalendar();

	// Constructor zonder parameters
	public Datum() {
		dag = gregCal.get(Calendar.DATE);
		maand = gregCal.get(Calendar.MONTH)+1;
		jaar = gregCal.get(Calendar.YEAR);
	}

	// Constructor met een Datum onject als parameter
	public Datum(Datum datum) {
		this.dag = datum.getDag();
		this.maand = datum.getMaand();
		this.jaar = datum.getJaar();
	}

	// Constructor met parameters dag, maand en jaar
	public Datum(int dag, int maand, int jaar) {
		setDag(dag);
		setMaand(maand);
		setJaar(jaar);
	}

	// Constructor met een String als parameter
	public Datum(String datum) {
		DateFormat datumFormaat = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = datumFormaat.parse(datum);
			gregCal.setTime(date);
			this.dag = gregCal.get(Calendar.DAY_OF_MONTH);
			this.maand = gregCal.get(Calendar.MONTH) + 1;
			this.jaar = gregCal.get(Calendar.YEAR);
		} catch (ParseException e) {
			System.out
					.println("Gelieve datum in formaat dd/mm/yyyy mee te geven");
			e.printStackTrace();
		}

	}

	// Set methoden
	public void setDag(int dag) {
		this.dag = dag;
	}
	public void setMaand(int maand) {
		this.maand = maand;
	}
	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
	boolean setDatum(int dag, int maand, int jaar) {

		String date = dag + "/" + maand + "/" + jaar;

		try {
			DateFormat datumFormaat = new SimpleDateFormat("dd/MM/yyyy");
			datumFormaat.parse(date);
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;

		} catch (Exception e) {
			return false;
		}

		return true;

	}

	// Get methoden
	public String getDatumInAmerikaansFormaat() throws ParseException {

		Date datum = new Date();
		String datumString = this.jaar + "/" + this.maand + "/" + this.dag;
		SimpleDateFormat resultFormaat = new SimpleDateFormat("yyyy/MM/dd");
		datum = resultFormaat.parse(datumString);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return (sdf.format(datum));

	}
	public String getDatumInEuropeesFormaat() throws ParseException {

		Date datum = new Date();
		String datumString = this.jaar + "/" + this.maand + "/" + this.dag;
		SimpleDateFormat resultFormaat = new SimpleDateFormat("yyyy/MM/dd");
		datum = resultFormaat.parse(datumString);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return (sdf.format(datum));
	}
	public int getDag() {
		return dag;
	}
	public int getMaand() {
		return maand;
	}
	public int getJaar() {
		return jaar;
	}
	
	// toString methode
	public String toString() {

		String datumString = this.dag + "/" + this.maand + "/" + this.jaar;
		DateFormat datumFormaat = new SimpleDateFormat("dd/MM/yyyy");
		Date datum = new Date();
		try {
			datum = datumFormaat.parse(datumString);
		} catch (ParseException e) {
			System.err.printf("\nException: %s/n", e);

		}
		DateFormat resultaatDatumFormaat = new SimpleDateFormat("dd MMMM yyyy");
		return resultaatDatumFormaat.format(datum).toString();

	}

	// equals methode , compareTo methode en kleinerDan methode
	public boolean equals() {
		boolean returnresult = false;
		Calendar calendar = new GregorianCalendar();
		calendar.getTime();

		if (this.dag == calendar.get(Calendar.DAY_OF_MONTH)
				&& this.maand == calendar.get(Calendar.MONTH) + 1
				&& this.jaar == calendar.get(Calendar.YEAR)) {
			returnresult = true;
		}

		return returnresult;
	}
	public int compareTo() {

		int returnresult = -1;

		if (this.equals()) {
			returnresult = 0;
		}

		return returnresult;
	}
	public boolean kleinerDan(Datum d)
	{
		//gebruik van verschilindagen code maar zonder de absolute waarde; negatieve waarde betekent dan kleinder dan...
		boolean result=false;
		Calendar datEen = toGregCal(d);
		Calendar datTwee = toGregCal(this);
		int verschilInJaar=datTwee.get(Calendar.YEAR) - datEen.get(Calendar.YEAR);
		int verschilInDag=verschilInJaar*365+datTwee.get(Calendar.DAY_OF_YEAR)-datEen.get(Calendar.DAY_OF_YEAR);
		if (verschilInDag<=0)
		{
			result=true;
		}
		
		
		return result;
	
	}
	
	
	// instantiemethoden: verschil in jaren, maanden en dagen
	int verschilInJaren(Datum eersteDat) {
		Calendar datEen = toGregCal(eersteDat);
		Calendar datTwee = toGregCal(this);
		return (Math
				.abs(datTwee.get(Calendar.YEAR) - datEen.get(Calendar.YEAR)));
	}
	public int verschilInMaanden(Datum eersteDat)
	{
		Calendar datEen = toGregCal(eersteDat);
		Calendar datTwee = toGregCal(this);
		int verschilInJaar=datTwee.get(Calendar.YEAR) - datEen.get(Calendar.YEAR);
		int verschilInMaand=verschilInJaar*12+datTwee.get(Calendar.MONTH)-datEen.get(Calendar.MONTH);
		return Math.abs(verschilInMaand);
	
	}
	public int verschilInDagen(Datum eersteDat)
	{
		Calendar datEen = toGregCal(eersteDat);
		Calendar datTwee = toGregCal(this);
		int verschilInJaar=datTwee.get(Calendar.YEAR) - datEen.get(Calendar.YEAR);
		int verschilInDag=verschilInJaar*365+datTwee.get(Calendar.DAY_OF_YEAR)-datEen.get(Calendar.DAY_OF_YEAR);
		return Math.abs(verschilInDag);
	
	}

	// instantiemethode: veranderDatum
	public Datum veranderDatum (int aantalDagen)
	{
		Calendar cal=toGregCal(this);
		cal.roll(Calendar.DAY_OF_YEAR, aantalDagen);
		Datum result=new Datum(cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH)+1,cal.get(Calendar.YEAR));
		return result;
	}

	// Conversie van Datum object naar GregorianCalendar object (Om vorige instantiemethoden te vergemakkelijken)
	public static Calendar toGregCal(Datum teConDat) {
		Calendar gregC = new GregorianCalendar();
		try {
			String dat = teConDat.dag + "/" + teConDat.maand + "/"
					+ teConDat.jaar;

			DateFormat datumF = new SimpleDateFormat("dd/MM/yyyy");
			Date datumD = new Date();
			datumD = datumF.parse(dat);
			gregC.setTime(datumD);
		} catch (Exception e) {
			System.out
					.println("Datum is niet correct, gelieve een geldige datum te voorzien");
		}
		return gregC;
	}

}