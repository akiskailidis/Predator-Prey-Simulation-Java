import java.util.Scanner;

public class Simulation {
    public static void main(String[] args) {
        Grid grid = new Grid();
        PopulationSimulator simulator = new PopulationSimulator(grid);

        simulator.populate(100, 5); // initial population

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of simulation steps: ");
        int steps = scanner.nextInt();

        for (int i = 0; i < steps; i++) {
            System.out.println("\nStep " + (i + 1));
            simulator.simulateStep();
            grid.display();
            simulator.printStats();
        }

        scanner.close();
    }
}
