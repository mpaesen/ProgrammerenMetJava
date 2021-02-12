package structural.proxy;

public class Account {
	private int accountNumber;
	private double amount;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean checkBalance(int account, double amountNeeded){
		//check amount availability
		return true;
	}
}
