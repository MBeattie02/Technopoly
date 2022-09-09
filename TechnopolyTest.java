package technopolyCode;





import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import technopolyCode.BoardSpace;
import technopolyCode.Dice;
import technopolyCode.Player;
import technopolyCode.Technopoly;
import technopolyCode.Shop;
import technopolyCode.Space;
import technopolyCode.Virus;

public class TechnopolyTest
{

	private ArrayList<Player> players = new ArrayList<Player>();
	
	public void build()
	{
		players.clear();
		Technopoly technopolyGame = new Technopoly();
	}	
	
// test creation of board 
@Test
public void testBoardSetup(){
	Technopoly technopolyGame = new Technopoly();

}




//test building app
@Test
public void testBuildApp() 
{
	build();
	//Arrange
	Player p = new Player("Test",5000, 1, null);
	BoardSpace b = new BoardSpace("1", 10, 0, 0, 0);
	
	//Act
	p.addApp(b);
	
	//Assert
	assertTrue(!p.app.isEmpty());//app added to player app arraylist 
	
}


// test building app with not enough Resources


@Test
public void testBuildAppNoResources() 
{
	build();
	
	//Arrange
	Player p = new Player("Test",0, 1,null);
	BoardSpace b = new BoardSpace("1", 500, 0, 0, 0);
	
	//Act
	p.addApp(b);
	
	//Assert
	assertTrue(p.getMoney() < b.purchasePrice);
}





// test upgrading app
@Test 
public void testUpgradeApp()
{
	build();
	//Arrange
	Player p = new Player("Test",0, 0, null);
	BoardSpace b = new BoardSpace("1", 500, 0, 0, 0);
	
	//Act
	p.addApp(b);
	b.buyUpgrade(p);
	
	//Assert
	assertTrue(b.upgraded );//app set to upgraded 
}








// testing upgrade with not enough Resources 
@Test 
public void testUpgradedAppNoResources()
{
	build();
	//Arrange
	
	Player p = new Player("Test",0, 0, null);
	BoardSpace b = new BoardSpace("1", 500, 0, 50, 0);
	
	//Act
	b.buyUpgrade(p);
	
	//Assert
	assertTrue(b.upgraded == false );//upgraded false 
}


//test tech over

@Test 
public void testTechOver()
{
	build();
	
	//Arrange
	BoardSpace b = new BoardSpace("1", 500, 0, 0, 0);
	Player p = new Player("Test",0, 0, null);
	Player p2 = new Player("Test2",0, 0, null);

	//Act
	p.addApp(b);
	p.removeApp(b);
	p2.addApp(b);
	
	//Assert
	assertTrue(p.app.isEmpty());// app empty
	assertTrue(!p2.app.isEmpty());//app not empty 
}


// pay other player 
@Test 
public void testPayPlayer()
{
	build();
	//Arrange
	BoardSpace b = new BoardSpace("1", 500, 0, 0, 0);
	Player p = new Player("Test",50, 0, null);
	Player p2 = new Player("Test2",100, 0, null);

	//Act
	p.takeMoney(50);
	p2.addMoney(50);

	//Assert
	assertTrue(p2.getMoney() == 150);// check player balance 
}



//take player Resources 
@Test 
public void testTakePlayerResources()
{
	build();
	//Arrange
	BoardSpace b = new BoardSpace("1", 500, 0, 0, 0);
	Player p = new Player("Test",100, 0, null);
	
	//Act
	p.takeMoney(50);
	
	//Assert
	assertTrue(p.getMoney() == 50);// check player balance 
	
}



//Add player Resources 
@Test 
public void AddPlayerResources()
{
	build();
	
	//Arrange
	BoardSpace b = new BoardSpace("1", 500, 0, 0, 0);
	Player p = new Player("Test",50, 0, null);
	
	//Act
	p.addMoney(50);

	//Assert
	assertTrue(p.getMoney() == 100);// check player balance 
	
}

//Testing Dice

@Test
void testConstructorDice() 
{
    Dice actualDice = new Dice();
    assertEquals(0, actualDice.getExtra2());
    assertEquals(0, actualDice.getExtra3());
    assertEquals(0, actualDice.getExtra());
    assertEquals(0, actualDice.getFirst());
    assertEquals(0, actualDice.getSecond());
}


//test dice roll 
@Test
public void testPlayerRoll()
{		
	//Arrange
	Dice dice = new Dice();
	
	
	//Act
	int actual = dice.roll();
	
	//Assert	
	assertTrue(actual >=0 && actual <=18); //Maximum a player can roll is 18, not 6!
											//Max dice 1 = 6 Max dice 2 = 6 upgraded1 = 1 upgraded2 = 2 upgraded3 = 3
	
}




//test dice roll upgrade1
@Test
public void testPlayerRollUpgrade1()
{		
	//Arrange
	Dice dice = new Dice();
	
	Player.upgraded = true;
	Player.upgraded2 = false; 
	Player.upgraded3 = false;
	
	//Act
	int actual = dice.roll();
	
	//Assert	
	assertTrue(actual >=0 && actual <=18); //Maximum a player can roll is 18, not 6!
											//Max dice 1 = 6 Max dice 2 = 6 upgraded1 = 1 upgraded2 = 2 upgraded3 = 3
	
}

//test dice roll upgrade2
@Test
public void testPlayerRollUpgrade2()
{		
	//Arrange
	Dice dice = new Dice();
	
	Player.upgraded = true;
	Player.upgraded2 = true; 
	Player.upgraded3 = false;
	
	//Act
	int actual = dice.roll();
	
	//Assert	
	assertTrue(actual >=0 && actual <=18); //Maximum a player can roll is 18, not 6!
											//Max dice 1 = 6 Max dice 2 = 6 upgraded1 = 1 upgraded2 = 2 upgraded3 = 3
	
}


//test dice roll upgrade3
@Test
public void testPlayerRollUpgrade3()
{		
	//Arrange
	Dice dice = new Dice();
		
	Player.upgraded = true;
	Player.upgraded2 = true; 
	Player.upgraded3 = true;
	
	//Act
	int actual = dice.roll();
	
	//Assert	
	assertTrue(actual >=0 && actual <=18); //Maximum a player can roll is 18, not 6!
											//Max dice 1 = 6 Max dice 2 = 6 upgraded1 = 1 upgraded2 = 2 upgraded3 = 3
	
}

//Testing Shop
@Test
void testConstructor() 
{
    assertNull((new Shop()).getOwner());
}


//test buy shop upgrade
@Test
public void testBuyShopUpgrade()
{		
build();
	
	//Arrange
	BoardSpace b = new BoardSpace("1", 500, 0, 0, 0);
	Player p = new Player("Test",50, 0, null);
	
	//Act
	Shop.buyUpgrade(p);
	
	//Assert
	assertTrue(Player.upgraded );// check if player upgraded 
	

	
}

//test buy shop upgrade 2
@Test
public void testBuyShopUpgrade2()
{		
build();
	
	//Arrange
	BoardSpace b = new BoardSpace("1", 500, 0, 0, 0);
	Player p = new Player("Test",100, 0, null);
	
	//Act
	Shop.buyUpgrade2(p);
	
	//Assert
	assertTrue(Player.upgraded2 );// check if player upgraded to level 2

	
}


//test buy shop upgrade 3
@Test
public void testBuyShopUpgrade3()
{		
build();
	
	//Arrange
	BoardSpace b = new BoardSpace("1", 500, 0, 0, 0);
	Player p = new Player("Test",100, 0, null);
	
	//Act
	Shop.buyUpgrade3(p);
	
	//Assert
	assertTrue(Player.upgraded3 );// check if player upgraded to level 3

	
}


//test buy shop upgrade with not enough resources
@Test
public void testBuyShopUpgradeNoResources()
{		
build();
	
	//Arrange
	BoardSpace b = new BoardSpace("1", 500, 0, 0, 0);
	Player p = new Player("Test",1, 0, null);//player balance not greater than upgrade cost of 20
	
	//Act
	Shop.buyUpgrade(p);
	
	//Assert
	assertTrue(Player.upgraded == false);// player not upgraded 
	
}


// Testing Hack

@Test
public void TestHackRandomBeta()
{
    build();
    //Arrange
    BoardSpace b = new BoardSpace("1", 500, 0, 0, 0);

    //Act
    int actual = b.getRandomBeta();
    //Assert
    assertTrue(actual >= 1 || actual <=5);

}

// Testing random hack function

@Test
public void TestHackRandomFull()
{
    build();
    //Arrange
    BoardSpace b = new BoardSpace("1", 500, 0, 0, 0);

    //Act
    int actual = b.getRandomFull();
    //Assert
    assertTrue(actual >= 1 || actual <=10);

}


//Testing Eureka moment

@Test
void testConstructorEureka() 
{
    assertNull((new EurekaMoment()).getOwner());
}

@Test
void testHandlePlayerEureka() 
{
    EurekaMoment eurekaMoment = new EurekaMoment();
    Player player = new Player("Player", 1, 1, new Technopoly());
    eurekaMoment.handlePlayer(player);
    assertEquals(301, player.getMoney());
}

//Testing WORM virus

@Test
void testConstructorWORM() 
{
    assertNull((new WormVirus()).getOwner());
}
@Test
void testHandlePlayerWORM() 
{
    WormVirus wormVirus = new WormVirus();
    Player player = new Player("Player", 1, 1, new Technopoly());
    wormVirus.handlePlayer(player);
    assertEquals(1, player.getMoney());
    assertEquals(0, wormVirus.amount);
}

// Testing Virus

@Test
void testConstructorVirus() 
{
    assertNull((new Virus()).getOwner());
}
@Test
void testHandlePlayerVirus() 
{
    Virus virus = new Virus();
    Player player = new Player("Player", 1, 1, new Technopoly());
    virus.handlePlayer(player);
    assertTrue(player.isBankrupt());
    assertEquals(0, player.getMoney());
}

//Testing Base

@Test
void testConstructorBase() 
{
    assertNull((new Base()).getOwner());
}
@Test
void testHandlePlayerBase() 
{
    Base base = new Base();
    Player player = new Player("Player", 1, 1, new Technopoly());
    base.handlePlayer(player);
    assertEquals(0, player.getCquest());
    assertTrue(player.app.isEmpty());
    assertFalse(player.isBankrupt());
    assertEquals(1, player.getPlayerOrder());
    assertEquals("Player", player.getName());
    assertEquals(1, player.getMoney());
    assertEquals(0, player.getCurSqr());
    assertEquals(4, player.getGame().quest.length);
}

// Testing Quests
@Test
void testCheckQuests() 
{
    Quest quest = new Quest();
    Player player = new Player("Player", 1, 1, new Technopoly());
    quest.check(player);
    assertEquals(0, player.getCquest());
    assertTrue(player.app.isEmpty());
    assertFalse(player.isBankrupt());
    assertEquals(1, player.getPlayerOrder());
    assertEquals("Player", player.getName());
    assertEquals(1, player.getMoney());
    assertEquals(0, player.getCurSqr());
    assertEquals(4, player.getGame().quest.length);
    assertEquals(0, quest.getID());
    assertEquals(5, quest.quests.length);
    assertFalse(quest.Qcomplete);
    assertEquals(0, quest.getTracker());
    assertEquals(0, quest.getPrevResources());
}
@Test
void testConstructor_Quests() 
{
    Quest actualQuest = new Quest();
    actualQuest.setID(1);
    actualQuest.setQcomplete(true);
    actualQuest.setTracker(1);
    assertEquals(1, actualQuest.getID());
    assertNull(actualQuest.getOwner());
    assertEquals(0, actualQuest.getPrevResources());
    assertEquals(1, actualQuest.getTracker());
}
@Test
void testConstructor2_Quests() 
{
    Quest actualQuest = new Quest();
    assertEquals(0, actualQuest.getID());
    assertEquals(5, actualQuest.quests.length);
    assertFalse(actualQuest.Qcomplete);
    assertEquals(0, actualQuest.getTracker());
    assertEquals(0, actualQuest.getPrevResources());
}

@Test
void testConstructor3_Quests() 
{
    Quest actualQuest = new Quest(1);
    assertEquals(1, actualQuest.getID());
    assertEquals(5, actualQuest.quests.length);
    assertFalse(actualQuest.Qcomplete);
    assertEquals(0, actualQuest.getTracker());
    assertEquals(0, actualQuest.getPrevResources());
}
@Test
void testHandlePlayer_Quests() 
{
    Quest quest = new Quest();
    quest.setQcomplete(true);
    Player player = new Player("Player", 1, 1, new Technopoly());
    player.setCquest(1);
    quest.handlePlayer(player);
    assertEquals(0, player.getCquest());
    assertEquals(251, player.getMoney());
    assertEquals(0, quest.getTracker());
}

//Testing Board Space


@Test
void testConstructor_BoardSpace() 
{
    BoardSpace actualBoardSpace = new BoardSpace("Player", 2, 1, 1, 1);
    actualBoardSpace.setLandWithUpgrade(1);
    assertEquals(1, actualBoardSpace.getCurrentRent());
    assertEquals(1, actualBoardSpace.getLandWithUpgrade());
    assertFalse(actualBoardSpace.getUpgrade());
    assertEquals(1, actualBoardSpace.getUpgradePrice());
    assertEquals(10, actualBoardSpace.s.radix());
}
@Test
void testConstructor2_BoardSpace() 
{
    BoardSpace actualBoardSpace = new BoardSpace("Player", 2, 1, 1, 1);
    assertEquals(1, actualBoardSpace.getCurrentRent());
    assertEquals(2, actualBoardSpace.purchasePrice);
    assertEquals(1, actualBoardSpace.getLandWithUpgrade());
    assertEquals(1, actualBoardSpace.getUpgradePrice());
    assertTrue(actualBoardSpace.canBeOwned);
    assertFalse(actualBoardSpace.getUpgrade());
    assertEquals("Player", actualBoardSpace.getName());
}

//Testing Mystery Space

@Test
void testConstructorMystery() 
{
    assertNull((new MysterySpace(new Quests(true))).getOwner());
}
@Test
void testHandlePlayerMystery() 
{
    MysterySpace mysterySpace = new MysterySpace(new Quests(true));
    Player player = new Player("Player", 1, 1, new Technopoly());
    mysterySpace.handlePlayer(player);
    assertEquals(201, player.getMoney());
}

@Test
void testNext() 
{
    Quests quests = new Quests(true);
    Player player = new Player("Player", 1, 1, new Technopoly());
    quests.next(player);
    assertEquals(201, player.getMoney());
}
@Test
void testPrint() 
{
    assertEquals("Bank error in your favor - collect 200 Programming Hours.", (new Quests(true)).print());
}

@Test
void testExecute() 
{
    PayQuest payQuest = new PayQuest("Text", 42);
    Player player = new Player("Player", 1, 1, new Technopoly());
    payQuest.execute(player);
    assertEquals(43, player.getMoney());
}
@Test
void testPrintText() 
{
    assertEquals("Text", (new PayQuest("Text", 42)).printText());
}

//Testing Player

@Test
void testNumSpaces() 
{
    assertEquals(0, (new Player("Player", 1, 1, new Technopoly())).numSpaces());
}
@Test
void testRemoveApp() 
{
    Player player = new Player("Player", 1, 1, new Technopoly());
    player.removeApp(new BoardSpace("Player", 2, 1, 1, 1));
    assertTrue(player.app.isEmpty());
}
@Test
void testReturnAllApps() 
{
    Player player = new Player("Player", 1, 1, new Technopoly());
    player.returnAllApps();
    assertEquals(0, player.getCquest());
    assertTrue(player.app.isEmpty());
    assertFalse(player.isBankrupt());
    assertEquals(1, player.getPlayerOrder());
    assertEquals("Player", player.getName());
    assertEquals(1, player.getMoney());
    assertEquals(0, player.getCurSqr());
    assertEquals(4, player.getGame().quest.length);
}


@Test
void testTakeMoney() 
{
    assertEquals(1, (new Player("Player", 1, 1, new Technopoly())).takeMoney(1));
}

// Testing Technopoly Class

@Test
void testReturnSquareTechnopoly() 
{
    assertNull((new Technopoly()).returnSquare(1));
}
@Test
void testResetSpot() 
{
    Technopoly technopoly = new Technopoly();
    Player player = new Player("Player", 1, 1, new Technopoly());
    technopoly.resetSpot(player);
    assertEquals(0, player.getCquest());
    assertTrue(player.app.isEmpty());
    assertFalse(player.isBankrupt());
    assertEquals(1, player.getPlayerOrder());
    assertEquals("Player", player.getName());
    assertEquals(1, player.getMoney());
    assertEquals(0, player.getCurSqr());
    assertEquals(4, player.getGame().quest.length);
    assertEquals(0, technopoly.getNumPlayers());
    assertEquals(4, technopoly.quest.length);
    assertEquals(20, technopoly.board.length);
    assertEquals(0, technopoly.playerNum);
}

@Test
void testConstructorTechnopoly() 
{
    Technopoly actualTechnopoly = new Technopoly();
    assertEquals(0, actualTechnopoly.getNumPlayers());
    Dice dice = actualTechnopoly.dice;
    assertEquals(0, dice.getSecond());
    assertEquals(0, dice.getFirst());
    assertEquals(0, dice.getExtra3());
    assertEquals(0, dice.getExtra2());
    assertEquals(0, dice.getExtra());
    assertEquals(10, actualTechnopoly.s.radix());
}

//Testing Space Class

@Test
void testReturnPurchasePrice() 
{
    assertEquals(0, (new Space()).returnPurchasePrice());
}


}

