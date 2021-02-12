package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Rudy Nelen
 */


public class DateTime implements Serializable
{
	private static final long serialVersionUID = 1L;

	Date date = new Date();
	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	Calendar calendar = new GregorianCalendar();
	private String datum = "";

	public DateTime()
	{	
		Calendar.getInstance();	
	}
	
	/**
	 * een ingevoerde datum wordt omgezet naar een juist formaat
	 * @param datumstring
	 */
	public DateTime (String datumstring)
	{
		String date = converteerNaarKlasseDatumFormaat(datumstring);
		this.datum = date;
	}
	
	public String getDatum() {
		return this.datum;
	}
	public void setDatum(String datumstring) {
		String date = converteerNaarKlasseDatumFormaat(datumstring);
		this.datum = date;
	}

	//toont datum vandaag en uur in juist formaat
	public String toonHuidigeDatumEnUur(){
		String datum = df.format(date);		
		return datum;
	}
	
	public String toonHuidigeDatum(){
		String datum = format.format(date);
		return datum;
	}

	public String converteerNaarKlasseDatumFormaat(String datum){
		String datumstring = "";
		Calendar calendar = null;
		try {
			format.parse(datum);
		    calendar = format.getCalendar();
		   			
		} catch (ParseException ex) {
	          System.out.println("De datum heeft geen formaat dd-MM-yyyy");
				//ex.printStackTrace();

	          try {
		    	SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
		    	format2.parse(datum);
		    	calendar = format2.getCalendar();
				
			} catch (ParseException ex2) {
		          System.out.println("De datum heeft geen formaat dd/MM/yyyy");
					//ex2.printStackTrace();
		          
		          try {
				    	SimpleDateFormat format3 = new SimpleDateFormat("dd.MM.yy");
				    	format3.parse(datum);
				    	calendar = format3.getCalendar();
						
					} catch (ParseException ex3) {
				          System.out.println("De datum heeft geen correct formaat");
							//ex3.printStackTrace();
				    }
					
					/**
					 * hierna kan je eventueel nog andere varianten toevoegen
					 */
		    }

		}
		datumstring = format.format(calendar.getTime());
		return datumstring;  
	}
	
	/**
	 * hier kan je een formaat meegeven 
	 * en de ingegeven datum wordt naar dit formaat omgezet
	 * @param dateformat
	 * @return
	 */
	
	public String converteerNaarDatumVolgensFormaat(String dateformat){
		String datumstring = "";
		
		try {
			format.parse(getDatum());
		    calendar = format.getCalendar();
		   			
		} catch (ParseException ex) {
	          System.out.println("De datum heeft geen formaat dd-MM-yyyy");
				//ex.printStackTrace();
		}
		SimpleDateFormat newformat = new SimpleDateFormat(dateformat);
   	
        datumstring = newformat.format(calendar.getTime());
        return datumstring;
	}

	@Override
	public String toString()
	{	
		return getDatum();
	}
	
}