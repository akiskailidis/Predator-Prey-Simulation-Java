public class Cell {
    private Animal animal;
    private int row, col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.animal = null;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public boolean isEmpty() {
        return animal == null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
