package technopolyCode;

public class Main{   

	// create the game 
    public static void main(String[] args){
	Technopoly technopolyGame = new Technopoly();
	
	technopolyGame.initialize();
	
	for (int j = 0; j < 100; j ++){
	    for (int i = 0; i < technopolyGame.getNumPlayers(); i ++){
	    	technopolyGame.turn(technopolyGame.players[i]);
	    }
	}
	
    }
}