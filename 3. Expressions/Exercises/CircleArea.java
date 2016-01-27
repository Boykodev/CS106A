/*
 * CircleArea.java
 * ---------------
 * Computes the area of the 
 * circle by the given radius.
 */

import acm.program.*;

public class CircleArea extends ConsoleProgram {
	double r, area;
	public void run() {
		println("Program computes the area of a circle.");
		takeRadius();
		computeArea();
		showResult();
	}
	private void takeRadius() {
		r = readDouble("Enter radius: ");
	}
	
	private void computeArea() {
		area = PI * r * r;
	}
	
	private void showResult() {
		println("The area of the circle is: " + area);
	}
	
	private static final double PI = 3.141592;
}