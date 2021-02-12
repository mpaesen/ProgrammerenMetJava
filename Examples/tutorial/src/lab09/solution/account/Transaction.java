package lab09.solution.account;


import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

abstract public class Transaction {

public Transaction(Date aDate, long anAmount) {
   date = aDate;
   amount = anAmount;
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

private Date date;
private long amount;
}
