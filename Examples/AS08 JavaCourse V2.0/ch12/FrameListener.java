//package com.ibm.as400ad.code400;
package ch12;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * A generally reusable class for processing the closing of a window. Will
 * handle the windowClosing action by disposing of the window, and if this is
 * identified in the constructor as being a "main" window, will exit the application.
 * Can also be used to handle a typical "Close" pushbutton in the same manner.
 * @author Phil Coulthard
 * @version 1.0
 */
public class FrameListener implements WindowListener, ActionListener {
    private Window owner; // instance variable
    private boolean mainWindow = true; // is this a main window we are closing?
    public static final boolean MAINWINDOW_NO = false;
    public static final boolean MAINWINDOW_YES = true;

    /**
     * Constructor. Assumes this IS a main window we are handling.
     * @param owner - the window we are processing close for
     */
    public FrameListener(Window owner) {
        this.owner = owner;
    }

    /**
     * Constructor. Allows you to explicitly state if this is a main window or not.
     * @param owner - the window we are processing close for
     * @param mainWindow - false if this is not a main window, hence closing it should not exit the entire application.
     */
    public FrameListener(Window owner, boolean mainWindow) {
        this.owner = owner;
        this.mainWindow = mainWindow;
    }

    /**
     * Helper class called by both windowClosing and actionPerformed. Closes the
     * window by calling dispose. Also, if identified in the constructor that this
     * is a main window, will exit the application via a call to System.exit(0).
     */
    public void closeWindow() {
        owner.dispose();
        if (mainWindow)
            System.exit(0);
        return;
    }

    public void windowOpened(WindowEvent e) {
    }

    /**
     * This method is called automatically by the system when the user closes the
     * window, assuming you have done window.addWindowListener(frameListenerObject);
     */
    public void windowClosing(WindowEvent e) {
        closeWindow();
        return;
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    /**
     * This method is called automatically by the system when the user presses the
     * close pushbutton, assuming you have done button.addActionListener(frameListenerObject);
     */
    public void actionPerformed(ActionEvent e) {
        closeWindow();
        return;
    }
}
