/*
 * File: NewImprovedKarel.java
 * ---------------------------
 * Defines new class of Karel with
 * turnRight and turnAround build in.
 */

import stanford.karel.*;

public class NewImprovedKarel extends Karel {
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
	public void turnAround() {
		turnLeft();
		turnLeft();
	}
}