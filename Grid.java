import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
    public static final int SIZE = 20;
    private Cell[][] cells;
    private Random random;

    public Grid() {
        cells = new Cell[SIZE][SIZE];
        random = new Random();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public Cell getCell(int row, int col) {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE) {
            return cells[row][col];
        }
        return null;
    }

    public List<Cell> getAdjacentCells(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();
        int row = cell.getRow();
        int col = cell.getCol();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                Cell neighbor = getCell(row + i, col + j);
                if (neighbor != null) {
                    neighbors.add(neighbor);
                }
            }
        }
        return neighbors;
    }

    public List<Cell> getEmptyAdjacentCells(Cell cell) {
        List<Cell> result = new ArrayList<>();
        for (Cell c : getAdjacentCells(cell)) {
            if (c.isEmpty()) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Cell> getOccupiedAdjacentCells(Cell cell, Class<?> animalType) {
        List<Cell> result = new ArrayList<>();
        for (Cell c : getAdjacentCells(cell)) {
            if (!c.isEmpty() && animalType.isInstance(c.getAnimal())) {
                result.add(c);
            }
        }
        return result;
    }

    public void display() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Animal a = cells[row][col].getAnimal();
                if (a == null) {
                    System.out.print("_ ");
                } else if (a instanceof Rabbit) {
                    System.out.print("o ");
                } else if (a instanceof Fox) {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
