package model.laadbakken;

public class LaadBak {
	String laadBak;
	/**
	 * @param laadBak
	 */
	private LaadBak(String laadBak) {
		super();
		this.laadBak = laadBak;
	}

	/**
	 * An example of a set method
	 * 
	 * @param laadbak
	 *            String
	 */
	public void setLaadBak(String laadBak) {
		// put your code here
		this.laadBak = laadBak;
	}

	/**
	 * An example of a set method
	 * 
	 * @return laadbak
	 */
	public String getLaadBak() {
		// put your code here
		return this.laadBak;
	}
	
	public static LaadBak setLaadBak() {
		// initialise instance variables
		LaadBak laadbak;
		switch ((int) (Math.random() * 3.0)) {
		case 0:
			laadbak = new LaadBak("open container");
			break;
		case 1:
			laadbak = new LaadBak("tank");
			break;
		case 2:
			laadbak = new LaadBak("gesloten container");
			break;
		default:
			laadbak = new LaadBak("geen laadbak");
			break;
		}
		return laadbak;
	}
	
	public String toString(){
		return getLaadBak();
	}
}
