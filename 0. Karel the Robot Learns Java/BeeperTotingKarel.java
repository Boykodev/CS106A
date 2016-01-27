/*
 * File: BeeperTotingKarel.java
 * ----------------------------
 * Karel transporting a beeper from one corner to another. 
 * 
 */

public class BeeperTotingKarel extends NewImprovedKarel {
	public void run() {
		move();
		pickBeeper();
		move();
		turnLeft();
		move();
		turnRight();
		move();
		move();
		putBeeper();
		move();
	}
}