# Predator-Prey-Simulation-Java

A Java-based simulation modeling the interaction between predators (foxes) and prey (rabbits) in a 20×20 grid environment. This project was developed as part of the course **Τεχνικές Αντικειμενοστρεφούς Προγραμματισμού (ΠΛΥ212)** at the University of Ioannina.

## Overview

The simulation involves:
- A grid of 20×20 cells.
- Rabbits that move, reproduce every 3 steps, and avoid foxes.
- Foxes that hunt rabbits, reproduce every 8 steps, and die after 3 steps without eating.

Simulation proceeds in discrete time steps. At each step:
- **Foxes act first**, attempting to eat and reproduce.
- **Rabbits act second**, moving and reproducing.

## Class Structure

| Class | Description |
|-------|-------------|
| `Cell` | Represents a grid cell. Stores the resident animal and neighboring cells. |
| `Grid` | Contains a 20×20 matrix of `Cell`s and utility methods to populate and display the grid. |
| `Animal` | Abstract class for both foxes and rabbits. Tracks survival steps and handles movement and breeding. |
| `Rabbit` | Subclass of `Animal`. Handles rabbit-specific behavior and breeding every 3 steps. |
| `Fox` | Subclass of `Animal`. Hunts rabbits, reproduces every 8 steps, and dies from starvation after 3 turns without food. |
| `PopulationSimulator` | Runs the simulation. Tracks animals in `HashSet`s and manages time steps. |
| `Simulation` | Main class with `public static void main(String[] args)`. Starts the simulation. |

## Simulation Logic

- Only one animal per cell.
- Rabbits:
  - Move randomly to empty neighboring cells.
  - Reproduce every 3 steps if an empty neighboring cell exists.
- Foxes:
  - Preferentially move to adjacent cells with rabbits to eat them.
  - Reproduce every 8 steps if possible.
  - Die after 3 turns of starvation.

## How to Compile and Run

Make sure all `.java` files are in the same directory.

```bash
javac *.java
java Simulation

When prompted, enter the number of steps for the simulation (e.g., 1000).


