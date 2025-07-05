import java.util.List;
import java.util.Random;

public abstract class Animal {
    protected Cell cell;
    protected Grid grid;
    protected int stepsSurvived;
    protected boolean moved;

    protected static final Random random = new Random();

    public Animal(Grid grid, Cell cell) {
        this.grid = grid;
        this.cell = cell;
        this.stepsSurvived = 0;
        this.moved = false;
        cell.setAnimal(this);
    }

    public abstract void act();

    protected void moveTo(Cell newCell) {
        cell.setAnimal(null);
        newCell.setAnimal(this);
        cell = newCell;
    }

    public void incrementSurvival() {
        stepsSurvived++;
    }

    public boolean hasMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public Cell getCell() {
        return cell;
    }

    public int getStepsSurvived() {
        return stepsSurvived;
    }

    public abstract Animal reproduce(Cell newCell);
}
