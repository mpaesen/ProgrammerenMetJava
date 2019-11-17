package business.vervoermiddelen;

/**
 * Abstract class VervoerMiddel - write a description of the class here
 * 
 * @author Mathy 
 * @version 1.0
 */
import java.rmi.server.UID;

public abstract class VervoerMiddel
{
	private String identificatie;
	private static  short count = 1;
	
	public VervoerMiddel() {
		this(new UID(count++).toString());
	}
	public VervoerMiddel(String identificatie) {
		super();
		this.identificatie = identificatie;
	}

	public String getIdentificatie() {
		return identificatie;
	}

	public void setIdentificatie(String identificatie) {
		this.identificatie = identificatie;
	}

	@Override
	public String toString() {
		return "[id=" + identificatie+ "]";
	}
}
