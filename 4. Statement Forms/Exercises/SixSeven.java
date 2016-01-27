/*
 * SixSeven.java
 * -------------
 * Displays numbers from 1 to 100
 * that are divisible by 6 or 7.
 */

import acm.program.*;

public class SixSeven extends ConsoleProgram {
	public void run() {
		showInfo();
		showNumbers();
	}

	private void showInfo() {
		println("This program displays numbers from 1 to 100 that are divisible by 6 or 7.");
		println("-------------------------------------------------------------------------");
	}

	private void showNumbers() {
		for (int i = 1; i <= 100; i++) {
			if ((i % 6 == 0) && (i % 7 == 0)) {
				println(i + " - divisible by 6/7.");
			} else if ((i % 6 == 0)) {
				println(i + " - divisible by 6.");
			} else if ((i % 7 == 0)) {
				println(i + " - divisible by 7.");
			}
		}
	}
}
