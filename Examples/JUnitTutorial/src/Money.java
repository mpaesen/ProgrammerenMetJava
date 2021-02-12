

/**
 * @author Mathy Paesen
 * @version 1.0
 * @date 21-09-2008
 * 
 */
public class Money {
	private int fAmount;
	private String fCurrency;

	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}

	public Money(Money money) {
		fAmount = money.getfAmount();
		fCurrency = money.getfCurrency();
	}
	public int amount() {
		return fAmount;
	}

	public String currency() {
		return fCurrency;
	}

	public boolean equals(Object m) {
		if (m != null) {
			Money x = (Money)m;
			//return this.amount() == x.amount() && this.currency().equals(x.currency()); //alternative
			return this.hashCode() == x.hashCode();
		}
		return false;
	}
	
	public int hashCode(){
		return currency().hashCode() + amount();
	}

	public Money add(Money m) {
		return new Money(this.amount() + m.amount(), this.currency());
	}

	/**
	 * @return the fAmount
	 */
	public int getfAmount() {
		return fAmount;
	}

	/**
	 * @param fAmount the fAmount to set
	 */
	public void setfAmount(int fAmount) {
		this.fAmount = fAmount;
	}

	/**
	 * @return the fCurrency
	 */
	public String getfCurrency() {
		return fCurrency;
	}

	/**
	 * @param fCurrency the fCurrency to set
	 */
	public void setfCurrency(String fCurrency) {
		this.fCurrency = fCurrency;
	}
}
