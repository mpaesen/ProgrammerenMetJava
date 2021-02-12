/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version v1.00
 * Deze klasse wordt gebruikt om tijdsintervallen te maken en met elkaar te vergelijken.
 */

package my.tools;

import java.util.GregorianCalendar;

/**
 * TijdsInterval klasse 
 */
/**
 * @author Kjell Lenaers
 * @version v1.00
 */
public class TijdsMoment
{
	GregorianCalendar vanMoment = new GregorianCalendar();
	GregorianCalendar totMoment = new GregorianCalendar();
	private long interval;
	private long vanMomentMs;
	private long totMomentMs;
	private int compareTo;
	private long equals;

	public void setEquals(long equals) {
		this.equals = equals;
	}

	public long getEquals() {
		return equals;
	}

	public void setCompareTo(int compareTo) {
		this.compareTo = compareTo;
	}

	public int getCompareTo() {
		return compareTo;
	}

	public void setTotMomentMs(long totMomentMs) {
		this.totMomentMs = totMomentMs;
	}

	public long getTotMomentMs() {
		return totMomentMs;
	}

	public void setVanMomentMs(long vanMomentMs) {
		this.vanMomentMs = vanMomentMs;
	}

	public long getVanMomentMs() {
		return vanMomentMs;
	}

	public void setInterval(long interval) 
	{
		this.interval = interval;
	}

	public long getInterval() 
	{
		return interval;
	}
/**
 * De default constructor maakt 2 instanties aan van GregorianCalendar, 
 * die beiden het huidig tijdstip bevatten. Het interval is dus 0.
 */
	public TijdsMoment()
	{
		super();
		vanMoment = new GregorianCalendar();
		totMoment = new GregorianCalendar();
		setInterval(totMoment.getTimeInMillis() - vanMoment.getTimeInMillis());
		setVanMomentMs(this.vanMoment.getTimeInMillis());
		setTotMomentMs(this.totMoment.getTimeInMillis());
	}
	
	/**
	 * Deze aangepaste constructor maakt het mogelijk om tijdsparameters mee te geven voor 
	 * beide tijdstippen waartussen het interval wordt berekend.
	 * @param van_jaar
	 * @param van_maand
	 * @param van_dag
	 * @param van_uur
	 * @param van_minuut
	 * @param van_seconde
	 * @param tot_jaar
	 * @param tot_maand
	 * @param tot_dag
	 * @param tot_uur
	 * @param tot_minuut
	 * @param tot_seconde
	 */
	
	public TijdsMoment(int van_jaar, int van_maand, int van_dag, int van_uur, 
			int van_minuut, int van_seconde, int tot_jaar, int tot_maand, 
			int tot_dag, int tot_uur, int tot_minuut, int tot_seconde)
	{
		super();

		try
		{
			vanMoment = new GregorianCalendar(van_jaar, van_maand, van_dag, van_uur, van_minuut, van_seconde);	
			totMoment = new GregorianCalendar(tot_jaar, tot_maand, tot_dag, tot_uur, tot_minuut, tot_seconde);
			setInterval(totMoment.getTimeInMillis() - vanMoment.getTimeInMillis());
			if (interval < 0)
			{
				GregorianCalendar van = vanMoment;
				vanMoment = totMoment;
				totMoment = van; 
			}		
			setVanMomentMs(this.vanMoment.getTimeInMillis());
			setTotMomentMs(this.totMoment.getTimeInMillis());
			
		}

		catch(Exception e)
		{	
			System.out.println("Een of meerdere tijdsparameters zijn fout ingegeven.");
		}

	}
	/**
	 * Deze constructor maakt het mogelijk een beperkter aantal parameters mee te geven
	 * voor beide tijdstippen waartussen het interval wordt berekend.
	 * @param van_jaar
	 * @param van_maand
	 * @param van_dag
	 * @param tot_jaar
	 * @param tot_maand
	 * @param tot_dag
	 */
	
	public TijdsMoment(int van_jaar, int van_maand, int van_dag, int tot_jaar, 
			int tot_maand, int tot_dag)
	{
		super();

		try
		{
			vanMoment = new GregorianCalendar(van_jaar, van_maand, van_dag);
			totMoment = new GregorianCalendar(tot_jaar, tot_maand, tot_dag);
			setInterval(totMoment.getTimeInMillis() - vanMoment.getTimeInMillis());
			if (interval < 0)
			{
				GregorianCalendar van = vanMoment;
				vanMoment = totMoment;
				totMoment = van; 
			}//end-if		
			setVanMomentMs(this.vanMoment.getTimeInMillis());
			setTotMomentMs(this.totMoment.getTimeInMillis());
		}

		catch(Exception e)
		{	
			System.out.println("Een of meerdere tijdsparameters zijn fout ingegeven.");
		}
	}
	
	
	public TijdsMoment(int jaar, int maand, int dag)
	{
		super();

		try
		{
			vanMoment = new GregorianCalendar(jaar, maand, dag);
			totMoment = new GregorianCalendar(jaar, maand, dag);
			setInterval(totMoment.getTimeInMillis() - vanMoment.getTimeInMillis());
			if (interval < 0)
			{
				GregorianCalendar van = vanMoment;
				vanMoment = totMoment;
				totMoment = van; 
			}//end-if		
			setVanMomentMs(this.vanMoment.getTimeInMillis());
			setTotMomentMs(this.totMoment.getTimeInMillis());
		}

		catch(Exception e)
		{	
			System.out.println("Een of meerdere tijdsparameters zijn fout ingegeven.");
		}

	}

