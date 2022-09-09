package technopolyCode;




import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;




public class Technopoly {

	
	 public int numPlayers;
	 public int playerNum;
	 Scanner s = new Scanner (System.in);
	
	 Square[] board = new Square[20];
	 Dice dice = new Dice();
	 Quests mysterySpace = new Quests(true);
	 Player [] players ;
	 Quest[] quest=new Quest[4];
	
	 
	 
	 public Technopoly(){
			numPlayers = 0;
		    }
	 
	 void resetSpot(Player p){// when player reaches space 20 on board lap back around 
			if (p.getCurSqr() == 20){     
			    p.changeCurSqr(0);
			    
			   
			}
				
	 }
	 
	 
		
	 
			
	 public void turn(Player p){
		 
			if(isGameOver(p) == false) {
				
				// output players stats
				System.out.println ("\nPlayer " + p.getName() + ", you're up.");
				System.out.println("Your balance is: " + p.getMoney() + " Programming Hours");
				System.out.println("You are currently on board space " + p.getCurSqr());
				while (true){
				    
					
					if(p.app.isEmpty()) // if the player does not own any apps 
					{
						System.out.println (""
					    		+ "What would you like to do?" + "\n\n1. Roll" + '\n' + "\n\nSelection: ");
					    String answer;
					    answer = s.next();
					    
					    if (answer.equals("1") == true)
					    {
						
						    int a = dice.roll();
							
						
						    if (Player.upgraded == false) // player has not bought any upgrades at shop
						    {
						    	System.out.println ("Dice 1 = " + dice.getFirst() + " | " + "Dice 2 = " + dice.getSecond());
								System.out.println (" Move " + a + " Places ");
						    }
						    
						    else if (Player.upgraded == true && Player.upgraded2 == false && Player.upgraded3 == false)// player has bought one upgrade at shop
						    {
						    	System.out.println ("Dice 1 = " + dice.getFirst() + " | " + "Dice 2 = " + dice.getSecond()+ " | " + "Upgraded = " + dice.getExtra());
								System.out.println (" Move " + a + " Places ");
						    	
						    	
						    	
						    }
						    else if(Player.upgraded == true && Player.upgraded2 == true && Player.upgraded3 == false) {// player has bought upgrade 2 at shop
						    	System.out.println ("Dice 1 = " + dice.getFirst() + " | " + "Dice 2 = " + dice.getSecond()+ " | " + "Upgraded = " + dice.getExtra() + " | " + "Upgraded 2 = " + dice.getExtra2()); 
			    				System.out.println (" Move  " + a + " Places ");	
						    }
						    else if(Player.upgraded == true && Player.upgraded2 == true && Player.upgraded3 == true) {// player has bought upgrade 3 at shop
						    	System.out.println ("Dice 1 = " + dice.getFirst() + " | " + "Dice 2 = " + dice.getSecond()+ " | " + "Upgraded = " + dice.getExtra() + " | " + "Upgraded2 = " + dice.getExtra2() +  " | " + "Upgraded 3 = " + dice.getExtra3()); 
			    				System.out.println (" Move  " + a + " Places ");	
						    }
						    	
						   
							this.movePlayer(a, p);
							break;
					    }
					    
						else 
						{
							 System.out.println ("Please enter a valid choice");
							    	
					    }
						
						
					}
					
					else if(!p.app.isEmpty()) {// player owns apps 
						System.out.println (""
					    		+ "What would you like to do?" + "\n\n1. Roll" + '\n' + "2. Apps Built" + '\n' + "3. Upgrade App"  + "\n\nSelection: ");
					    String answer;
					    answer = s.next();
					    if (answer.equals("1") == true){
						
					    int a = dice.roll();
						
					    if (Player.upgraded == false) // player has not bought any upgrades at shop
					    {
					    	System.out.println ("Dice 1 = " + dice.getFirst() + " | " + "Dice 2 = " + dice.getSecond());
							System.out.println (" Move " + a + " Places ");
					    }
					    
					    else if (Player.upgraded == true && Player.upgraded2 == false && Player.upgraded3 == false)// player has bought one upgrade at shop
					    {
					    	System.out.println ("Dice 1 = " + dice.getFirst() + " | " + "Dice 2 = " + dice.getSecond()+ " | " + "Upgraded = " + dice.getExtra());
							System.out.println (" Move " + a + " Places ");
					    	
					    	
					    	
					    }
					    else if(Player.upgraded == true && Player.upgraded2 == true && Player.upgraded3 == false) {// player has bought upgrade 2 at shop
					    	System.out.println ("Dice 1 = " + dice.getFirst() + " | " + "Dice 2 = " + dice.getSecond()+ " | " + "Upgraded = " + dice.getExtra() + " | " + "Upgraded 2 = " + dice.getExtra2()); 
		    				System.out.println (" Move  " + a + " Places ");	
					    }
					    else if(Player.upgraded == true && Player.upgraded2 == true && Player.upgraded3 == true) {// player has bought upgrade 3 at shop
					    	System.out.println ("Dice 1 = " + dice.getFirst() + " | " + "Dice 2 = " + dice.getSecond()+ " | " + "Upgraded = " + dice.getExtra() + " | " + "Upgraded2 = " + dice.getExtra2() +  " | " + "Upgraded 3 = " + dice.getExtra3()); 
		    				System.out.println (" Move  " + a + " Places ");	
					    }
					    
						this.movePlayer(a, p);
						break;
					    }
					    else if (answer.equals("2") == true){
					    	if(p.app.isEmpty()) {
					            System.out.println("You have not built any apps .");
					    	
					        } else {
					        	System.out.println("The apps you have built are: ");
					        	p.returnAllApps();
					        }
					    }
					
		
					    else if (answer.equals("3") ==true){// allows users to select apps to upgrade
					    	if(p.app.isEmpty()) {
					            System.out.println("You have not built any apps to upgrade .");
					    	
					        } else {
					        	System.out.println("The apps you have built are: ");
					            p.returnAllApps();
							    while (true){
									    System.out.println ("\nPress A to exit, B to Upgrade App");
									    String Build = s.next();
				
				
									    if (Build.equalsIgnoreCase("A")== true){
										break;
									    }
									    else if (Build.equalsIgnoreCase("B") == true) {
										this.upgradeApp(p);
							    		}
							    		else {
							    			System.out.println ("Not a valid choice");
							    			break;
							    		}
							    }
					        }
					    }
					   
					    
					    else {
					    	System.out.println ("Please enter a valid choice");
					    	
					    
					    }
					}
				}
			}
	 }
					
					
					
					
					
				
	
