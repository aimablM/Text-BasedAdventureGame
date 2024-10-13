import java.util.*;

public class Location {
    // State of the location object
    String name;
    String description;

    // The arrays could be ArrayLists for ease of use - look them up and learn how
    // you can use them.
    Item[] itemsHere = new Item[3]; // to hold all of the items in this location.
    Item[] itemsOnPerson = new Item[3]; // holds the items that the person decides to take with them
    Location[] exits = new Location[3]; // to hold all of the locations that you can get to from this location.
    String[] locations = { "Frontdoor", "Kitchen", "Bedroom", "Library", "Lab", "Ending" };

    public Location() {
    };

    public Item getItem(String objectName) {
        // Find the item in itemsHere and return it.
        return itemsHere[0]; // this is not correct.
    }

    public String getName() {
        return this.name;
    }

    public void addItem(Item objectName, int index) {
        itemsHere[index] = objectName;
    }

    public void removeItem(Item objectName, int index) {
        // onPerson[index] = objectName;
    }

    public void nextLocation(Location loc, int index) {
        exits[index] = loc;
    }

    public Boolean hasExit(String locName) {
        for (Location loc : exits) {
            if (loc != null && loc.getName().equalsIgnoreCase(locName)) {
                return true;
            }
        }
        return false;
    }

    public Location changeLocation(String nextLoc) {
        // if (hasExit(nextLoc) == true) {
        for (int i = 0; i < exits.length; i++) {
            if (exits[i] == null) {
                continue;
            }
            if (exits[i].name.equalsIgnoreCase(nextLoc)) {
                System.out.println("Location changed");
                return exits[i];
            }
        }
        // }
        return this;
    }

    public void isLocation(String loc) {
        for (int j = 0; j < 5; j++) {
            if (loc.equalsIgnoreCase(locations[j])) {
                System.out.println("This location is not accessible from your current location");
            }
            // else {
            // System.out.println("This is not a location!");
            // }
        }
    }

    public void addToPerson(Item objectName, int index) {
        onPerson[index] = objectName;
    }

    public boolean checkItemInLocation(String itemName) {
        for (Item nam : itemsHere) {
            if (nam != null && nam.getName().equalsIgnoreCase(item)) {
                return true;
            }
        }
        return false;
    }
    public boolean checkItemOnPerson(String itemName) {
        for (Item nam : itemsOnPerson) {
            if (nam != null && nam.getName().equalsIgnoreCase(item)) {
                return true;
            }
        }
        return false;
    }
}
