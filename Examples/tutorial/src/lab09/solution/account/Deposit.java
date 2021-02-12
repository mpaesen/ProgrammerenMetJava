package lab09.solution.account;




public class Deposit extends Transaction {

public Deposit(java.util.Date aDate, long anAmount) {
   super(aDate, anAmount);
}

public long getSignedAmount() {
   return getAmount();
}
}
