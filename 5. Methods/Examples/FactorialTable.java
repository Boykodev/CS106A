/*
 * Draws a factorial table.
 */

import acm.program.*;

public class FactorialTable extends ConsoleProgram {
	private static final int LOWER_LIMIT = 0;
	private static final int UPPER_LIMIT = 10;
	
	public void run() {
		for (int i = LOWER_LIMIT; i <= UPPER_LIMIT; i++) {
			println(((i < 10) ? " " : "") + i + "! = " + factorial(i));
		}
	}
	
	int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}