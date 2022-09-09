

package technopolyCode;

public class Dice {
    
    private int diceOne = 0;
    private int diceTwo = 0;
    private int upgrade1 = 0;
    private int upgrade2 = 0;
    private int upgrade3 = 0;
    private int total = 0;
    private boolean loaded;
    private static int upgradePrice = 20;
    private static int upgradePrice2 = 40;
    private static int upgradePrice3 = 80;
    
    public Dice(){
	
	loaded = false;
    }
    public Dice (boolean loaded){
	
	this.loaded = loaded;
    }
    
    
    
    
    
    public  int roll (){ //roll the dice
    	
    	if (Player.upgraded == false) //no upgrade
    	{
				diceOne = 0;
				diceTwo = 0;
				
				while (diceOne<1||diceOne>6)
				{
				    diceOne = (int)(Math.random()*10);
			    }
				
				if (loaded == false)
				{
				    
				    while (diceTwo<1||diceTwo>6)
				    {
				    	
					diceTwo = (int)(Math.random()*10);
					
				    }
				    
				    if (loaded == true)
					diceTwo = diceOne;
				    
				}
				
				total = diceOne + diceTwo;
				
			
				
		}
    	else if (Player.upgraded == true && Player.upgraded2 == false && Player.upgraded3 == false) {//upgrade 1
    		diceOne = 0;
			diceTwo = 0;
			upgrade1 = 1;
			
			while (diceOne<1||diceOne>6){
			    diceOne = (int)(Math.random()*10);
			    }
			
			if (loaded == false){
			    
			    while (diceTwo<1||diceTwo>6){
				diceTwo = (int)(Math.random()*10);
			    }
			    
			    if (loaded == true)
				diceTwo = diceOne;
			    
			}
			
			total = diceOne + diceTwo + upgrade1;
			
			
			
			
			
		}
    	
    	
    	
    	else if(Player.upgraded == true && Player.upgraded2 == true && Player.upgraded3 == false){//upgrade 2
		    			
		    		
		    		diceOne = 0;
					diceTwo = 0;
					upgrade1 = 1;
					upgrade2 = 2;
					
					while (diceOne<1||diceOne>6){
					    diceOne = (int)(Math.random()*10);
					    }
					
					if (loaded == false)
					{
					    
					    while (diceTwo<1||diceTwo>6)
					    {
					    	
					    	diceTwo = (int)(Math.random()*10);
					    }
					    
					    if (loaded == true)
						diceTwo = diceOne;
					    
					}
					
					total = diceOne + diceTwo + upgrade1 + upgrade2;
					
					
				}
    	
    	
    	else if(Player.upgraded2 == true && Player.upgraded == true && Player.upgraded3 == true)//upgrade 3
    		{
    		
    		
    		diceOne = 0;
			diceTwo = 0;
			upgrade1 = 1;
			upgrade2 = 2;
			upgrade3 = 3;
			
			while (diceOne<1||diceOne>6){
			    diceOne = (int)(Math.random()*10);
			    }
			
			if (loaded == false)
			{
			    
			    while (diceTwo<1||diceTwo>6)
			    {
			    	
			    	diceTwo = (int)(Math.random()*10);
			    }
			    
			    if (loaded == true)
				diceTwo = diceOne;
			    
			}
			
			total = diceOne + diceTwo + upgrade1 + upgrade2 + upgrade3;
			
		}
    	
    	
    	
    	return total;
    }
				
				
    public int getFirst() 
    {
        return diceOne;
    }

    public int getSecond() 
    {
        return diceTwo;
    }
    
    public int getExtra() 
    {
        return upgrade1;
    }
    
    public int getExtra2() 
    {
        return upgrade2;
    }
    
    public int getExtra3() 
    {
        return upgrade3;
    }
    
    
//    public boolean isDouble (){ // are the two dice last rolled doubles?
//    	
//    	if (diceOne==diceTwo)
//    	    return true;
//    	else 
//    	    return false;
//        }   
    
    public static int getUpgradePrice() 
    {
    	return upgradePrice;
    }
    
    public static int getUpgradePrice2() 
    {
    	return upgradePrice2;
    }
    
    public static int getUpgradePrice3() 
    {
    	return upgradePrice3;
    }
    
}



 
