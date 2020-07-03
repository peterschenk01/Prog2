package array2d;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before; 
import java.util.Iterator;

public class IterableArray2DTest{

  private double[][] a2d;

  @Before
  public void before_createArray(){
    a2d = new double[][] {
      {1},
      {2,3},
      {4,5,6}
    };
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_constructorNull(){
    new IterableArray2D(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_constructorNullEntry(){
    new IterableArray2D(new double[][] { {1,2,3}, null });
  }

  @Test
  public void test_iterator(){
    assertNotNull((new IterableArray2D(a2d)).iterator());
  }

  @Test(expected = NoSuchElementException.class)
  public void test_iteratorLength0Array(){
    IterableArray2D a = new IterableArray2D(new double[][] {});
    Iterator<Double> i = a.iterator();

    assertFalse(i.hasNext());
    i.next();
  }

  @Test
  public void test_iteratorCorrectness(){
    Iterator<Double> i = new IterableArray2D(a2d).iterator();

    assertEquals(i.next(), 1.0, 1e-10);
    assertEquals(i.next(), 2.0, 1e-10);
    assertEquals(i.next(), 3.0, 1e-10);
    assertEquals(i.next(), 4.0, 1e-10);
    assertEquals(i.next(), 5.0, 1e-10);
    assertEquals(i.next(), 6.0, 1e-10);
    assertFalse(i.hasNext());
  }

  @Test
  public void test_iteratorCorrectnessWithChange(){
    Iterator<Double> i = new IterableArray2D(a2d).iterator();
    a2d[0][0] = 0;

    assertEquals("Iterator must return current content of array", i.next(), 0.0, 1e-10);
  }

}

