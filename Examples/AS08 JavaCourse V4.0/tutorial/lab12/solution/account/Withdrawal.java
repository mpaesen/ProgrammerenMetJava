package lab12.solution.account;


public class Withdrawal extends Transaction {

public Withdrawal(String dateText, String amountText) throws TransactionException{
   super(dateText, amountText);
}

public Withdrawal(java.util.Date aDate, long anAmount) {
   super(aDate, anAmount);
}

public long getSignedAmount() {
   return -getAmount();
}
}
