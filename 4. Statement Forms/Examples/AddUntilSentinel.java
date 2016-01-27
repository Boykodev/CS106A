/*
 * AddUntilSentinel.java
 * ---------------------
 * Adds numbers until sentinel.
 */

import acm.program.*;

public class AddUntilSentinel extends DialogProgram {
	private static final int SENTINEL = 0;
	int value, total, index = 0;
	
	public void run() {
		showInfo();
		addUntilSentinel();
		showResult();
	}

	private void showInfo() {
		println("Program adds integers until sentinel (zero).");
	}
	
	private void addUntilSentinel() {
		while (true) {
			value = readInt("Enter integer # " + (index + 1) + ": ");
			if (value == SENTINEL) break;
			total += value;
			index++;
		}
	}
	
	private void addUntilSentinel2() {
		value = readInt("Enter integer # " + (index + 1) + ": ");
		while (value != SENTINEL) {
			total += value;
			index++;
			value = readInt("Enter integer # " + (index + 1) + ": ");
		}
	}

	private void showResult() {
		println("Total of " +index+" numbers is: " + total + ".");
	}
}