/* Generated by Together */

package testtegenpartijen;
import keybIO.*;


final public class UI {
    public static String setString(String string){
        System.out.println("Geef "+string+": ");
		return KeybIO.readString();
    }
    public static int setInteger(String string){
        System.out.println("Geef "+string+": ");
		return KeybIO.readInt();
    }
}
