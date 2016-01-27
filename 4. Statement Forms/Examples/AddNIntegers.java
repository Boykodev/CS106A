/*
 * AddNIntegers.java
 * ------------------
 * Adds predefined number of integers.
 */

import acm.program.*;

public class AddNIntegers extends ConsoleProgram {
	int n, value, total;
	
	public void run() {
		showInfo();
		addNIntegers();
		showResult();
	}

	private void showInfo() {
		println("Program adds predefined number of integers.");
	}

	private void addNIntegers() {
		int n = readInt("Enter number of integers to add: ");
		for (int i = 0; i < n; i++) {
			value = readInt("Enter integer # " + (i + 1) + ": ");
			total += value;
		}
	}

	private void showResult() {
		println("Total is: " + total);
	}
}