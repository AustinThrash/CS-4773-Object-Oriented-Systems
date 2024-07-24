package versions;

import java.util.ArrayList;
import java.util.List;

import cardManagement.Card;
import cardManagement.Player;

public class War {
	
	private static List<Card> cardsToWin = new ArrayList<Card>();
	
	public String beginWar2Players(Player ply1, Player ply2, int version){
		cardsToWin.clear();
		System.out.println("**WAR**");
		
		while(ply1.handSize() != 0 && ply2.handSize() != 0) {
			if(ply1.handSize() < 2) {
				return "GameOver1";
			}
			if(ply2.handSize() < 2) {
				return "GameOver2";
			}
			Card ply1Card, ply2Card, ply1Prize, ply2Prize;
			ply1Card = ply1.playFromHand();
			ply2Card = ply2.playFromHand();
			ply1Prize = ply1.playFromHand();
			ply2Prize = ply2.playFromHand();
			System.out.println("Player " + ply1.playerNum + " plays " + ply1Card.toString());
			System.out.println("Player " + ply2.playerNum + " plays " + ply2Card.toString());
			cardsToWin.add(ply2Prize);
			cardsToWin.add(ply1Prize);
			cardsToWin.add(ply2Card);
			cardsToWin.add(ply1Card);
			if(ply1Card.getValue() > ply2Card.getValue()) {
				if(version == 1) {
					ply1.addAllCardsToHand(cardsToWin);
				} else {
					ply1.addAllCardsToPoints(cardsToWin);
				}
				return "ply1win";
			} else if (ply1Card.getValue() < ply2Card.getValue()) {
				if(version == 1) {
					ply2.addAllCardsToHand(cardsToWin);
				} else {
					ply2.addAllCardsToPoints(cardsToWin);
				}
				return "ply2win";
			} else if (ply1Card.getValue() == ply2Card.getValue()) {
				//do nothing and repeat
			}
			
		}		
		return "GameOver";
	}
	public String beginWar3Players(Player ply1, Player ply2, Player ply3){
		cardsToWin.clear();
		System.out.println("**WAR**");
		String outcome;
		while(ply1.handSize() != 0 && ply2.handSize() != 0 && ply3.handSize() != 0) {
			if(ply1.handSize() < 2) {
				beginWar2Players(ply2, ply3, 2);
				return "GameOverPlayer1";
			}
			if(ply2.handSize() < 2) {
				beginWar2Players(ply1, ply3, 2);
				return "GameOverPlayer2";
			}
			if(ply3.handSize() < 2) {
				beginWar2Players(ply1, ply2, 2);
				return "GameOverPlayer3";
			}
			Card ply1Card, ply2Card, ply3Card, ply1Prize, ply2Prize, ply3Prize;
			ply1Card = ply1.playFromHand();
			ply2Card = ply2.playFromHand();
			ply3Card = ply3.playFromHand();
			ply1Prize = ply1.playFromHand();
			ply2Prize = ply2.playFromHand();
			ply3Prize = ply3.playFromHand();
			System.out.println("Player 1 plays " + ply1Card.toString());
			System.out.println("Player 2 plays " + ply2Card.toString());
			System.out.println("Player 3 plays " + ply3Card.toString());
			int player1Value = ply1Card.getValue();
			int player2Value = ply2Card.getValue();
			int player3Value = ply3Card.getValue();
			cardsToWin.add(ply2Prize);
			cardsToWin.add(ply1Prize);
			cardsToWin.add(ply3Prize);
			cardsToWin.add(ply3Card);
			cardsToWin.add(ply2Card);
			cardsToWin.add(ply1Card);
			if(player1Value > player2Value && player1Value > player3Value) {
				ply1.addAllCardsToPoints(cardsToWin);
				return "player1win";
			} else if (player2Value > player1Value && player2Value > player3Value) {
				ply2.addAllCardsToPoints(cardsToWin);
				return "player2win";
			} else if (player3Value > player1Value && player3Value > player2Value) {
				ply3.addAllCardsToPoints(cardsToWin);
				return "player3win";
			} else if (player1Value == player2Value && player1Value == player3Value) {
				//Do nothing if all three are equal
			} else if (player1Value == player2Value && player1Value > player3Value) {
				System.out.println("**WAR** - Player 1 vs Player 2");
				outcome = beginWar2Players(ply1, ply2, 2);
				if(outcome == "ply1win"){
					ply1.addAllCardsToPoints(cardsToWin);
					System.out.println("Player 1 wins the round");
				} else {
					ply2.addAllCardsToPoints(cardsToWin);
					System.out.println("Player 2 wins the round");
				}
				return "playerVSplayer";
			} else if (player1Value == player3Value && player1Value > player2Value) {
				System.out.println("**WAR** - Player 1 vs Player 3");
				outcome = beginWar2Players(ply1, ply3, 2);
				if(outcome == "ply1win"){
					ply1.addAllCardsToPoints(cardsToWin);
					System.out.println("Player 1 wins the round");
				} else {
					ply3.addAllCardsToPoints(cardsToWin);
					System.out.println("Player 3 wins the round");
				}
				return "playerVSplayer";
			} else if (player3Value == player2Value && player3Value > player1Value) {
				System.out.println("**WAR** - Player 3 vs Player 2");
				outcome = beginWar2Players(ply3, ply2, 2);
				if(outcome == "ply1win"){
					ply3.addAllCardsToPoints(cardsToWin);
					System.out.println("Player 3 wins the round");
				} else {
					ply2.addAllCardsToPoints(cardsToWin);
					System.out.println("Player 2 wins the round");
				}
				return "playerVSplayer";
			}
			
		}		
		return "GameOver";
	}
	
}
