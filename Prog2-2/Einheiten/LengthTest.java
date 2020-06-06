import org.junit.Test;
import static org.junit.Assert.*;

public class LengthTest {
    @Test public void testLength_initContructor() {
      var length = new Length(1.0, LengthUnit.METER);

      assertEquals(length.getValue(), 1.0, 1e-10);
      assertEquals(length.getUnit(), LengthUnit.METER);

      length = new Length(10.0, LengthUnit.ASTRONOMICAL_UNIT);
      assertEquals(length.getValue(), 10.0, 1e-10);
      assertEquals(length.getUnit(), LengthUnit.ASTRONOMICAL_UNIT);
    }

    @Test public void testLength_as() {
      var length = new Length(2.0, LengthUnit.METER);


      assertEquals(length.as(LengthUnit.INCH).getUnit(), LengthUnit.INCH);
      assertEquals(length.as(LengthUnit.INCH).getValue(), 78.74, 1e-2);
      assertEquals(length.as(LengthUnit.FOOT).getUnit(), LengthUnit.FOOT);
      assertEquals(length.as(LengthUnit.FOOT).getValue(), 6.56, 1e-2);
      assertEquals(length.as(LengthUnit.CENTIMETER).getUnit(), LengthUnit.CENTIMETER);
      assertEquals(length.as(LengthUnit.CENTIMETER).getValue(), 200, 1e-2);
      assertEquals(length.as(LengthUnit.YARD).getUnit(), LengthUnit.YARD);
      assertEquals(length.as(LengthUnit.YARD).getValue(), 2.18, 1e-2);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testLength_addNullArg() {
      var length = new Length(2.0, LengthUnit.METER);
      length.add(null);
    }

    @Test public void testLength_add() {
      var toAdd = new Length(2.0, LengthUnit.METER);

      for (var unit : LengthUnit.values()){
        var length = new Length(1.0, unit);
        var sum = length.add(toAdd);

        assertFalse(sum == length);
        assertFalse(toAdd == length);

        assertEquals(sum.getUnit(), length.getUnit());
        assertEquals(sum.getValue(), (toAdd.getValue() * LengthUnit.METER.getMeters())/unit.getMeters() + length.getValue(), 1e-10);
      }
    }

}
