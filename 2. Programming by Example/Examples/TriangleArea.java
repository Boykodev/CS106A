/*
 * TriangleArea.java
 * ---------------
 * Calculates area of a triangle.
 */

import acm.program.*;

public class TriangleArea extends ConsoleProgram {
	public void run() { 
		println("This program calculates area of a triangle: ");
		double b = readDouble("Enter triangle side: ");
		double h = readDouble("Enter triangle height: ");
		double a = (b * h) / 2;
		println("The area is: " + a + ".");
	}
}