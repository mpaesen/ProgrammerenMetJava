package structural.bridge;

/**
 * Implement the switch for Fan
 */
public class Fan implements Switch {
	// Two positions of switch.
	public void switchOn() {
		System.out.println("FAN Switched ON");
	}

	public void switchOff() {
		System.out.println("FAN Switched OFF");
	}

}// End of class
