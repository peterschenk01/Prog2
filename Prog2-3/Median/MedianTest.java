import org.junit.Test;
import static org.junit.Assert.*;

public class MedianTest {
    @Test public void testMedian() {
      assertEquals(Median.computeMedian(0), 0, 1e-10);
      assertEquals(Median.computeMedian(0,1), 0.5, 1e-10);
      assertEquals(Median.computeMedian(4,7,1,9,2), 4.0, 1e-10);
      assertEquals(Median.computeMedian(4,7,1,9,2,5), (4.0+5.0)/2.0, 1e-10);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testMedianNoArg() {
      Median.computeMedian();
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testMedianNullArg() {
      Median.computeMedian(null);
    }
}

