package AssignmentThree;

import assignment2.AssignmentTwo;
import assignment2.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testOne() {

    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);
    Assert.assertEquals(p1.distance(p2), 0.0);
    Assert.assertEquals(AssignmentTwo.distance(p1, p2), 0.0);
    Assert.assertEquals(AssignmentTwo.distance(p1, p2), p1.distance(p2));
  }

  @Test
  public void testTwo() {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(1, 1);
    Assert.assertEquals(p1.distance(p2), 0.0);
    Assert.assertEquals(AssignmentTwo.distance(p1, p2), 0.0);
    Assert.assertEquals(AssignmentTwo.distance(p1, p2), p1.distance(p2));
  }

  @Test
  public void testThree() {
    Point p1 = new Point(1, 5);
    Point p2 = new Point(7, 5);
    Assert.assertEquals(p1.distance(p2), 6.0);
    Assert.assertEquals(AssignmentTwo.distance(p1, p2), 6.0);
    Assert.assertEquals(AssignmentTwo.distance(p1, p2), p1.distance(p2));
  }
}

