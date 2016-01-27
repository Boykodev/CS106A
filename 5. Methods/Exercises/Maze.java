/*
 * Algorithm for solving a maze.
 */

import acm.program.*;

public class Maze extends ConsoleProgram {
	public void run() {
		while (!isOutside()) {
			turnRight();
			if (isFacingWall()) {
				turnLeft();
			}
			moveForward();
		}
	}
	
	private boolean isOutside() {
			return false;
	}
	
	private boolean isFacingWall() {
		return true;
	}
	
	private void turnLeft() {		
	}

	private void turnRight() {
	}

	private void moveForward() {
	}
}
