package utilities;

public enum Currency {
	EUR("\u20AC", "EUR"), CHF("Fr", "CHF"), USD("\u0024", "USD"), SEK("SEK", "SEK"), GBP("\u00A3", "GBP");
	private String symbol;
	private String isoCode;

	/**
	 * @param name
	 * @param ordinal
	 */

	public String symbol()
	{
		return this.symbol;
	}

	/**
	 * @param symbol
	 */
	private Currency(final String symbol, final String isoCode)
	{
		this.symbol = symbol;
		this.isoCode = isoCode;
	}

	/**
	 * @return the isoCode
	 */
	public String getIsoCode()
	{
		return isoCode;
	}

}
