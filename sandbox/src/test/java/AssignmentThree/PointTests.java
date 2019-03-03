package AssignmentThree;

import assignment2.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testOne() {

    Point points = new Point(0, 0, 0, 0);
    Assert.assertEquals(points.distance(), 0.0);
  }

  @Test
  public void testTwo() {
    Point points2 = new Point(1, 1, 1, 1);
    Assert.assertEquals(points2.distance(), 0.0);
  }

  @Test
  public void testThree() {
    Point points3 = new Point(1, 5, 7, 5);
    Assert.assertEquals(points3.distance(), 6.0);
  }
}

