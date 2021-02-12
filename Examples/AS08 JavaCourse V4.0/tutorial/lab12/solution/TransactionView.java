package lab12.solution;


import lab12.solution.account.Deposit;
import lab12.solution.account.Transaction;
import lab12.solution.account.TransactionException;
import lab12.solution.account.Withdrawal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TransactionView
   implements ActionListener, WindowListener
{

   /* Instance variables */
   private TextField ivDateText, ivAmountText;
   private Checkbox ivDepositCheckbox, ivWithdrawalCheckbox;
   private Button ivAddButton, ivFinishedButton;
   private AccountApplet ivOwner;
   private Frame ivFrame;
   private MessageDialog ivMessageDialog;
   /** Construct the receiver unopened owned by owner */
   public TransactionView(AccountApplet owner)
   {
     Panel mainPanel, buttonPanel;
     CheckboxGroup checkGroup;
     ScrollPane scroller;

     // Record the owner
     setOwner(owner);

     // Create infrastructure

     setFrame(new Frame("Add Transactions"));
     scroller= new ScrollPane();
     mainPanel= new Panel();
     buttonPanel= new Panel();
     checkGroup= new CheckboxGroup();

     frame().setLayout(new BorderLayout());
     mainPanel.setLayout(new GridBagLayout());

     scroller.setSize(320, 330);
     frame().add(scroller, "Center");
     scroller.add(mainPanel);

     // Build the components of the main panel

     // Add padding
     mainPanel.add(new Panel(), constraints(1, 1, 1, 1));
     mainPanel.add(new Panel(), constraints(2, 1, 1, 1));
     mainPanel.add(new Panel(), constraints(3, 1, 1, 1));
     mainPanel.add(new Panel(), constraints(2, 10, 1, 1));

     mainPanel.add(new Label("Date:"), constraints(2, 2, 3, 3));

     setDateText(new TextField(32));
     mainPanel.add(dateText(), constraints(2, 3, 3, 0));

     mainPanel.add(new Label("Amount:"), constraints(2, 4, 3, 3));

     setAmountText(new TextField());
     mainPanel.add(amountText(), constraints(2, 5, 3, 0));

     mainPanel.add(new Label("Type:"), constraints(2, 6, 3, 3));

     setDepositCheckbox(new Checkbox("Deposit", checkGroup, true));
     mainPanel.add(depositCheckbox(), constraints(2, 7, 3, 0));

     setWithdrawalCheckbox(new Checkbox("Withdrawal", checkGroup, false));
     mainPanel.add(withdrawalCheckbox(), constraints(2, 8, 3, 0));

     setAddButton(new Button("Add"));
     setFinishedButton(new Button("Finished"));

     buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
     buttonPanel.add(addButton());
     buttonPanel.add(finishedButton());
     mainPanel.add(buttonPanel, constraints(2, 9, 3, 3));

     // Register callbacks
     frame().addWindowListener(this);
     addButton().addActionListener(this);
     finishedButton().addActionListener(this);

     // Make the frame take its preferred size
     frame().pack();

     // Add a modal message dialog for feedback to the user
     setMessageDialog(new MessageDialog(frame(), true));
   }
   /* A button has been clicked */
   public void actionPerformed(ActionEvent event)
   {
     if (event.getSource() == addButton()) {
       handleAddRequest();
     }
     else if (event.getSource() == finishedButton()) {
       handleFinishedRequest();
     }
   }
   /* Answer the receiver's add button */
   protected final Button addButton()
   {
     return ivAddButton;
   }
   /* Answer the receiver's amount text */
   protected final TextField amountText()
   {
     return ivAmountText;
   }
   /* Answer constraints with SOUTHWEST anchor, insets of 4, fill of HORIZONTAL
      and grid position and weights set from the arguments */
   protected GridBagConstraints constraints(
     int gridx, int gridy, int weightx, int weighty
   )
   {
     GridBagConstraints result;

     result= new GridBagConstraints();
     result.anchor= GridBagConstraints.SOUTHWEST;
     result.insets= new Insets(4, 4, 4, 4);
     result.fill= GridBagConstraints.HORIZONTAL;

     result.gridx= gridx;
     result.gridy= gridy;
     result.weightx= weightx;
     result.weighty= weighty;

     return result;
   }
   /* Answer the receiver's date text */
   protected final TextField dateText()
   {
     return ivDateText;
   }
   /* Answer the receiver's deposit check box */
   protected final Checkbox depositCheckbox()
   {
     return ivDepositCheckbox;
   }
   /** Dispose of the receiver's resources
      - do not use the receiver after sending this message! */
   public void dispose()
   {
     frame().dispose();
     messageDialog().dispose();
   }
   /* Answer the receiver's finished button */
   protected final Button finishedButton()
   {
     return ivFinishedButton;
   }
   /* Answer the receiver's frame */
   protected final Frame frame()
   {
     return ivFrame;
   }
/* Handle an add request */
protected void handleAddRequest() {
   try {
      String dateText = dateText().getText();
      String amountText = amountText().getText();
      Transaction transaction;
      if (depositCheckbox().getState()) {
         transaction = new Deposit(dateText, amountText);
      } else {
         transaction = new Withdrawal(dateText, amountText);
      }
      owner().post(transaction);
      owner().update();
   } catch (TransactionException e) {
      messageDialog().setTitle("Invalid Transaction");
      messageDialog().setMessage(e.getMessage());
      messageDialog().setVisible(true);
   }
   dateText().requestFocus();
}
   /* Handle a finished request */
   protected void handleFinishedRequest()
   {
     frame().setVisible(false);
   }
   /* Answer the receiver's message dialog */
   protected final MessageDialog messageDialog()
   {
     return ivMessageDialog;
   }
   /* Answer the receiver's owner */
   protected final AccountApplet owner()
   {
     return ivOwner;
   }
   /* Set the receiver's add button to button */
   protected final void setAddButton(Button button)
   {
     ivAddButton= button;
   }
   /* Set the receiver's amount text to text */
   protected final void setAmountText(TextField text)
   {
     ivAmountText= text;
   }
   /* Set the receiver's date text to text */
   protected final void setDateText(TextField text)
   {
     ivDateText= text;
   }
   /* Set the receiver's deposit check box to checkBox */
   protected final void setDepositCheckbox(Checkbox checkBox)
   {
     ivDepositCheckbox= checkBox;
   }
   /* Set the receiver's finished button to button */
   protected final void setFinishedButton(Button button)
   {
     ivFinishedButton= button;
   }
   /* Set the receiver's frame to frame */
   protected final void setFrame(Frame frame)
   {
     ivFrame= frame;
   }
   /* Set the receiver's message dialog to dialog */
   protected final void setMessageDialog(MessageDialog dialog)
   {
     ivMessageDialog= dialog;
   }
   /* Set the receiver's owner to owner */
   protected final void setOwner(AccountApplet owner)
   {
     ivOwner= owner;
   }
   /** Set the receiver's visibility to visibility */
   public void setVisible(boolean visibility)
   {
     if (visibility) {
       if (!frame().isVisible()) {
         dateText().setText("");
         amountText().setText("");
         depositCheckbox().setState(true);
         frame().setVisible(true);
         dateText().requestFocus();
       }
     }
     else {
       frame().setVisible(false);
     }
   }
   /* Set the receiver's withdrawal check box to checkBox */
   protected final void setWithdrawalCheckbox(Checkbox checkBox)
   {
     ivWithdrawalCheckbox= checkBox;
   }
   /* The receiver's frame has been activated */
   public void windowActivated(WindowEvent event)
   {
   }
   /* The receiver's frame has been closed */
   public void windowClosed(WindowEvent event)
   {
   }
   /* The receiver's frame is closing */
   public void windowClosing(WindowEvent event)
   {
     handleFinishedRequest();
   }
   /* The receiver's frame has been deactivated */
   public void windowDeactivated(WindowEvent event)
   {
   }
   /* The receiver's frame has been deiconified */
   public void windowDeiconified(WindowEvent event)
   {
     dateText().requestFocus();
   }
   /* The receiver's frame has been iconified */
   public void windowIconified(WindowEvent event)
   {
   }
   /* The receiver's frame has been opened */
   public void windowOpened(WindowEvent event)
   {
     dateText().requestFocus();
   }
   /* Answer the receiver's withdrawal check box */
   protected final Checkbox withdrawalCheckbox()
   {
     return ivWithdrawalCheckbox;
   }
}
