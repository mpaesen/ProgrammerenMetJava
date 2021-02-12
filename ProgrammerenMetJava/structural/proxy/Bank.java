package structural.proxy;

/**
 * Bank.java The class acts as the main object for which the proxy has to be
 * created. As described, going to bank for withdrawal is very costly time wise.
 */
public class Bank {

	private int numberInQueue;

	/**
	 * Method getMoneyForPurchase This method is responsible for the entire
	 * banking operation described in the write-up
	 */
	public double getMoneyForPurchase(double amountNeeded) {
		
		You you = new You("Prashant");		
		Account account = new Account();		
		int accountNumber = you.getAccountNumber();
		
		boolean gotPassbook = you.getCard();		
		int number = getNumberInQueue();		
		while (number != 0) {
			number--;
		}
		
		boolean isBalanceSufficient = account.checkBalance(accountNumber,
				amountNeeded);
		if (isBalanceSufficient)
			return amountNeeded;
		else
			return 0;
	}

	/**
	 * returns the number in the queue
	 */
	private int getNumberInQueue() {
		return numberInQueue;
	}

}// End of class