	/**
	 * De getLengteInMinuten() method geeft het interval tussen de 2 momenten in minuten terug.
	 * @return
	 */
	
	public int getLengteInMinuten()
	{
		int result = Math.abs((int)Math.floor(interval/60000));

		return result;
	}
	
	/**
	 * De overlapt() method geeft true terug als het actieve tijdsinterval overlapt
	 * met het paremeter tijdsinterval, false indien dit niet zo is.
	 * @param tijdsInterval
	 * @return
	 */
	
	public boolean overlapt(TijdsMoment tijdsInterval)
	{
		boolean result = false;
		long vanMomentMs2 = tijdsInterval.vanMoment.getTimeInMillis();
		long totMomentMs2 = tijdsInterval.totMoment.getTimeInMillis();

		
		if ((vanMomentMs2 >= getVanMomentMs() && vanMomentMs2 <= getTotMomentMs()) || (totMomentMs2 >= getVanMomentMs() && totMomentMs2 <= getTotMomentMs()))
		{
			result = true;
		}//end-if
		if ((getVanMomentMs() >= vanMomentMs2 && getVanMomentMs() <= totMomentMs2) || (getTotMomentMs() >= vanMomentMs2 && getTotMomentMs() <= totMomentMs2))
		{
			result = true;
		}//end-if
		return result;
	}
	
	/**
	 * De toSring() method geeft het tijdsinterval weer op een leesbare manier voor de gebruiker.
	 */
	
	public String toString()
	{
		return "Van moment: " + vanMoment.getTime().toString() + "\nTot moment: " + totMoment.getTime().toString()+"\n-------------------------------------------";
	}
	
	/**
	 * De equals() method geeft in minuten weer in hoeverre de 2 tijdsintervallen 
	 * met elkaar overlappen.
	 * @param tijdsInterval
	 * @return
	 */
	
	public boolean equals(TijdsMoment tijdsInterval)
	{
		boolean result=false;
		this.compareTo(tijdsInterval);
		long vanMomentMs2 = tijdsInterval.vanMoment.getTimeInMillis();
		long totMomentMs2 = tijdsInterval.totMoment.getTimeInMillis();
		setEquals(0);
		if (getCompareTo() == 1)
		{
			setEquals(totMomentMs2 - vanMomentMs2);
		}
		else if (getCompareTo() == -1)
		{
			setEquals(interval);
		}
		else if (getCompareTo() == -2)
		{
			setEquals(getTotMomentMs() - vanMomentMs2); 
		}
		else if (getCompareTo() == 2)
		{
			setEquals(totMomentMs2 - getVanMomentMs());
		}
		else if (getCompareTo() == 0)
		{
				setEquals(interval);
		}//end-if
	
		if ((int)Math.abs(Math.floor(getEquals()/60000))==0)
		{
			result=true;
		}
		return result;
	}

	/**
	 * De compareTo() method geeft een integere waarde terug afhankelijk van hoe het parameter
	 * tijdsinterval zich verhoudt ten opzichte van het actueel tijdsinterval.
	 * 
	 * @param tijdsInterval
	 * @return
	 */
	
	public int compareTo(TijdsMoment tijdsInterval)
	{
		long vanMomentMs2 = tijdsInterval.vanMoment.getTimeInMillis();
		long totMomentMs2 = tijdsInterval.totMoment.getTimeInMillis();

		if (getVanMomentMs() > totMomentMs2) 
		{
			setCompareTo(3);
		}
		else if (getTotMomentMs() < vanMomentMs2)
		{
			setCompareTo(-3);
		}
		else// if (vanMomentMs2 == getVanMomentMs() && getTotMomentMs() == totMomentMs2)
		{
			setCompareTo(0);
		}
	/*	else
		{
			setCompareTo(1);
			if (getTotMomentMs() <= totMomentMs2)
			{
				if (getVanMomentMs() <= vanMomentMs2)
				{
					setCompareTo(-2);
				}
				else if (getVanMomentMs() >= vanMomentMs2)
				{
					setCompareTo(-1);
				}//end-if
			}//end-if
			if (getVanMomentMs() >= vanMomentMs2)
			{
				if (getTotMomentMs() >= totMomentMs2)
				{
					setCompareTo(+2);
				}
				else if (getTotMomentMs() <= totMomentMs2)
				{
					setCompareTo(-1);
				}//end-if
			}//end-if
		}//end-if
		*/
		return getCompareTo();
	}
}