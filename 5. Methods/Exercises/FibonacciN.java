/*
 * Let you choose a number
 * in Fibonacci sequence.
 */

import acm.program.*;

public class FibonacciN extends ConsoleProgram {
	public void run() {
		int n = 0;
		showInfo();
		while (n != -1) {
			n = readInt("Enter number in sequence: ");
			fibonacciN(n);
		}
	}
	
	private void showInfo() {
		println("Program let you choose a number in Fibonacci sequence.");
		println("------------------------------------------------------");
	}
	
	private void fibonacciN(int n) {
		int f2Prev = 0, f1Prev = 1, fCur = 0;
		int i;
		for (i = 1; i < n; i++) {
			fCur = f1Prev + f2Prev;
			f2Prev = f1Prev;
			f1Prev = fCur;
		}
		println("F" + i + " = " + ((n == 1) ? f1Prev : fCur));
	}
}
