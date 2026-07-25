public class EnhancedCalculator {
    //  Attributes 
    private double num1;
    private double num2;
    private double result;

    //  Constructor
    public EnhancedCalculator() {
        this.num1 = 0;
        this.num2 = 0;
        this.result = 0;
    }

    //  Set numbers 
    public void setNumbers(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    //  Operations 
    public void add() {
        result = num1 + num2;
    }

    public void subtract() {
        result = num1 - num2;
    }

    public void multiply() {
        result = num1 * num2;
    }

    public void divide() {
        if (num2 == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return;
        }
        result = num1 / num2;
    }

    public void modulus() {
        if (num2 == 0) {
            System.out.println("Error: Modulus by zero is not allowed.");
            return;
        }
        result = num1 % num2;
    }

    public void average() {
        result = (num1 + num2) / 2;
    }

    //  Display state 
    public void displayState() {
        System.out.println("num1   : " + num1);
        System.out.println("num2   : " + num2);
        System.out.println("result : " + result);
    }
}
