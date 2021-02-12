
/////////////////////////////////////////////////////////////////////////
//
// Command call menu item example.  This program demonstrates how to
// use a menu item that calls an AS/400 command.  It will display
// any messages that are returned in a dialog.
//
// Command syntax:
//    CommandCallMenuItemExample system
//
/////////////////////////////////////////////////////////////////////////
//
// This source is an example of AS/400 Toolbox for Java "CommandCallMenuItem".
// IBM grants you a nonexclusive license to use this as an example
// from which you can generate similar function tailored to
// your own specific needs.
//
// This sample code is provided by IBM for illustrative purposes
// only. These examples have not been thoroughly tested under all
// conditions. IBM, therefore, cannot guarantee or imply
// reliability, serviceability, or function of these programs.
//
// All programs contained herein are provided to you "AS IS"
// without any warranties of any kind.  The implied warranties of
// merchantablility and fitness for a particular purpose are
// expressly disclaimed.
//
// AS/400 Toolbox for Java
// (C) Copyright IBM Corp. 1997, 1999
// All rights reserved.
// US Government Users Restricted Rights -
// Use, duplication, or disclosure restricted
// by GSA ADP Schedule Contract with IBM Corp.
//
/////////////////////////////////////////////////////////////////////////

package as400test.commandcall;

import com.ibm.as400.access.*;
import com.ibm.as400.vaccess.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CommandCallMenuItemExample
{



    private static JFrame f;



    public static void main (String[] args)
    {
        // If a system was not specified, then display help text and
        // exit.
        if (args.length != 1)
        {
            System.out.println("Usage:  CommandCallMenuItemExample system");
            return;
        }

        try
        {
            // Create an AS400 object.  The system name was passed
            // as the first command line argument.
            AS400 system = new AS400 (args[0]);

            // Create a frame.
            f = new JFrame ("Command call menu item example");

            // Create an error dialog adapter.  This will display
            // any errors to the user.
            ErrorDialogAdapter errorHandler = new ErrorDialogAdapter (f);

            // Create a CommandCallMenuItem object to run the command.
            CommandCallMenuItem menuItem = new CommandCallMenuItem ("cler library fred",
                null, system, "CLRLIB PAMA");
            menuItem.addErrorListener (errorHandler);

            // Add an action completed listener to display any
            // returned messages in a dialog.
            menuItem.addActionCompletedListener (new ActionCompletedListener ()
            {
                public void actionCompleted (ActionCompletedEvent event)
                {
                    // Get the message list from the event source.
                    CommandCallMenuItem item = (CommandCallMenuItem) event.getSource ();
                    AS400Message[] messageList = item.getMessageList ();

                    // Use an AS/400 details pane to display the messages.
                    VMessageList vmessageList = new VMessageList (messageList);
                    AS400DetailsPane messageDetails = new AS400DetailsPane (vmessageList);
                    messageDetails.load ();

                    // Show the details in a dialog.
                    JDialog dialog = new JDialog(f);
              dialog.getContentPane().setLayout(new BorderLayout());
              dialog.getContentPane().add("Center", messageDetails);
              dialog.pack();
              dialog.setVisible(true);
                }
            });

            // Create a menu with the item.
            JMenu menu = new JMenu ("AS/400 Command Calls");
            menu.add (menuItem);

            JMenuBar menuBar = new JMenuBar ();
            menuBar.add (menu);

            f.getRootPane ().setJMenuBar (menuBar);

            // When the frame closes, exit.
            f.addWindowListener (new WindowAdapter () {
                public void windowClosing (WindowEvent event)
                {
                    System.exit (0);
                }
            });

            // Layout the frame with the details pane.
            f.getContentPane ().setLayout (new BorderLayout ());
            f.setSize (300, 400);
            f.show ();
        }
        catch (Exception e)
        {
           System.out.println ("Error: " + e.getMessage ());
           System.exit (0);
        }
    }


}