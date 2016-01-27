/*
 * ThisOldMan.java
 * ---------------
 * Program generates lyrics for
 * "This Old Man..." silly song.
 */

import acm.program.*;

public class ThisOldMan extends ConsoleProgram {
	int n;
	
	public void run() {
		showInfo();
		switchWord();
		lyrics();
	}

	private void showInfo() {
		println("This program generates \"This Old Man\" song.");
		println("-------------------------------------------");
	}

	private void switchWord() {
		switch (n) {
		case 1: println("thumb."); break;
		case 2: println("shoe."); break;
		case 3: println("knee."); break;
		case 4: println("door."); break;
		case 5: println("hive."); break;
		case 6: println("sticks."); break;
		case 7: println("up to heaven."); break;
		case 8: println("pate."); break;
		case 9: println("spine."); break;
		case 10: println("shin."); break;
		default: break;
		}
	}

	private void lyrics() {
		for (n = 1; n <= 10; n++) {
			println("This old man, he played " + n + ".");
			print("He played knick-knack " + ((n == 7) ? "" : "on my "));
			switchWord();
			println("With a knick-knack, paddy-whack,");
			println("Give your dog a bone.");
			println("This old man came rolling home.");
			println("");
		}
	}
}
