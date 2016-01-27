/*
 * OddIntegersSum.java
 * -------------------
 * Displays sum of odd integers, starting from 1.
 */

import acm.program.*;

public class OddIntegersSum extends DialogProgram {
	int n, sum = 1;
	
	public void run() {
		showInfo();
		takeNumberOfIntegers();
		oddIntegersSum();
		showResult();
	}

	private void showInfo() {
		println("Program displays the sum of odd integers, starting from 1.");
	}

	private void takeNumberOfIntegers() {
		while (n <= 0) n = readInt("Define the number of integers: ");
	}

	private void oddIntegersSum() {
		for (int i = 1; i < n; i++) {
			sum += 2 * i + 1;
		}
	}
	
	private void showResult() {
		println("The sum of " + n + " odd integer" + ((n == 1) ? "" : "s" ) +" is: " + sum);
	}
}
