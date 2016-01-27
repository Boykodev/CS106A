import acm.program.*;

public class CountLetterFrequencies extends ConsoleProgram {
	
	public void run() {
		readText();
		buildArray();
		showLetters();
	}
	
	private void showLetters() {
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] != 0) {
				char ch = (char) ('A' + i);
				print(ch + ": " + letters[i] + "\n");
			}
		}
		
	}

	private void buildArray() {
		letters = new int[26];
		
		for (int i = 0; i < text.length(); i++) {
			char ch = Character.toUpperCase(text.charAt(i));
			
			if (ch >= 'A' && ch <= 'Z') {
				letters[ch - 'A']++;
			}
		}
		
	}

	private void readText() {
		println("Enter text to get letter frequencies:");
		text = readLine();
	}

	private int [] letters;
	private String text;
}
