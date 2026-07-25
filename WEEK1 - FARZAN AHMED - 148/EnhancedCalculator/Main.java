public class Main {
    public static void main(String[] args) {
        EnhancedCalculator calc = new EnhancedCalculator();

        calc.setNumbers(10, 4);

        calc.add();
        calc.displayState();

        calc.subtract();
        calc.displayState();

        calc.multiply();
        calc.displayState();

        calc.divide();
        calc.displayState();

        calc.modulus();
        calc.displayState();

        calc.average();
        calc.displayState();
    }
}
