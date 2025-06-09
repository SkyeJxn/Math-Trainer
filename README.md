# Math Trainer

## Overview

**Math Trainer** is a simple game designed to help training mental arithmetic.
It generates random math tasks and checks the user input in real-time.

This project was developed as a university learning project to practice object-oriented design, Java syntax, code structuring and documentation.

## Features

- Random task generation (addition, subtraction, multiplication, division)
- Configurable number range
- Task statistics
- Optional **Lives** feature for attempt limiting
- Optional **Timer** feature to track task times

## Classes

The core classes are:

- Calculator for task generation
- GameController for game flow control
- Config for feature control

The full javadoc with all classes can be found [here](https://skyejxn.github.io/Math-Trainer/).

## Testing

Includes a basic test for the Calculator class to check the logic functions.
Tests are located in the 'code/test' folder.

Planning to add JUnit testing in the future.

## Configuration

Configuration is handled by the Config class. You can change:

- **Task number per round**
- **Number range of operands**
- **Lives system** (on/off)
- **Timer** (on/off)

Planning to add configuration prompts to the game loop.

## Compile & Run

The Project requires the Java Development Kit (JDK 17+)

To compile and run the game, use

```bash
javac code/*.java
java code.Main
```

## ToDo's

- [x] Add config option in game loop
- [x] Add user input validation
- [ ] Fix: Game loop continues after lives reach 0
- [ ] Add tests for all core classes
- [ ] Add round timer in addition to task timer
- [ ] Build standalone .jar release
- [ ] Add GUI version parallel to terminal version
