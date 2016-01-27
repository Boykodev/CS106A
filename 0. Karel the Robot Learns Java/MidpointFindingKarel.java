/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	public void run() {
		cornerBeepers();
		while(noBeepersPresent()) {
			addBeepers();
		}
		turnAround();
		move();
		pickBeeper();
		if (noBeepersPresent()) {
			putBeeper();
			putBeeper();
			turnAround();
			move();
			putBeeper();
			clearBeeperLine();
		} else {
			putBeeper();
			clearBeeperLine();
		}
	}
	
	private void cornerBeepers() {
		while (frontIsClear()) {
			move();
		}
		putBeeper();
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnAround();
		putBeeper();
		move();
	}
	
	private void addBeepers() {
		move();
		while (noBeepersPresent()) {
			move();
		}
		turnAround();
		move();
		putBeeper();
		move();
		while (noBeepersPresent()) {
			move();
		}
		turnAround();
		move();
		putBeeper();
		move();
	}
	
	private void clearBeeperLine() {
		while (frontIsClear()) {
			move();
		}
		turnAround();
		pickBeeper();
		while (frontIsClear()) {
			move();
			pickBeeper();
		}
	}
}
	
/*int moves;
	public void run() {
		moves = 0;
		while (frontIsClear()) {
			move();
			moves++;
		}
		turnAround();
		for (int i = 0; i < moves/2; i++) {
			move();
		}
		if (moves % 2 == 0) { // odd width
			putBeeper();
		} else { // even width
			putBeeper();
			move();
			putBeeper();
		}
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}
*/