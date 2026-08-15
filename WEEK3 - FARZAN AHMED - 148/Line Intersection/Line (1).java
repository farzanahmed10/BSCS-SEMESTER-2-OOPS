/**
 * Line.java
 *
 * Demonstrates COMPOSITION: a Line "has-a" two Points (its endpoints).
 * A Line is built FROM Point (Line has-a Point, just like Triangle
 * used to have-a Point directly). Later, Triangle will be rebuilt to
 * be composed of three Line objects instead of three Point objects
 * (composition on top of composition).
 *
 * NOTE: This file contains ONLY the class definition.
 * See LineTriangleMain.java for the test/driver code (main method).
 */
public class Line {
    private Point start;
    private Point end;

    // ---------- Constructors ----------

    // Parameterized constructor.
    // Stores DEFENSIVE COPIES of the endpoints (same pattern as the
    // old Triangle-from-Point class), so mutating the original Point
    // objects after the Line is built does not affect this Line.
    public Line(Point start, Point end) {
        this.start = new Point(start);
        this.end = new Point(end);
    }

    // Copy constructor
    public Line(Line other) {
        this.start = new Point(other.start);
        this.end = new Point(other.end);
    }

    // ---------- Getters ----------

    public Point getStart() { return new Point(start); } // return a copy, not the live reference
    public Point getEnd() { return new Point(end); }

    // ---------- Geometry ----------

    public double length() {
        return start.distanceTo(end);
    }

    public Point midpoint() {
        return new Point((start.getX() + end.getX()) / 2.0,
                          (start.getY() + end.getY()) / 2.0);
    }

    // Slope (dy/dx). Returns Double.NaN for a vertical line (undefined slope).
    public double slope() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        if (dx == 0) return Double.NaN; // vertical line -> undefined slope
        return dy / dx;
    }

    public boolean isVertical() {
        return start.getX() == end.getX();
    }

    // Two lines are parallel if their direction vectors are scalar multiples
    // of each other. Using a cross-product check avoids dividing by zero
    // for vertical lines.
    public boolean isParallelTo(Line other) {
        double dx1 = this.end.getX() - this.start.getX();
        double dy1 = this.end.getY() - this.start.getY();
        double dx2 = other.end.getX() - other.start.getX();
        double dy2 = other.end.getY() - other.start.getY();
        double cross = dx1 * dy2 - dy1 * dx2;
        return cross == 0;
    }

    /**
     * Computes the intersection point of THIS line and OTHER line,
     * treating both as infinite lines (not just the segments between
     * their endpoints).
     *
     * Uses the standard 2-line intersection formula (Cramer's rule on
     * the two line equations). Returns null if the lines are parallel
     * (including the case where they are the same line).
     */
    public Point intersect(Line other) {
        double x1 = this.start.getX(), y1 = this.start.getY();
        double x2 = this.end.getX(),   y2 = this.end.getY();
        double x3 = other.start.getX(), y3 = other.start.getY();
        double x4 = other.end.getX(),   y4 = other.end.getY();

        double denom = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        if (denom == 0) {
            // Lines are parallel (or coincident) -> no single intersection point
            return null;
        }

        double preA = (x1 * y2 - y1 * x2);
        double preB = (x3 * y4 - y3 * x4);

        double px = (preA * (x3 - x4) - (x1 - x2) * preB) / denom;
        double py = (preA * (y3 - y4) - (y1 - y2) * preB) / denom;

        // Normalize -0.0 to 0.0 for cleaner output (IEEE 754: -0.0 + 0.0 == 0.0)
        px = px + 0.0;
        py = py + 0.0;

        return new Point(px, py);
    }

    /**
     * Same as intersect(), but also checks that the computed point
     * actually lies WITHIN both finite segments (not just on the
     * infinite lines through them). Useful for triangle-side checks.
     */
    public Point intersectSegment(Line other) {
        Point p = this.intersect(other);
        if (p == null) return null;

        if (isOnSegment(p, this) && isOnSegment(p, other)) {
            return p;
        }
        return null;
    }

    private static boolean isOnSegment(Point p, Line seg) {
        double minX = Math.min(seg.start.getX(), seg.end.getX()) - 1e-9;
        double maxX = Math.max(seg.start.getX(), seg.end.getX()) + 1e-9;
        double minY = Math.min(seg.start.getY(), seg.end.getY()) - 1e-9;
        double maxY = Math.max(seg.start.getY(), seg.end.getY()) + 1e-9;
        return p.getX() >= minX && p.getX() <= maxX && p.getY() >= minY && p.getY() <= maxY;
    }

    // ---------- Object overrides ----------

    @Override
    public String toString() {
        return "Line[" + start + " -> " + end + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Line)) return false;
        Line l = (Line) obj;
        return this.start.equals(l.start) && this.end.equals(l.end);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(start, end);
    }
}
