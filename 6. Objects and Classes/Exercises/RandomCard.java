import acm.program.*;
import acm.util.*;

public class RandomCard extends ConsoleProgram {
	
	public void run() {
		intro();
		for(int i = 0; i < 52; i++) {
			println(new RandomCard());
			pause(100);
		}
	}
	
	public RandomCard() {
		this.rank = rgen.nextInt(1, 13);
		this.suit = rgen.nextInt(1, 4);
	}
	
	public void intro() {
		println("This program displays 52 randomly chosen cards.");
	}
	
	public String toString() {
		String card;
		
		switch(this.rank) {
			case 1: card = "Ace"; break;
			case 11: card = "Jack"; break;
			case 12: card = "Queen"; break;
			case 13: card = "King"; break;
			default: card = ""+this.rank+""; break;
		}
		
		switch(this.suit) {
			case 1: card += " of Clubs"; break;
			case 2: card += " of Diamonds"; break;
			case 3: card += " of Hearts"; break;
			case 4: card += " of Spades"; break;
			default: break;
		}
		return card;
	}
	
	private int rank;
	private int suit;
	private RandomGenerator rgen = new RandomGenerator();
}