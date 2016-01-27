import acm.program.*;

public class SecondLargest extends ConsoleProgram {

	private static final int SENTINEL = 0;
	
	public void run() {
		println("Enter numbers line by line.");
		numbersInit();
		readUntilSentinel();
		showResult();
	}
	
	private void showResult() {
		println("The largest value is: " + largest);
		println("The second largest value is: " + second);
	}

	private void readUntilSentinel() {
		while (true) {
			int value = readInt("? ");
			
			if (value == SENTINEL) {
				break;
			}
			
			if (value > largest) {
				second = largest;
				largest = value;
			} else if (value > second) {
				second = value;
			}
		}
	}

	private void numbersInit() {
		largest = readInt("? ");
		second = readInt("? ");
		if (second > largest) {
			largest += second;
			second = largest - second;
			largest -= second; 
		}
	}

	private int largest;
	private int second;
}
