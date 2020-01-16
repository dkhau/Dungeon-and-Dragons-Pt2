package dungeon;

import dnd.models.Monster;

public class PassageSection {
    /**
     * instance variable.
     */
    private int length;
    /**
     * instance variable.
     */
    private String passageDescription;
    /**
     * instance variable.
     */
    private Door door;
    /**
     * instance variable.
     */
    private Monster monster;

    /**
     * constructor.
     */
    public PassageSection() {
        this.length = 10;
        this.door = new Door();
        this.monster = new Monster();
        this.passageDescription = "The passage is 10 ft long.";
    }

    /**
     * constructor.
     * @param  description description of passsage.
     */
    public PassageSection(String description) {
        this.passageDescription = description;
        this.door = new Door();
        this.monster = new Monster();
    }

    /**
     * gets door in passage section.
     * @return door
     */
    public Door getDoor() {
        if (passageDescription.contains("Door") || passageDescription.contains("door")) {
            return door;
        } else {
            return null;
        }
    }

    /**
     * gets monster in passage section.
     * @return monster
     */
    public Monster getMonster() {
        if (passageDescription.contains("monster") || passageDescription.contains("Monster")) {
            return monster;
        } else {
            return null;
        }
    }

    /**
     * sets monster in passage section.
     * @param theMonster monster
     */
    public void setMonster(Monster theMonster) {
        this.monster = theMonster;
    }

    /**
     * description of table 1.
     * @return string of table 1
     */
    public String getDescription() {
        return passageDescription;
    }

}
