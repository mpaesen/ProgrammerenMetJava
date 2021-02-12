package structural.bridge;

/**
 * Implement the switch for Bulb
 */
public class Bulb implements Switch {
	// Two positions of switch.
	public void switchOn() {
		System.out.println("BULB Switched ON");
	}

	public void switchOff() {
		System.out.println("BULB Switched OFF");
	}

}// End of class