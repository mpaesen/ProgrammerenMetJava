package lab08.solution;
public class Withdrawal extends Transaction {

public Withdrawal(java.util.Date aDate, long anAmount) {
   super(aDate, anAmount);
}

public long getSignedAmount() {
   return -getAmount();
}
}
