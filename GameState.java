/*
GameState.java
For use in the Final project for COSC 236.
Based on starter code first developed by Prof. Dastyni Loksa

This is the class to hold the state of the running game and allows easy
passing of important information to methods that require data from the
state of the game.

This starter code is designed for the verbs to be stored in the commandSystem.

*/

public class GameState {
    Location frontDoor;
    Location kitchen;
    Location bedroom;
    Location library;
    Location lab;
    Location currentLocation;
    Location end;
    
    Entity person;
    
    CommandSystem commandSystem;

    public static int DISPLAY_WIDTH = 100;

    /*
     * GameState Constructor
     * 
     * Ideally, your game will be fully loaded and ready to play once this
     * constructor has finished running.
     * 
     * How things have been done here are just a rudementry setup to link the other
     * classes and have the
     * bare bones example of the command system. This is not a great way to
     * initilize your project.
     * 
     * You should do better!
     */
    public GameState() {
        commandSystem = new CommandSystem(this);

        // Create first (starting) location
        // (and store it in currentLocation so I can always referece where the player is
        // easily)
        
        currentLocation = new Location();
        currentLocation= frontDoor;
        
        frontDoor = new Location();
        frontDoor.name = "Frontdoor";
        frontDoor.description = "You are at the front door of the mansion. In order to enter without setting off the security alarms, you'll need to disarm the security system with your laptop, which is in your backpack. After you get in (if you get in), the ancient pacifier is located in the bedroom.";
        commandSystem.addNoun("Frontdoor");
       
        
        currentLocation = frontDoor;
        
        kitchen = new Location();
        kitchen.name = "Kitchen";
        kitchen.description = "You have made your way to the kitchen. You can explore around and find things you find interesting and would like to take";
        commandSystem.addNoun("Kitchen");
        


        bedroom = new Location();
        bedroom.name = "Bedroom";
        bedroom.description= "You have entered the master bedroom, the location of the safe containing the ancient pacifier";
        commandSystem.addNoun("Bedroom");


        library = new Location();
        library.name = "Library";
        library.description= "You enter what appears to be a library (Rich people am I right). The cat jumps onto a desk in the center of the room next to a globe and meows crassly.";
        commandSystem.addNoun("Library");

        lab= new Location();
        lab.name= "lab";
        lab.description = "You enter to find what can only be described as abhorrent- bone chilling! ";
        lab.nextLocation(library, 0);
        commandSystem.addNoun("lab");
        
        end = new Location();
        end.name = "Ending";
        end.description = "Game Over";
        commandSystem.addNoun("End");
        
       //Creates person entity
        person = new Entity("Player", "This is the your player, you can use him to check inventory of what you have on you");
        commandSystem.addNoun("person");
    
        // Create a demo item.
        Item laptop = new Item();
        laptop.name= "laptop";
        laptop.description = "Your laptop contains the necessary security disarming software";
        commandSystem.addNoun(laptop.name);
        frontDoor.addItem(laptop,0);

        Item cat = new Item(); 
        cat.name = "cat";
        cat.description = "There is where a cat lives. This is a special cat.";
        kitchen.addItem(cat,0);
        commandSystem.addNoun(cat.name);

        Item knife = new Item();
        knife.name= "knife";
        knife.description = "There is a knife on the counter. Maybe could be useful later. Maybe not.";
        kitchen.addItem(knife, 1);
        commandSystem.addNoun(knife.name);
       
        Item globe = new Item();
        globe.name= "globe";
        globe.description = "There is a knife on the counter. Maybe could be useful later. Maybe not.";
        library.addItem(globe, 0);
        commandSystem.addNoun(globe.name);
        
        
        Item pacifier = new Item(); 
        pacifier.name = "pacifier";
        pacifier.description = "This the super rare pacifier one of a kind belonging to the baby King Charles from Ancient Macedonia";
        bedroom.addItem(pacifier,0);
        commandSystem.addNoun(pacifier.name);

        
        
        //Adds locations to their exits
        frontDoor.nextLocation(kitchen, 0);
        frontDoor.nextLocation(bedroom, 1);
        frontDoor.nextLocation(end, 2);
       
        kitchen.nextLocation(bedroom,0);
        kitchen.nextLocation(library, 1);
        kitchen.nextLocation(frontDoor, 2);
       
        bedroom.nextLocation(frontDoor,0);
        bedroom.nextLocation(kitchen, 1);
        
        library.nextLocation(kitchen, 0);
        library.nextLocation(lab,1);




        // Add item to list of nouns so our command system knows it exists.
        
        
        
        

        /*
         * Once the commandSystem knows about the item, we need to code what happens
         * with each of the commands that can happen with the item.
         * See CommandSystem line 96 for what happens if you currently "look mat"
         */
    }
}
