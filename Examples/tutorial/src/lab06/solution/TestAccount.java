package lab06.solution;

import java.text.DateFormat;
import java.text.ParseException;
public class TestAccount {
public static void main(java.lang.String[] args) throws ParseException{
     Account account = new Account();
     DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
     Transaction t;

     t = new Transaction(format.parse("1/7/95"), 100000);
     account.post(t);

     t = new Transaction(format.parse("11/21/95"), -5995);
     account.post(t);

     t = new Transaction(format.parse("12/2/93"), -9999);
     account.post(t);

     System.out.println(account);
}
}
