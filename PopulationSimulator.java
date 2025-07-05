import java.util.ArrayList;
import java.util.List;

public class PopulationSimulator {
    private Grid grid;
    private List<Animal> animals;

    public PopulationSimulator(Grid grid) {
        this.grid = grid;
        this.animals = new ArrayList<>();
    }

    public void populate(int rabbits, int foxes) {
        int count = 0;
        while (count < rabbits) {
            int r = (int)(Math.random() * Grid.SIZE);
            int c = (int)(Math.random() * Grid.SIZE);
            Cell cell = grid.getCell(r, c);
            if (cell.isEmpty()) {
                animals.add(new Rabbit(grid, cell));
                count++;
            }
        }

        count = 0;
        while (count < foxes) {
            int r = (int)(Math.random() * Grid.SIZE);
            int c = (int)(Math.random() * Grid.SIZE);
            Cell cell = grid.getCell(r, c);
            if (cell.isEmpty()) {
                animals.add(new Fox(grid, cell));
                count++;
            }
        }
    }

    public void simulateStep() {
        for (Animal animal : animals) {
            animal.setMoved(false);
        }

        List<Animal> newAnimals = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            if (animal.getCell() != null) {
                animal.act();
                if (animal.getCell() != null && animal.hasMoved()) {
                    Cell cell = animal.getCell();
                    List<Cell> births = grid.getEmptyAdjacentCells(cell);
                    if (!births.isEmpty()) {
                        Cell birthCell = births.get(0); // Simplified birth logic
                        Animal offspring = animal.reproduce(birthCell);
                        if (offspring != null) newAnimals.add(offspring);
                    }
                }
            }
        }

        animals.addAll(newAnimals);
    }

    public void printStats() {
        int rabbits = 0, foxes = 0;
        for (Animal a : animals) {
            if (a.getCell() != null) {
                if (a instanceof Rabbit) rabbits++;
                else if (a instanceof Fox) foxes++;
            }
        }
        System.out.println(rabbits + " rabbits and " + foxes + " foxes");
    }
}
