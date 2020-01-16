package dungeon;

import dnd.models.ChamberContents;
import dnd.models.ChamberShape;
import dnd.models.Monster;
import dnd.models.Treasure;
import dnd.models.Stairs;
import dnd.models.Trap;
import dnd.die.D20;
import java.util.ArrayList;
import dnd.die.Percentile;

public class Chamber extends Space {
    /**
     * instance variable for chamber contents.
     */
    private ChamberContents myContents;

    /**
     * instance variable for shape of chamber.
     */
    private ChamberShape mySize;

    /**
     * instance variable to store multiple doors.
     */
    private ArrayList<Door> door;

    /**
     * instance variable to store multiple monsters.
     */
    private ArrayList<Monster> monster;

    /**
     * instance variable to store multiple treasures.
     */
    private ArrayList<Treasure> treasure;

    /**
     * constructor for chamber with random contents and shape.
     */
    public Chamber() {
        this.myContents = new ChamberContents();
        this.mySize = ChamberShape.selectChamberShape(1);
        this.door = new ArrayList<Door>();
        this.monster = new ArrayList<Monster>();
        this.treasure = new ArrayList<Treasure>();
    }

    /**
     * constructor for chamber with specific shape and contents.
     * @param  theShape    shape of the chamber
     * @param  theContents contents in a chamber
     */
    public Chamber(ChamberShape theShape, ChamberContents theContents) {
        theShape = ChamberShape.selectChamberShape(1);
        this.myContents = theContents;
        this.mySize = theShape;
        this.door = new ArrayList<Door>();
        this.monster = new ArrayList<Monster>();
        this.treasure = new ArrayList<Treasure>();
    }

    /**
     * gets the total number of exits in chamber.
     * @return    number of exits
     */
    public int getNumOfExits() {
        return mySize.getNumExits();
    }

    /**
     * sets the number of exits.
     * @param exits number of exits
     */
    public void setNumOfExits(int exits) {
        this.mySize.setNumExits(exits);
    }

    /**
     * create doors corresponding to number of exits.
     * @param numExits number of exits
     */
    public void createDoors(int numExits) {
        int i = 0;
        for (i = 0; i < numExits; i++) {
            this.setDoor(new Door());
        }
    }

    /**
     * gets shape of chamber.
     * @return returns a string
     */
    public String getShape() {
        return mySize.getShape();
    }

    /**
     * sets the shape of the chamber.
     * @param theShape shape of the chamber
     */
    public void setShape(ChamberShape theShape) {
        this.mySize = theShape;
    }

    /**
     * gets all doors in chamber.
     * @return all the doors
     */
    public ArrayList<Door> getDoors() {
        return door;
    }

    /**
     * adds a monster in the chamber.
     * @param theMonster adds a specific monster in the chamber
     */
    public void addMonster(Monster theMonster) {
        this.monster.add(theMonster);

    }

    /**
     * gets all the monsters in the chamber.
     * @return all the monsters
     */
    public ArrayList<Monster> getMonsters() {
        return monster;
    }

    /**
     * adds treasure to the chamber.
     * @param theTreasure treasure in the chamber
     */
    public void addTreasure(Treasure theTreasure) {
        this.treasure.add(theTreasure);
    }

    /**
     * gets all the treasure in the chamber.
     * @return all the treasure on the chamber
     */
    public ArrayList<Treasure> getTreasureList() {
        return treasure;
    }

    /**
     * prints contents and shape of the chamber.
     * @return string with contents and shape
     */
    @Override
    public String getDescription() {
        String description = "";
        D20 die20 = new D20();
        Percentile die = new Percentile();
        int roll = die20.roll();
        int roll2 = die20.roll();
        int stairsRoll = die20.roll();
        int trapRoll = die20.roll();
        int treasureRoll = die.roll();
        int monsterRoll = die.roll();
        int i = 0;

        Treasure myTreasure = new Treasure();
        Monster myMonster = new Monster();
        Trap myTrap = new Trap();
        Stairs myStairs = new Stairs();

        myContents.chooseContents(roll);
        mySize = ChamberShape.selectChamberShape(roll2);

        description += "Shape: " + mySize.getDescription();
        description += "\nChamber Content: " + myContents.getDescription();

        if ((myContents.getDescription().contains("treasure") || myContents.getDescription().contains("Treasure"))
            && (myContents.getDescription().contains("monster") || myContents.getDescription().contains("Monster"))) {
            myTreasure.chooseTreasure(treasureRoll);
            myMonster.setType(monsterRoll);
            this.addTreasure(myTreasure);
            this.addMonster(myMonster);
            for (i = 0; i < this.getTreasureList().size(); i++) {
                description += "\nTreasure: " + myTreasure.getWholeDescription();
            }

            for (i = 0; i < this.getMonsters().size(); i++) {
                description += "\nMonster: " + myMonster.getDescription();
            }
        } else if (myContents.getDescription().contains("treasure") || myContents.getDescription().contains("Treasure")) {
            myTreasure.chooseTreasure(treasureRoll);
            this.addTreasure(myTreasure);
            for (i = 0; i < this.getTreasureList().size(); i++) {
                description += "\nTreasure: " + myTreasure.getWholeDescription();
            }
        } else if (myContents.getDescription().contains("monster") || myContents.getDescription().contains("Monster")) {
            this.addMonster(myMonster);
            myMonster.setType(monsterRoll);
            for (i = 0; i < this.getMonsters().size(); i++) {
                description += "\nMonster: " + myMonster.getDescription();
            }
        } else if (myContents.getDescription().contains("stairs") || myContents.getDescription().contains("Stairs")) {
            myStairs.setType(stairsRoll);
            description += "\nStairs: " + myStairs.getDescription();
        } else if (myContents.getDescription().contains("trap") || myContents.getDescription().contains("Trap")) {
            myTrap.chooseTrap(trapRoll);
            description += "\nTrap: " + myTrap.getDescription();
        }
        return description;
    }

    /**
     * sets a door in the chamber.
     * @param newDoor creates a door
     */
    @Override
    public void setDoor(Door newDoor) {
        this.door.add(newDoor);
    }

}
