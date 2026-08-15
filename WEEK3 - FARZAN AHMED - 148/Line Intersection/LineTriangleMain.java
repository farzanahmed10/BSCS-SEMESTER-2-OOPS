/**
 * LineTriangleMain.java
 *
 * Single driver/test file for Point.java, Line.java, and Triangle.java.
 * Contains ONLY the main() method — no class logic here.
 */
public class LineTriangleMain {
    public static void main(String[] args) {

        // ---------------- Line tests ----------------
        System.out.println("========== LINE TESTS ==========");

        Point a = new Point(0, 0);
        Point b = new Point(4, 4);

        Line l1 = new Line(a, b);
        Line l1Copy = new Line(l1); // copy constructor

        System.out.println("l1        = " + l1);
        System.out.println("l1Copy    = " + l1Copy);
        System.out.println("length    = " + l1.length());
        System.out.println("midpoint  = " + l1.midpoint());
        System.out.println("slope     = " + l1.slope());

        // Prove defensive copy: mutating original point 'a' after
        // building the Line should NOT change the Line's internal start.
        a.setX(999);
        System.out.println("\nAfter mutating original point a:");
        System.out.println("a          = " + a);
        System.out.println("l1.getStart() = " + l1.getStart() + "  (unchanged, proves defensive copy)");

        // ---------------- Line intersection tests ----------------
        System.out.println("\n========== LINE INTERSECTION TESTS ==========");

        Line lineA = new Line(new Point(0, 0), new Point(4, 4));   // y = x
        Line lineB = new Line(new Point(0, 4), new Point(4, 0));   // y = -x + 4

        Point crossing = lineA.intersect(lineB);
        System.out.println("lineA = " + lineA);
        System.out.println("lineB = " + lineB);
        System.out.println("Intersection point = " + crossing); // expect (2.0, 2.0)

        // Parallel lines: no intersection
        Line lineC = new Line(new Point(0, 0), new Point(4, 4));  // y = x
        Line lineD = new Line(new Point(0, 1), new Point(4, 5));  // y = x + 1
        System.out.println("\nlineC = " + lineC);
        System.out.println("lineD = " + lineD);
        System.out.println("Parallel? " + lineC.isParallelTo(lineD));
        System.out.println("Intersection (should be null) = " + lineC.intersect(lineD));

        // Vertical line intersection
        Line lineE = new Line(new Point(3, 0), new Point(3, 5)); // vertical line x = 3
        Line lineF = new Line(new Point(0, 2), new Point(6, 2)); // horizontal line y = 2
        System.out.println("\nlineE (vertical)   = " + lineE);
        System.out.println("lineF (horizontal) = " + lineF);
        System.out.println("Intersection = " + lineE.intersect(lineF)); // expect (3.0, 2.0)

        // ---------------- Triangle-from-Line tests ----------------
        System.out.println("\n========== TRIANGLE (COMPOSED OF LINES) TESTS ==========");

        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(0, 3);

        Triangle t1 = new Triangle(p1, p2, p3);      // built from 3 points -> 3 internal Lines
        Triangle t2 = new Triangle(t1);               // copy constructor

        System.out.println("t1 = " + t1);
        System.out.println("t2 (copy of t1) = " + t2);
        System.out.println("sideAB = " + t1.getSideAB());
        System.out.println("sideBC = " + t1.getSideBC());
        System.out.println("sideCA = " + t1.getSideCA());

        System.out.printf("Perimeter = %.2f%n", t1.perimeter());
        System.out.printf("Area      = %.2f%n", t1.area());
        System.out.println("Valid triangle? " + t1.isValidTriangle());

        // Build the same triangle a different way: directly from 3 Lines
        Line s1 = new Line(new Point(0, 0), new Point(4, 0));
        Line s2 = new Line(new Point(4, 0), new Point(0, 3));
        Line s3 = new Line(new Point(0, 3), new Point(0, 0));
        Triangle t3 = new Triangle(s1, s2, s3);
        System.out.println("\nt3 (built directly from 3 Lines) = " + t3);
        System.out.println("t1.equals(t3)? " + t1.equals(t3));

        // Intersection of two of the triangle's own sides
        // (they should meet exactly at the shared vertex)
        Point corner = t1.getSideAB().intersect(t1.getSideBC());
        System.out.println("\nIntersection of sideAB and sideBC = " + corner + " (should equal p2)");
    }
}
