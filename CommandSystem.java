/*
CommandSystem.java
For use in the Final project for COSC 236.
Based on starter code first developed by Prof. Dastyni Loksa

This class is the primary logic class for the system. It defines what commands are valid, 
and what happens when those commands are executed.  
*/

import java.util.*;

public class CommandSystem {
    private GameState state;

    // ArrayList to store all of the verbs that the game knows about. (This is a
    // parallel array with the verbDescription arraylist)
    private List<String> verbs = new ArrayList<String>();

    // ArrayList of the descriptions for the verbs the game knows. (This is a
    // parallel array with the verbs arraylist)
    private List<String> verbDescription = new ArrayList<String>();

    // ArratList to store all of the nouns the game knows about.
    private List<String> nouns = new ArrayList<String>();

    /*
     * Constructor should defines all verbs that can be used in the commands and all
     * nouns the user can interact with.
     * 
     * Suggestion: These could all be loaded from a file.
     * 
     * Verb descriptions are stored in a parallel Arraylist with the Verbs and are
     * used when printing out the help menu (using the ? command).
     */
    public CommandSystem(GameState state) {
        this.state = state;
        // Assign verbs and descriptions here
        addVerb("?", "Show this help screen.");
        addVerb("look",
                "Use the look command by itself to look in your current area. \nYou can also look at a person or object by typing look and the name of what you want to look at.\nExample: 'look book'. ");
        addVerb("go", "Use the go command to move around the house. 'go bedroom'. ");
        addVerb("explore",
                "Use the explore command by itself to take a look around room. This shows you the all items you can interact with in the room. ");
        addVerb("use", "Use the 'use' command in front of a noun to utilize the object's function.\n ie. 'use book'.");
        addVerb("take", "use the 'take' command to add an object to your person.");
        addVerb("quit", "Quit the game."); // NOTE: In the starter code, this is handeled by the client code - not the
                                           // CommandSystem.
    }

    // When a command is only one Verb this method controls the result.
    public void executeVerb(String verb) {
        switch (verb) {
            case "look": // will show the description of the current room (stored in the state object)
                gameOutput("You look around.");
                gameOutput(state.currentLocation.description);
                break;
            case "go":// will change to next possible location from current locations
                System.out.println("You have have not entered a location to go");
                break;
            case "explore":
                gameOutput("You decide to explore- your curiosity is unrelenting");

            case "?":
                this.printHelp();
                break;
        }
    }

    // When a command is a Verb followed by a noun, this method controls the result.
    public void executeVerbNoun(String verb, String noun) {

        /**
         * Initilize the string that we will use as a response text.
         * This method allows us to create a single string and just print it at the end
         * of the method.
         * You can do it any way you wish.
         */
        String resultString = "";

        switch (verb) { // Deciddes what to do based on each verb
            case "l":
            case "look":
                resultString = lookAt(noun);
                break;
            case "go": // validate for location
                boolean validExit = state.currentLocation.hasExit(noun);
                if (validExit == true) {
                    state.currentLocation = state.currentLocation.changeLocation(noun);
                } else {
                    state.currentLocation.isLocation(noun);
                }

                // System.out.println(state.currentlocation.name);
                // state.changeLocation(state.currentLocation, noun);
            case "use":
                System.out.println("Use command used on " + noun);
                resultString = useObject(noun);

            case "take":
                System.out.println("You are trying to take " + noun);
                resultString = takeObject(noun);

        }
        gameOutput(resultString);

    }

    // When a command is a Verb followed by two nouns, this method controls the
    // result.
    public void executeVerbNounNoun(String string, String string2, String string3) {

    }

