/*
 * Displays greatest common
 * divisor(GCD) of two integers.
 */

import acm.program.*;

public class GCD extends ConsoleProgram {
	public void run() {
		int x, y;
		
		showInfo();
		x = readInt("Enter first number: ");
		y = readInt("Enter second number: ");
		showResult(x, y);
	}
	
	private void showInfo() {
		println("Program displays GCD of two integers: ");
	}

	int gcd(int x, int y) {
		if (x < y) {
			for (int i = x; i > 0; i--) {
				if (x % i == 0 && y % i == 0) {
					return i;
				}
			}
		} else {
			for (int i = y; i > 0; i--) {
				if (x % i == 0 && y % i == 0) {
					return i;
				}
			}
		}
		return 0;
	}
	
	int gcd2(int x, int y) {
		int guess = Math.min(x, y);
		while(x % guess != 0 || y % guess != 0) {
			guess--;
		}
		return guess;
	}
	
	int gcd3(int x, int y) {
		int r = x % y;
		while (r != 0) {
			x = y;
			y = r;
			r = x % y;
		}
		return y;
	}
	
	private void showResult(int x, int y) {
		println("GCD (" + x + ", " + y + ") = " + gcd3(x, y));
	}	
}