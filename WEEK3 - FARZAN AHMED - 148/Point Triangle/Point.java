/*
  Point.java
 
 Represents a 2D point (x, y). Demonstrates:
 default constructor
 parameterized constructor
 copy constructor
 instance methods that return NEW objects (add, subtract)
 toString()
 equals()
 */
public class Point {
    private double x;
    private double y;

    // Constructors 

    // Default constructor: 
    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Parameterized constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Copy constructor
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    // getters

    public double getX() {
         return x;
         }
    public double getY() {
         return y;
         }

    // setters
    public void setX(double x) {
         this.x = x;
         }
    public void setY(double y) {
         this.y = y;
         }

    // Arithmetic

    public Point add(Point other) {
        return new Point(this.x + other.x, this.y + other.y);
    }

    // Subtraction
    public Point subtract(Point other) {
        return new Point(this.x - other.x, this.y - other.y);
    }

    // Distance
    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Object overrides 

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point p = (Point) obj;
        return Double.compare(this.x, p.x) == 0 && Double.compare(this.y, p.y) == 0;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }
}
