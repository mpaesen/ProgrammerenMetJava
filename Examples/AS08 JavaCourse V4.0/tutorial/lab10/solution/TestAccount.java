package lab10.solution;

import lab10.solution.account.Account;
import lab10.solution.account.Deposit;
import lab10.solution.account.Transaction;
import lab10.solution.account.Withdrawal;

import java.text.DateFormat;
import java.text.ParseException;

public class TestAccount {

public static void main(java.lang.String[] args) throws ParseException{
     Account account = new Account();
     DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
     Transaction t;

     t = new Deposit(df.parse("1/7/95"), 100000);
     account.post(t);

     t = new Withdrawal(df.parse("11/21/95"), 5995);
     account.post(t);

     t = new Withdrawal(df.parse("12/2/93"), 9999);
     account.post(t);

     System.out.println(account);
}
}
