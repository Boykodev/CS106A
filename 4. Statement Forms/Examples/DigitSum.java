/*
 * DigitSum.java
 * -------------
 * Sums the digits in
 * a positive integer.
 */

import acm.program.*;

public class DigitSum extends DialogProgram {
	int n, sum;
	
	public void run() {
		showInfo();
		takeNumber();
		sumTheDigits();
		showResult();
	}

	private void showInfo() {
		println("This program sums up the digits in a positive integer.");
	}

	private void takeNumber() {
		while(n <= 0) n = readInt("Enter a positive integer: ");
	}

	private void sumTheDigits() {
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
	}

	private void showResult() {
		println("Sum of digits is: " + sum);
	}
}