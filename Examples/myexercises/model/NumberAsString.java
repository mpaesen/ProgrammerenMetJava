package model;

/**
 * @author bempn
 * @version 1.0
 */
public class NumberAsString {

	private final String[] GETALLEN = { "nul", "een", "twee", "drie", "vier",
			"vijf", "zes", "zeven", "acht", "negen", "tien", "elf", "twaalf",
			"dertien", "veertien", "vijftien", "zestien", "zeventien",
			"achttien", "negentien", "twintig" };

	private final String[] TIENTALLEN = { "", "tien", "twintig", "dertig",
			"veertig", "vijftig", "zestig", "zeventig", "tachtig", "negentig" };

	private final String HONDERD = "honderd";

	private StringBuilder getalAlsString;

	private String oorspronkelijkGetal;

	private int getal;

	/**
	 * Default constructor
	 */
	public NumberAsString() {
		super();
		getalAlsString = new StringBuilder();
	}

	/**
	 * Verwijdert alle '0' voor het getal
	 */
	public String zeroSuppression(String getal) {
		String help = getal;
		for (int i = 0; i < getal.length() - 1; i++) {
			if (getal.charAt(i) == '0') {
				help = getal.substring(i + 1);
			} else {
				break;
			}
		}
		return help;
	}

	/**
	 * Analyseert het ingegeven getal
	 */
	public boolean ontleedGetal() {
		String teOntleden = zeroSuppression(this.getOorspronkelijkGetal());
		boolean ontleed = true;
		switch (teOntleden.length()) {
		case 1:
			analyseerGetalKleinerDanTien(teOntleden);

			break;
		case 2:
			analyseerGetalGroterDanNegen(teOntleden);

			break;
		case 3:

			analyseerGetalGroterDanNegenEnNegentig(teOntleden);
			break;
		default:
			ontleed = false;
		}
		return ontleed;
	}

	/**
	 * Analyseert een getal kleiner dan 10
	 */
	public void analyseerGetalKleinerDanTien(String teOntleden) {
		int eenheid = Integer.parseInt(teOntleden);
		getalAlsString.append(GETALLEN[eenheid]);
	}

	/**
	 * Ontleedt een getal groter dan 9
	 */
	public void analyseerGetalGroterDanNegen(String teOntleden) {
		StringBuffer zoekGetal = new StringBuffer();
		int eenheid = Integer.parseInt(teOntleden.substring(1, 2));
		int index = Integer.parseInt(teOntleden.substring(0, 1));
		if (Integer.parseInt(teOntleden.substring(1)) == 0) {
			zoekGetal.append(TIENTALLEN[index]);
		} else {
			index *= 10;
			index += eenheid;
			if (index < 20) {
				zoekGetal.append(GETALLEN[index]);
			} else {
				index = Integer.parseInt(teOntleden.substring(0, 1));
				zoekGetal.append(GETALLEN[eenheid]);
				zoekGetal.append(" en ");
				zoekGetal.append(TIENTALLEN[index]);
			}
		}
		getalAlsString.append(zoekGetal);
	}

	/**
	 * Analyseert een getal groter dan 99
	 */
	public void analyseerGetalGroterDanNegenEnNegentig(String teOntleden) {
		String zoekGetal = null;
		
		for (int i = 0; i < oorspronkelijkGetal.length() - 1; i++) {
			switch (i) {
			case 0: {
				zoekGetal = getOorspronkelijkGetal().substring(i, 1);
				if (Integer.parseInt(zoekGetal) != 1) {
					analyseerGetalKleinerDanTien(zoekGetal);
				}
				getalAlsString.append(HONDERD);
				break;
			}
			case 1: {
				String getal = zeroSuppression(getOorspronkelijkGetal()
						.substring(i));
				if (Integer.parseInt(getal) > 0 && Integer.parseInt(getal) < 20) {
					getalAlsString.append(" en ");
				} else
					getalAlsString.append(" ");
				if (Integer.parseInt(getal) > 9)
					analyseerGetalGroterDanNegen(getal);
				else if (Integer.parseInt(getal) != 0)
					analyseerGetalKleinerDanTien(getal);

				break;
			}
			case 2:
			case 3:
				
			default:
				break;

			}

		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getalAlsString.toString();
	}

	/**
	 * @return Returns the getalAlsString.
	 */
	/**
	 * @return
	 */
	public StringBuilder getGetalAlsString() {
		return getalAlsString;
	}

	/**
	 * @param getalAlsString
	 *            The getalAlsString to set.
	 */
	public void setGetalAlsString(StringBuilder getalAlsString) {
		this.getalAlsString = getalAlsString;
	}

	/**
	 * @return Returns the oorSpronkelijkGetal.
	 */
	public String getOorspronkelijkGetal() {
		return oorspronkelijkGetal;
	}

	/**
	 * @param oorSpronkelijkGetal
	 *            The oorSpronkelijkGetal to set.
	 */
	public void setOorspronkelijkGetal(String oorSpronkelijkGetal) {
		this.setGetalAlsString(new StringBuilder());
		this.oorspronkelijkGetal = oorSpronkelijkGetal;
		this.setGetal(Integer.parseInt(getOorspronkelijkGetal()));
	}

	/**
	 * @return Returns the getal.
	 */
	public int getGetal() {
		return getal;
	}

	/**
	 * @param getal
	 *            The getal to set.
	 */
	public void setGetal(int getal) {
		this.getal = getal;
	}
}
