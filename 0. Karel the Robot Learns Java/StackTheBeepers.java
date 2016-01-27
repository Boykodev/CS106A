/*
 * StackTheBeepers.java
 * --------------------
 * Stacks the beepers from
 * towers in to the last corner.
 */

import stanford.karel.*;

public class StackTheBeepers extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			moveToTower();
			moveBeeperFromTowerToCorner();
		}
	}
	
	public void moveToTower() {
		while (noBeepersPresent()) {
			move();
		}
	}
	public void moveBeeperFromTowerToCorner() {
		
		/* Pre: Facing east, at the bottom of the uncleared tower.
		 * 
		 * Post: Same position, same direction, tower is cleared
		 */
		
		takeOneBeeper();
		moveToCorner();
		putBeeperOnTheCorner();
		backToTower();
	}
	public void takeOneBeeper() {
		turnLeft();
		while (beepersPresent()) {
			move();
		}
		turnAround();
		move();
		pickBeeper();
	}
	
	public void moveToCorner() {
		while (frontIsClear()) {
			move();
		}
		turnLeft();
		while (frontIsClear()) {
			move();
		}
	}
	
	public void putBeeperOnTheCorner() {
		putBeeper();
	}
	public void backToTower() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnAround();
		while (noBeepersPresent()) {
			move();
		}
	}
}
