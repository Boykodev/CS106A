/*
 * CountdownWhile.java
 * -------------------
 * Counts backwards while loop.
 */

import acm.program.*;

public class CountdownWhile extends ConsoleProgram {
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
		int t = START;
		while (t >= 0) {
			println(t);
			if (t == 0) println("Liftoff!");
			t--;
		}
	}
}