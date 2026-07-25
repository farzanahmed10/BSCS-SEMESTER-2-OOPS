public class Car {
    //  Attributes 
    private String model;
    private int speed;
    private boolean state; // true = engine ON, false = engine OFF

    //  Constructor 
    public Car() {
        this.model = "Unknown";
        this.speed = 0;
        this.state = false; // engine starts OFF
    }

    // Set details 
    public void setDetails(String model) {
        this.model = model;
    }

    //  Speed control
    public void accelerate(int delta) {
        if (!state) {
            System.out.println("Engine is OFF. Start the engine before accelerating.");
            return;
        }
        speed += delta;
    }

    public void decelerate(int delta) {
        if (!state) {
            System.out.println("Engine is OFF. Start the engine before decelerating.");
            return;
        }
        speed -= delta;
        if (speed < 0) {
            speed = 0;
        }
    }

    //  Engine control 
    public void startEngine() {
        state = true;
        System.out.println("Engine started.");
    }

    public void stopEngine() {
        state = false;
        speed = 0;
        System.out.println("Engine stopped.");
    }

    //  Display state 
    public void displayState() {
        System.out.println("Model  : " + model);
        System.out.println("Speed  : " + speed);
        System.out.println("Engine : " + (state ? "ON" : "OFF"));
    }
}
