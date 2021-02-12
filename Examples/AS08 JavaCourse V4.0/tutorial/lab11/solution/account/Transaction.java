package lab11.solution.account;


import lab10.solution.utility.Sortable;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

abstract public class Transaction implements Sortable{

public Transaction(Date aDate, long anAmount) {
   date = aDate;
   amount = anAmount;
}

public Transaction(String dateText, String amountText) throws Exception {
   DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
      date = df.parse(dateText);
      amount = Long.parseLong(amountText);
}

public long getAmount() {
   return amount;
}

public Date getDate() {
   return date;
}
   public abstract long getSignedAmount();

public String toString() {
   DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
   NumberFormat nf = NumberFormat.getCurrencyInstance();
   return df.format(date) + ", " + nf.format(getSignedAmount()/100.0);
}

public boolean lessThan(Sortable s) {
   Transaction t = (Transaction)s;
   return date.before(t.getDate());
}

private Date date;
private long amount;
}
