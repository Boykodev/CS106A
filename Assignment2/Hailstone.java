/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	int n, index;
	
	public void run() {
		takeNumber();
		calculation();
		showResult();
	}

	private void takeNumber() {
		n = readInt("Enter a number: ");
	}

	private void calculation() {
		for (; n != 1; index++) {
			if (n % 2 == 0) {
				print(n + " is even so I take half: ");
				n /= 2;
				println(n);
			} else {
				print(n + " is odd, so I make 3n + 1: ");
				n = 3 * n + 1;
				println(n);
			}
		}
	}

	private void showResult() {
		println("The process took " + index + " to reach 1.");
	}
}