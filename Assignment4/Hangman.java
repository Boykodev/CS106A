/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	private static final int GUESSES = 8;
	private static final char CRYPT = '-';
	
	public void init() {
		canvas = new HangmanCanvas();
		lexicon = new HangmanLexicon();
		add(canvas);
		welcome();
	}
	
    public void run() {
    		playNewGame();
	}
    
    private void welcome() {
		println("Welcome to Hangman!");
	}

	private void playNewGame() {
    		word = lexicon.getWord(rgen.nextInt(0, lexicon.getWordCount()));
    		cryptTheWord();
    		
    		canvas.reset();
    		canvas.displayWord(cryptedWord);
    		
    		int guesses = GUESSES;
    		boolean win = false;
    		
    		while (guesses > 0 && !win) {
    			println("The word now look like this: " + cryptedWord);
    			println("You have " + guesses + " guess" + ((guesses == 1) ? "" : "es") + " left.");
    			String guess = readLine("Your guess: ");
    			
    			if (checkGuess(guess)) {
    				println("That guess is correct!");
    				canvas.displayWord(cryptedWord);
    			} else if (guess.length() == 1) {
    				println("There are no " + guess.toUpperCase() + "'s in the word.");
    				guesses--;
    				canvas.noteIncorrectGuess(guesses);
    			} else {
    				println("Your guess is wrong!");
    				guesses--;
    				canvas.noteIncorrectGuess(guesses);
    			}
    			
    			if (cryptedWord.indexOf(CRYPT) == -1) {
    				win = true;
    				println("You guessed the word: " + cryptedWord);
    				println("You win!");
    			}
    			
    			if (guesses == 0) {
    				println("You're completly hung.");
    				println("The word was: " + word);
    			}
    		}
    		
    		restart();
	}

	private void restart() {
		String answer = "";
		while (!answer.equals("n") && !answer.equals("N")) {
			answer = readLine("Play again(y/n)? ");
			if (answer.equals("y") || answer.equals("Y")) {
				playNewGame();
			}
		}
		println("Thanks for playing!");
	}

	private boolean checkGuess(String guess) {
		boolean correctGuess = false;
		guess = guess.toUpperCase();
		
		if (guess.length() == 1) {
			int startIndex = 0;
			while (word.indexOf(guess, startIndex) != -1) {
				startIndex = openLetters(guess, startIndex);
				correctGuess = true;
			}
		}
		
		if (guess.length() == word.length()) {
			if (guess.equals(word)) {
				cryptedWord = word;
				correctGuess = true;
			}
		}
		
		return correctGuess;
	}

	private int openLetters(String guess, int startIndex) {
		cryptedWord = cryptedWord.substring(0, word.indexOf(guess, startIndex)) 
		+ guess + cryptedWord.substring(word.indexOf(guess, startIndex) + 1);
		return word.indexOf(guess, startIndex) + 1;
	}

	private void cryptTheWord() {
		cryptedWord = "";
		for(int i = 0; i < word.length(); i++) {
			cryptedWord += CRYPT;
		}
	}
	
	private String word;
    private String cryptedWord;
    private HangmanCanvas canvas;
	private HangmanLexicon lexicon;
	private RandomGenerator rgen = new RandomGenerator();
}
