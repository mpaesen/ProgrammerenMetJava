package ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class WWLog extends JFrame implements ActionListener {
    private File logFile;
    private String logFileName;
    private DefaultListModel listModel;
    private JList listbox;
    private JButton saveAsButton, clearButton, closeButton;
    private JTextField infoArea;

    public WWLog(File logFile) {
        super("Work with Log File");
        this.logFile = logFile;
        try {
            logFileName = logFile.getCanonicalPath();
        } catch (IOException exc) {
            logFileName = "error";
        }
        getContentPane().setLayout(new BorderLayout());
        listModel = new DefaultListModel();
        listbox = new JList(listModel);
        listbox.setVisibleRowCount(10);
        JPanel buttons = new JPanel(new GridLayout(1, 3));
        saveAsButton = createButton("Save As...", buttons);
        clearButton = createButton("Clear", buttons);
        closeButton = createButton("Close", buttons);
        infoArea = new JTextField();
        infoArea.setBackground(Color.cyan);
        infoArea.setEditable(false);
        infoArea.setBorder(BorderFactory.createLoweredBevelBorder());
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 1));
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);
        getContentPane().add(new JScrollPane(listbox), BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        loadListBox();
        // An inner class...
        WindowListener closer = new WindowAdapter() {
            public void windowClosing(WindowEvent evt) { close(); }
        };
        addWindowListener(closer);
        setLocation(400, 150);
        pack();
        setVisible(true);
    } // end ctor

    /**
     * Helper method for creating a JButton with the given label, setting its border, registering we want to listen for pressed
     * events, and adding it to the given JPanel
     */
    private JButton createButton(String label, JPanel buttonPanel) {
        JButton newButton = new JButton(label);
        newButton.setBorder(BorderFactory.createRaisedBevelBorder());
        newButton.addActionListener(this);
        buttonPanel.add(newButton);
        return newButton;
    }

    private void close() {
        dispose();
    } // end close

    private void loadListBox() {
        int count = 0;
        try {
            // open source file for reading...
            BufferedReader newFileStream = new BufferedReader(new InputStreamReader(new FileInputStream(logFileName)));
            boolean done = false;
            while (!done) {
                String line = newFileStream.readLine(); // read one line
                if (line != null) {
                    listModel.addElement(line);
                    count++;
                }
                else
                    done = true;
            } // end while-loop
            if (count > 0)
                infoArea.setText(count + " messages in file " + logFileName);
            else
                infoArea.setText("No messages in file " + logFileName);
            newFileStream.close(); // close the file
        } // end try
        catch (IOException exc) {
            infoArea.setText("Error reading " + logFileName + ": " + exc.getMessage());
        }
    } // end loadListBox

    /** copy current log file to given file */
    private boolean copyToFile(String newFile) {
        boolean ok = false;
        try {
            // open source file for reading...
            BufferedReader inFileStream = new BufferedReader(new InputStreamReader(new FileInputStream(logFile)));
            // open logFile object for writing...
            PrintWriter logFileStream = new PrintWriter(new FileOutputStream(new File(newFile))); // instantiate printwriter object
            // loop through input file, writing to output file
            boolean done = false;
            while (!done) {
                String line = inFileStream.readLine(); // read input line
                if (line != null)
                    logFileStream.write(line); // write output line to the log file
                else
                    done = true;
            } // end while-loop
            logFileStream.flush();
            inFileStream.close(); // close the input file
            logFileStream.close(); // close the output file
            infoArea.setText("Copied to " + newFile + ".");
        }
        catch (IOException exc) {
            infoArea.setText("Copy to " + newFile + " failed: " + exc.getMessage());
        }
        return ok;
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();
        if (obj == saveAsButton) {
            JFileChooser openDlg = new JFileChooser(logFile);
            openDlg.setDialogTitle("SaveAs Window");
            openDlg.setSelectedFile(logFile);
            int returnValue = openDlg.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = openDlg.getSelectedFile();
                String fullFile = selectedFile.getAbsolutePath(); // retrieve fully qualified file name
                boolean ok = copyToFile(fullFile);
            } // end if dir and file not null
            else
                infoArea.setText("Save As canceled.");
        } // end if obj == saveAsButton
        else if (obj == clearButton) {
            if (logFile.exists())
                logFile.delete(); // delete the file
            listModel.removeAllElements();
            infoArea.setText("File " + logFileName + " cleared.");
            saveAsButton.setEnabled(false);
        }
        else if (obj == closeButton) {
            close();
        }
    } // end actionPerformed
} // end WWLog
