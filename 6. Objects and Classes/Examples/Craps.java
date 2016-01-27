/*
 * Simulates a game of "craps".
 */

import acm.program.*;
import acm.util.*;

public class Craps extends ConsoleProgram {
	public void run() {
		int rollCount = 0;
		int point = 0;
		intro();
		while(true) {
			int roll = rollDice();
			rollCount++;
			if (rollCount == 1) {
				if (roll == 7 | roll == 11) {
					println("NATURAL!");
					println("You win!");
					println("Total rolls: " + rollCount);
					break;
				} else if (roll == 2 | roll == 3 | roll == 12) {
					println("CRAPS!");
					println("You lose!");
					println("Total rolls: " + rollCount);
					break;
				} else {
					point = roll;
					println("POINT!");
				}
			}
			if (rollCount > 1) {
				if (roll == point) {
					println("You rolled your point!");
					println("You win!");
					println("Total rolls: " + rollCount);
					break;
				} else if (roll == 7) {
					println("You rolled seven!");
					println("You lose!");
					println("Total rolls: " + rollCount);
					break;
				}
			}	
		}
	}
	
	private void intro() {
		println("Welcome to CRAPS!");
	}

	int rollDice() {
		int dice1 = rgen.nextInt(1, 6);
		int dice2 = rgen.nextInt(1, 6);
		println("Rolling dice: " + dice1 + " + " + dice2 + " = " + (dice1 + dice2));
		return dice1 + dice2;
	}
	
	public RandomGenerator rgen = new RandomGenerator();
}
