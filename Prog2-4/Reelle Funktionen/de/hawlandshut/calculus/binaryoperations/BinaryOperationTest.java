package de.hawlandshut.calculus.binaryoperations;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Modifier;
import java.util.function.DoubleFunction;

import de.hawlandshut.calculus.*;
import de.hawlandshut.calculus.realfunctions.Constant;
import de.hawlandshut.calculus.realfunctions.Cosine;
import de.hawlandshut.calculus.realfunctions.Exp;
import de.hawlandshut.calculus.realfunctions.Log;
import de.hawlandshut.calculus.realfunctions.OutsideOfDomainException;
import de.hawlandshut.calculus.realfunctions.Sine;

public class BinaryOperationTest {
    @Test public void testBinaryOperation() {
    var c = BinaryOperation.class; 
    assertTrue(
        "BinaryOperation must be abstract",
        Modifier.isAbstract(c.getModifiers()));

    }

    @Test public void testTypes(){
      assertEquals("Addition must derive from BinaryOperation", 
          Addition.class.getSuperclass(), BinaryOperation.class);
      assertEquals("Multiplication must derive from BinaryOperation", 
          Multiplication.class.getSuperclass(), BinaryOperation.class);
      assertEquals("Composition must derive from BinaryOperation", 
          Composition.class.getSuperclass(), BinaryOperation.class);
    }

    @Test public void testAddition(){
      Sine s = new Sine(1,1);
      Cosine c = new Cosine(2,2);
      Addition a = new Addition(s,c);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(a.evaluateAt(x), Math.sin(x) + 2*Math.cos(2*x), 1e-10);
        assertTrue(a.inDomain(x));
      }

    }

    @Test public void testAddition2(){
      Log l = new Log();
      Exp e = new Exp();
      Addition a = new Addition(l,e);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(a.inDomain(x), x > 0);

        if (a.inDomain(x))
          assertEquals(a.evaluateAt(x), Math.log(x) + Math.exp(x), 1e-10);
      }


    }

    @Test public void testAdditionToString(){
    Sine s = new Sine(1,1);
    Cosine c = new Cosine(2,2);
    Addition a = new Addition(s,c);
    assertEquals(
        "Addition.toString must return \"(left.toString())+(right.toString())\"",
        a.toString(), String.format("(%s)+(%s)", s.toString(), c.toString()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdditionArgCheck(){
      new Addition(null, new Constant(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdditionArgCheck2(){
      new Addition(new Constant(1), null);
    }


    @Test public void testMultiplication(){
      Sine s = new Sine(1,1);
      Cosine c = new Cosine(2,2);
      Multiplication m = new Multiplication(s,c);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(m.evaluateAt(x), Math.sin(x) * 2*Math.cos(2*x), 1e-10);
        assertTrue(m.inDomain(x));
      }

    }

    @Test public void testMultiplication2(){
      Log l = new Log();
      Exp e = new Exp();
      Multiplication m = new Multiplication(l,e);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(m.inDomain(x), x > 0);

        if (m.inDomain(x))
          assertEquals(m.evaluateAt(x), Math.log(x) * Math.exp(x), 1e-10);
      }

    }

    @Test public void testMultiplicationToString(){
    Sine s = new Sine(1,1);
    Cosine c = new Cosine(2,2);
    Multiplication a = new Multiplication(s,c);
    assertEquals(
        "Multiplication.toString must return \"(left.toString())+(right.toString())\"",
        a.toString(), String.format("(%s)*(%s)", s.toString(), c.toString()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplicationArgCheck(){
      new Multiplication(null, new Constant(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplicationArgCheck2(){
      new Multiplication(new Constant(1), null);
    }

    @Test public void testComposition(){
      Sine s = new Sine(1,1);
      Cosine c = new Cosine(2,2);
      Composition m = new Composition(s,c);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(m.evaluateAt(x), Math.sin(2*Math.cos(2*x)), 1e-10);
        assertTrue(m.inDomain(x));
      }

    }

    @Test public void testComposition2(){
      Log l = new Log();
      Sine s = new Sine(1,1);
      Composition c = new Composition(l,s);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(c.inDomain(x), Math.sin(x) > 0);

        if (c.inDomain(x))
          assertEquals(c.evaluateAt(x), Math.log(Math.sin(x)), 1e-10);
      }

    }

    @Test(expected = OutsideOfDomainException.class)
    public void testCompositionOutsideOfDomain(){
      Log l = new Log();
      Sine s = new Sine(1,1);
      Composition c = new Composition(l,s);
      c.evaluateAt(-0.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompositionArgCheck(){
      new Composition(null, new Constant(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompositionArgCheck2(){
      new Composition(new Constant(1), null);
    }

    @Test public void testCompositionToString(){
    Sine s = new Sine(1,1);
    Cosine c = new Cosine(2,2);
    Composition a = new Composition(s,c);
    assertEquals(
        "Composition.toString must return \"(left.toString())+(right.toString())\"",
        a.toString(), String.format("(%s)o(%s)", s.toString(), c.toString()));

    }

}

