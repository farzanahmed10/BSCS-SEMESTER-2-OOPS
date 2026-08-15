/**
 * Triangle.java
 *
 * Demonstrates a SECOND LAYER of COMPOSITION:
 *   Point  ->  Line (has-a two Points)  ->  Triangle (has-a three Lines)
 *
 * A Triangle here is built from 3 Points, but internally it stores
 * three Line objects (sideA, sideB, sideC) instead of three raw Points.
 * Each Line, in turn, is composed of two Points. This mirrors real
 * geometric structure: a triangle IS three connected line segments.
 *
 * NOTE: This file contains ONLY the class definition.
 * See LineTriangleMain.java for the test/driver code (main method).
 */
public class Triangle {
    private Line sideAB; // p1 -> p2
    private Line sideBC; // p2 -> p3
    private Line sideCA; // p3 -> p1

    // Build a Triangle from 3 vertices. Internally builds 3 Line objects,
    // one per side, each of which defensively copies its own endpoints
    // (Line's constructor already does this).
    public Triangle(Point p1, Point p2, Point p3) {
        this.sideAB = new Line(p1, p2);
        this.sideBC = new Line(p2, p3);
        this.sideCA = new Line(p3, p1);
    }

    // Alternate constructor: build a Triangle directly from 3 Line objects,
    // as long as they connect end-to-end to form a closed triangle.
    public Triangle(Line sideAB, Line sideBC, Line sideCA) {
        if (!sideAB.getEnd().equals(sideBC.getStart()) ||
            !sideBC.getEnd().equals(sideCA.getStart()) ||
            !sideCA.getEnd().equals(sideAB.getStart())) {
            throw new IllegalArgumentException("Lines do not form a closed triangle");
        }
        this.sideAB = new Line(sideAB);
        this.sideBC = new Line(sideBC);
        this.sideCA = new Line(sideCA);
    }

    // Copy constructor for Triangle itself
    public Triangle(Triangle other) {
        this.sideAB = new Line(other.sideAB);
        this.sideBC = new Line(other.sideBC);
        this.sideCA = new Line(other.sideCA);
    }

    // ---------- Getters ----------

    public Line getSideAB() { return new Line(sideAB); }
    public Line getSideBC() { return new Line(sideBC); }
    public Line getSideCA() { return new Line(sideCA); }

    public Point getP1() { return sideAB.getStart(); }
    public Point getP2() { return sideAB.getEnd(); }   // == sideBC.getStart()
    public Point getP3() { return sideBC.getEnd(); }   // == sideCA.getStart()

    // ---------- Geometry ----------

    public double perimeter() {
        return sideAB.length() + sideBC.length() + sideCA.length();
    }

    // Area via the shoelace formula, using the vertices pulled out of
    // the three sides.
    public double area() {
        Point p1 = getP1(), p2 = getP2(), p3 = getP3();
        double x1 = p1.getX(), y1 = p1.getY();
        double x2 = p2.getX(), y2 = p2.getY();
        double x3 = p3.getX(), y3 = p3.getY();
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    public boolean isValidTriangle() {
        double a = sideBC.length(); // opposite p1
        double b = sideCA.length(); // opposite p2
        double c = sideAB.length(); // opposite p3
        return (a + b > c) && (b + c > a) && (a + c > b);
    }

    // ---------- Object overrides ----------

    @Override
    public String toString() {
        return "Triangle[" + getP1() + ", " + getP2() + ", " + getP3() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Triangle)) return false;
        Triangle t = (Triangle) obj;
        return this.sideAB.equals(t.sideAB)
            && this.sideBC.equals(t.sideBC)
            && this.sideCA.equals(t.sideCA);
    }
}
