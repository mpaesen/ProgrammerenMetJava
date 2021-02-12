package lab11.solution.account;


public class Withdrawal extends Transaction {

public Withdrawal(java.util.Date aDate, long anAmount) {
   super(aDate, anAmount);
}

public Withdrawal(String dateText, String amountText) throws Exception{
   super(dateText, amountText);
}

public long getSignedAmount() {
   return -getAmount();
}
}
