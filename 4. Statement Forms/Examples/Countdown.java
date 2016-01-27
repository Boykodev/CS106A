/*
 * Countdown.java
 * --------------
 * Counts backwards.
 */

import acm.program.*;

public class Countdown extends ConsoleProgram {
	private static final int START = 10;
	
	public void run() {
		showInfo();
		countdown();
	}

	private void showInfo() {
		println("This is a countdown program.");
		println("----------------------------");
	}

	private void countdown() {
		for (int t = START; t >= 0; t--) {
			println(t);
			if (t == 0) println("Liftoff!");
		}
	}
}