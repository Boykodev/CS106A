/*
 * Shows if integer is a prime.
 */

import acm.program.*;

public class Prime extends ConsoleProgram {
	public void run() {
		println("Enter integer to test if it is a prime.");
		int n = readInt();
		if (isPrimeE(n)) {
			print("Number is a prime.");
		} else {
			print("Number is NOT a prime.");
		}
	}
	
	boolean isPrimeB(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	boolean isPrimeE(int n) {
		return ((factorial(n - 1) + 1) % n == 0);
	}
	
	int factorial (int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}	
}