package cardManagement;

public class Card {
	public enum Suit{
		SPADES, HEARTS, DIAMONDS, CLUBS
	}
	
	public enum Rank{
		ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO
	}
	
	private Suit suit;
	private Rank rank;
	private int cValue;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		setValue();
	}
	
	public int getValue() {
		return this.cValue;
	}
	
	private void setValue(){
		switch(this.rank) {
			case ACE:
				this.cValue = 14;
				return;
			case KING:
				this.cValue = 13;
				return;
			case QUEEN:
				this.cValue = 12;
				return;
			case JACK:
				this.cValue = 11;
				return;
			case TEN:
				this.cValue = 10;
				return;
			case NINE:
				this.cValue = 9;
				return;
			case EIGHT:
				this.cValue = 8;
				return;
			case SEVEN:
				this.cValue = 7;
				return;
			case SIX:
				this.cValue = 6;
				return;
			case FIVE:
				this.cValue = 5;
				return;
			case FOUR:
				this.cValue = 4;
				return;
			case THREE:
				this.cValue = 3;
				return;
			default:
				this.cValue = 2;
				return;
		}
	}
	
	public String toString() {
		return rank + " of " + suit;
	}
}
