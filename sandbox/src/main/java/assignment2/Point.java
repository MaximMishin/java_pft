package assignment2;

public class Point {

  double x1;
  double y1;
  double x2;
  double y2;

  public Point(double x1, double y1, double x2, double y2) {

    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;

  }

  public double square(double a) {
    return a * a;
  }

  public double distance() {
    return Math.sqrt(square(x2 - x1) + square(y2 - y1));
  }
}
