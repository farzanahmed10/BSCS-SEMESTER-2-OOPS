// complex.java

public class Complex {
    private double real;
    private double imag;

    public Complex() {
        this.real = 0;
        this.imag = 0;
    }

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Copy constructor
    public Complex(Complex other) {
        this.real = other.real;
        this.imag = other.imag;
    }

    public double getReal() { return real; }
    public double getImag() { return imag; }

    // Arithmetic 

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }
// subtraction
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }

    // (a+bi)(c+di) = (ac - bd) + (ad + bc)i
    // multiplication
    public Complex multiply(Complex other) {
        double r = this.real * other.real - this.imag * other.imag;
        double i = this.real * other.imag + this.imag * other.real;
        return new Complex(r, i);
    }

    // (a+bi)/(c+di) = ((ac+bd) + (bc-ad)i) / (c^2 + d^2)
    // division
    public Complex divide(Complex other) {
        double denom = other.real * other.real + other.imag * other.imag;
        if (denom == 0) throw new ArithmeticException("Division by zero complex number");
        double r = (this.real * other.real + this.imag * other.imag) / denom;
        double i = (this.imag * other.real - this.real * other.imag) / denom;
        return new Complex(r, i);
    }
// magnitude
    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }
// conjugate
    public Complex conjugate() {
        return new Complex(real, -imag);
    }

    //  Object overrides

    @Override
    public String toString() {
        if (imag == 0) return String.valueOf(real);
        String sign = (imag >= 0) ? "+" : "-";
        return real + " " + sign + " " + Math.abs(imag) + "i";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Complex)) return false;
        Complex c = (Complex) obj;
        return Double.compare(this.real, c.real) == 0 && Double.compare(this.imag, c.imag) == 0;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(real, imag);
    }
}
