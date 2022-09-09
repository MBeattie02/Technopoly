package technopolyCode;


import java.util.Scanner;


public class BoardSpace extends Space{
    
    
	public int purchasePrice;
	private int defaultLand;
	private int currentLand;
	private int upgradePrice;
	private int landWithUpgrade;
    Scanner s = new Scanner (System.in);

    public BoardSpace (String z, int x, int b, int c,int q){   // the constructor
       
	purchasePrice = x;
	defaultLand = b;
	upgradePrice = c;
	landWithUpgrade = q;
	currentLand = defaultLand;
	name = z;
	upgraded = false;
	canBeOwned = true;
    }
    
    public void handlePlayer (Player p){
    	// allows player to build app
    	while (true){
    		if (this.owner == null){
    		    System.out.println ("Would you like to build an app on " + this.name +"?");
    		    System.out.println ("The cost is " + this.purchasePrice);
    		    System.out.println ("Y/N");
    		    String answer;
    		    answer = s.next();
    		    
    		    if (answer.equalsIgnoreCase("Y") == true){
    		    	if (p.getMoney() < this.purchasePrice)  {
   		    		System.out.println ("You do not have enough resources");
    		    		
    		    	}
    		    	
    		    	else {
    		    		p.takeMoney(this.purchasePrice);  
        				this.owner = p;
        				System.out.println ("You have built an app on " + this.name);
        				p.addApp(this);
        				break;
    		    	}
    		    }	
    		    		
    		    
    		    
    			else if (answer.equalsIgnoreCase("N") == true) {
    					System.out.println ("You have not buit an app " + this.name);
    					break;
    					
    				}
    				else {
    					System.out.println ("Please enter a valid input ");
    					
    				}
    		    }
    		    

	
    		 // Beginning of Hack and TechOver 
    		// Hack App
    		else if (this.owner.getName().equals(p.getName()) == false) {

    			//Menu option for selecting Hack or TechOver
    			System.out.println("You have landed on " + this.name + " it is owned by " + this.owner.getName());
    			System.out.println("1. Hack app(Random odds of taking over) \n2. TechOver (Pay fee to take over)");
    			String hackOrTechOver ;
    			hackOrTechOver = s.next();

    			// Hack Section
    			if(hackOrTechOver.equals("1")) {

    				System.out.println("Would you like to attempt to Hack " + this.name + "?");

    				int chance;
    				if (this.upgraded == true)
    					chance = 10;
    				else chance = 20;
    				System.out.println("Your chance of success is " + chance + "%");
    				System.out.println("Y/N");
    				String input;
    				input = s.next();

    				// User wants to Hack

    				if (input.equalsIgnoreCase("Y") == true) {


    					int min = 1;
    					int max = 10;
    					int maxB = 1;
    					int minB = 5;

    					if (this.upgraded = true) {
    						// Upgraded Hack Successful - Grants user the BoardSpace
    						int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
    						if (random_int == 5) {
    							this.owner.removeApp(this);
    							this.owner = p;
    							System.out.println("You have hacked the app on " + this.name);
    							System.out.println(random_int);
    							p.addApp(this);

    						} else {
    							//  Upgraded Hack Failed - User misses go and pays fee
    							System.out.println("You failed the hack skip this go because of the firewall");
    							System.out.println("You owe " + this.owner.getName() +" "+ this.currentLand+ " Programming Hours.");
    							int c = this.currentLand;
    							if (p.getMoney() < this.currentLand)
    								c = p.getMoney();
    							p.takeMoney(c);
    							this.owner.addMoney(c);
    							break;

    						}
    					} else {
    						// Beta App Hack successful
    						int random_int = (int) Math.floor(Math.random() * (maxB - minB + 1) + minB);
    						if (random_int == 5) {
    							this.owner.removeApp(this);
    							this.owner = p;
    							System.out.println("You have hacked the app on " + this.name);
    							System.out.println(random_int);
    							p.addApp(this);

    						} else {
    							// Beta App Hack Fail
    							System.out.println("You failed the hack skip this go because of the firewall");
    							int c = this.currentLand;
    							if (p.getMoney() < this.currentLand)
    								c = p.getMoney();
    							p.takeMoney(c);
    							this.owner.addMoney(c);

    						}

    					}
    					// Delcine Hack - Pay fee
    				} else if ((input.equalsIgnoreCase("N") == true)) {

    					System.out.println("You have not Hacked the app " + this.name);
    					System.out.println("You owe " + this.owner.getName() + " " + this.currentLand + " Programming Hours.");
    					int c = this.currentLand;
    					if (p.getMoney() < this.currentLand)
    						c = p.getMoney(); 
    					p.takeMoney(c);
    					this.owner.addMoney(c);
    				}
    			
    			
    		
    			
    }
    		
    		
    		
    		
	 	//Tech Over
	    	else if(hackOrTechOver.equals("2")){
			 System.out.println ("Would you like to take over the app " + this.name +"?");
			 System.out.println ("Take over will cost " + this.currentLand);
			 System.out.println ("Y/N");
			 String input;
			 input = s.next();
			    if (input.equalsIgnoreCase("Y") == true){
			    	this.owner.removeApp(this);
					p.takeMoney(this.currentLand);  
					this.owner = p;
					System.out.println ("You have taken over the app on " + this.name);
					p.addApp(this);
					break;
					
			    }
				else {
						System.out.println ("You have not taken over the app " + this.name);
						System.out.println ("You owe " + this.owner.getName() + " " + this.currentLand + " Programming Hours.");
						int c = this.currentLand;
						if (p.getMoney() < this.currentLand)
						    c = p.getMoney();
						p.takeMoney(c);
						this.owner.addMoney(c);
						break;
					}
			    }
	    		else {
	    		 System.out.println ("Please enter a valid choice");
	    		}
	    			
	    		
	    		}
	    }
	    		
    	
    }
    	
    	
    
    
   
    
    // get upgrade status
    public boolean getUpgrade() {
    	return this.upgraded;
    }
    
    public int getRandomFull(){
		int min = 1;
		int max = 10;
    	int ranNum = (int) Math.floor(Math.random() * (max - min + 1) + min);
    	return ranNum;
	}

	public int getRandomBeta(){
		int max = 1;
		int min = 5;
		int ranNum = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return ranNum;
	}
    
    
    // cost if landed on and upgraded
    public void setLandWithUpgrade(int c){
    	landWithUpgrade = c;
        }
    
    public int getLandWithUpgrade(){
    	return landWithUpgrade;
        }

    
    
    
    public int getCurrentRent(){     // returns the current cost to land on square of the square
    	return this.currentLand;
    }

    
    
    //price to upgrade app
    public int getUpgradePrice() 
    {
    	return this.upgradePrice;
    }
    
    
    
    // buy upgrade for app
    public void buyUpgrade(Player p){
    	
    	if (p.getMoney() >= this.upgradePrice){
    	    this.upgraded = true;
    	    if (upgraded == true)
    	    	currentLand = this.landWithUpgrade;
    	    

    	    p.takeMoney(this.upgradePrice);
    	}
       }
    
  
    
    
    
}