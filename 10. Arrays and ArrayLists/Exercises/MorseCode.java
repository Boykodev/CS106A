import acm.program.*;
import java.util.*;

public class MorseCode extends ConsoleProgram {
	
	public void run() {
		println("This program translates a line into Morse code.");
		String text = readLine("Enter English text: ");
		ArrayList<String> code = translateToMorse(text);
		for (int i = 0; i < code.size(); i++) {
			if (code.get(i).equals("\n")) {
				print(code.get(i));
			} else if (i < code.size() - 1 && code.get(i + 1).equals("\n")) {
				print(code.get(i));
			} else if (i == code.size() - 1) {
				print(code.get(i));
			} else {
				print(code.get(i) + " ");
			}
		}
	}

	private ArrayList<String> translateToMorse(String text) {
		ArrayList<String> morseCode = new ArrayList<String>();
		
		for (int i = 0; i < text.length(); i++) {
			String morseLetter = letterToMorse(text.charAt(i));
			if (!morseLetter.equals("")) {
				morseCode.add(morseLetter);
			}
		}
		return morseCode;
	}

	private String letterToMorse(char ch) {
		switch (Character.toUpperCase(ch)) {
		case 'A':
			return ".-";
		case 'B':
			return "-...";
		case 'C':
			return "-.-.";
		case 'D':
			return "-..";
		case 'E':
			return ".";
		case 'F':
			return "..-.";
		case 'G':
			return "--.";
		case 'H':
			return "....";
		case 'I':
			return "..";
		case 'J':
			return ".---";
		case 'K':
			return "-.-";
		case 'L':
			return ".-..";
		case 'M':
			return "--";
		case 'N':
			return "-.";
		case 'O':
			return "---";
		case 'P':
			return ".--.";
		case 'Q':
			return "--.-";
		case 'R':
			return ".-.";
		case 'S':
			return "...";
		case 'T':
			return "-";
		case 'U':
			return "..-";
		case 'V':
			return "...-";
		case 'W':
			return ".--";
		case 'X':
			return "-..-";
		case 'Y':
			return "-.--";
		case 'Z':
			return "--..";
		case ' ':
			return "\n";
		default:
			return "";
		}
	}
}
