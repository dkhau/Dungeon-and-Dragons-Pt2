package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
final class Levels {

    private Levels() {
    }

    /**
     * main method.
     * @param args takes in arguments
     */
    public static void main(String[] args) {

        int chamber = 0;
        int door = 0;
        int i = 0;
        int randChamber = 0;
        int totalNumDoors = 0;
        int randDoors = 0;
        int numPassages = 0;
        HashMap<Door, ArrayList<Chamber>> doorMap = new HashMap<Door, ArrayList<Chamber>>();
        ArrayList<Chamber> chamberList = new ArrayList<Chamber>();
        ArrayList<Chamber> connect = new ArrayList<Chamber>();
        ArrayList<Passage> passageList = new ArrayList<Passage>();

        Random randNum = new Random();

        Chamber c1 = new Chamber();
        Chamber c2 = new Chamber();
        Chamber c3 = new Chamber();
        Chamber c4 = new Chamber();
        Chamber c5 = new Chamber();

        chamberList.add(c1);
        chamberList.add(c2);
        chamberList.add(c3);
        chamberList.add(c4);
        chamberList.add(c5);

        //creates all the doors for each chamber
        for (i = 0; i < 5; i++) {
            chamberList.get(i).createDoors(chamberList.get(i).getNumOfExits());
            totalNumDoors += chamberList.get(i).getDoors().size();
        }

        //creates passages equal to number of doors
        for (i = 0; i < totalNumDoors; i++) {
            Passage passage  = new Passage();
            PassageSection ps1 = new PassageSection();
            PassageSection ps2 = new PassageSection();

            passage.addPassageSection(ps1);
            passage.addPassageSection(ps2);
            passageList.add(passage);
        }

        //loop through all chambers
        for (chamber = 0; chamber < chamberList.size(); chamber++) {

            System.out.println("\n=============== Chamber " + (chamber + 1) + " ===============");
            System.out.println(chamberList.get(chamber).getDescription());
            System.out.println("Number of doors: " + chamberList.get(chamber).getDoors().size() + "\n");

            //loops through doors in each chamber
            for (door = 0; door < chamberList.get(chamber).getDoors().size(); door++) {
                numPassages++;
                //picks a random chamber
                do {
                    randChamber = randNum.nextInt(5);
                } while (randChamber == chamber);

                //picks a random door in the random chamber
                randDoors = randNum.nextInt(chamberList.get(randChamber).getDoors().size());

                //mapping each door to a chamber
                connect.add(chamberList.get(chamber));
                connect.add(chamberList.get(randChamber));
                doorMap.put(chamberList.get(chamber).getDoors().get(door), connect);
                doorMap.put(chamberList.get(randChamber).getDoors().get(randDoors), connect);

                System.out.println("Chamber" + (chamber + 1) + " door " + (door + 1) + " connects to " + "Chamber" + (randChamber + 1) + " door " + (randDoors + 1));
                System.out.println("Passage" + numPassages + ": " + passageList.get(door).getDescription());
                connect.clear();
            }
        }
    }
}
