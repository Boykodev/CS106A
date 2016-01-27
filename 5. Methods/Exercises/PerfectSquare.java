/*
 * Tells if a number is
 * a perfect square.
 */

import acm.program.*;

public class PerfectSquare extends ConsoleProgram {
	public void run() {
		showInfo();
		int n = readInt("Enter a number to test: ");
		while (n == 0) {
			println("Zero is a controversial case.");
			n = readInt("Enter another number: ");
			while (n < 0) {
				println("Square can't be negative.");
				n = readInt("Enter another number: ");
			}
		}
		while (n < 0) {
			println("Square can't be negative.");
			n = readInt("Enter another number: ");
			while (n == 0) {
				println("Zero is a controversial case.");
				n = readInt("Enter another number: ");
			}
		}
		showResult(isPerfectSquare(n));
	}

	private void showInfo() {
		println("This program tells if a number is a perfect square.");
	}

	private boolean isPerfectSquare(int n) {
		return ((int)Math.sqrt(n) * (int)Math.sqrt(n) == n);
	}
	
	private void showResult(boolean isPerfectSquare) {
		if (isPerfectSquare) {
			println("This number is a perfect square.");
		} else {
			println("Nothing special about this number.");
		}
	}
}
