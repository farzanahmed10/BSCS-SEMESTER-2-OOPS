 // PointTriangleMain.java

public class PointTriangleMain {
    public static void main(String[] args) {

        // Point tests
        System.out.println(" POINT TESTS");

        Point a = new Point(2, 3);
        Point b = new Point(4, 1);

        // Copy constructor in work
        Point aCopy = new Point(a);

        Point sum = a.add(b);
        Point diff = a.subtract(b);

        System.out.println("a       = " + a);
        System.out.println("b       = " + b);
        System.out.println("aCopy   = " + aCopy);
        System.out.println("a + b   = " + sum);
        System.out.println("a - b   = " + diff);

        
        aCopy.setX(999);
        System.out.println("\nAfter mutating aCopy.x = 999:");
        System.out.println("a       = " + a);     
        System.out.println("aCopy   = " + aCopy);  
        System.out.println("a.equals(aCopy) after mutation? " + a.equals(aCopy)); 

        // Triangle tests 
        System.out.println("\n TRIANGLE TESTS");

        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(0, 3);

        Triangle t1 = new Triangle(p1, p2, p3);
        Triangle t2 = new Triangle(t1); 

        System.out.println("t1 = " + t1);
        System.out.println("t2 (copy of t1) = " + t2);

        System.out.printf("Side A (p2-p3) = %.2f%n", t1.sideA());
        System.out.printf("Side B (p1-p3) = %.2f%n", t1.sideB());
        System.out.printf("Side C (p1-p2) = %.2f%n", t1.sideC());
        System.out.printf("Perimeter      = %.2f%n", t1.perimeter());
        System.out.printf("Area           = %.2f%n", t1.area());
        System.out.println("Valid triangle? " + t1.isValidTriangle());

        
        p1.setX(1000);
        System.out.println("\nAfter mutating original point p1:");
        System.out.println("p1         = " + p1);
        System.out.println("t1.getP1() = " + t1.getP1() + "  (unchanged, proves defensive copy)");
    }
}
