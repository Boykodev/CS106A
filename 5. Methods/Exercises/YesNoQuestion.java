/*
 * Asks user a yes-no question.
 */

import acm.program.*;

public class YesNoQuestion extends ConsoleProgram {
	public void run() {
		while (true) {
			String answer = readLine("Would you like instructions? ");
			if (answer.equals("yes") || answer.equals("no")) {
				println("The answer is: " + askYesNoQuestion(answer));
				break;
			} else {
				println("Please answer yes or no.");
			}
		}
	}

	private boolean askYesNoQuestion(String answer) {
		return answer.equals("yes");
	}
}
