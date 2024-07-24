package versions;

import java.util.ArrayList;
import java.util.List;

import cardManagement.Card;
import cardManagement.Deck;
import cardManagement.Player;

public class Driver {
	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}
	
	public static void main(String args[]) {
		int defaultrounds = 10;
		int defaultSeed = 10;
		int argsCount = args.length;
		Boolean errors = false;
		check: if(argsCount == 2) {
					if(args[0].equals("2")) {
						if(!isNumeric(args[1])) {
							errors = true;
							break check;
						}
						defaultSeed = Integer.parseInt(args[1]);
						
						Version2 game = new Version2();
						game.setSeed(defaultSeed);
						game.initializeGame();
					} else if (args[0].equals("3")) {
						if(!isNumeric(args[1])) {
							errors = true;
							break check;
						}
						defaultSeed = Integer.parseInt(args[1]);
						Version3 game = new Version3();
						game.setSeed(defaultSeed);
						game.initializeGame();
					}
				} else if(argsCount == 3) {
					if(args[0].equals("1")) {
						if(!isNumeric(args[1])) {
							errors = true;
							break check;
						}
						if(!isNumeric(args[2])) {
							errors = true;
							break check;
						}
						defaultSeed = Integer.parseInt(args[2]);
						defaultrounds = Integer.parseInt(args[1]);
						Version1 game = new Version1();
						game.setSeed(defaultSeed);
						game.setNumRounds(defaultrounds);
						game.initializeGame();
					}
				}
		if(errors) {
			System.err.println("ERROR Usage: [Game Version 1|2|3] [Version 1 Rounds] [Seed]");
			System.out.println("Using Default Values");
			
			
			Version1 game = new Version1();
			game.initializeGame();
		}
	}
	
}
