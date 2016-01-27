/*
 * File: PotholeFillingKarel.java
 * ------------------------------
 * Karel fills up pot holes with beepers.
 */

public class PotholeFillingKarel extends NewImprovedKarel {
	public void run() {
		while (frontIsClear()) {
			if (rightIsClear()) {
				fillPothole();
			}
			move();
		}
		if (rightIsClear()) {
			fillPothole();
		}
	}
	private void fillPothole() {
		turnRight();
		move();
		if (noBeepersPresent()) {
			if (beepersInBag()) {
				putBeeper();
			}
		}
		turnAround();
		move();
		turnRight();
	}
}