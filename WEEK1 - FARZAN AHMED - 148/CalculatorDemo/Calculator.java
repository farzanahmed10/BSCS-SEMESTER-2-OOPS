public class Calculator {
    
    // Attributes
    private float num1;
    private float num2;
    private float result;
    private boolean state; // true = ON, false = OFF

    //  Constructor 
    public Calculator() {
        this.num1 = 0;
        this.num2 = 0;
        this.result = 0;
        this.state = false; // calculator starts OFF
    }

    //  State accessors
    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    //  Set numbers 
    public void setNumbers(float num1, float num2) {
        if (!state) {
            System.out.println("Calculator is OFF. Turn it ON before use.");
            return;
        }
        this.num1 = num1;
        this.num2 = num2;
    }

    // Operations 
    public void add() {
        if (!state) {
            System.out.println("Calculator is OFF. Turn it ON before use.");
            return;
        }
        result = num1 + num2;
    }

    public void subtract() {
        if (!state) {
            System.out.println("Calculator is OFF. Turn it ON before use.");
            return;
        }
        result = num1 - num2;
    }

    public void multiply() {
        if (!state) {
            System.out.println("Calculator is OFF. Turn it ON before use.");
            return;
        }
        result = num1 * num2;
    }

    public void divide() {
        if (!state) {
            System.out.println("Calculator is OFF. Turn it ON before use.");
            return;
        }
        if (num2 == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return;
        }
        result = num1 / num2;
    }

    // Display state 
    public void displayState() {
       
        System.out.println("Calculator State : " + (state ? "ON" : "OFF"));
        System.out.println("num1   : " + num1);
        System.out.println("num2   : " + num2);
        System.out.println("result : " + result);
        
    }
}
