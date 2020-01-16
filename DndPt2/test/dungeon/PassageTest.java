package dungeon;

import dnd.models.Exit;
import dnd.models.Monster;
import dnd.models.Stairs;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;


public class PassageTest {
    //you don't have to use instance variables but it is easier
    // in many cases to have them and use them in each test
    private Passage testerOne;
    private Passage testerTwo;
    private PassageSection sectionOne;
    private PassageSection sectionTwo;

	@Before
	public void setup(){
    	testerOne = new Passage();
    	testerTwo = new Passage();
    	sectionOne = new PassageSection();
    	sectionTwo = new PassageSection();
	}

	@Test
	public void getDoorsTest() {
		System.out.println("getDoorsTest");

		Door door1 = new Door();
		Door door2 = new Door();

		ArrayList<Door> doorList = new ArrayList<Door>();

		testerOne.addPassageSection(sectionOne);
		testerOne.setDoor(door1);

		testerOne.addPassageSection(sectionTwo);
		testerOne.setDoor(door2);

		doorList = testerOne.getDoors();

		int expResult = 2;

		assertEquals(expResult, doorList.size());
	}

	@Test
	public void getDoorTest1() {
		System.out.println("getDoorTest1");
        
        Door expResult = null;
        Door doors;
        sectionOne = new PassageSection("Wandering Monster (passage continues straight for 10 ft)");
		Door door1 = new Door();
		Door door2 = new Door();

		testerOne.addPassageSection(sectionOne);
		testerOne.setDoor(door1);

		testerOne.addPassageSection(sectionTwo);
		testerOne.setDoor(door2);

		doors = testerOne.getDoor(1);
        
        assertEquals(expResult,doors);
	}

	@Test
	public void getDoorTest2() {
		System.out.println("getDoorTest2");
        
        Door expResult = null;
        Door doors;
        sectionOne = new PassageSection("");
        sectionTwo = new PassageSection("door");
		Door door1 = new Door();
		Door door2 = new Door();

		testerOne.addPassageSection(sectionOne);
		testerOne.setDoor(door1);

		testerOne.addPassageSection(sectionTwo);
		testerOne.setDoor(door2);

		doors = testerOne.getDoor(1);
		expResult = sectionTwo.getDoor();
        
        assertEquals(expResult,doors);
	}

	@Test
	public void monsterTest1() {
		System.out.println("monsterTest1");

		int location = 0;
		Monster monster = new Monster();
		Monster pMonster = new Monster();
		Monster expResult = new Monster();

		sectionOne = new PassageSection("monster");

		testerOne.addPassageSection(sectionOne);

		testerOne.addMonster(monster, location);

		pMonster = testerOne.getMonster(location);

		expResult = sectionOne.getMonster();

		assertEquals(expResult,pMonster);
	}

	@Test
	public void monsterTest2() {
		System.out.println("monsterTest2");

		int location = 0;
		Monster monster = new Monster();
		Monster pMonster = new Monster();
		Monster expResult = new Monster();

		sectionOne = new PassageSection("door");

		testerOne.addPassageSection(sectionOne);

		testerOne.addMonster(monster, location);

		pMonster = testerOne.getMonster(location);

		expResult = null;

		assertEquals(expResult,pMonster);
	}

	@Test
	public void addPassageSectionTest1() {
		System.out.println("addPassageSectionTest1");

		sectionOne = new PassageSection("hello");

		testerOne.addPassageSection(sectionOne);

		assertTrue(testerOne.getDescription().contains("hello"));
	}

	@Test
	public void addPassageSectionTest2() {
		System.out.println("addPassageSectionTest2");

		sectionOne = new PassageSection();
		sectionTwo = new PassageSection("this is a door");

		testerOne.addPassageSection(sectionOne);
		testerOne.addPassageSection(sectionTwo);

		assertTrue(testerOne.getDescription().contains(""));
		assertTrue(testerOne.getDescription().contains("door"));
	}

	@Test
	public void setDoorTest() {
		System.out.println("setDoorTest");

		int numDoors = 0;
		ArrayList <Door> door = new ArrayList<Door>();

		while(numDoors < 5) {
			testerOne.setDoor(new Door());
			numDoors++;
		}

		door = testerOne.getDoors();

		assertEquals(door.size(), numDoors);
	}

	@Test
	public void getDescriptionTest() {
		System.out.println("getDescriptionTest");

		String passage = "passageTest";
		sectionOne = new PassageSection("passageTest");
		testerOne.addPassageSection(sectionOne);

		assertTrue(testerOne.getDescription().contains(passage));
	}



}