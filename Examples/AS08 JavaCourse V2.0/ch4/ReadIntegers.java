/** Supplies a helper method to read integers from the command line. This class does not need to be instantiated */

package ch4;
public class ReadIntegers {
    /** reads another integer from the console. Returns -9999 if the user chose to quit */
    public static int readNextInteger() {
        /* prompt for, and read, user input from console... */

        System.out.println("Enter an integer or 'q' to quit: ");
        String inLine;
        int intValue = -9999;
        java.io.BufferedReader d = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        try {
            boolean goodinput = false;
            boolean done = false;
            while (!done && !goodinput) {
                inLine = d.readLine();
                goodinput = true;
                if (!inLine.equalsIgnoreCase("q") && !inLine.equalsIgnoreCase("'q'")) {
                    try {
                        intValue = Integer.parseInt(inLine);
                        done = true;
                    } catch (NumberFormatException exc) {
                        System.out.println("You typed an invalid number. Try again: ");
                        goodinput = false;
                    } // end catch
                } // end if
                else
                    done = true;
            } // end while loop
        } // end try statement
        catch (java.io.IOException exc) { }
        return intValue;
    } 
}