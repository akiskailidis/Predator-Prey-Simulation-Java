import java.util.List;

public class Fox extends Animal {
    private static final int BREEDING_AGE = 8;
    private static final int STARVATION_LIMIT = 3;
    private int stepsSinceLastMeal;

    public Fox(Grid grid, Cell cell) {
        super(grid, cell);
        this.stepsSinceLastMeal = 0;
    }

    @Override
    public void act() {
        if (moved || cell == null) return;

        List<Cell> rabbitsNearby = grid.getOccupiedAdjacentCells(cell, Rabbit.class);
        if (!rabbitsNearby.isEmpty()) {
            Cell preyCell = rabbitsNearby.get(random.nextInt(rabbitsNearby.size()));
            preyCell.getAnimal().cell = null; // Remove rabbit
            moveTo(preyCell);
            stepsSinceLastMeal = 0;
        } else {
            List<Cell> empty = grid.getEmptyAdjacentCells(cell);
            if (!empty.isEmpty()) {
                Cell newCell = empty.get(random.nextInt(empty.size()));
                moveTo(newCell);
            }
            stepsSinceLastMeal++;
        }

        incrementSurvival();
        moved = true;

        if (stepsSinceLastMeal >= STARVATION_LIMIT) {
            cell.setAnimal(null);
            cell = null;
            return;
        }

        if (stepsSurvived >= BREEDING_AGE) {
            List<Cell> birthPlaces = grid.getEmptyAdjacentCells(cell);
            if (!birthPlaces.isEmpty()) {
                Cell birthCell = birthPlaces.get(random.nextInt(birthPlaces.size()));
                reproduce(birthCell);
                stepsSurvived = 0;
            }
        }
    }

    @Override
    public Animal reproduce(Cell newCell) {
        return new Fox(grid, newCell);
    }
}
