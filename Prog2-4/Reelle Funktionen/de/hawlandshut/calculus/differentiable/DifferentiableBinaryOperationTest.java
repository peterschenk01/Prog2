package de.hawlandshut.calculus.differentiable;
import org.junit.Test;

import de.hawlandshut.calculus.binaryoperations.Addition;
import de.hawlandshut.calculus.binaryoperations.Composition;
import de.hawlandshut.calculus.binaryoperations.Multiplication;
import de.hawlandshut.calculus.realfunctions.Cosine;
import de.hawlandshut.calculus.realfunctions.OutsideOfDomainException;
import de.hawlandshut.calculus.realfunctions.RealFunction;
import de.hawlandshut.calculus.realfunctions.Sine;

import static org.junit.Assert.*;

import java.lang.reflect.Modifier;
import java.util.function.DoubleFunction;

public class DifferentiableBinaryOperationTest {

  private static class NonDiffFunction extends RealFunction{

    @Override
    public double evaluateAt(double x) throws OutsideOfDomainException {
      return 0;
    }

    @Override
    public boolean inDomain(double x) {
      return true;
    }

  }

  @Test(expected = DiffException.class)
  public void testAdditionNonDiff() throws DiffException{
    Sine sin = new Sine(1,1);
    var nonDiff = new NonDiffFunction();
    Addition a = new Addition(sin,nonDiff);
    a.derive();
  }

  @Test public void testAdditionDiff() throws DiffException {
    Sine sin = new Sine(1,1);
    Cosine cos = new Cosine(2,2);
    Addition a = new Addition(sin,cos);

    var d = a.derive();

    assertTrue(d instanceof Addition);

    for (double x = -10; x < 10; x+=0.1){
      assertEquals(d.evaluateAt(x), Math.cos(x) - 4*Math.sin(2*x), 1e-10);
    }
  }

  @Test(expected = DiffException.class)
  public void testMultiplicationNonDiff() throws DiffException{
    Sine sin = new Sine(1,1);
    var nonDiff = new NonDiffFunction();
    var a = new Multiplication(sin,nonDiff);
    a.derive();
  }

  @Test public void testMultiplicationDiff() throws DiffException {
    Sine sin = new Sine(1,1);
    Cosine cos = new Cosine(2,2);
    Multiplication a = new Multiplication(sin,cos);

    var d = a.derive();

    assertTrue(d instanceof Addition);

    for (double x = -10; x < 10; x+=0.1){
      assertEquals(d.evaluateAt(x), Math.cos(x)*2*Math.cos(2*x) - 4*Math.sin(2*x)*Math.sin(x), 1e-10);
    }
  }


  @Test(expected = DiffException.class)
  public void testCompositionNonDiff() throws DiffException{
    Sine sin = new Sine(1,1);
    var nonDiff = new NonDiffFunction();
    var a = new Composition(sin,nonDiff);
    a.derive();
  }

  @Test public void testCompositionDiff() throws DiffException {
    Sine sin = new Sine(1,1);
    Cosine cos = new Cosine(2,2);
    Composition a = new Composition(sin,cos);

    var d = a.derive();

    assertTrue(d instanceof Multiplication);

    for (double x = -10; x < 10; x+=0.1){
      assertEquals(d.evaluateAt(x), Math.cos(2*Math.cos(2*x)) * (-4*Math.sin(2*x)), 1e-10);
    }
  }




}



