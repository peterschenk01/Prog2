import org.junit.Test;
import static org.junit.Assert.*;

public class LengthUnitTest {
    @Test public void testEnumMeterValues() {
      assertEquals(LengthUnit.MILLIMETER.getMeters()       , 1e-3,    1e-10);
      assertEquals(LengthUnit.CENTIMETER.getMeters()       , 1e-2,    1e-10);
      assertEquals(LengthUnit.METER.getMeters()            , 1,       1e-10);
      assertEquals(LengthUnit.KILOMETER.getMeters()        , 1e3,     1e-10);
      assertEquals(LengthUnit.ASTRONOMICAL_UNIT.getMeters(), 0.149e12,1e-10);
      assertEquals(LengthUnit.INCH.getMeters()             , 25.4e-3, 1e-10);
      assertEquals(LengthUnit.FOOT.getMeters()             , 0.305,   1e-10);
      assertEquals(LengthUnit.YARD.getMeters()             , 0.914,   1e-10);
    }

    @Test public void testEnumSymbols() {
      assertEquals(LengthUnit.MILLIMETER.getSymbol()       , "mm");
      assertEquals(LengthUnit.CENTIMETER.getSymbol()       , "cm");
      assertEquals(LengthUnit.METER.getSymbol()            , "m" );
      assertEquals(LengthUnit.KILOMETER.getSymbol()        , "km");
      assertEquals(LengthUnit.ASTRONOMICAL_UNIT.getSymbol(), "au");
      assertEquals(LengthUnit.INCH.getSymbol()             , "in");
      assertEquals(LengthUnit.FOOT.getSymbol()             , "ft");
      assertEquals(LengthUnit.YARD.getSymbol()             , "yd");
    }

    @Test public void testEnumSystem() {
      assertEquals(LengthUnit.MILLIMETER.isSI()       , true);
      assertEquals(LengthUnit.CENTIMETER.isSI()       , true);
      assertEquals(LengthUnit.METER.isSI()            , true);
      assertEquals(LengthUnit.KILOMETER.isSI()        , true);
      assertEquals(LengthUnit.ASTRONOMICAL_UNIT.isSI(), true);
      assertEquals(LengthUnit.INCH.isSI()             , false);
      assertEquals(LengthUnit.FOOT.isSI()             , false);
      assertEquals(LengthUnit.YARD.isSI()             , false);
    }
}

