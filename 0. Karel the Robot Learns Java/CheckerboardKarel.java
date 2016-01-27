/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		if (frontIsBlocked()) {
			turnLeft();
		}
		while (frontIsClear()) {
			fillLine();
			changeLine();
		}
	}
	
	private void fillLine() {
		putBeeper();
		while (frontIsClear()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
		}
	}
	
	private void changeLine() {
		if(facingEast()) {
			if (beepersPresent()) {
				turnLeft();
				if (frontIsClear()) {
					move();
					turnLeft();
					move();
				}
				
			} else {
				turnLeft();
				if (frontIsClear()) {
					move();
					turnLeft();
				}
			}
		} else {
			if (beepersPresent()) {
				turnRight();
				if (frontIsClear()) {
					move();
					turnRight();
					move();
				}
			} else {
				turnRight();
				if (frontIsClear()) {
					move();
					turnRight();
				}
			}
		}
	}
}