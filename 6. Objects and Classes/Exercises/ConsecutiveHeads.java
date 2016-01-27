import acm.program.*;
import acm.util.*;

public class ConsecutiveHeads extends ConsoleProgram {
	
	public void run() {
		int flips = 0;
		while(true) {
			pause(500);
			flipCoin();
			flips++;
			if(threeHeads()) break;
		}
		println("It took " + flips + " flips to get 3 consecutive heads.");
	}
	
	void flipCoin() {
		if(rgen.nextBoolean()) {
			println("Heads");
			headsCount++;
		} else {
			println("Tails");
			headsCount = 0;
		}
	}

	boolean threeHeads() {
		if (headsCount == 3) return true;
		return false;
	}

	int headsCount;
	RandomGenerator rgen = new RandomGenerator();
}
