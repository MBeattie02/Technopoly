package technopolyCode;



public class PayQuest extends OutputQuest {

	private String text;
    private int amount;

    public PayQuest(String text, int value){ 
	this.text = text;
	this.amount = value;
    }
    
    public void execute(Player p){
	p.addMoney(amount); // add or take players resources
    }
    public String printText(){
	return this.text;
    }
}
