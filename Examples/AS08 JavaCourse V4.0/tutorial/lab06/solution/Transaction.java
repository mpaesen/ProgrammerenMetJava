package lab06.solution;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

public class Transaction {

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

public String toString() {
   DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
   NumberFormat nf = NumberFormat.getCurrencyInstance();
   return df.format(date) + ", " + nf.format(amount/100.0);
}

private Date date;
private long amount;
}
