package technopolyCode;

import java.util.Random;



public class Quests {
	
	private OutputQuest[] cards= new OutputQuest[6];// my card array
    private int index = 0;
    
    private int total;
    
    public Quests (boolean QuestDeck){
    	// range of outputs that can be displayed
	    this.cards[0]= new PayQuest("Bank error in your favor - collect 200 Programming Hours.", 200);
	    this.cards[1]= new PayQuest("Computer Crash - lose 50 Programming Hours", -50);
	    this.cards[2]= new PayQuest("Get help from expert - collect 200 Programming Hours", 350);
	    this.cards[3]= new PayQuest("Get upgraded computer - collect 200 Programming Hours", 150);
	    this.cards[4]= new PayQuest("Forgot to save - lose 200 Programming Hours", -100);
	    this.cards[5]= new PayQuest("Eclipse wont load - lose 200 Programming Hours", -70);
	   
	    this.total = 6;
	}
	
    
    
    public void shuffle () { //shuffle the deck
	Random randomGenerator = new Random();
	for (int i=0;i<900;i++){ 
	    int chosenCard = randomGenerator.nextInt(total);
	    int chosenCard2 = randomGenerator.nextInt(total);
	    OutputQuest temp = cards[chosenCard]; 
	    cards[chosenCard]= cards[chosenCard2]; 
	    cards[chosenCard2]=temp;
	}
    }
    
    public void next(Player p) { 
    OutputQuest temp = cards[index];
	cards[index].execute(p);
	index++; 
	if (index==total){ 
	    index=0;
	}
	
	
    }
    public String print (){ 
	return cards[index].printText();
    }

}
