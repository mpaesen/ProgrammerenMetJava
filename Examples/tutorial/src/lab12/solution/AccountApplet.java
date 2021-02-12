package lab12.solution;


import lab12.solution.account.Account;
import lab12.solution.account.Transaction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Enumeration;
public class AccountApplet extends java.applet.Applet implements ActionListener{

public AccountApplet() {
   setLayout(new GridLayout(0, 1));
   add(new Label("Balance:"));
   balanceText = new TextField(32);
   balanceText.setEditable(false);
   add(balanceText);
   add(new Label("Log:"));
   logList = new List();
   add(logList);
   addButton = new Button("Add Transactions...");
   add(addButton);
   addButton.addActionListener(this);
}

public void actionPerformed(ActionEvent ae) {
   transactionView.setVisible(true);
}

public void destroy() {
   transactionView.dispose();
}

public void init() {
   account = new Account();
   transactionView = new TransactionView(this);
   //account.post(new Deposit(new Date(), 10000));
   update();
}

public void post(Transaction t) {
   account.post(t);
}

public void stop() {
   transactionView.setVisible(false);
}

public void update() {
   NumberFormat nf = NumberFormat.getCurrencyInstance();
   String s = nf.format(account.getBalance() / 100.0);
   balanceText.setText(s);
   logList.removeAll();
   Enumeration e = account.elements();
   if (account.size() > 0) {
      while (e.hasMoreElements()) {
         //logList.addItem(e.nextElement().toString()); // Java 1.1 uses addItem
         logList.add(e.nextElement().toString()); // Java 1.2 uses add
      }
   } else {
      //logList.addItem("No Transactions"); // Java 1.1 uses addItem
      logList.add("No Transactions"); // Java 1.2 uses add
   }
}

private TextField balanceText;
private List logList;
private Button addButton;
private Account account;
private TransactionView transactionView;
}
