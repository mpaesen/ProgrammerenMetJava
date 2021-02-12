package lab12.solution.account;


import lab12.solution.utility.Sortable;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
public abstract class Transaction implements Sortable{

public Transaction(String dateText, String amountText) throws TransactionException {
   DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
   try {
      date = df.parse(dateText);
      if (date == null)
         throw new InvalidDateException();
   } catch (Exception e) {
      throw new InvalidDateException();
   }
   try {
      amount = Long.parseLong(amountText);
      if (amount <= 0)
         throw new InvalidAmountException();
   } catch (Exception e) {
      throw new InvalidAmountException();
   }
}

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

public boolean lessThan(Sortable s) {
   Transaction t = (Transaction)s;
   return date.before(t.getDate());
}

public String toString() {
   DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
   NumberFormat nf = NumberFormat.getCurrencyInstance();
   return df.format(date) + ", " + nf.format(getSignedAmount()/100.0);
}

private Date date;
private long amount;
}
