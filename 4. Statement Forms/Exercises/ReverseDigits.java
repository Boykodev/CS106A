/*
 * ReverseDigits.java
 * -------------
 * Reverts the digits in the integer.
 */

import acm.program.*;

public class ReverseDigits extends ConsoleProgram {
	int n, r;
	boolean easy;
	
	public void run() {
		showInfo();
		takeNumber();
		if(easy) {
			easyWay();
		} else {
			showResult(hardWay());
		}
	}

	private void showInfo() {
		println("This program reverts the digits in the integer.");
	}

	private void takeNumber() {
		int easy;
		while(n <= 0) n = readInt("Enter a positive integer: ");
		easy = readInt("Enter 1 for easy way solution: ");
		if (easy == 1) this.easy = true;
	}

	private void easyWay() {
		print("The reversed number is: ");
		while (n > 0) {
			print(n % 10);
			n /= 10;
		}
	}
	
	private int hardWay() {
		int digits = digitsCount(n);
		for (int i = 0; i < digits; digits--) {
			r += (n % 10) * pow(10, digits - 1);
			n /= 10;
		}
		return r;
	}

	private int digitsCount(int n) {
		int digits = 0;
		for (; n > 0; digits++) {
			n /= 10;
		}
		return digits;
	}

	private int pow(int base, int power) {
	    if (power == 0) return 1;
	    return base * pow(base, --power);
	}
	
	private void showResult(int r) {
		println("The reversed number is: " + r);
	}
}