/*
 * StIves.java
 * -----------
 * Solves the St. Ives riddle.
 */

import acm.program.*;

public class StIves extends ConsoleProgram {
	int sacks, cats, kits, total;
	
	public void run() {
		showInfo();
		calculation();
		showResult();
	}
	
	private void showInfo() {
		println("Who were coming from St. Ives?");
	}
	
	private void calculation() {
		sacks = WIVES * 7;
		cats = sacks * 7;
		kits = cats * 7;
		total = WIVES + cats + kits;
	}
	
	private void showResult() {
		println("The answer is: " + WIVES +" wives with " + sacks + " sacks, containing " + cats + " cats and " + kits + " kits.");
		println("That makes total of " + total + " living creatures.");
	}
	
	private static final int WIVES = 7;
}