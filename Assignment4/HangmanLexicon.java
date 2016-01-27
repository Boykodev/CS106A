/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;

public class HangmanLexicon {

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		int count;
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader("ShorterLexicon.txt"));
			
			for (count = 0; true; count++) {
				String line = rd.readLine();
				if (line == null) break;
			}
			rd.close();
		} catch (IOException e) {
			throw new ErrorException(e);
		}
		return count;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		String line;
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader("ShorterLexicon.txt"));
			
			for (int i = 0; i < index; i++) {
				rd.readLine();
			}
			line = rd.readLine();
			rd.close();
		} catch (IOException e) {
			throw new ErrorException(e);
		}
		return line;
	}
}