	 // welcome screen for player to enter there name and number of players 
	 void initialize(){

		 	welcome();
		 	System.out.println("!Welcome to Technopoly!");
			System.out.println ("How many players will be playing, between 2-6: ");
			validate();			
			
			if (playerNum > 6)
				playerNum = 6;
			if (playerNum < 2)
				playerNum = 2;
		 

			
			// creates the board layout 
			board [0] = new Base(); 
			board [1] = new BoardSpace("Draw.io", 60, 2, 10,5);
			board [2] = new BoardSpace("Eclipse", 40, 3, 10,9);
			board [3] = new BoardSpace("Photoshop", 50, 4, 10,10);
			board [4] = new MysterySpace(mysterySpace);
			board [5] = new Virus();
			board [6] = new BoardSpace("Teams", 70, 7, 15,15);
			board [7] = new WormVirus();
			board [8] = new BoardSpace("Snapchat", 80, 9, 20,18);
			board [9] = new Quest();
			board [10] = new BoardSpace("Youtube", 100, 6, 15,16);
			board [11] = new BoardSpace("Maps", 70, 20, 10,25);
			board [12] = new Shop();
			board [13] = new MysterySpace(mysterySpace);
			board [14] = new BoardSpace("Twitter", 45, 6, 20,30);
			board [15] = new BoardSpace("Google", 65, 10, 10,25);
			board [16] = new BoardSpace("Visual Studio", 60, 2, 60,5);
			board [17] = new EurekaMoment();
			board [18] = new BoardSpace("Facebook", 60, 10, 70,15);
			board [19] = new BoardSpace("Apple", 90, 3, 100,9);
			
			numPlayers = playerNum; 
			 
			players = new Player[numPlayers];
			for (int i = 0; i < numPlayers; i ++){
			    System.out.println ("What is player " + (i + 1) + "'s name?");
			    String temp = s.next();
			    players[i] = new Player (temp,1500,i,this);
			    players[i].changeCurSqrWithNoCheck(0);
			    quest[i]=new Quest(i);
			    
			}

			gameMode();// allow user to select what game mode they want to play
			
			
		    }
	 

	 
	 public void validate() {
		 while (true) {
	         try {
	            
	            playerNum = s.nextInt();
	            if( playerNum >= 2 && playerNum <= 6){
	              break;
	            }
	            System.out.println("Out of range.");
	            System.out.println ("Please enter an integer between 2 & 6");
	            
	 
	         } catch (InputMismatchException e) {
	            System.out.println("You did not enter a Integer.");
	            System.out.println ("Please enter an integer between 2 & 6");
	            s.nextLine(); 
	         }
	      }
	 }

	 
	 public void gameMode() {
		 while (true){
				System.out.println ("What game mode would you like ?" + "\n\n1. Unlimited timer" + '\n' + "2. Short Timer (30 Seconds) " + '\n' + "3. Long Timer (60 seconds)");
			    String answer;
			    answer = s.next();
			    if (answer.equals("1") == true){
			    	
			    	 break;
			    }
			    else if (answer.equals("2") ==true){
			    	 new Reminder(30);
			    	 
			    	 break;
						}
					    
				else if (answer.equals("3") ==true){
					new Reminder(60);
					
					 break;
						}
				 else {
					 System.out.println ("Please enter a valid choice");
					 
				 }
			
			}
	 
	 }
	 
	 
	 
	 
	 
	 
	 public int getNumPlayers(){
			return numPlayers;
		    }
	 
	
	 void movePlayer(int num, Player p){        // player movement, only for dice rolls
			for (int i = 0; i < num; i ++){
			    
			    p.changeCurSqrWithNoCheck(p.getCurSqr() + 1);
			    
			    resetSpot(p);
			    
			}
			checkSquare(p.getCurSqr(), p);      // checks square once they land
			
		    }
	 
	 
	 void checkSquare(int squareNum, Player p){       // checks the square the player is on and runs the checkplayer
			board[squareNum].handlePlayer(p);
		    }
	 
	 
	 public Player getPlayer (int i){
		return players[i];
		}
	
	 
	 private void upgradeApp (Player p){
		 System.out.println ("What App to upgrade?");	
		 Scanner temp = new Scanner (System.in);
		 String App = temp.nextLine();
		 boolean spaceChecked = false;
		 
		for (int i = 0; i < p.numSpaces(); i ++){
			    if (p.app.get(i).getName().equalsIgnoreCase(App)){   // goes through every owned property to see if the names match
			    	spaceChecked = true;
				
			    if(p.app.get(i).upgraded == false) {
			    	if (p.getMoney() < p.app.get(i).getUpgradePrice()) {
			    		System.out.println("You do not have enough resources");
			    	}
			    	else {
			    		p.takeMoney(p.app.get(i).getUpgradePrice());
					    p.app.get(i).buyUpgrade(p);//buys the upgrade
					  
					    System.out.println ("You have upgraded an app on " + p.app.get(i).getName());
			    	}
			    	
			    }
		
			    else
			    	System.out.println ("This app is already upgraded.");
			    }
			}
				
				

			if (spaceChecked == false){  // if no property is found, it doesn't exist
				System.out.println ("This app does not exist.");
			}	
			
		}
			 


	
	 // count down timer for game 
	 public class Reminder {
		    Timer timer;

