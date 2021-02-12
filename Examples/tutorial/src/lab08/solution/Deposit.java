package lab08.solution;
public class Deposit extends Transaction {

public Deposit(java.util.Date aDate, long anAmount) {
   super(aDate, anAmount);
}

public long getSignedAmount() {
   return getAmount();
}
}
