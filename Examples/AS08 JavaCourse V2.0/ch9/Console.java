package ch9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Helper class for reading input from the console */
public class Console {
    // private instance variables...
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /** default constructor */
    public Console() {
    } // end of ctor for Console

    /**
     * Read a line from the user, with a prompt
     * @param prompt text to display to user first
     * @return String object with user entered line of input
     */
    public String readLine(String prompt) {
        String resultLine = " ";
        System.out.println(prompt);
        try {
            resultLine = reader.readLine();
        } // end try
        catch (IOException exc) { }
        return resultLine;
    } // end readLine

    /**
     * Read a character from the user
     * @param prompt text to display to user first
     * @return first character entered by user. Rest ignored
     */
    public char readChar(String prompt) {
        char resultChar = ' ';
        System.out.println(prompt);
        try {
            String resultLine = reader.readLine();
            resultChar = resultLine.charAt(0);
        } // end try
        catch (IOException exc) { }
        return resultChar;
    } // end readChar

    /**
     * Read a valid integer value from the user, with a prompt
     * @param prompt text to display to user first
     * @return integral number entered by customer. Returns -9999 if user canceled
     */
    public int readInteger(String prompt) {
        int intValue = -9999;
        while (intValue == -9999) {
            String resultLine = readLine(prompt); // call our own method to get line
            try {
                intValue = Integer.parseInt(resultLine);
            } // end try
            catch (NumberFormatException exc) {
                System.out.println("You typed an invalid number. Try again: ");
            } // end catch
        }
        return intValue;
    } // end readInteger
} // end of class Console
