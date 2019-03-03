package assignment2;

public class AssignmentTwo {

  public static void main(String[] args) {

    Point points = new Point(4, 7, 2, -3);

    System.out.println("Расстояния между двумя точками "
            + points.x1 + ";" + points.y1 +
            " и " + points.x2 + ";" + points.y2 +
            " = " + points.distance());
  }
}


