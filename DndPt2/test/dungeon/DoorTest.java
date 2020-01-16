package dungeon;

import dnd.models.Trap;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import org.junit.Test;



public class DoorTest {
    
    @Test
    public void lockedTest1() {
    	System.out.println("lockedTest1");

    	Door door = new Door();

    	boolean expResult = false;
    	boolean locked = false;

    	door.setLocked(false);

    	locked = door.isLocked();

    	assertEquals(expResult,locked);
    }

    @Test
    public void lockedTest2() {
    	System.out.println("lockedTest2");

    	Door door = new Door();

    	boolean expResult = true;
    	boolean locked = false;

    	door.setLocked(true);

    	locked = door.isLocked();

    	assertEquals(expResult,locked);
    }

    @Test
    public void lockedTest3() {
    	System.out.println("lockedTest3");

    	boolean expResult = false;
    	boolean locked = true;
    	Door door = new Door();

    	door.setOpen(true);

    	locked = door.isLocked();

    	assertEquals(expResult,locked);
    }

    @Test
    public void openTest1() {
    	System.out.println("openTest1");

    	Door door = new Door();

    	boolean expResult = false;
    	boolean open = false;

    	door.setOpen(false);
    	open = door.isOpen();

    	assertEquals(expResult,open);
    }
    
    @Test
    public void openTest2() {
    	System.out.println("openTest2");

    	Door door = new Door();

    	boolean expResult = true;
    	boolean open = false;

    	door.setOpen(true);
    	open = door.isOpen();

    	assertEquals(expResult,open);
    }

    @Test
    public void openTest3() {
    	System.out.println("openTest3");

    	Door door = new Door();

    	boolean expResult = true;
    	boolean open = false;

    	door.setArchway(true);
    	open = door.isOpen();

    	assertEquals(expResult,open);
    }

    @Test
    public void archwayTest1() {
    	System.out.println("archwayTest1");

    	Door door = new Door();

    	boolean expResult = false;
    	boolean archway = false;

    	door.setArchway(false);
    	archway = door.isArchway();

    	assertEquals(expResult, archway);
    }

    @Test
    public void archwayTest2() {
    	System.out.println("archwayTest2");

    	Door door = new Door();

    	boolean expResult = true;
    	boolean archway = false;

    	door.setOpen(true);
    	door.setArchway(true);
    	archway = door.isArchway();

    	assertEquals(expResult, archway);
    }

    @Test
    public void archwayTest3() {
    	System.out.println("archwayTest3");

    	Door door = new Door();

    	boolean expResult = false;
    	boolean archway = true;

    	door.setOpen(false);
    	archway = door.isArchway();

    	assertEquals(expResult,archway);
    	
    }

    @Test
    public void trappedTest1() {
    	System.out.println("trappedTest1");

    	Door door = new Door();

    	boolean expResult = false;
    	int roll = 1;
    	boolean trapped = false;

    	door.setTrapped(false, roll);
    	trapped = door.isTrapped();

    	assertEquals(expResult,trapped);
    }

    @Test
    public void trappedTest2() {
    	System.out.println("trappedTest2");

    	Door door = new Door();

    	boolean expResult = true;
    	int roll = 1;
    	boolean trapped = false;

    	door.setArchway(false);
    	door.setTrapped(true, roll);
    	trapped = door.isTrapped();

    	assertEquals(expResult,trapped);
    }

    @Test
    public void spacesTest() {
    	System.out.println("spacesTest");

    	ArrayList<Space> numSpaces = new ArrayList<Space>();
    	Chamber c = new Chamber();
    	Chamber c2 = new Chamber();
    	int expResult = 2;

    	Door door = new Door();

    	door.setSpaces(c,c2);

    	numSpaces = door.getSpaces();

    	assertEquals(expResult, numSpaces.size());
    }
   	
   	@Test
   	public void getDescriptionTest() {
   		System.out.println("getDescriptionTest");

   		Door door = new Door();
   		Trap trap = new Trap();

   		trap.chooseTrap(8);

   		door.setArchway(false);
   		door.setTrapped(true,8);

   		assertTrue(door.getDescription().contains(trap.getDescription()));
   	}
    
/* set up similar to the sample in PassageTest.java */
    
}
