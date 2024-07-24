package versions;

import java.util.List;

import cardManagement.Card;
import cardManagement.Deck;
import cardManagement.Player;

public class Version3 {
	public int seed = 10;
	public int deckSize = 52;
	public void initializeGame() {
		Player ply1 = new Player();
		Player ply2 = new Player();
		Player ply3 = new Player();
		ply1.setPlayerNumber(1);
		ply2.setPlayerNumber(2);
		ply3.setPlayerNumber(3);
		Deck deck = new Deck();
		
		deck.shuffleDeck(seed);
		
		int cardsToRemove = 52 - deckSize;
		if(cardsToRemove > 0) {
			deck.setSize(cardsToRemove);
		}
		
		int splitdeck = deck.deckSize() / 3;
		for(int i = 0; i <= splitdeck-1; i++) {
			ply1.addCardtoHand(deck.dealCard());
		}
		for(int i = 0; i <= splitdeck-1; i++) {
			ply2.addCardtoHand(deck.dealCard());
		}
		for(int i = 0; i <= splitdeck-1; i++) {
			ply3.addCardtoHand(deck.dealCard());
		}
		startGame(ply1, ply2, ply3);
	}
	public void startGame(Player ply1, Player ply2, Player ply3) {
		int currRound = 0;
		loop: while(ply1.handSize() != 0 && ply2.handSize() != 0 && ply3.handSize() != 0) {
			Card ply1Card, ply2Card, ply3Card;
			ply1Card = ply1.playFromHand();
			ply2Card = ply2.playFromHand();
			ply3Card = ply3.playFromHand();
			int player1Value = ply1Card.getValue();
			int player2Value = ply2Card.getValue();
			int player3Value = ply3Card.getValue();
			System.out.println("Player 1 plays " + ply1Card.toString());
			System.out.println("Player 2 plays " + ply2Card.toString());
			System.out.println("Player 3 plays " + ply3Card.toString());
			if(player1Value > player2Value && player1Value > player3Value) {
				ply1.addCardtoPoints(ply2Card);
				ply1.addCardtoPoints(ply1Card);
				ply1.addCardtoPoints(ply3Card);
				System.out.println("Player 1 wins the round.");
				System.out.println("Player 1 has a score of " + ply1.points());
				System.out.println("Player 2 has a score of " + ply2.points());
				System.out.println("Player 3 has a score of " + ply3.points());
			} else if (player2Value > player1Value && player2Value > player3Value) {
				ply2.addCardtoPoints(ply2Card);
				ply2.addCardtoPoints(ply1Card);
				ply2.addCardtoPoints(ply3Card);
				System.out.println("Player 2 wins the round.");
				System.out.println("Player 1 has a score of " + ply1.points());
				System.out.println("Player 2 has a score of " + ply2.points());
				System.out.println("Player 3 has a score of " + ply3.points());
			} else if (player3Value > player1Value && player3Value > player2Value) {
				ply3.addCardtoPoints(ply2Card);
				ply3.addCardtoPoints(ply1Card);
				ply3.addCardtoPoints(ply3Card);
				System.out.println("Player 2 wins the round.");
				System.out.println("Player 1 has a score of " + ply1.points());
				System.out.println("Player 2 has a score of " + ply2.points());
				System.out.println("Player 3 has a score of " + ply3.points());
			} else if (ply1Card.getValue() == ply2Card.getValue()) {
				War war = new War();
				String outcome = war.beginWar3Players(ply1, ply2, ply3);
				switch(outcome) {
					case "player1win":
						ply1.addCardtoPoints(ply1Card);
						ply1.addCardtoPoints(ply2Card);
						ply1.addCardtoPoints(ply3Card);
						System.out.println("Player 1 wins the round.");
						break;
					case "player2win":
						ply2.addCardtoPoints(ply1Card);
						ply2.addCardtoPoints(ply2Card);
						ply2.addCardtoPoints(ply3Card);
						System.out.println("Player 2 wins the round.");
						break;
					case "player3win":
						ply3.addCardtoPoints(ply1Card);
						ply3.addCardtoPoints(ply2Card);
						ply3.addCardtoPoints(ply3Card);
						System.out.println("Player 3 wins the round.");
						break;
					case "GameOver":
						break loop;
					case "GameOverPlayer1":
						System.out.println("Player 1 does not have enough cards for WAR.");
						Version2 game2v3 = new Version2();
						game2v3.startGame(ply3, ply2);
						System.exit(0);
						break loop;
					case "GameOverPlayer2":
						System.out.println("Player 2 does not have enough cards for WAR.");
						Version2 game1v3 = new Version2();
						game1v3.startGame(ply1, ply3);
						System.exit(0);
						break loop;
					case "GameOverPlayer3":
						System.out.println("Player 3 does not have enough cards for WAR.");
						Version2 game1v2 = new Version2();
						game1v2.startGame(ply1, ply2);
						System.exit(0);
						break loop;
				}
				System.out.println("Player 1 has a score of " + ply1.points());
				System.out.println("Player 2 has a score of " + ply2.points());
				System.out.println("Player 3 has a score of " + ply3.points());
			}
			currRound = currRound + 1;
		}
		if(ply1.points() > ply2.points() && ply1.points() > ply3.points()) {
			System.out.println("Player 1 wins the game.");
			return;
		} else if (ply2.points() > ply1.points() && ply2.points() > ply3.points()){
			System.out.println("Player 2 wins the game.");
			return;
		} else if(ply3.points() > ply1.points() && ply3.points() > ply2.points()) {
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
}
