import java.util.List;

public class Rabbit extends Animal {
    private static final int BREEDING_AGE = 3;

    public Rabbit(Grid grid, Cell cell) {
        super(grid, cell);
    }

    @Override
    public void act() {
        if (moved || cell == null) return;

        List<Cell> empty = grid.getEmptyAdjacentCells(cell);
        if (!empty.isEmpty()) {
            Cell newCell = empty.get(random.nextInt(empty.size()));
            moveTo(newCell);
        }

        incrementSurvival();
        moved = true;

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
        return new Rabbit(grid, newCell);
    }
}
