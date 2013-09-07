package be.groept.model;
public class Subscription {
	private int price; // subscription total price in euro-cent
	private int length; // length of subscription in months

	/**
	 * A constructor to create a subscription.
	 */
	public Subscription(int p, int n) {
		price = p;
		length = n;
	}

	/**
	 * Calculate the monthly subscription price in euro, rounded up to the
	 * nearest cent.
	 */
	public double pricePerMonth() {
		double r = (double) price / (double) length;
		System.out.print(r);
		return r;
	}

	/**
	 * Call this to cancel/nullify this subscription.
	 */
	public void cancel() {
		length = 0;
	}
}