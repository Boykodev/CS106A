import acm.program.*;
import acm.util.*;

/**
 * Creates cards with
 * ranks and suits.
 */
public class Card extends ConsoleProgram {
	private static final int CLUBS = 1;
	private static final int DIAMONDS = 2;
	private static final int HEARTS = 3;
	private static final int SPADES = 4;
	
	private static final int ACE = 1;
	private static final int JACK = 11;
	private static final int QUEEN = 12;
	private static final int KING = 13;

/** Creates a new random card. */	
	public Card() {
		this.rank = rgen.nextInt(1, 13);
		this.suit = rgen.nextInt(0, 3);
	}
	
/**
 * Creates specified card.
 * @param rank 1 - 13 or named card.
 * @param suit 0 - 3 or named suit.
 */
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public void run() {
		Card card = new Card(ACE, CLUBS);
		println(card);
		println(card.getRank());
		println(card.getSuit());
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public int getSuit() {
		return this.suit;
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
