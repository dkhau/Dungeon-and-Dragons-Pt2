package dungeon;

import dnd.models.ChamberContents;
import dnd.models.ChamberShape;
import dnd.models.DnDElement;
import dnd.models.Monster;
import dnd.models.Stairs;
import dnd.models.Trap;
import dnd.models.Treasure;
import dnd.die.Percentile;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChamberTest {
    ChamberShape theShape;
    ChamberContents theContents;
    Monster myMonster;
    Treasure myTreasure;

    @Before
    public void setup() {
    	theShape = ChamberShape.selectChamberShape(1);
    	theShape.setNumExits();
    	theContents = new ChamberContents();
    	myMonster = new Monster();
    }

    @Test
    public void exitsTest() {
    	System.out.println("exitsTest");
    	Chamber c = new Chamber();
    	int expResult = 0;
    	int cExits = 0;
    	int num = 5;

    	theShape.setNumExits(num);
    	expResult = theShape.getNumExits();

    	c.setNumOfExits(num);
    	cExits = c.getNumOfExits();

    	assertEquals(expResult,cExits);
    }

    @Test
    public void createDoorsTest() {
    	System.out.println("createDoorsTest");

    	int expResult = 7;
    	int numDoors = 0;

    	ArrayList<Door> door = new ArrayList<Door>();

    	Chamber c = new Chamber();
    	c.createDoors(expResult);
    	door = c.getDoors();
    	numDoors = door.size();
    	assertEquals(expResult, numDoors);
    }

    @Test
    public void shapeTest() {
    	System.out.println("shapeTest");
    	Chamber c = new Chamber();

    	theShape = ChamberShape.selectChamberShape(1);

    	c.setShape(theShape);

    	assertTrue(theShape.getDescription().contains(c.getShape()));
    }

    @Test
    public void addMonsterTest() {
    	System.out.println("addMonsterTest");
    	int monsterCount = 0;
    	Chamber c = new Chamber();
    	ArrayList<Monster> monsterList = new ArrayList<Monster>();

    	while(monsterCount < 5) {
    		c.addMonster(new Monster());
    		monsterCount++;
    	}

    	monsterList = c.getMonsters();

    	assertEquals(monsterCount,monsterList.size());
    }

    @Test
    public void addTreasureTest() {
    	System.out.println("addTreasureTest");
    	int treasureCount = 0;
        int randomTreasure = 0;
    	Chamber c = new Chamber();
    	ArrayList<Treasure> treasureList = new ArrayList<Treasure>();
        Treasure treasure = new Treasure();
        Percentile die100 = new Percentile();

    	while(treasureCount < 5) {
            randomTreasure = die100.roll();
            treasure.chooseTreasure(randomTreasure);
    		c.addTreasure(new Treasure());
    		treasureCount++;
    	}

    	treasureList = c.getTreasureList();

    	assertEquals(treasureCount,treasureList.size());

    }

    @Test
    public void getDescriptionTest() {
    	System.out.println("getDescriptionTest");
    	String content = theContents.getDescription();
    	Chamber c = new Chamber(theShape,theContents);

    	assertTrue(c.getDescription().contains(content));

    }

    @Test
    public void setDoorTest() {
    	System.out.println("setDoorTest");
    	int numDoors = 0;
    	Chamber c = new Chamber();

    	ArrayList<Door> doors = new ArrayList<Door>();

    	while(numDoors < 5) {
    		c.setDoor(new Door());
    		numDoors++;
    	}

    	doors = c.getDoors();

    	assertEquals(numDoors, doors.size());

    }


    /* set up similar to the sample in PassageTest.java */
    
}