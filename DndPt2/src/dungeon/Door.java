package dungeon;

import dnd.models.Exit;
import dnd.models.Trap;
import java.util.ArrayList;

public class Door {
    /**
     * instance variable.
     */
    private Exit exit;
    /**
     * instance variable.
     */
    private Trap trap;
    /**
     * instance variable.
     */
    private boolean open;
    /**
     * instance variable.
     */
    private boolean locked;
    /**
     * instance variable.
     */
    private boolean archway;
    /**
     * instance variable.
     */
    private boolean trapped;
    /**
     * instance variable.
     */
    private ArrayList<Space> space;

    /**
     * constructor for default door.
     */
    public Door() {
        this.archway = false;
        this.locked = false;
        this.trapped = false;
        this.open = false;
        this.trap = new Trap();
        this.exit = new Exit();
        this.space = new ArrayList<Space>();
    }

    /**
     * sets default settings for door.
     * @param  theExit door with exit
     */
    public Door(Exit theExit) {
        this.exit = theExit;
        this.archway = false;
        this.locked = false;
        this.trapped = false;
        this.open = false;
        this.space = new ArrayList<Space>();
    }

    /**
     * sets door to locked or unlocked.
     * @param flag true or false
     */
    public void setLocked(boolean flag) {
        this.locked = flag;
    }

    /**
     * sets a trap in the door.
     * @param flag       checks if flag is true or false
     * @param roll       roll for trap
     */
    public void setTrapped(boolean flag, int...roll) {
        this.trapped = flag;
        this.trap.chooseTrap(roll[0]);
    }

    /**
     * sets door to open.
     * @param flag shows if the door is open or not
     */
    public void setOpen(boolean flag) {
        //true == open
        this.open = flag;
    }

    /**
     * sets door to an archway.
     * @param flag shows if the door is an archway or not
     */
    public void setArchway(boolean flag) {
        //true == is archway
        this.archway = flag;
    }

    /**
     * checks if door is locked.
     * @return if door is locked
     */
    public boolean isLocked() {
        if (open) {
            locked = false;
            return locked;
        } else {
            return locked;
        }
    }
    /**
     * sees if door is trapped.
     * @return a trap
     */
    public boolean isTrapped() {
        if (archway) {
            trapped = false;
            return trapped;
        } else {
            return trapped;
        }
    }

    /**
     * sees if door is open.
     * @return if door is open
     */
    public boolean isOpen() {
        if (archway) {
            open = true;
            return open;
        } else {
            return open;
        }
    }

    /**
     * sees if door is an archway.
     * @return if door is an archway
     */
    public boolean isArchway() {
        if (open) {
            return archway;
        } else {
            archway = false;
            return archway;
        }
    }

    /**
     * gets the location of the exit.
     * @return location of exit
     */
    public String getExitLocation() {
        return exit.getLocation();
    }

    /**
     * gets the direction of the exit.
     * @return direction of exit
     */
    public String getExitDirection() {
        return exit.getDirection();
    }

    /**
     * gets description of trap.
     * @return a string stating what trap it is
     */
    public String getTrapDescription() {
        return trap.getDescription();
    }

    /**
     * gets all spaces connected to door.
     * @return all spaces connected by door
     */
    public ArrayList<Space> getSpaces() {
        return space;
    }

    /**
     * sets spaces which is connected to the door.
     * @param spaceOne chamber or passage
     * @param spaceTwo chamber or passage
     */
    public void setSpaces(Space spaceOne, Space spaceTwo) {
        spaceOne.setDoor(this);
        this.space.add(spaceOne);
        spaceTwo.setDoor(this);
        this.space.add(spaceTwo);
    }

    /**
     * gets description of the trap.
     * @return a string of what trap it is
     */
    public String getDescription() {
        return getTrapDescription();
    }
}
