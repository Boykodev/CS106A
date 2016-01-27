/*
 * DoubleBeepers.java
 * ------------------
 * Doubles the number of
 * beepers using recursion.
 */

import stanford.karel.*;

public class DoubleBeepers extends SuperKarel {

	public void run() {
		move();
		doubleBeepers();
		move();
	}
	private void doubleBeepers() {
		if (beepersPresent()) {
			pickBeeper();
			doubleBeepers(); // recursion
			putBeeper();
			putBeeper();
		}
	}
}