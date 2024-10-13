# Text-Based Adventure Game

## Table of Contents
- [Description](#description)
- [Features](#features)
- [Installation](#installation)
- [How to Play](#how-to-play)
- [Command Examples](#command-examples)
- [Project Structure](#project-structure)
- [Future Improvements](#future-improvements)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)
- [Contact](#contact)

## Description

This is a text-based adventure game implemented in Java. The game puts the player in the role of a thief attempting to steal an ancient pacifier from a mansion. Players must navigate through different rooms, interact with objects, and solve puzzles to complete their mission.

## Features

- Multiple interconnected locations (Front Door, Kitchen, Bedroom, Library, Lab)
- Interactive objects (laptop, cat, knife, globe, pacifier)
- Command-based gameplay (look, go, explore, use, take)
- Simple inventory system
- Puzzle elements (e.g., disarming the security system)

## Installation

1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Clone the repository:
   ```
   git clone https://github.com/yourusername/text-adventure-game.git
   ```
3. Navigate to the project directory:
   ```
   cd text-adventure-game
   ```
4. Compile the Java files:
   ```
   javac *.java
   ```

## How to Play

1. After compilation, run the `App` class to start the game:
   ```
   java App
   ```
2. Use text commands to interact with the game world. 
3. Type `?` at any time for a list of available commands.

## Command Examples

| Command | Description | Example |
|---------|-------------|---------|
| `look` | Examine your current surroundings | `look` |
| `go [location]` | Move to a different location | `go kitchen` |
| `use [item]` | Interact with an item | `use laptop` |
| `take [item]` | Add an item to your inventory | `take knife` |
| `explore` | Get a detailed description of the current location | `explore` |

## Project Structure

```
text-adventure-game/
├── src/
│   ├── App.java
│   ├── CommandSystem.java
│   ├── GameState.java
│   ├── Location.java
│   ├── Item.java
│   └── Entity.java
├── README.md
└── LICENSE
```

- `App.java`: Main driver class for the game
- `CommandSystem.java`: Handles command processing and execution
- `GameState.java`: Manages the overall state of the game
- `Location.java`: Represents individual locations in the game
- `Item.java`: Represents interactive items in the game
- `Entity.java`: Base class for game entities

## Future Improvements

- [ ] Add more complex puzzles and interactions
- [ ] Implement a scoring system
- [ ] Expand the game world with additional locations and items
- [ ] Add a graphical user interface
- [ ] Implement save/load game functionality

## Contributing

Contributions to improve the game are welcome. Please follow these steps:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is open source and available under the [MIT License](LICENSE).

## Acknowledgments

- Based on starter code developed by Prof. Dastyni Loksa
- Created as a final project for COSC 236

## Contact

For any questions or feedback, please [open an issue](https://github.com/yourusername/text-adventure-game/issues) on this GitHub repository.
