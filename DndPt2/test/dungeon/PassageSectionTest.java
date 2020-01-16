package dungeon;

import dnd.models.Exit;
import dnd.models.Monster;
import org.junit.Test;
import static org.junit.Assert.*;


public class PassageSectionTest {
    
/* set up similar to the sample in PassageTest.java */

    @Test
    public void getDoorTest1() {
   		System.out.println("getDoorTest1");

   		PassageSection ps = new PassageSection("This is a monster");
   		Door door;
   		boolean isDoor;
   		boolean result = false;

   		door = ps.getDoor();

   		if(door != null){
   			isDoor = true;
   		} else {
   			isDoor = false;
   		}

   		assertEquals(result,isDoor);
    }

	@Test
    public void getDoorTest2() {
   		System.out.println("getDoorTest2");

   		PassageSection ps = new PassageSection("This is a door");
   		Door door;
   		boolean isDoor;
   		boolean result = true;

   		door = ps.getDoor();

   		if(door != null){
   			isDoor = true;
   		} else {
   			isDoor = false;
   		}

   		assertEquals(isDoor,result);
    }

    @Test
    public void getMonsterTest1() {
    	System.out.println("getMonsterTest1");

    	boolean result = false;
    	boolean isMonster;
    	PassageSection ps = new PassageSection("This is a door");

    	if (ps.getMonster() == null) {
    		isMonster = false;
    	} else {
    		isMonster = true;
    	}

    	assertEquals(result,isMonster);

    }

    @Test
    public void getMonsterTest2() {
    	System.out.println("getMonsterTest2");

    	boolean result = true;
    	boolean isMonster;
    	PassageSection ps = new PassageSection("This is a monster");

    	if (ps.getMonster() == null) {
    		isMonster = false;
    	} else {
    		isMonster = true;
    	}

    	assertEquals(result,isMonster);
    }

    @Test
    public void getDescriptionTest() {
    	System.out.println("getDescriptionTest");

    	String passageDes = "passage ends in Door to a Chamber";
    	String expResult = "passage ends";

    	PassageSection ps = new PassageSection(passageDes);

    	assertTrue(ps.getDescription().contains(expResult));
    }
    
}
