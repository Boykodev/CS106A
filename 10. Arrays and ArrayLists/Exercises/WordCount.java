import java.io.*;
import java.util.*;

import acm.util.*;
import acm.program.*;

public class WordCount extends ConsoleProgram {

	private static final String FILE_NAME = "Sample.txt";
	
	public void run() {
		getThrough(FILE_NAME);
		printResult();
	}
	
	private void printResult() {
		println("File: " + FILE_NAME);
		println("Lines = " + totalLines);
		println("Words = " + totalWords);
		println("Chars = " + totalChars);
	}

	private void getThrough(String fileName) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(fileName));
			
			for (totalLines = 0; true; totalLines++) {
				String line = rd.readLine();
				if (line == null) break;
				totalWords += getWordsInLine(line);
				totalChars += getCharsInLine(line);
			}
			rd.close();
		} catch (IOException e) {
			throw new ErrorException(e);
		}
	}
	
	private int getWordsInLine(String line) {
		StringTokenizer token = new StringTokenizer(line);
		
		int wordsInLine = token.countTokens();
		
		return wordsInLine;
	}

	private int getCharsInLine(String line) {
		int charsInLine = 0;
		
		for (int i = 0; i < line.length(); i++) {
			if ( Character.isLetterOrDigit(line.charAt(i)) ) {
				charsInLine++;
			}
		}
		
		return charsInLine;
	}

	private int totalLines;
	private int totalWords;
	private int totalChars;
}
