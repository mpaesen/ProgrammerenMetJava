package model;
/**
 * 
 */
import java.util.StringTokenizer;

/**
 * 
 * @author Mathy Paesen
 * @version 2013/9/29
 *
 */
public class Amount {
	private long intg; // The numbers before the decimal point

	private short frac; // The numbers after the decimal point

	private char currency;

	// Constructors
	/**
	 * Default constuctor
	 */
	public Amount() {
		this(0.0, '€');
	}

	public Amount(double value) {
		this(value, '€');
	}

	public Amount(double value, char currency) {
		setValue(value);
		setCurrency(currency);
	}

	// Selectors
	/**
	 * @return the integral part of the Amount
	 */
	public long getIntegral() {
		return intg;
	}

	/**
	 * @return the fraction part of the Amount
	 */
	public short getFraction() {
		
		return frac;
	}

	/**
	 * @return the whole Amount as a double value
	 */
	public double getValue() {
		double val;
		val = Math.abs(intg);		
		val += (double) Math.abs(frac) / 100;
		val = (intg < 0? -val:val);
		return val;
	}

	// Comparisons

	/**
	 * Is the Amount negative
	 * 
	 * @return
	 */
	public boolean isNegative() {
		return ((intg < 0) || (frac < 0));
	}

	/**
	 * Is the Amount positive
	 * 
	 * @return
	 */
	public boolean isPositive() {
		return ((intg >= 0) && (frac >= 0));
	}

	/**
	 * Is the Amount equal to 0.0
	 * 
	 * @return
	 */
	public boolean isZero() {
		return ((intg == 0L) && (frac == 0));
	}

	// Operations
	private short makeFraction(short fraction) {
		return (short)(fraction < 10? fraction * 10: fraction);
	}

	/**
	 * Add an Amount and return the result as an Amount
	 * 
	 * @param am
	 * @return
	 */
	public Amount add(Amount am) {
		short tmpfrac = 0;
		long tmpintg = 0L;

		
		tmpintg = this.intg + am.getIntegral();	
		if (this.getIntegral()< 0 && (am.getIntegral()< 0)){
			tmpfrac = (short) (-this.frac - am.getFraction());
		}else if(this.getIntegral()< 0){
			if(this.frac < am.getFraction()){
				tmpfrac = (short) (100 + this.frac - am.getFraction());
				tmpintg++;
			}else{
				tmpfrac = (short) (this.frac - am.getFraction());
			}
		}else if ((am.getIntegral()< 0)){
			if(this.frac < am.getFraction()){
				tmpfrac = (short) (100 + this.frac- am.getFraction());
				tmpintg--;
			}else{
				tmpfrac = (short) (this.frac - am.getFraction());
			}			
		}else {
			tmpfrac = (short) (this.frac + am.getFraction());
		}
		
		
		tmpintg += tmpfrac / 100; // If over 100 add one
		tmpfrac = (short) (tmpfrac % 100); // Rest of division
		

		Amount res = new Amount();
		res.setAmount(tmpintg, tmpfrac);
		return res;
	}

	/**
	 * Subtract an Amount and return the result
	 * 
	 * @param am
	 * @return
	 */
	public Amount subtract(Amount am) {
		Amount tmp;
		if(this.getValue() < am.getValue()){
			tmp = new Amount(this.getValue());
			tmp.flipSign();
			tmp= am.add(tmp);
			tmp.flipSign();
			return tmp;
		}
		tmp = new Amount();
		tmp.setAmount(am.getIntegral(), am.getFraction());
		tmp.flipSign();
		return add(tmp);
	}

	// Modifiers
	/**
	 * Set the whole Amount according to the double
	 * 
	 * @param newval
	 */
	public void setValue(double newval) {
		long tmpin;
		short tmpfrc;
		double quot = 0.0, rest = 0.0;
		double tempDouble = Double.valueOf(String.format("%.2f", newval));
		String number = Double.toString(tempDouble);
		StringTokenizer stringTokenizer = new StringTokenizer(number, ".");
		tmpin = Long.parseLong(stringTokenizer.nextToken());
		String temp = stringTokenizer.nextToken();
		
		tmpfrc = Short.parseShort(temp);
		
		if(temp.charAt(0) != '0'){
			tmpfrc = makeFraction(tmpfrc);
		}

		if (Math.abs(tmpfrc)>999){
			quot = tmpfrc / 100.0;
			rest = tmpfrc % 100.0;
			if(rest >= 50){
				quot += 1.0; 
			}
			tmpfrc = (short)Math.abs(quot);
		}
		if (Math.abs(tmpfrc)>99){
			quot = tmpfrc / 100.0;
			rest = tmpfrc % 100.0;
			if(rest >= 50){
				quot += 1.0; 
			}
			tmpfrc = (short)Math.abs(quot);
		}
		intg = tmpin;
		frac = tmpfrc;
	}

	/**
	 * Set the integral and fraction The integral value is used for the sign of
	 * the Amount
	 * 
	 * @param integral
	 * @param fraction
	 */
	public void setAmount(long integral, short fraction) {

		intg = integral;
		if (intg != 0) {
			frac = (short) Math.abs(fraction);
			frac = (short) ((intg < 0) ? frac * -1 : frac);
		} else
			frac = fraction;
		adjust();
	}

	/**
	 * Make Amount positive
	 */
	public void makePositive() {
		intg = (intg < 0) ? intg * -1 : intg;
		//frac = (short) ((frac < 0) ? frac * -1 : frac);
	}

	/**
	 * Make Amount negative
	 */
	public void makeNegative() {
		intg = (intg > 0) ? intg * -1 : intg;
		//frac = (short) ((frac > 0) ? frac * -1 : frac);
	}

	/**
	 * Invert the sign
	 */
	public void flipSign() {
		if (isPositive())
			makeNegative();
		else
			makePositive();
	}

	/**
	 * 
	 */
	public void adjust() {
		if ((frac >= 100) || (frac <= -100)) {
			intg = intg + (frac / 100);
			frac = (short) (frac % 100);
		}
	}

	/**
	 * @param am
	 *            Copy argument into current
	 */
	public void copy(Amount am) {
		intg = am.getIntegral();
		frac = am.getFraction();
	}

	public String toString() {
		return ""+this.getCurrency() + this.getValue()
				+ "\n which represents: \n\tIntegral " +this.getCurrency()+ this.getIntegral()
				+ " and Fraction " + this.getFraction()+" cents";
	}

	/**
	 * @return Returns the currency.
	 */
	private char getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            The currency to set.
	 */
	private void setCurrency(char currency) {
		this.currency = currency;
	}
}