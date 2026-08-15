# OOP ASSIGNMENT WEEK 3

Three separate folders. Each folder works on its own.

## 1. PointTriangle
Files: Point.java, Triangle.java, PointTriangleMain.java

- Point.java = stores an (x, y) location. Can add, subtract, and copy points.
- Triangle.java = made using 3 Points. Can find perimeter and area.
- PointTriangleMain.java = the file that runs and tests everything.

## 2. LineTriangle
Files: Point.java, Line.java, Triangle.java, LineTriangleMain.java

- Line.java = made using 2 Points (a start point and an end point).
  Can find length, midpoint, and where two lines cross (intersection).
- Triangle.java = now made using 3 Lines instead of 3 Points.
- LineTriangleMain.java = the file that runs and tests everything.

## 3. ComplexRational
Files: Complex.java, Rational.java, ComplexRationalMain.java

- Complex.java = a complex number (real + imaginary part). Can add,
  subtract, multiply, divide.
- Rational.java = a fraction (numerator/denominator). Simplifies
  itself automatically. Can add, subtract, multiply, divide.
- ComplexRationalMain.java = the file that runs and tests everything.

## Main idea 
- Each class has 3 constructors: empty, normal, and copy.
- Math operations (add, subtract, etc.) always return a NEW object.
- toString() makes objects print in a nice readable way.
- equals() checks if two objects have the same values.
- Bigger classes are built using smaller classes (Line uses Point,
  Triangle uses Line). This is called composition.
