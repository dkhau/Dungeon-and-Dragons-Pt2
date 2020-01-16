package dungeon;

public abstract class Space {

    /**
     * abstract variable for descrption of space.
     * @return string of space
     */
    public abstract  String getDescription();

    /**
     * abstract variable for set door in space.
     * @param theDoor door
     */
    public abstract void setDoor(Door theDoor);

}
