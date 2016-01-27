/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final int SENTINEL = 0;
	
	public void run() {
		/* You fill this in */
		showInfo();
		readList();
	}

	private void showInfo() {
		println("This program finds the largest and smallest numbers.");
	}

	private void readList() {
		int n, smallest, largest, index = 0;
		n = readInt("Enter number: ");
		largest = smallest = n;
		while (n != SENTINEL) {
			if (n > largest) {
				largest = n;
			} else if (n < smallest) {
				smallest = n;
			}
			n = readInt("Enter number: ");
			index++;
		}
		showResult(index, smallest, largest);
	}

	private void showResult(int index, int smallest, int largest) {
		if (index == 0) {
			println("No values have been entered.");
		} else if (index == 1) { 
			println("Both smallest and largest values are: " + smallest);
		} else {
			println("Smallest: " + smallest);
			println("Largest: " + largest);
		}
	}
}