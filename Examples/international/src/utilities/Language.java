package utilities;

public enum Language {
	ENGLISH("English"), DUTCH("Nederlands"), GERMAN("Deutch"), FRENCH("Francais"), ITALIAN("Italiano"), SPANISH("Espanol"), SWEDISH("Swedish");
	private String language;

	public String language()
	{
		return this.language;
	}

	/**
	 * @param language
	 */
	private Language(final String language)
	{
		this.language = language;
	}
}
