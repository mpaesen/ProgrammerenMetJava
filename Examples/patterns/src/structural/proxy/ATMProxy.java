package structural.proxy;

public class ATMProxy {

	/**
	 * Method getMoneyForPurchase This method is responsible for the entire
	 * banking operation described in the write-up
	 */
	public double getMoneyForPurchase(double amountNeeded) {


		You you = new You("Prashant");
		Account account = new Account();

		boolean isBalanceAvailable = false;
		// if card there, go ahead
		if (you.getCard()) {
			isBalanceAvailable = account.checkBalance(you.getAccountNumber(),
					amountNeeded);
		}

		if (isBalanceAvailable)
			return amountNeeded;
		else
			return 0;
	}
}// End of class