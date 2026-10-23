import java.util.Scanner;

/**
 * Main class - entry point of the Car Management System.
 * Demonstrates: object creation, if/else selection, for loop,
 * and use of getters and setters.
 */
public class Main {
    public static void main(String[] args) {

        // Scanner reads the user's input from the console
        Scanner scanner = new Scanner(System.in);
        Car car;

        // Menu of cars
        System.out.println("Choose a car:");
        System.out.println("1. Toyota Vios");
        System.out.println("2. Honda City");
        System.out.println("3. Mazda 3");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        // If/else selection: create a different Car object per choice
        if (choice == 1) {
            car = new Car("Toyota", "Vios", 2023, "Silver", 15000, 60, false);
        } else if (choice == 2) {
            car = new Car("Honda", "City", 2024, "Blue", 8000, 45, false);
        } else if (choice == 3) {
            car = new Car("Mazda", "3", 2022, "White", 22000, 80, false);
        } else {
            // Input validation: stop the program if the choice is invalid
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        // Show the starting information of the selected car
        car.displayInfo();

        // Use of getters and setters
        System.out.println("\nSelected car: " + car.getBrand() + " " + car.getModel());
        car.setColor("Red");
        System.out.println("New color: " + car.getColor());

        // Ask whether to start the engine
        System.out.print("\nStart engine? 1 = Yes, 0 = No: ");
        int start = scanner.nextInt();

        if (start == 1) {
            car.startEngine();

            // For loop: drive three times
            for (int i = 1; i <= 3; i++) {
                System.out.print("Enter distance to drive: ");
                double distance = scanner.nextDouble();
                car.drive(distance);
            }

            // Refuel the car
            System.out.print("Enter fuel amount to add: ");
            double fuel = scanner.nextDouble();
            car.refuel(fuel);

            // Show final information, then stop the engine
            car.displayInfo();
            car.stopEngine();
        } else {
            System.out.println("Engine remains off.");
        }

        scanner.close();
    }
}
