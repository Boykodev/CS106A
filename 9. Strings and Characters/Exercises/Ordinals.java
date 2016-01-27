import acm.program.*;

/** Transforms integers to corresponding ordinals.*/
public class Ordinals extends ConsoleProgram {
	
	private static final int MAX = 101;

	public void init() {
		
		for (int i = 1; i <= MAX; i++) {
			print(i + " - " + ordinalForm(i) + "\n");
		}
	}

	private String ordinalForm(int i) {
		
		int n = 0;
		if (i != 11 & i != 12 & i != 13) {
			n = i % 10;
		}
		
		switch(n) {
		case 1:
			return i + "st";
		case 2:
			return i + "nd";
		case 3:
			return i + "rd";
		default:
			return i + "th";
		}
	}
}
