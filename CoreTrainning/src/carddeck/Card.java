package carddeck;
/**
 * 
 */

/**
 * @author Phan Toan
 *
 */
public class Card {
	private Suit suit;
	private Rank rank;

	Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit() {
		return this.suit;
	}

	public Rank getRank() {
		return this.rank;
	}

	public String toString() {
		return rank + " of " + suit;
	}
}