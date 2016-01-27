/*
 * CardRank.java
 * -------------
 * Defines card rank by its number
 * and draws a corresponding table.
 */

import acm.program.*;

public class CardRank extends ConsoleProgram {
	public void run() {
		drawTable();
	}

	private void cardRank(int rank) {
		switch(rank) {
		case 1:
			println("Ace");
			break;
		case 11:
			println("Jack");
			break;
		case 12:
			println("Queen");
			break;
		case 13:
			println("King");
			break;
		default:
			println(rank);
			break;
		}
	}

	private void drawTable() {
		int n = 1;
		for (int i = 0; i < 13; i++) {
			print(n + ((n < 10) ? " ": "") +" = ");
			cardRank(n);
			n++;
		}
	}
}