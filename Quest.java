package technopolyCode;

import java.util.Random;

public class Quest implements Square {
	int id;//connects to player
	int PrevResources;//amount of resources the player owned last time it landed on a quest
	int tracker;//difference needed to complete quest
	boolean Qcomplete;
	public Quest() {// default constructor
		this.id=0;
		this.PrevResources=0;
		this.tracker=0;
		this.Qcomplete=false;
	}
	public Quest(int id) {//player constructor
		setID(id);
		this.PrevResources=0;
		this.tracker=0;
		this.Qcomplete=false;
	}
	Random rand=new Random();
	String[] quests= {"","gain 500 resourses","buy something in the shop","lose or spend 1000 resources","takeover any square"};
	//String[] quests= {"gain 500 resourses"};
	public void handlePlayer(Player p){
    
	if(p.getCquest()==0) //if the user doesn't have an active quest
	{
		System.out.println ("You got a quest");
		int quest=1+rand.nextInt(4);
		System.out.println("Your quest is to : "+ quests[quest]);
		p.setCquest(quest);//make quest active
		switch(quest) {
		case 1:
			setTracker(500);//set difference
			setPrevResources(p);//record players current resources
			setQcomplete(false);
		break;
		case 3:
			setTracker(-1000);
			setPrevResources(p);
			setQcomplete(false);
			break;
		}
	}
	else {//if user has an active quest
		check(p);//check if quest is complete
		System.out.println("QUEST: "+ quests[p.getCquest()]);
		if(getQcomplete(p)==false) {System.out.println("STATUS: INCOMPLETE");}
		else{
			System.out.println("STATUS: COMPLETE");
			System.out.println("REWARD: "+ 250*p.getCquest());
			p.addMoney(250*p.getCquest());//reward
			p.setCquest(0);//deactivate quest
			setTracker(0);//reset difference
		}
	}
	}
	public int getID() {
    	return this.id;
    }
    public void setID(int id) { 
    	this.id=id;
    }
    public int getPrevResources() {
    	return this.PrevResources;
    }
    public void setPrevResources(Player p) {
    	this.PrevResources=p.getMoney();
    }
    public int getTracker() {
    	return this.tracker;
    }
    public void setTracker(int goal) {
    	this.tracker=goal;
    }
    public boolean getQcomplete(Player p) {
    	return this.Qcomplete;
    }
    public void setQcomplete(boolean Qcomplete) {
    	this.Qcomplete=Qcomplete;
    }
    public void check(Player p) {
    	if(p.getMoney()>getPrevResources()+getTracker()&& getTracker()>0)
    	{
    		setQcomplete(true);	
    	}
	}
	
    public Player getOwner() {
	return null;
   }
}
    /*
    take over and shop
    quests.setQcomplete=true
    */