/*
 * Created on Jun 1, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab8.control;

import lab8.model.Constants;

import javax.swing.*;
import java.util.Date;
/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TimeLimitThreadImpl implements Runnable {

	private JLabel label = null;
	private java.util.Date endTime;
	private JButton stopButton;

	/**
	 * 
	 */
	public TimeLimitThreadImpl() {
		super();
	}

	/**
	 * 
	 */
	public TimeLimitThreadImpl(Date stopTime, JLabel remaining, JButton stop) {
		super();
		endTime = stopTime;
		label= remaining;
		stopButton = stop;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			while (true) {
				Thread.sleep(Constants.SECONDMILLIS);
				if (label != null) {
					long now = new Date().getTime();
					if (now < endTime.getTime()) {
						label.setText(
							Long.toString(
								(endTime.getTime() - now)
									/ Constants.SECONDMILLIS)
								+ " seconds remain");
						label.repaint();
					} else {
						//		   Time exceeded. Score the test
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
