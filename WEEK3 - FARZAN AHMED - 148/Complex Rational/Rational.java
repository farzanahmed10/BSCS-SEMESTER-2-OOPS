// Rational.java

public class Rational {
    private int numerator;
    private int denominator;

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        if (denominator == 0) throw new ArithmeticException("Denominator cannot be zero");
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // Copy constructor
    public Rational(Rational other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a == 0 ? 1 : a;
    }

    
    private void simplify() {
        if (denominator < 0) { 
            numerator = -numerator;
            denominator = -denominator;
        }
        int g = gcd(numerator, denominator);
        numerator /= g;
        denominator /= g;
    }

    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }

    // Arithmetic 

    // a/b + c/d = (ad + bc) / bd
    public Rational add(Rational other) {
        int n = this.numerator * other.denominator + other.numerator * this.denominator;
        int d = this.denominator * other.denominator;
        return new Rational(n, d);
    }
 
    // subtraction
    public Rational subtract(Rational other) {
        int n = this.numerator * other.denominator - other.numerator * this.denominator;
        int d = this.denominator * other.denominator;
        return new Rational(n, d);
    }
// multiplication
    public Rational multiply(Rational other) {
        return new Rational(this.numerator * other.numerator, this.denominator * other.denominator);
    }
//division
    public Rational divide(Rational other) {
        if (other.numerator == 0) throw new ArithmeticException("Division by zero");
        return new Rational(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    // Object overrides 

    @Override
    public String toString() {
        if (denominator == 1) return String.valueOf(numerator);
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rational)) return false;
        Rational r = (Rational) obj;
        return this.numerator == r.numerator && this.denominator == r.denominator;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(numerator, denominator);
    }
}
