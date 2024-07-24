package versions;

import java.util.List;

import cardManagement.Card;
import cardManagement.Deck;
import cardManagement.Player;

public class Version2 {
	public int seed = 10;
	public int deckSize = 52;
	
	public void initializeGame() {
		Player ply1 = new Player();
		Player ply2 = new Player();
		ply1.setPlayerNumber(1);
		ply2.setPlayerNumber(2);
		Deck deck = new Deck();
		
		deck.shuffleDeck(seed);
		
		int cardsToRemove = 52 - deckSize;
		
		if(cardsToRemove > 0) {
			deck.setSize(cardsToRemove);
		}
		
		int splitdeck = deck.deckSize() / 2;
		
		for(int i = 0; i <= splitdeck-1; i++) {
			ply1.addCardtoHand(deck.dealCard());
		}
		for(int i = 0; i <= splitdeck-1; i++) {
			ply2.addCardtoHand(deck.dealCard());
		}
		startGame(ply1, ply2);
	}
	
	
	public void startGame(Player ply1, Player ply2) {
		int currRound = 0;
		loop: while(ply1.handSize() != 0 && ply2.handSize() != 0) {
			Card ply1Card, ply2Card;
			ply1Card = ply1.playFromHand();
			ply2Card = ply2.playFromHand();
			System.out.println("Player "+ply1.playerNum+" plays " + ply1Card.toString());
			System.out.println("Player "+ply2.playerNum+" plays " + ply2Card.toString());
			
			if(ply1Card.getValue() > ply2Card.getValue()) {
				ply1.addCardtoPoints(ply2Card);
				ply1.addCardtoPoints(ply1Card);
				System.out.println("Player "+ply1.playerNum+" wins the round.");
				printScore(ply1, ply2);
			} else if (ply1Card.getValue() < ply2Card.getValue()) {
				ply2.addCardtoPoints(ply2Card);
				ply2.addCardtoPoints(ply1Card);
				System.out.println("Player 2 wins the round.");
				printScore(ply1, ply2);
			} else if (ply1Card.getValue() == ply2Card.getValue()) {
				War war = new War();
				String outcome = war.beginWar2Players(ply1, ply2, 1);
				switch(outcome) {
					case "ply1win":
						ply1.addCardtoPoints(ply1Card);
						ply1.addCardtoPoints(ply2Card);
						System.out.println("Player 1 wins the round.");
						printScore(ply1, ply2);
						break;
					case "ply2win":
						ply2.addCardtoPoints(ply1Card);
						ply2.addCardtoPoints(ply2Card);
						System.out.println("Player 2 wins the round.");
						printScore(ply1, ply2);
						break;
					case "GameOver":
						break loop;
					case "GameOver1":
						System.out.println("Player 1 does not have enough cards for WAR.");
						break loop;
					case "GameOver2":
						System.out.println("Player 2 does not have enough cards for WAR.");
						break loop;
				}
			}
			currRound = currRound + 1;
		}
		
		if(ply1.points() > ply2.points()) {
			System.out.println("Player " + ply1.playerNum + " wins the game.");
			return;
		} else if(ply2.points() > ply1.points()){
			System.out.println("Player " + ply2.playerNum + " wins the game.");
			return;
		} else if(ply1.points() == ply2.points()) {
			System.out.println("Its a draw.");
			return;
		}
	}
	
	public void setSeed(int input) {
		seed = input;
	}
	public void setDeckSize(int input) {
		deckSize = input;
	}
	public void printScore(Player player1, Player player2) {
		System.out.println("Player "+player1.playerNum+" has a score of " + player1.handSize());
		System.out.println("Player "+player2.playerNum+" has a score of " + player2.handSize());
		return;
	}
}
