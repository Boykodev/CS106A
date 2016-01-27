/*
 * Fibonacci.java
 * -------------------
 * Displays the fibonacci sequence.
 */

import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	private static final int LAST_NUMBER = 21;
	private static final int MAX = 10000;
	
	public void run() {
		showInfo();
		showFibonacciMax();
	}

	private void showInfo() {
		println("Program displays the famous fibonacci sequence.");
		println("-----------------------------------------------");
	}

	private void showFibonacci() {
		int f2Prev = 0, f1Prev = 1, fCur;
		println("F0 = " + f2Prev);
		println("F1 = " + f1Prev);
		for (int i = 2; i <= LAST_NUMBER; i++) {
			fCur = f1Prev + f2Prev;
			println("F" + i + " = " + fCur);
			f2Prev = f1Prev;
			f1Prev = fCur;
		}
	}
	
	private void showFibonacciMax() {
		int f2Prev = 0, f1Prev = 1, fCur;
		println("F0 = " + f2Prev);
		println("F1 = " + f1Prev);
		for (int i = 2; ; i++) {
			fCur = f1Prev + f2Prev;
			if (fCur > MAX) break;
			println("F" + i + " = " + fCur);
			f2Prev = f1Prev;
			f1Prev = fCur;
		}
	}
}