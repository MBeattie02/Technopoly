package technopolyCode;


import java.util.Scanner;

public class Shop implements Square 
{

    public void handlePlayer(Player p)
    {
    	
    	Scanner s = new Scanner (System.in);
	
	System.out.println ("You are at Shop");
	
	
	
	
	
	
	while (true){
	    System.out.println ("What would you like to do?" + "\n\n1. Buy upgrade to move extra spaces " + '\n' + "2. Dont want upgrade" + "\n\nSelection: ");
	    String answer;
	    answer = s.next();
	    if (answer.equals("1") == true){
	    	
	    	if(Player.upgraded == false) {//get upgrade 1
	    		while (true){
	    		System.out.println ("Are you sure you wish to buy another upgrade? It will cost " + Dice.getUpgradePrice() + " ? ");
	    		System.out.println ("Y/N" );
	    		String confirmation2;
	 		    confirmation2 = s.next();
	 		    
	 			if (confirmation2.equalsIgnoreCase("Y") == true)
		 			{
		 			buyUpgrade(p);
			    	System.out.println ("You have successfully bought upgrade 1");
			    	break;
		 				    		
		 			}
		 			else if (confirmation2.equalsIgnoreCase("N") == true)
		 			{
		 				System.out.println ("You have not bought upgrade 1");
		 				break;
		 				
		 			}
		 			else {
		 				System.out.println ("Please enter a valid choice");
		 				confirmation2 = s.next();
	 				
		 			}
	    		}
	    	}
	    		
	    		
	    		
	    	
	    	else if(Player.upgraded == true && Player.upgraded2 == false && Player.upgraded3 == false){//get upgrade 2
	    		while (true){
	    		System.out.println ("Are you sure you wish to buy another upgrade? It will cost " + Dice.getUpgradePrice2() + " ? ");
	    		System.out.println ("Y/N" );
	    		String confirmation2;
	 		    confirmation2 = s.next();
	 		    
	 			if (confirmation2.equalsIgnoreCase("Y") == true)
		 			{
		 			buyUpgrade2(p);
			    	System.out.println ("You have successfully bought upgrade 2");
			    	break;
		 				    		
		 			}
		 			else if (confirmation2.equalsIgnoreCase("N") == true)
		 			{
		 				System.out.println ("You have not bought upgrade 2");
		 				break;
		 			}
		 			else {
		 				System.out.println ("Please enter a valid choice");
		 				confirmation2 = s.next();
		 			}
	    		}
	    		
	    	}
	    	else if(Player.upgraded2 == true && Player.upgraded == true && Player.upgraded3 == false){//get upgrade 3
	    		while (true){
	    		System.out.println ("Are you sure you wish to buy another upgrade? It will cost " + Dice.getUpgradePrice3() + " ? ");
	    		System.out.println ("Y/N" );
	    		String confirmation2;
	 		    confirmation2 = s.next();
	 		    
	 			if (confirmation2.equalsIgnoreCase("Y") == true)
		 			{
		 			buyUpgrade3(p);
			    	System.out.println ("You have successfully bought upgrade 3");
			    	break;
		 				    		
		 			}
		 			else if (confirmation2.equalsIgnoreCase("N") == true)
		 			{
		 				System.out.println ("You have not bought upgrade 3");
		 				break;
		 			}
		 			else {
		 				System.out.println ("Please enter a valid choice");
		 				confirmation2 = s.next();
		 			}
	    		
	    		}
	    		
	    	}
	    		
	    	
	    	else {
	    		System.out.println ("You have reached the maximum number of upgrades");
	    		
	    	}
	    	
	    	
	    	
	    	break;
	    

	    }
	    else if (answer.equals("2") == true){
	    	System.out.println ("You did not buy any upgrades");
	    	break;
	    }
	    
	    else {
	    	System.out.println ("Please enter a valid choice");
	    	
	    }
	}
}
	
	
	
	
	
	

    
 public static void buyUpgrade(Player p)//upgrade 1
 {
    	
    	if (p.getMoney() >= Dice.getUpgradePrice())
    	{
    	    Player.upgraded = true;
    	    p.takeMoney(Dice.getUpgradePrice());
    	}
    		
    	else 
    	  {
    	    System.out.println ("Cant upgrade");
    	  }
    	    	
    	    

 }
 
 public static void buyUpgrade2(Player p)//upgrade 2
 {
    	
    	if (p.getMoney() >= Dice.getUpgradePrice2())
    	{
    	    Player.upgraded2 = true;
    	    p.takeMoney(Dice.getUpgradePrice2());
    	}
    		
    	  else 
    	  {
    	    System.out.println ("Cant upgrade");
    	  }
    	    	
    	    

 }
 
 public static void buyUpgrade3(Player p)//upgrade 3
 {
    	
    	if (p.getMoney() >= Dice.getUpgradePrice3())
    	{
    	    Player.upgraded3 = true;
    	    p.takeMoney(Dice.getUpgradePrice3());
    	}
    		
    	  else 
    	  {
    	    System.out.println ("Cant upgrade");
    	  }
    	    	
    	    

 }
 


	public Player getOwner() 
	{
		
	return null;
	
    }


}
