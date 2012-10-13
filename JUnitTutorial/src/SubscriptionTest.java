import static org.junit.Assert.*;

import org.junit.Test;

public class SubscriptionTest {

	@Test
	public void test_returnEuro() {
		Subscription S = new Subscription(200, 2);
		assertTrue(S.pricePerMonth() == (double) 100);
	}

	@Test
	public void test_roundingup() {
		Subscription S3 = new Subscription(200, 3);
		assertTrue(S3.pricePerMonth() == (double) 66.66666666666667);
	}
}
