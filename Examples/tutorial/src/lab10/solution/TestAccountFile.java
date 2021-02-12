package lab10.solution;

import lab10.solution.account.Account;
import lab10.solution.account.Deposit;
import lab10.solution.account.Transaction;
import lab10.solution.account.Withdrawal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.Date;

public class TestAccountFile {

public static void main(java.lang.String[] args) {
   Account account = new Account();
   try {
      DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
      BufferedReader br = new BufferedReader(new FileReader("account.in"));
      Transaction t;
      String s = br.readLine();
      while (s != null) {
         Date date = df.parse(s);
         s = br.readLine();
         if (s == null)
            break;
         long amount = Long.parseLong(s);
         if (amount >= 0)
            t = new Deposit(date, amount);
         else
            t = new Withdrawal(date, -amount);
         account.post(t);
         s = br.readLine();
      }
      br.close();
   } catch (Exception e) {
      e.printStackTrace();
   }
   System.out.println(account);
   try {
      BufferedWriter bw = new BufferedWriter(new FileWriter("Account.out"));
      String s = account.toString();
      bw.write(s, 0, s.length());
      bw.close();
   } catch (Exception e) {
      e.printStackTrace();
   }
}
}
