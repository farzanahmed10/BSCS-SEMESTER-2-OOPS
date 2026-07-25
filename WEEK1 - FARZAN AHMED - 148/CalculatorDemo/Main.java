public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Try using it while OFF
        calc.setNumbers(5, 3);
        calc.add();
        calc.displayState();

        // Turn it ON and use it
        calc.setState(true);
        calc.setNumbers(10, 4);

        calc.add();
        calc.displayState();

        calc.subtract();
        calc.displayState();

        calc.multiply();
        calc.displayState();

        calc.divide();
        calc.displayState();

        // Turn it OFF again
        calc.setState(false);
        calc.add();
        calc.displayState();
    }
}
