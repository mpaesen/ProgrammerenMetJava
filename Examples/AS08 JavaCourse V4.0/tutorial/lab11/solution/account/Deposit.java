package lab11.solution.account;


public class Deposit extends Transaction {

public Deposit(java.util.Date aDate, long anAmount) {
   super(aDate, anAmount);
}

public Deposit(String dateText, String amountText) throws Exception {
   super(dateText, amountText);
}

public long getSignedAmount() {
   return getAmount();
}
}
