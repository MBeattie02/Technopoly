package technopolyCode;


public class Space implements Square {
	

		   public Player owner;
		   public int defaultRent;
		   public int purchasePrice;
		   public String name;
		   public boolean canBeOwned;
		    public boolean upgraded;
		    
		    public void handlePlayer (Player p){

		    }


		    public void setOwner(Player p) {
			this.owner = p;//sets the owner of the app
		    }

		    public Player getOwner (){
			return this.owner;//returns the owner of the app
		    }

		    public boolean isOwned (){
			if (this.getOwner() != null)//if get Owner is not null
			    return true;//the app is owned
			else
			    return false;//else the app is unowned

			
		    }
		    
		   
		   
		    public String getName() {
			return this.name;
		    }

		    public int returnPurchasePrice(){
			return this.purchasePrice;
		    }

		    public void setPurchasePrice(int c){
			this.purchasePrice = c;
		    }

		    public void setDefaultRent(int c){
			this.defaultRent = c;
		    }

		    

}


