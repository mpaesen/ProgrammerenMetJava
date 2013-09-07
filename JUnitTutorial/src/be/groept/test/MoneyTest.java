package be.groept.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.groept.model.Money;


public class MoneyTest {
	private Money money;
	private Money moneyCopy;
	@Before
	public void setUp() throws Exception {
		money = new Money(500, "€");
		moneyCopy = new Money(money);
	}

	@Test
	public void testAmount() {
		//fail("Not yet implemented");
		assertTrue(money.getfAmount() == 500);
	}

	@Test
	public void testCurrency() {
		//fail("Not yet implemented");
		assertTrue(money.getfCurrency().equals("€"));
	}

	@Test
	public void testEqualsObject() {
		//fail("Not yet implemented");
		assertTrue(money.equals(moneyCopy));
	}

	@Test
	public void testAdd() {
		//fail("Not yet implemented");
		Money addition = money.add(moneyCopy);	
		assertTrue(addition.getfAmount() == 1000);
	}

}
