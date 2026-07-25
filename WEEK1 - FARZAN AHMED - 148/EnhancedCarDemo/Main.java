public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();

        car1.setDetails("Ferrari");
        car2.setDetails("Toyota");

        // car1: normal driving sequence
        car1.startEngine();
        car1.accelerate(30);
        car1.moveRight();
        car1.turboMode();

        // car2: engine left off on purpose, to prove independence
        car2.moveLeft();
        car2.accelerate(20);   // should fail: engine off

        System.out.println("== Car 1 state ==");
        car1.displayState();

        System.out.println("== Car 2 state ==");
        car2.displayState();

        // further prove independence: changing car1 does not affect car2
        car1.decelerate(50);
        car1.stopEngine();

        System.out.println("== Car 1 after stopping ==");
        car1.displayState();

        System.out.println("== Car 2 unchanged ==");
        car2.displayState();
    }
}
