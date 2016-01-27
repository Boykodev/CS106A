/*
 * SignTest.java
 * -------------
 * Tests number for sign.
 */

import acm.program.*;

public class SignTest extends DialogProgram {
	int n;
	
	public void run() {
		showInfo();
		takeNumber();
		showResult();
	}

	private void showInfo() {
		println("Program tests number for sign.");
	}

	private void takeNumber() {
		n = readInt("Enter number: ");
	}

	private void showResult() {
		if (n == 0) {
			println("Number is zero.");
		} else {
			println("Number is " + ((n < 0) ? "negative." : "positive." ));
		}
		
		/*if (n < 0) {
			println("Number is negative.");
		} else if (n > 0) {
			println("Number is positive.");
		} else {
			println("Number is zero.");
		}*/
	}
}