		    public Reminder(int seconds) {
		        timer = new Timer();
		        timer.schedule(new RemindTask(), seconds*1000);
			}

		    class RemindTask extends TimerTask {
		        public void run() {
		            System.out.println("Time's up!");
		            calcWinner();
		            timer.cancel(); //Terminate the timer thread
		           
		            
		        }
		    }
		
	 }
	 // end the game if a player becomes bankrupt 
	 public boolean isGameOver(Player p) {
		
	 	int bankruptCount = 0;
	 	
		
			if ( p.isBankrupt() == true) {
				bankruptCount++;
			
		}


		if ( bankruptCount >= (this.getNumPlayers()-1) ) {
			calcWinner();
			return true;
		}
		return false;
	
	}

	 
	 



	 // output the score board 
	 public void calcWinner() {
			
		 Arrays.sort(players);
		 	
			 System.out.println("LeaderBoard: \n " + Arrays.toString(players));
			 System.exit(1);
		 
		
		 }
	 
	 
	
	
	 
		
	
	 
	 // start up image
	 public void welcome() {
		 
		 System.out.println(                   
		         "     ```.``                                                        \n"
		         + "                                   `ydmd////++++/-`                                                 \n"
		         + "                                   /MMMs      .mMNms:`                                              \n"
		         + "                              ``   dMMN.     .dMMMMMMh:                                             \n"
		         + "                     `:/+ooso//os`:MMMs.``  `hMMMMMMN//+                                            \n"
		         + "                    /s:. /-:oy/-.-hyys++ooooyMMMMMMm--s.                                            \n"
		         + "                   oo  y/.:--ys`:mNm/...`` +hhmNMMN--y`                                             \n"
		         + "                  -s   h.-yhymNdmddysooooo+yyyyydmm+d.                                              \n"
		         + "               `/-y`  .-  `-+sds.`.-:/hNmsosssyysssdm:                                              \n"
		         + "              .o-y+`  .:::/.-s```    `. .s    `+o+y:`/h.           --                               \n"
		         + "              mNy.`/////    h`--      +`       .+-/N` oo        :oysyh                              \n"
		         + "             :MMMNds+:/o   :s  `o`              +o+yooy`  `-+o+o+++++h/                             \n"
		         + "             +yyMMMMMMMd ` s+-/.o:.:/`             :m//++ooysyNsoooosyhh/                           \n"
		         + "             +s-MMMMMMMN.syso:`  `  .s/.`.-`   ./+ydy++///hsodmm/oo+///od:                          \n"
		         + "             .m`dMMMMMMMm+s/-..-/+.  `-/+hs`  `+dhs+////////yohMmh++o+ody+o/`                       \n"
		         + "              so-NMMMMMMMMmmNmo+/-.//++o+-   /ssy+//////////+/hMMMmdNNNMMmo/y.                      \n"
		         + "              `y+:dMMMMMMMMMMMd+.`      `  .s++y//::.::////////smMMMMMMMMMMy:d.                     \n"
		         + "               `os:omMMMMMMMMMMMNsoss+sy/`-y-`m+//-``.`-///////s+dMMMMMMMMMM/so                     \n"
		         + "                 .oo/+ymNMMMMMMMd:mMhyd//:s` /m///- -- .////+o+d+yNy/hMMMMMMy/s                     \n"
		         + "                   `:+o+++osyhhhds:hh`:+oo`  /N//-`.:- .ssossooo/:-o+`oMMMMM/s/                     \n"
		         + "                       `-:////++h:hMMs   .:` `dy/:`....:os/::.      +o yMMNs/s                      \n"
		         + "                     `.:+ooo++++oooyhdy/-``/``.hh+////oso/oosm       m oMd/o/  -+:`                 \n"
		         + "                   -syo:.              `-////o/+mNdyss++ssoyy.`     :N/sMmo`.-sMMMNy`               \n"
		         + "                 :yo.                       ``  `:ssshhdhs+-/+.    +NMMMMhs/..oyhys: --             \n"
		         + "               `yo`                                    `:/oo:-` -omNmdyo:`          `mss+/.         \n"
		         + "      `+o:.    s:                              -           ``  `````                /MNds++s:       \n"
		         + "      -/sNNmhysy`                    ``        .o.                                  +NNMMMmo/o`     \n"
		         + "       .:/smMMMM:             `-///--///.       `os-                             `:o/.`.-/ohy/`     \n"
		         + "         .::+shN-          `-oo:.  ``  ./o+/:-....:yho-`                      .:+o:`        ``      \n"
		         + "           ``.:s .::-.   ./o/.            .-://:-`  -+yhho/-..``      ``.-:/oso:.                   \n"
		         + "                -mMMNms:::.                            .-+syhhhyyyyyyyssoo/-.`                      \n"
		         + "                 -odmo``                                     `...-...``                             \n"
		         + "                    `                                                                               \n"
		         + "                                                                                                    \n"
		         + "                                                                                                    \n");

                                                                
	 }
	 
	 
	  public Square returnSquare(int a){
			
			return board[a];
		    }
	 
	 }
	 
	

