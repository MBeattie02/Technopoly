package technopolyCode;

public class MysterySpace implements Square {
	  private Quests mysterySpace;

	    public MysterySpace (Quests d) {
		this.mysterySpace = d;//creates a deck 
	    }

	    public void handlePlayer (Player p) {
		System.out.println ("You landed on mysterySpace!  You draw:");
		System.out.println (mysterySpace.print());//prints the string
		mysterySpace.next(p); //draws a card

	    }
	    
	    public Player getOwner() {
		return null;//the square cannot be owned
	    }
}
