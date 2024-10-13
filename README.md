Text-Based Adventure Game
Description
This is a text-based adventure game implemented in Java. The game puts the player in the role of a thief trying to steal an ancient pacifier from a mansion. Players must navigate through different rooms, interact with objects, and solve puzzles to complete their mission.
Features

Multiple interconnected locations (Front Door, Kitchen, Bedroom, Library, Lab)
Interactive objects (laptop, cat, knife, globe, pacifier)
Command-based gameplay (look, go, explore, use, take)
Simple inventory system
Puzzle elements (e.g., disarming the security system)

How to Play

Clone the repository to your local machine.
Compile the Java files.
Run the App class to start the game.
Use text commands to interact with the game world. Type '?' for a list of available commands.

Command Examples

look: Examine your current surroundings
go [location]: Move to a different location (e.g., go kitchen)
use [item]: Interact with an item (e.g., use laptop)
take [item]: Add an item to your inventory (e.g., take knife)
explore: Get a detailed description of the current location

Project Structure

App.java: Main driver class for the game
CommandSystem.java: Handles command processing and execution
GameState.java: Manages the overall state of the game
Location.java: Represents individual locations in the game
Item.java: Represents interactive items in the game
Entity.java: Base class for game entities

Future Improvements

Add more complex puzzles and interactions
Implement a scoring system
Expand the game world with additional locations and items
Add a graphical user interface

Contributing
Contributions to improve the game are welcome. Please fork the repository and create a pull request with your changes.
License
This project is open source and available under the MIT License.
Acknowledgments

Based on starter code developed by Prof. Dastyni Loksa
Created as a final project for COSC 236

Contact
For any questions or feedback, please open an issue on this GitHub repository.
