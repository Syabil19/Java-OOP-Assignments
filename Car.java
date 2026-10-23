public class Car {

    // ===== Attributes (all private = encapsulation) =====
    private String brand;
    private String model;
    private int year;
    private String color;
    private double mileage;     // total distance travelled in km
    private double fuelLevel;   // fuel level in percent (0 - 100)
    private boolean engineOn;   // true = engine running, false = engine off

    // Fuel used (in % of tank) for every km driven
    private static final double FUEL_PER_KM = 0.08;

    // ===== Constructors =====

    // Default constructor: sets safe starting values
    public Car() {
        brand = "Unknown";
        model = "Unknown";
        year = 0;
        color = "Unknown";
        mileage = 0;
        fuelLevel = 0;
        engineOn = false;
    }

    // Parameterized constructor: sets all values when the object is created
    public Car(String brand, String model, int year, String color,
               double mileage, double fuelLevel, boolean engineOn) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.fuelLevel = fuelLevel;
        this.engineOn = engineOn;
    }

    // ===== Getters =====
    public String getBrand()     { return brand; }
    public String getModel()     { return model; }
    public int getYear()         { return year; }
    public String getColor()     { return color; }
    public double getMileage()   { return mileage; }
    public double getFuelLevel() { return fuelLevel; }
    public boolean isEngineOn()  { return engineOn; }

    // ===== Setters =====
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Validation: mileage cannot be negative
    public void setMileage(double mileage) {
        if (mileage >= 0) {
            this.mileage = mileage;
        }
    }

    // Validation: fuel level must stay between 0 and 100
    public void setFuelLevel(double fuelLevel) {
        if (fuelLevel < 0) {
            this.fuelLevel = 0;
        } else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        } else {
            this.fuelLevel = fuelLevel;
        }
    }

    public void setEngineOn(boolean engineOn) {
        this.engineOn = engineOn;
    }

    // ===== Main car methods =====

    // Start the engine only if it is not already running
    public void startEngine() {
        if (!engineOn) {
            engineOn = true;
            System.out.println("The engine has started.");
        } else {
            System.out.println("The engine is already running.");
        }
    }

    // Stop the engine only if it is currently running
    public void stopEngine() {
        if (engineOn) {
            engineOn = false;
            System.out.println("The engine has stopped.");
        } else {
            System.out.println("The engine is already off.");
        }
    }

    // Drive a distance: increases mileage and reduces fuel level
    public void drive(double distance) {
        if (distance <= 0) {
            System.out.println("Distance must be more than 0.");
        } else if (!engineOn) {
            System.out.println("Start the engine first.");
        } else if (fuelLevel <= 0) {
            System.out.println("No fuel left. Please refuel.");
        } else {
            double fuelNeeded = distance * FUEL_PER_KM;

            if (fuelNeeded > fuelLevel) {
                // Not enough fuel for the full distance
                double possibleDistance = fuelLevel / FUEL_PER_KM;
                mileage += possibleDistance;
                fuelLevel = 0;
                System.out.printf("The car ran out of fuel after %.1f km.%n", possibleDistance);
            } else {
                mileage += distance;
                fuelLevel -= fuelNeeded;
                System.out.printf("The car drove %.1f km.%n", distance);
            }
        }
    }

    // Add fuel to the car (fuel level cannot exceed 100%)
    public void refuel(double amount) {
        if (amount <= 0) {
            System.out.println("Fuel amount must be more than 0.");
        } else {
            fuelLevel += amount;
            if (fuelLevel > 100) {
                fuelLevel = 100;
            }
            System.out.printf("Fuel level: %.1f%%%n", fuelLevel);
        }
    }

    // Display all information about the car
    public void displayInfo() {
        System.out.println("\n--- Car Information ---");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.printf("Mileage: %.1f km%n", mileage);
        System.out.printf("Fuel Level: %.1f%%%n", fuelLevel);
        System.out.println("Engine On: " + engineOn);
    }
}
