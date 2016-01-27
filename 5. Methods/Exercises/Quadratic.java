/*
 * Displays solution for
 * a quadratic equation.
 */

import acm.program.*;

public class Quadratic extends ConsoleProgram {
	public void run() {
		int a = 0;
		int b, c;
		
		showInfo();
		while(a == 0) {
			a = readInt("Enter a: ");
		}
		b = readInt("Enter b: ");
		c = readInt("Enter c: ");
		if ((b*b - 4 * a * c) < 0) {
			showResult();
		} else {
			showResult(firstSolution(a, b, c), secondSolution(a, b, c));
		}
	}

	private void showInfo() {
		println("The program shows solutions to the quadratic equation.");
		println("Enter the coefficients:");
	}
	
	double firstSolution(int a, int b, int c) {
		return (-b + Math.sqrt(b*b - 4 * a * c)) / 2 * a;
	}
	
	double secondSolution(int a, int b, int c) {
		return (-b - Math.sqrt(b*b - 4 * a * c)) / 2 * a;
	}
	
	private void showResult() {
		println("The equation has no real solutions.");
	}
	
	private void showResult(double first, double second) {
		println("The first solution is " + (int)first);
		println("The second solution is " + (int)second);
	}
}
