package cardManagement;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Card> playerHand = new ArrayList<Card>();
	private List<Card> pointPile = new ArrayList<Card>();
	public int playerNum;
	
	public void addCardtoHand(Card card) {
		playerHand.add(card);
		return;
	}
	public void addAllCardsToHand(List<Card> cards) {
		playerHand.addAll(cards);
	}
	public void addAllCardsToPoints(List<Card> cards) {
		pointPile.addAll(cards);
	}
	public void addCardtoPoints(Card card) {
		pointPile.add(card);
		return;
	}
	public int handSize() {
		return playerHand.size();
	}
	
	public int points() {
		return pointPile.size();
	}
	
	public Card playFromHand() {
		Card crd = playerHand.get(0);
		playerHand.remove(0);
		return crd;
	}
	
	public void setPlayerNumber(int i) {
		this.playerNum = i;
	}
	
	public String toString() {
		for(Card element: playerHand) {
			System.out.println(element.toString());
		}
		return "done";
	}

}
