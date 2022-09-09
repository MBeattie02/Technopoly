package technopolyCode;

public class Virus implements Square {

	 int defaultAmount = 300; 
	   
	
	    
	    public Virus() {
	    	
	    }
	    
	    
	    public Player getOwner() {
			return null;
		   }

	    
	    
	    
	public void handlePlayer(Player p){
			
			System.out.println ("You landed on virus");
			
		
			System.out.println ("You are charged "+defaultAmount+" Programming Hours.");
			p.takeMoney(defaultAmount);//return the value
		
		
	    }
}
	    
	
