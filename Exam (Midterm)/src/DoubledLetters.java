import acm.program.*;

public class DoubledLetters extends ConsoleProgram {

	public void run() {
		String word = readLine("Enter word to remove its doubled letters: ");
		word = removeDoubledLetters(word);
		println(word);
	}

	private String removeDoubledLetters(String word) {
		for (int i = 0; i < word.length() - 1; i++) {
			if (word.charAt(i) == word.charAt(i + 1)) {
				word = word.substring(0, i) +  word.substring(i + 1);
				i--;
			}
		}
		
		return word;
	}
}
