package technopolyCode;

public class WormVirus implements Square {

	 int defaultAmount = 200; //the most common charge
	    int amount;
	
	    
	    public WormVirus() {
	    	
	    }
	    
	    
	    public Player getOwner() {
			return null;
		   }

	    
	    
	    
	public void handlePlayer(Player p){
			
			System.out.println ("You landed on worm virus");
			System.out.println ("Cost calculated by taking 10 percent of your account, with a max fee of 200 Programming Hours.");
		    
		    
			amount = (int)(p.getMoney()*.1); //calculates 10 percent of players total worth

		if (amount > defaultAmount){//if this is more than 200 , just use the default
			amount = 200;
		}
		
		System.out.println ("You are charged "+amount+" Programming Hours.");
		p.takeMoney(amount);//return the value
		
		
	    }
	    
	
}
