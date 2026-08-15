// ComplexRationalMain.java

public class ComplexRationalMain {
    public static void main(String[] args) {

        // Complex tests 
        System.out.println("COMPLEX TESTS");

        Complex a = new Complex(3, 4);
        Complex b = new Complex(1, -2);
        Complex aCopy = new Complex(a);

        System.out.println("a       = " + a);
        System.out.println("b       = " + b);
        System.out.println("aCopy   = " + aCopy);
        System.out.println("a + b   = " + a.add(b));
        System.out.println("a - b   = " + a.subtract(b));
        System.out.println("a * b   = " + a.multiply(b));
        System.out.println("a / b   = " + a.divide(b));
        System.out.println("|a|     = " + a.magnitude());
        System.out.println("conj(a) = " + a.conjugate());

        //Rational tests 
        System.out.println("\n RATIONAL TESTS");

        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(2, 6); // will auto-simplify to 1/3
        Rational r1Copy = new Rational(r1);

        System.out.println("r1      = " + r1);
        System.out.println("r2 (2/6 simplified) = " + r2);
        System.out.println("r1Copy  = " + r1Copy);
        System.out.println("r1 + r2 = " + r1.add(r2));
        System.out.println("r1 - r2 = " + r1.subtract(r2));
        System.out.println("r1 * r2 = " + r1.multiply(r2));
        System.out.println("r1 / r2 = " + r1.divide(r2));
        System.out.println("r1 as double = " + r1.toDouble());
    }
}
