//Triangle.java

public class Triangle {
    private Point p1;
    private Point p2;
    private Point p3;

    // Parameterized constructor
    
    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
        this.p3 = new Point(p3);
    }

    // Copy constructor for Triangle itself
    public Triangle(Triangle other) {
        this.p1 = new Point(other.p1);
        this.p2 = new Point(other.p2);
        this.p3 = new Point(other.p3);
    }

    //  getters 
    public Point getP1() { 
        return new Point(p1);
     } 
    public Point getP2()
     { 
    return new Point(p2);
     }
    public Point getP3() {
    return new Point(p3);
     }

    // Geometry 

    public double sideA() { 
        return p2.distanceTo(p3); 
    } // opposite p1
    public double sideB() { 
        return p1.distanceTo(p3);
     } // opposite p2
    public double sideC() { 
        return p1.distanceTo(p2);
     } // opposite p3

    public double perimeter() {
        return sideA() + sideB() + sideC();
    }

    // Area 
    public double area() {
        double x1 = p1.getX(), y1 = p1.getY();
        double x2 = p2.getX(), y2 = p2.getY();
        double x3 = p3.getX(), y3 = p3.getY();
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    public boolean isValidTriangle() {
        double a = sideA(), b = sideB(), c = sideC();
        return (a + b > c) && (b + c > a) && (a + c > b);
    }

    // Object overrides 

    @Override
    public String toString() {
        return "Triangle[" + p1 + ", " + p2 + ", " + p3 + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Triangle)) return false;
        Triangle t = (Triangle) obj;
        return this.p1.equals(t.p1) && this.p2.equals(t.p2) && this.p3.equals(t.p3);
    }
}
