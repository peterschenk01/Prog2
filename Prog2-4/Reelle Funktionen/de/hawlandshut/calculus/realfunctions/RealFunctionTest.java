package de.hawlandshut.calculus.realfunctions;

import org.junit.Test;

import static org.junit.Assert.*;

import java.lang.reflect.Modifier;
import java.util.function.DoubleFunction;

public class RealFunctionTest {
    @Test public void testRealFunction() {
    var c = RealFunction.class; 
    assertTrue(
        "RealFunction must be abstract",
        Modifier.isAbstract(c.getModifiers()));

    }

    @Test public void testTypes(){
      assertEquals("Constant must derive vom RealFunction", Constant.class.getSuperclass(), RealFunction.class);
      assertEquals("CubicPolynomial must derive vom RealFunction", CubicPolynomial.class.getSuperclass(), RealFunction.class);
      assertEquals("Sine must derive vom RealFunction", Sine.class.getSuperclass(), RealFunction.class);
      assertEquals("Cosine must derive vom RealFunction", Cosine.class.getSuperclass(), RealFunction.class);
      assertEquals("Log must derive vom RealFunction", Log.class.getSuperclass(), RealFunction.class);
      assertEquals("Exp must derive vom RealFunction", Exp.class.getSuperclass(), RealFunction.class);
    }

    @Test public void TestExceptionType(){
      assertEquals("OutsideOfDomainException must derive vom RuntimeException", 
          OutsideOfDomainException.class.getSuperclass(), RuntimeException.class);
      
    }

    @Test public void testConstant() {
      Constant c = new Constant(1);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(c.evaluateAt(x), 1, 1e-10);
        assertTrue(c.inDomain(x));
      }

    }

    @Test public void testConstantToString(){
      double c = 3.24;
      assertEquals(new Constant(c).toString(), String.format("%f", c));
    }

    private double refPolynomial(double x){
      return (3*x*x*x-2*x*x+5*x-10);
    }

    @Test public void testCubicPolynomial(){
      CubicPolynomial p = new CubicPolynomial(3,-2,5,-10);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(p.evaluateAt(x), refPolynomial(x), 1e-10);
        assertTrue(p.inDomain(x));
      }

    }

    @Test public void testCubicPolynomialToString(){
      double a = 31.1;
      double b = -1.31;
      double c = 0.0;
      double d = 302.19;
      assertEquals(
          "CubicPolynomial.toString must return \"a*x^3+b*x^2+c*x+d\"",
          new CubicPolynomial(a,b,c,d).toString(), String.format("%f*x^3+%f*x^2+%f*x+%f", a,b,c,d));
    }

    @Test public void testSine(){
      Sine s = new Sine(3f,4f);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(s.evaluateAt(x), 3f*Math.sin(4f*x), 1e-10);
        assertTrue(s.inDomain(x));
      }

    }

    @Test public void testSineToString(){
      double a = 31.1;
      double f = -1.31;
      assertEquals(
          "Sine.toString must return \"a*sin(f*x)\"",
          new Sine(a,f).toString(), String.format("%f*sin(%f*x)", a,f));
    }


    @Test public void testCosine(){
      Cosine s = new Cosine(3f,4f);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(s.evaluateAt(x), 3f*Math.cos(4f*x), 1e-10);
        assertTrue(s.inDomain(x));
      }

    }

    @Test public void testCosineToString(){
      double a = 31.1;
      double f = -1.31;
      assertEquals(
          "Cosine.toString must return \"a*cos(f*x)\"",
          new Cosine(a,f).toString(), String.format("%f*cos(%f*x)", a,f));
    }

    @Test public void testExp(){
      Exp e = new Exp();

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(e.evaluateAt(x), Math.exp(x), 1e-10);
        assertTrue(e.inDomain(x));
      }

    }

    @Test public void testExpToString(){
      assertEquals(
          "Exp.toString must return \"e^x\"",
          new Exp().toString(), String.format("e^x"));
    }

    @Test public void testLog(){
      Log l = new Log();

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(l.inDomain(x), x > 0.0);

        if (l.inDomain(x))
          assertEquals(l.evaluateAt(x), Math.log(x), 1e-10);
      }

    }

    @Test public void testLogToString(){
      assertEquals(
          "Exp.toString must return \"ln(x)\"",
          new Log().toString(), String.format("ln(x)"));
    }

    @Test(expected = OutsideOfDomainException.class) 
    public void testLogOutsideOfDomain(){
      Log l = new Log();
      l.evaluateAt(-1);
    }

}
