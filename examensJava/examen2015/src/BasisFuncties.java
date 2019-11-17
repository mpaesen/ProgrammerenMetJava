import java.security.SecureRandom;

/**
 * Write a description of interface BasisFuncties here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface BasisFuncties
{
	public SecureRandom random = new SecureRandom();

	public double getSnelheid();

	public double getReactieTijd();

	public double getWendbaarheid(double graden);

	public double getGrootte();

	public int getCapaciteit();

	public double getKoers();

}
