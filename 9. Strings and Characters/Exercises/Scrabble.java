import acm.program.*;

/** Shows points for words in Scrabbleª.*/
public class Scrabble extends ConsoleProgram {
	
	public void init() {
		this.setFont("Helvetica-25");
		
		String word = readLine("Enter word to get its Scrabbleª points: ");
		
		int points = scrabblePoints(word);
		
		println("Your word has " + points + " scrabble points.");
		
		println(scrabblePointsPlus(word));
	}

	private int scrabblePoints(String word) {
		int totalPoints = 0;
		
		for (int i = 0; i < word.length(); i++) {
			totalPoints += pointsForLetter(word.charAt(i));
		}
		return totalPoints;
	}
	
	private String scrabblePointsPlus(String word) {
		String result = "";
		
		for (int i = 0; i < word.length(); i++) {
			result += word.charAt(i) + " - " +
			pointsForLetter(word.charAt(i)) + "\n";
		}
		return result;
	}

	private int pointsForLetter(char ch) {
		ch = Character.toUpperCase(ch);
		
		switch (ch) {
			case 'A': case 'E': case 'I': case 'L': case 'N':
			case 'O': case 'R': case 'S': case 'T': case 'U':
				return 1;
			case 'D': case 'G':
				return 2;
			case 'B': case 'C': case 'M': case 'P':
				return 3;
			case 'F': case 'H': case 'V': case 'W': case 'Y':
				return 4;
			case 'K':
				return 5;
			case 'J': case 'X':
				return 8;
			case 'Q': case 'Z':
				return 10;
			default:
				return 0;
		}
	}
}
