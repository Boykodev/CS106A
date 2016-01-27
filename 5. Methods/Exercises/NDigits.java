/*
 * Counts the number of
 * digits in an integer.
 */

import acm.program.*;

public class NDigits extends ConsoleProgram {
	public void run() {
		showInfo();
		int n = takeNumber();
		println("Number has " + nDigits(n) + " digit" + ((nDigits(n) == 1) ? "" : "s") + ".");
	}

	private void showInfo() {
		println("This program display the number of digits in a positive integer.");
	}

	private int takeNumber() {
		int n = 0;
		while(n <= 0) n = readInt("Enter a positive integer: ");
		return n;
	}
	
	private int nDigits(int n) {
		int i;
		for (i = 0; n > 0; i++) {
			n /= 10;
		}
		return i;
	}
}
