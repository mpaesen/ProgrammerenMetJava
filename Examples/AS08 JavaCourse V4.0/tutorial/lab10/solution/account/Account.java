package lab10.solution.account;


import lab10.solution.utility.SortedVector;

import java.text.NumberFormat;
import java.util.Enumeration;

public class Account {

public Account() {
   balance = 0;
   log = new SortedVector();
}

public void post(Transaction t){
   balance += t.getSignedAmount();
   log.addElement(t);
}

public String toString() {
   NumberFormat nf = NumberFormat.getCurrencyInstance();
   return "Balance: " + nf.format(balance/100.0) + ", Log: " + log;
}

public long getBalance(){
   return balance;
}

public Enumeration elements() {
   return log.elements();
}

public int size() {
   return log.size();
}

private long balance;
private SortedVector log;
}
