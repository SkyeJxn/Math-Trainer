# Math Trainer

## Overview

The Project requires the Java Development Kit (JDK 17+)

**Math Trainer** is a simple game designed to help training mental arithmetic.
It generates random math tasks and checks the user input in real-time.

This project was developed as a university learning project to practice object-oriented design, Java syntax, code structuring and documentation.

## Features

- Random task generation (addition, subtraction, multiplication, division)
- Configurable number range
- Task statistics
- Optional **Lives** feature for attempt limiting
- Optional **Timer** feature to track task and round times

## Structure

The project is build in modules, which are the following:

- core: the core functionality of the game, all other modules depend on this one
- terminal: this is the implementation of the terminal UI
- websocket: this module is the implementation of a websocket backend

## Classes

The core classes are:

- Calculator for task generation
- GameController for game flow control
- Config for feature control

The full javadoc with all classes can be found here: [github pages](https://skyejxn.github.io/Math-Trainer/).

## Testing

Includes JUnit Testing Files for:

- Calculator class: checking arithmetic logic
- Lives class: checking live update logic
- Statistics class: checking statistic update logic

Tests are located in the 'src/test/java' folder.

## Configuration

Configuration is handled by the Config class. You can change:

- **Task number per round**
- **Number range of operands**
- **Lives system** (on/off)
- **Task Timer** (on/off)
- **Round Timer** (on/off)

Planning to add configuration prompts to the game loop.

## Commands

To compile and rebuild the game:

```bash
mvn clean compile
mvn clean package
```

To run the Terminal version:

```bash
java -jar release/Math-Trainer-Terminal-1.0.jar
```

To run the Websocket Backend:

```bash
java -jar release/Math-Trainer-Websocket-1.0.jar
```

If you are using VS Code, the needed Tasks are set up with the `tasks.json` file.

## ToDo's

- [x] Add config option in game loop
- [x] Add user input validation
- [x] Fix: Game loop continues after lives reach 0
- [x] Add tests for all core classes
- [x] Add round timer in addition to task timer
- [x] Convert to Maven Project
- [x] Build standalone .jar release
- [ ] Add Websocket backend
- [ ] Add GUI version