    // Method to take care of looking at a noun.
    public String lookAt(String noun) {
        // This will be what is returned by the method.
        String resultString = "";

        switch (noun) { // for the given verb, decide what to do based on what noun was entered
            case "laptop":
                // get the description from the item you are looking at.
                resultString += state.currentLocation.itemsHere[0].getDesc();
                // resultString += state.currentLocation.itemsHere[0].description;
                break;
            case "cat":
                // get the description from the item you are looking at.
                resultString += state.currentLocation.itemsHere[0].getDesc();
                // gameOutput(state.currentLocation.itemsHere[0].description);
                break;
            case "knife":
                // get the description from the item you are looking at.
                resultString += state.currentLocation.itemsHere[1].getDesc();
                // gameOutput(state.currentLocation.itemsHere[0].description);
                break;
            case "globe":
                // get the description from the item you are looking at.
                resultString += state.currentLocation.itemsHere[0].getDesc();
                // gameOutput(state.currentLocation.itemsHere[0].description);
                break;
            case "pacifier":
                // get the description from the item you are looking at.
                resultString += state.currentLocation.itemsHere[0].getDesc();
                // gameOutput(state.currentLocation.itemsHere[0].description);
                break;

            // You cound design a way to look at any item without having to specify how to
            // deal with each of them.
            // That way you can code special cases for some items, and others would just use
            // default behavior.
            // This is HIGHLY encouraged. (It will save time and headaches!)
            default:
                resultString = "Can't find that here";
        }
        return resultString;
    }

    public String useObject(String noun) {
        Scanner scan = new Scanner(System.in);
        String resultString = " ";
        boolean password = false;
        int answer = 0;

        switch (noun) {
            case "laptop":
                for (int i = 0; i < 3; i++) {
                    System.out.println(
                            "If seven cats kill seven rats in 7 minutes, how many would be needed to kill one hundred rats in 50 minutes?");
                    answer = scan.nextInt();
                    if (answer == 14) {
                        return resultString = "You have successfully disarmed the alarm system and can now enter the mansion and begin the heist.";
                        // break;
                    } else {
                        System.out.println("you have" + (2 - i) + "more tries");
                    }

                }
                // state.currentLocation = state.currentLocation.changeLocation("Ending");
                return resultString = "ENDING 1: You have failed to disarm the security system, and can already hear the sirens approaching. With no wear to run, you accept your fate at the dogpound";
            case "cat":
                return returnString = "You can't do that that's weird.";
                break;
            case "knife":
                for (int i = 0; i < state.currentlocation.itemsHere.length; i++) {
                    if (noun.equalsIgnoreCase(state.currentLocation.itemsHere[i])
                            && noun.equalsIgnoreCase(state.onPerson[i])) {

                    }

                }
            
            default:
            return returnString = "You cannot use this item yet";
            break;
        }

       

    }

    public String takeObject(String noun) {
        switch (noun) {

            case "laptop":
                return returnString = "The laptop is already in your backpack";
                break;

            case "cat":
                if (state.checkItemInLocation == true) {
                    return returnString = "You try to pick up the cat but it jumps on you and attacks you. Bad idea.";
                } else {
                    return returnString = "there is no cat in this location silly.";
                }
                break;

            case "knife":
                if (state.checkItemInLocation == true) {
                    addToPerson(noun);
                    return returnString = "You take the knife- it may come in handy later- this mansion is creepier than anticipated.";
                } else {
                    return returnString = "There is no knife to take in this location.";
                }
                break;
            case "globe":
                if (state.checkItemInLocation == true) {
                    return returnString = "The globe is not only bolted into the desk for some reason but it wouldn't fit on your person. Also why are you trying to take the globe?";
                } else {
                    return returnString = "There is no globe in this location.";
                }
                break;
            case "pacifier":
                if (state.checkItemInLocation == true) {
                    addToPerson(noun);
                    return returnString = "The Super Rare King Richard the ... has been added to your loot";
                } else {
                    return returnString = "Unfortunately the Super Rare King Richard pacifier is not in this location. It's said to be in the bedroom, though.";
                }
                break;
            default:
                return returnString = "You cannot use this object";

        }

    }

    /*****************************************************************
     * Helper methods to help system work.
     ******************************************************************/

    /*
     * Prints out the help menu. Goes through all verbs and verbDescriptions
     * printing a list of all commands the user can use.
     */
    public void printHelp() {
        int DISPLAY_WIDTH = GameState.DISPLAY_WIDTH;
        String s1 = "";
        while (s1.length() < DISPLAY_WIDTH)
            s1 += "-";

        String s2 = "";
        while (s2.length() < DISPLAY_WIDTH) {
            if (s2.length() == (DISPLAY_WIDTH / 2 - 10)) {
                s2 += " Commands ";
            } else {
                s2 += " ";
            }
        }

        System.out.println("\n\n" + s1 + "\n" + s2 + "\n" + s1 + "\n");
        for (String v : verbs) {
            // System.out.printp(v + " --> " + verbDescription.get(verbs.indexOf(v)));
            System.out.printf("%-8s  %s", v, formatMenuString(verbDescription.get(verbs.indexOf(v))));
        }
    }

