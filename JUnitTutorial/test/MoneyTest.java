

import junit.framework.TestCase;
import junit.framework.Assert;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * @author Mathy Paesen
 * @version 1.0
 * @date 21-09-2008
 * 
 */
public class MoneyTest extends TestCase {

	private Money f12CHF;
	private Money f14CHF;

	public MoneyTest(String title) {
		super(title);
	}

	protected void setUp() throws Exception {
		f12CHF = new Money(12, "CHF");
		f14CHF = new Money(14, "CHF");
	}

	public void testEquals() {
		Assert.assertTrue(!f12CHF.equals(null)); 
		Assert.assertEquals(f12CHF, f12CHF);		
		Assert.assertEquals(f12CHF, new Money(12, "CHF"));
		Assert.assertTrue(!f12CHF.equals(f14CHF));
	}

	public void testSimpleAdd() {
		Money expected = new Money(26, "CHF");
		Money result = f12CHF.add(f14CHF);
		Assert.assertTrue(expected.equals(result));
		expected = new Money(-7, "CHF");
		result = f12CHF.add(new Money(-19, "CHF"));
		Assert.assertTrue(expected.equals(result));
	}

	public static Test suite() {
		return new TestSuite(MoneyTest.class);
	}
}
