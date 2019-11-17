package model;

public class EengezinsWoning extends Woning{
	private static final int EENHEID = 10;
	public static final int MAX = 5;
	public EengezinsWoning(){
		this(EENHEID);
	}
	public EengezinsWoning(int eenheid){
		super(eenheid);
	}
	
	public double berekenKostPrijs() {		
		return super.berekenKostPrijs();
	}

	public String toString(){
		return "Deze Eengezins woning "+super.toString();
	}
}
