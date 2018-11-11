package behavioral.strategy.duck;

public class FlyRocketPowered implements FlyBehavior
{

	@Override
	public void fly()
	{
		System.out.println("I fly with rocket power!");

	}

}
