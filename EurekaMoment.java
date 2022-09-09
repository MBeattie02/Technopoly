package technopolyCode;

public class EurekaMoment implements Square {
	
	
	  int amount = 300;
	public EurekaMoment(){
		
	}
	

	  public void handlePlayer(Player p){
			
		
		  
			System.out.println ("You landed on Eureka Moment");
			
			
			System.out.println ("You have received 300 Programming Hours.");
			p.addMoney(amount);//return the value
			
		    }
		    
		    public Player getOwner() {
			return null;
		   }
	}


