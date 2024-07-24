package versions;

import java.util.List;

import cardManagement.Card;
import cardManagement.Deck;
import cardManagement.Player;

public class Version1 {
	public int seed = 10;
	public int rounds = 50;
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
			if(currRound > rounds) {
				System.out.println("Game Over: Round Limit Reached");
				System.out.println("Player 1 has a score of " + ply1.handSize());
				System.out.println("Player 2 has a score of " + ply2.handSize());
				break loop;
			}
			Card ply1Card, ply2Card;
			ply1Card = ply1.playFromHand();
			ply2Card = ply2.playFromHand();
			System.out.println("Player 1 plays " + ply1Card.toString());
			System.out.println("Player 2 plays " + ply2Card.toString());
			
			if(ply1Card.getValue() > ply2Card.getValue()) {
				ply1.addCardtoHand(ply2Card);
				ply1.addCardtoHand(ply1Card);
				System.out.println("Player 1 wins the round.");
			} else if (ply1Card.getValue() < ply2Card.getValue()) {
				ply2.addCardtoHand(ply2Card);
				ply2.addCardtoHand(ply1Card);
				System.out.println("Player 2 wins the round.");
			} else if (ply1Card.getValue() == ply2Card.getValue()) {
				War war = new War();
				String outcome = war.beginWar2Players(ply1, ply2, 1);
				switch(outcome) {
					case "ply1win":
						ply1.addCardtoHand(ply1Card);
						ply1.addCardtoHand(ply2Card);
						System.out.println("Player 1 wins the round.");
						break;
					case "ply2win":
						ply2.addCardtoHand(ply1Card);
						ply2.addCardtoHand(ply2Card);
						System.out.println("Player 2 wins the round.");
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
		
		if(ply1.handSize() > ply2.handSize()) {
			System.out.println("Player 1 wins the game.");
			return;
		} else {
			System.out.println("Player 2 wins the game.");
			return;
		}
	}
	
	public void setSeed(int input) {
		seed = input;
	}
	public void setDeckSize(int input) {
		deckSize = input;
	}
	public void setNumRounds(int input) {
		rounds = input;
	}
}
