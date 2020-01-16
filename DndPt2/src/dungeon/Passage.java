package dungeon;

import dnd.models.Monster;
import java.util.ArrayList;
import java.util.HashMap;

public class Passage extends Space {
    /**
     * instance variable.
     */
    private ArrayList<PassageSection> thePassage;
    /**
     * instance variable.
     */
    private HashMap<Door, PassageSection> doorMap;
    /**
     * instance variable.
     */
    private ArrayList<Door> theDoor;

    /**
     * constructor.
    */
    public Passage() {
        this.thePassage = new ArrayList<PassageSection>();
        this.theDoor = new ArrayList<Door>();
        this.doorMap = new HashMap<Door, PassageSection>();
    }

    /**
     * gets all doors in passage.
     * @return doors
     */
    public ArrayList<Door> getDoors() {
        return theDoor;
    }

    /**
     * gets door at specific passage section.
     * @param  i passage section
     * @return   door
     */
    public Door getDoor(int i) {
        return thePassage.get(i).getDoor();
    }

    /**
     * adds monster to passage section.
     * @param theMonster monster
     * @param i          passage section
     */
    public void addMonster(Monster theMonster, int i) {
        this.thePassage.get(i).setMonster(theMonster);
    }

    /**
     * gets monster in passage section.
     * @param  i passage section
     * @return   monster
     */
    public Monster getMonster(int i) {
        return thePassage.get(i).getMonster();
    }

    /**
     * adds passage section.
     * @param toAdd passage
     */
    public void addPassageSection(PassageSection toAdd) {
        this.thePassage.add(toAdd);
    }

    /**
     * sets door in passage.
     * @param newDoor door
     */
    @Override
    public void setDoor(Door newDoor) {
        this.theDoor.add(newDoor);
    }

    /**
     * description of passage.
     * @return string of passage
     */
    @Override
    public String getDescription() {
        String inPassage = "";
        int i = 0;
        for (i = 0; i < thePassage.size(); i++) {
            inPassage += thePassage.get(i).getDescription();
        }
        return inPassage;
    }
}
