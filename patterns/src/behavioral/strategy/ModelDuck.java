package behavioral.strategy;

public class ModelDuck extends Duck
{

	public ModelDuck()
	{
		super();
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new Quack());

	}

	public void display()
	{
		System.out.println("Ik ben een model eend");
	}

}
