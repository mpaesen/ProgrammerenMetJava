package behavioral.strategy;

/**
 * Write a description of class MuteQuack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuteQuack implements QuackBehavior
{

	public MuteQuack()
	{

	}

	public void quack()
	{
		System.out.println("<<Stilte>>");
	}
}
