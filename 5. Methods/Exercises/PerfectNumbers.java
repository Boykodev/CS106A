/*
 * Checks for perfect numbers.
 */

import acm.program.*;

public class PerfectNumbers extends ConsoleProgram {
	public void run() {
		println("Program displays perfect numbers in a range.");
		int last = readInt("Enter last number in a range: ");
		for (int i = 1; i <= last; i++) {
			if (isPerfect(i)) println("Number " + i + " is perfect.");
		}
	}
	
	boolean isPerfect(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) sum += i;
		}
		return (sum == n);
	}
	
}
