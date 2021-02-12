package lab12.solution.account;


public class Deposit extends Transaction {

public Deposit(String dateText, String amountText) throws TransactionException {
   super(dateText, amountText);
}

public Deposit(java.util.Date aDate, long anAmount) {
   super(aDate, anAmount);
}

public long getSignedAmount() {
   return getAmount();
}
}
