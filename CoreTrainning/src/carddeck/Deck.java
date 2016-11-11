package carddeck;
/**
 * 
 */

/**
 * @author Phan Toan
 *
 */
public class Deck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Card[] deck = new Card[52];
		int i = 0;

		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				deck[i++] = new Card(suit, rank);
			}
		}

		for (Card card : deck) {
			System.out.println(card.toString());
		}

	}

}