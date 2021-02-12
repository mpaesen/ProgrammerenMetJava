package lab07.solution;

import java.text.NumberFormat;
import java.util.Vector;

public class Account {

public Account() {
   balance = 0;
   log = new Vector();
}

public void post(Transaction t){
   balance += t.getAmount();
   log.addElement(t);
}

public String toString() {
   NumberFormat nf = NumberFormat.getCurrencyInstance();
   return "Balance: " + nf.format(balance/100.0) + ", Log: " + log;
}

private long balance;
private Vector log;
}
