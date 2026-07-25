public class Car {
    private String model;
    private int speed;
    private boolean state;
    private double fuelLevel;
    private String direction;

    public Car() {
        model = "unknown";
        speed = 0;
        state = false;
        fuelLevel = 100.0;
        direction = "straight";
    }

    public void setDetails(String model) {
        this.model = model;
    }

    public void startEngine() {
        if (fuelLevel <= 0) {
            System.out.println(model + ": cannot start engine, no fuel");
            return;
        }
        state = true;
    }

    public void stopEngine() {
        state = false;
        speed = 0;
    }

    public void accelerate(int delta) {
        if (!state) {
            System.out.println(model + ": cannot accelerate, engine is off");
            return;
        }
        if (fuelLevel <= 0) {
            System.out.println(model + ": cannot accelerate, out of fuel");
            return;
        }
        speed += delta;
        fuelLevel -= delta * 0.1;
        if (fuelLevel < 0) fuelLevel = 0;
    }

    public void decelerate(int delta) {
        speed -= delta;
        if (speed < 0) speed = 0;
    }

    public void moveLeft() {
        direction = "left";
    }

    public void moveRight() {
        direction = "right";
    }

    public void turboMode() {
        if (!state) {
            System.out.println(model + ": cannot engage turbo, engine is off");
            return;
        }
        if (fuelLevel < 15) {
            System.out.println(model + ": cannot engage turbo, insufficient fuel");
            return;
        }
        speed += 40;
        fuelLevel -= 15;
        System.out.println(model + ": TURBO engaged!");
    }

    public void displayState() {
        System.out.println("Model: " + model);
        System.out.println("Speed: " + speed);
        System.out.println("Engine on: " + state);
        System.out.println("Fuel level: " + fuelLevel);
        System.out.println("Direction: " + direction);
        
    }
}
