package cardManagement;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import cardManagement.Card.Suit;
import cardManagement.Card.Rank;

public class Deck {
	private static List<Card> cardDeck = new ArrayList<Card>();
	
	static {
		for(Suit curSuit: Suit.values()) {
			for(Rank curRank : Rank.values()) {
				cardDeck.add(new Card(curSuit, curRank));
			}
		}
	}
	
	public void setSize(int n) {
		for(int i = 0; i <= n; i++) {
			cardDeck.remove(0);
		}
	}
	//return size of deck
	public int deckSize() {
		return cardDeck.size();
	}
	
	public Card dealCard() {
		Card crd = cardDeck.get(0);
		cardDeck.remove(0);
		return crd;
	}
	
	//add card to deck
	public void addCard(Card card) {
		cardDeck.add(card);
	}
	
	public List<Card> shuffleDeck(int seed) {
		Collections.shuffle(cardDeck, new Random(seed));
		return cardDeck;
	}
	
	public static List<Card> getDeck(){
		return cardDeck;
	}
	
	//for testing
	public String toString() {
		for(Card element : cardDeck) {
			System.out.println(element.toString());
		}
		return "done";
	}
}