    // Used to format the help menu
    public String formatMenuString(String longString) {
        String result = "";
        Scanner chop = new Scanner(longString);
        int charLength = 0;

        while (chop.hasNext()) {
            String next = chop.next();
            charLength += next.length();
            result += next + " ";
            if (charLength >= (GameState.DISPLAY_WIDTH - 30)) {
                result += "\n          ";
                charLength = 0;
            }
        }
        chop.close();
        return result + "\n\n";
    }

    /**
     * Default game output.
     * This is an alias for the other gameOutput method and defaults to
     * doing both the bracketing and the width formatting.
     **/
    public void gameOutput(String longstring) {
        gameOutput(longstring, true, true);
    }

    public void gameOutput(String longstring, boolean addBrackets, boolean formatWidth) {
        if (addBrackets) {
            longstring = addNounBrackets(longstring);
        }
        if (formatWidth) {
            longstring = formatWidth(longstring);
        }

        System.out.println(longstring);
    }

    // formats a string to DISPLAY_WIDTH character width.
    // Used when getting descriptions from items/locations and printing them to the
    // screen.
    // You can also add [nl] for a newline in a string in a description etc.
    public String formatWidth(String longString) {

        Scanner chop = new Scanner(longString);
        String result = "";
        int charLength = 0;
        boolean addSpace = true;

        while (chop.hasNext()) {

            // Get our next word in the string.
            String next = chop.next();

            // Add the legnth to our charLength.
            charLength += next.length() + 1;

            // Find and replace any special newline characters [nl] with \n.
            if (next.contains("[nl]")) {
                // Find the index after our [nl] characters.
                int secondHalf = next.indexOf("[nl]") + 4;

                // Set charLength to the number of characters after the [nl],
                // because that will be the beginnig of a new line.
                if (secondHalf < next.length()) {
                    charLength = secondHalf;
                } else {
                    charLength = 0;
                    addSpace = false; // Do not add space after if this ended with a newline character.
                }

                // Now actually replace the [nl] with the newline character
                next = next.replace("[nl]", "\n");

            }

            // Add the word to the result.
            result += next;

            // Only add a space if our special case did not happen.
            if (addSpace)
                result += " ";

            // Normally we add a space after a word, prepare for that.
            addSpace = true;

            if (charLength >= GameState.DISPLAY_WIDTH) {
                result += "\n";
                charLength = 0;
            }
        }
        chop.close();
        return result;
    }

    /**
     * Adds brackets around whole words that are included in the `nouns` list,
     * ignoring case, and also deals with any that have punctuation after them.
     *
     * @param longString the string to check for nouns
     * @return the modified string with brackets around the nouns
     */
    public String addNounBrackets(String longString) {
        String[] words = longString.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i].replaceAll("\\p{Punct}+$", "");
            String punct = words[i].substring(word.length());
            for (String noun : nouns) {
                if (word.equalsIgnoreCase(noun)) {
                    words[i] = "[" + word + "]" + punct;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    // Adds a noun to the noun list
    // lets the command system know this is something you an interact with.
    public void addNoun(String string) {
        if (!nouns.contains(string.toLowerCase()))
            nouns.add(string.toLowerCase());
    }

    // Adds a verb to the verb list and its description to the parallel description
    // list.
    // This method should be used to register new commands with the command system.
    public void addVerb(String verb, String description) {
        verbs.add(verb.toLowerCase());
        verbDescription.add(description.toLowerCase());
    }

    // Allows the client code to check to see if a verb is in the game.
    public boolean hasVerb(String string) {
        return verbs.contains(string);
    }

    // Allows the client code to check to see if a noun is in the game.
    public boolean hasNoun(String string) {
        return nouns.contains(string);
    }

}
