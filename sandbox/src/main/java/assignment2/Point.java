package assignment2;

public class Point {

  double x;
  double y;

  public Point(double x, double y) {

    this.x = x;
    this.y = y;

  }

  public double square(double a) {
    return a * a;
  }

  public double distance(Point p1, Point p2) {
    return Math.sqrt(square(p2.x - p1.x) + square(p2.y - p1.y));
  }
}
