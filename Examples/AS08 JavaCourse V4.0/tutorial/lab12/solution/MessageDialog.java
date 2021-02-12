package lab12.solution;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MessageDialog
   implements ActionListener, WindowListener
{

   /* Instance variables */
   private Dialog ivDialog;
   private Label ivMessageLabel;
   private Button ivOKButton;
   /** Construct the receiver unopened, owned by parent and modal
      according to modality */
   public MessageDialog(Frame parent, boolean modality)
   {
     Panel panel, packingPanel;

     setDialog(new Dialog(parent, modality));

     // Build components
     setMessageLabel(new Label());
     messageLabel().setAlignment(Label.CENTER);
     setOKButton(new Button("OK"));

     // Lay them out
     dialog().setLayout(new BorderLayout(20, 20));
     dialog().add(messageLabel(), "Center");
     packingPanel= new Panel();
     dialog().add(packingPanel, "North");
     panel= new Panel();
     panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
     panel.add(oKButton());
     dialog().add(panel, "South");

     // Initialize the information
     setTitle("No title");
     setMessage("Enough text to fit a decent verbose error message");

     // Register callbacks
     dialog().addWindowListener(this);
     oKButton().addActionListener(this);

     // Make the window take its preferred size
     dialog().pack();
   }
   /* A button has been clicked */
   public void actionPerformed(ActionEvent event)
   {
     if (event.getSource() == oKButton()) {
       handleQuitRequest();
     }
   }
   /* Answer the receiver's dialog */
   protected final Dialog dialog()
   {
     return ivDialog;
   }
   /** Dispose of the receiver's resources
      - do not use the receiver after sending this message! */
   public void dispose()
   {
     dialog().dispose();
   }
   /* The receiver has been asked to close */
   protected void handleQuitRequest()
   {
     setVisible(false);
   }
   /** Answer the receiver's message */
   public String message()
   {
     return messageLabel().getText();
   }
   /* Answer the receiver's message label */
   protected final Label messageLabel()
   {
     return ivMessageLabel;
   }
   /* Answer the receiver's OK button */
   protected final Button oKButton()
   {
     return ivOKButton;
   }
   /* Set the receiver's dialog to dialog */
   protected final void setDialog(Dialog dialog)
   {
     ivDialog= dialog;
   }
   /** Set the receiver's message to message */
   public void setMessage(String message)
   {
     messageLabel().setText(message);
   }
   /* Set the receiver's message label to label */
   protected final void setMessageLabel(Label label)
   {
     ivMessageLabel= label;
   }
   /* Set the receiver's OK button to button */
   protected final void setOKButton(Button button)
   {
     ivOKButton= button;
   }
   /** Set the receiver's title to title */
   public void setTitle(String title)
   {
     dialog().setTitle(title);
   }
   /** Set the receiver's visibility to visibility */
   public void setVisible(boolean visibility)
   {
     if (visibility) {
       if (!dialog().isVisible()) {
         dialog().setVisible(true);
         oKButton().requestFocus();
       }
     }
     else {
       dialog().setVisible(false);
     }
   }
   /** Answer the receiver's title */
   public String title()
   {
     return dialog().getTitle();
   }
   /* The receiver's dialog has been activated */
   public void windowActivated(WindowEvent event)
   {
   }
   /* The receiver's dialog has been closed */
   public void windowClosed(WindowEvent event)
   {
   }
   /* The receiver's dialog is closing */
   public void windowClosing(WindowEvent event)
   {
     handleQuitRequest();
   }
   /* The receiver's dialog has been deactivated */
   public void windowDeactivated(WindowEvent event)
   {
   }
   /* The receiver's dialog has been deiconified */
   public void windowDeiconified(WindowEvent event)
   {
     oKButton().requestFocus();
   }
   /* The receiver's dialog has been iconified */
   public void windowIconified(WindowEvent event)
   {
   }
   /* The receiver's dialog has been opened */
   public void windowOpened(WindowEvent event)
   {
     oKButton().requestFocus();
   }
}
