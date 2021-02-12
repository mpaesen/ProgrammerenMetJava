package behavioral.strategy;

/**
 * Abstract class Duck - 
 * 
 * @author (Mathy Paesen)
 * @version (1.0)
 */
public abstract class Duck
{
	// instance variables - replace the example below with your own
	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;

	public void setFlyBehavior(final FlyBehavior flyBehavior)
	{
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(final QuackBehavior quackBehavior)
	{
		this.quackBehavior = quackBehavior;
	}

	public Duck()
	{
	}

	/**
	 * execute fly()
	 * 
	 * @param   none
	 * @return        void 
	 */
	public void performFly()
	{
		flyBehavior.fly();
	}

	/**
	 * execute quack()
	 * 
	 * @param   none
	 * @return        void 
	 */
	public void performQuack()
	{
		quackBehavior.quack();
	}

	public void swim()
	{
		System.out.println("Alle eenden drijven, ook lokeenden");
	}

}
