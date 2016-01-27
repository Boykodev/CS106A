/*
 * Computes the math combinations function.
 */

import acm.program.*;

public class Combinations extends ConsoleProgram {
	public void run() {
		int n, k;
		showInfo();
		n = readInt("Enter number of objects in the set (n): ");
		k = readInt("Enter number of objects to be chosen (k): ");
		println("C(" + n + ", " + k + ") = " + combinations(n, k));
	}

	void showInfo() {
		println("This program computes the combinations function.");
	}
	
	int combinations(int n, int k) {
		return factorial(n) / (factorial(k) * factorial(n - k));
	}
	
	int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
