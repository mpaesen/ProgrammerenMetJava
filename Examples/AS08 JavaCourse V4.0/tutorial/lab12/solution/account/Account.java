package lab12.solution.account;


import lab12.solution.utility.SortedVector;

import java.text.NumberFormat;
import java.util.Enumeration;

public class Account {

public Account() {
   balance = 0;
   log = new SortedVector();
}

public Enumeration elements() {
   return log.elements();
}

public long getBalance(){
   return balance;
}

public void post(Transaction t){
   balance += t.getSignedAmount();
   log.addElement(t);
}

public int size() {
   return log.size();
}

public String toString() {
   NumberFormat nf = NumberFormat.getCurrencyInstance();
   return "Balance: " + nf.format(balance/100.0) + ", Log: " + log;
}

private long balance;
private SortedVector log;
}
