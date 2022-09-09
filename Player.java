package technopolyCode;

import java.util.ArrayList;




public class Player implements Comparable<Player> {

	private Technopoly game;
	String name;
	int cursqr;//contains the location of the player on the board
	int balance;
	int playerOrder;
	int Cquest;
	static boolean upgraded;
	static boolean upgraded2;
	static boolean upgraded3;
	private boolean bankrupt;
	ArrayList<BoardSpace> app = new ArrayList<BoardSpace>();
	//static boolean upgraded;
	
	public Player(String n, int b, int p, Technopoly tempMono)
	{
		this.game = tempMono;//
		this.name = n;//set the player name
		this.balance = b;//set the players money
		this.playerOrder = p;//give a number for player order
		this.bankrupt = false;
		this.Cquest=0;
		Player.upgraded = false;
		Player.upgraded2 = false;
		Player.upgraded3 = false;
	}

	public int getCquest() {
		 return this.Cquest;
	 }
	 public void setCquest(int quest) {
		 this.Cquest=quest;
	 }
	

	public int numSpaces() {
		return app.size();//return the count of apps
	    }
	
	
	
	public void addApp(BoardSpace b) {//adds a app
		app.add(b);//add a app to the players list of their apps
	    }
	
	public void removeApp(BoardSpace b) {//adds a app
		app.remove(b);//remove a app from the players list of their apps
	    }
	
	public int takeMoney(int amt) {
		int temp;
		
		if (this.balance > amt) {//if the player can afford to pay
		    this.balance = this.balance - amt;//take the amount of money from the player
		}
		
		if (this.balance < amt) {//if the player can't afford to pay
		    temp = this.balance;//store what money the player has
		    this.balance = 0;//set balance to 0
		    this.becameBankrupt();
		}
		
		return amt;//return the amount
		
	    }
	
	public void addMoney(int amt) {
		this.balance = this.balance + amt;//add the resources taken from whoever to the player	
	    }
	
	
	
	public static boolean isUpgraded() 
	{
		return upgraded;
	}
	
	public static boolean isUpgraded2() 
	{
		return upgraded2;
	}
	
	public static boolean isUpgraded3() 
	{
		return upgraded3;
	}


	public int getMoney() {
		return this.balance;//returns a players balance
	    }

	public Technopoly getGame() {
		return this.game;//get the game
		}

	 public String getName() {
		return this.name;//return the players name
		}

	 public int getPlayerOrder() {
			return this.playerOrder;//return the players play order
		    }
	 
	 public int getCurSqr() {
		return this.cursqr;//returns the current square of the player
	 }
		    
	public void changeCurSqrWithNoCheck(int p){//don't check the square after moving
		cursqr = p;//move the player
	}
		    
	 
	public void changeName(String s) {
		name = s;//change the players name
		}
	
	public boolean equals(Player p) {

		if (p.getPlayerOrder() == this.getPlayerOrder()) {//if the player has the same player order
		    return true;//its the same player
		}else {
		    return false;//its not the same player
		}
	    }
	
	 public void changeCurSqr(int p) {
			cursqr = p;//move the player
			game.checkSquare(p, this);//check the cursqr of the player
		    }
	
	 public void returnAllApps() {  // lists all the properties

			for (int i = 0;i < app.size();i++) {
			    System.out.println ("Name : " + app.get(i).getName()+"      "+ "Upgraded app? : " +app.get(i).getUpgrade() +"      "+ "Cost if landed on? : " + app.get(i).getCurrentRent()) ;//get the name of all the apps and display them
			}
	
	 }
	 public boolean isBankrupt() {
			return this.bankrupt;
		}
	 
	 private void becameBankrupt() {
			this.bankrupt = true;
		}

	 

	@Override
	public int compareTo(Player player) {
		// TODO Auto-generated method stub
		//return this.balance - player.balance;
		return player.balance - this.balance ;
	}
	 
	@Override
   public String toString()
   {
        return "Player Name:" + name + " || " + "player Balance " +  balance + "\n"   ;
    }

	 public boolean getUpgrade() 
	 {
			return upgraded;
	 }
	 
	 public boolean getUpgrade2() 
	 {
			return upgraded2;
	 }
	 
	 public boolean getUpgrade3() 
	 {
			return upgraded3;
	 }







	
	
}
