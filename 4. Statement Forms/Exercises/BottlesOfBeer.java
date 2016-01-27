/*
 * BottlesOfBeer.java
 * ------------------
 * Program generates lyrics for
 * "99 bottles of beer" song.
 */

import acm.program.*;

public class BottlesOfBeer extends ConsoleProgram {
	private static final int BOTTLES_OF_BEER = 99;
	
	public void run() {
		showInfo();
		lyrics();
	}

	private void showInfo() {
		println("This program generates \"99 bottles of beer\" song.");
		println("-------------------------------------------------");
	}

	private void lyrics() {
		for (int i = BOTTLES_OF_BEER; i > 0; i--) {
			println(i + " bottle" + ((i == 1) ? "" : "s") + " of beer on the wall.");
			println(i + " bottle" + ((i == 1) ? "" : "s") + " of beer.");
			println("You take one down, pass it around.");
			if ((i - 1) == 0) {
				println("NO MORE BEER!!!");
				break;
			}
			println((i - 1) + " bottle" + ((i == 2) ? "" : "s") + " of beer on the wall.");
			println("");
		}
	}
}
