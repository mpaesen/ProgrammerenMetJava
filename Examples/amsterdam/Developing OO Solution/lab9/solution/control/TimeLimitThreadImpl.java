package lab9.solution.control;

import lab9.solution.model.Constants;

import javax.swing.*;
import java.util.Date;

public class TimeLimitThreadImpl implements Runnable {
	private JLabel label = null;
	private Date endTime;
	private JButton stopButton;

	public TimeLimitThreadImpl(Date stopTime,JLabel remaining,JButton stop) {
		endTime = stopTime;
		label = remaining;
		stopButton = stop;
	}

	public void run() {
		try {
			while (true) {
				Thread.sleep(Constants.SECONDMILLIS);
				if (label != null) {
					long now = new Date().getTime();
					if (now < endTime.getTime()) {
						label.setText(Long.toString((endTime.getTime() - now) / Constants.SECONDMILLIS)
							+ " seconds remain");
						label.repaint();
					} else {
						// Time exceeded. Score the test
						if (stopButton != null) {
							stopButton.doClick();
						}
						break; // end this thread
					}
				}
			}
		} catch (java.lang.InterruptedException ex) {
			System.out.println("Timer thread interrupted");
		}
	}
}
