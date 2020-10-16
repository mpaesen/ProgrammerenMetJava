package model.laadbakken;

public class LaadBak {
	String laadBak;
	/**
	 * @param laadBak
	 */
	public LaadBak(String laadBak) {
		super();
		this.laadBak = laadBak;
	}

	/**
	 * An example of a set method
	 * 
	 * @param laadbak
	 *            String
	 */
	public void createLaadBak(String laadBak) {
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
	

	
	public String toString(){
		return getLaadBak();
	}
}
