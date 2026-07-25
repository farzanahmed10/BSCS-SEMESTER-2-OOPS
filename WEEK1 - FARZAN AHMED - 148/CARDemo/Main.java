public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        car.setDetails("Toyota Corolla");

        // Try accelerating while engine is OFF
        car.accelerate(20);
        car.displayState();

        // Start the engine and drive
        car.startEngine();
        car.accelerate(30);
        car.displayState();

        car.accelerate(20);
        car.displayState();

        car.decelerate(15);
        car.displayState();

        // Stop the engine
        car.stopEngine();
        car.displayState();
    }
}
