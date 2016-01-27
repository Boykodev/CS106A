import acm.program.*;
import acm.util.*;

/**
 * Math quiz
 * application.
 */
public class MathQuiz extends ConsoleProgram {
	
	public static final int NUMBER_OF_QUESTIONS = 5;
	public static final int MAX_NUMBER = 20;
	public static final int TRIALS = 3;
	
	public void run() {
		MathQuiz quiz = new MathQuiz();
		quiz.setConsole(this.getConsole());
		quiz.intro();
		quiz.questions();
	}
	
	public void intro() {
		println("Welcome to Math Quiz");
	}
	
	public void questions() {
		for (int i = 0; i < NUMBER_OF_QUESTIONS;) {
			int n1, n2;
			int answer = 0;
			String value;
			
			n1 = rgen.nextInt(1, MAX_NUMBER);
			n2 = rgen.nextInt(1, MAX_NUMBER);
			
			if (isPlus()) {
				if ((n1 + n2) <= MAX_NUMBER) {
					for (int j = 0; j < TRIALS; j++) {
						if (j == 0) {
							value = readLine("What is " + n1 + " + " + n2 + " in base 8? ");
							answer = Integer.parseInt(value, 8);
						} else {
							value = readLine(incorrect());
							answer = Integer.parseInt(value, 8);
						}
						
						if (check(answer, n1 + n2)) {
							println(correct());
							break;
						}
						
						if (j == TRIALS - 1) {
							int result = n1 + n2;
							println("No, the answer is " + Integer.toString(result, 8) + ".");
						}
					}
					
					i++;
				}
			} else {
				if (Math.max(n1, n2) - Math.min(n1, n2) > 0 &&
						Math.max(n1, n2) - Math.min(n1, n2) <= MAX_NUMBER) {
					for (int j = 0; j < TRIALS; j++) {
						if (j == 0) {
							value = readLine("What is " + Math.max(n1, n2) +
									" - " + Math.min(n1, n2) + " in base 8? ");
							answer = Integer.parseInt(value, 8);
						} else {
							value = readLine(incorrect());
							answer = Integer.parseInt(value, 8);
						}
						
						if (check(answer, Math.max(n1, n2) - Math.min(n1, n2))) {
							println(correct());
							break;
						}
						
						if (j == TRIALS - 1) {
							int result = (Math.max(n1, n2) - Math.min(n1, n2));
							println("No, the answer is " + Integer.toString(result, 8) + ".");
						}
					}
					
					i++;
				}
			}
		}
	}
	
	private boolean check(int answer, int rightAnswer) {
		return answer == rightAnswer;
	}

	private String correct() {
		switch (rgen.nextInt(1, 3)) {
		case 1: return "That's the answer!";
		case 2: return "Correct!";
		case 3: return "You got it!";
		default: return null;
		}
	}
	
	private String incorrect() {
		return "That's incorrect - try a different answer: ";
	}
	
	private boolean isPlus() {
		return rgen.nextBoolean();
	}
	
	private RandomGenerator rgen = new RandomGenerator();
}
