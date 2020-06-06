
import org.junit.Test;
import static org.junit.Assert.*;

public class HouseTest {
    @Test public void testConstructor() {
      House house = new House("Lannister", "Casterly Rock");
      assertEquals(house.getName(), "Lannister");
      assertEquals(house.getSeat(), "Casterly Rock");
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testConstructor_nullName() {
      House house = new House(null, "Casterly Rock");
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testConstructor_emptyName() {
      House house = new House("", "Casterly Rock");
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testConstructor_nullSeat() {
      House house = new House("Lannister", null);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testConstructor_emptySeat() {
      House house = new House("Lannister", "");
    }

    @Test public void testToString(){
      House house = new House("Lannister", "Casterly Rock");
      String s = house.toString();

      assertTrue(s.contains("Lannister"));
      assertTrue(s.contains("Casterly Rock"));

    }

    @Test public void testEquals(){
      House house = new House("Lannister", "Casterly Rock");

      assertFalse(house.equals(null));
      assertFalse(house.equals("House"));
      assertFalse(house.equals(new House("Lannister", "Landshut")));
      assertFalse(house.equals(new House("Auer", "Casterly Rock")));
      assertTrue(house.equals(new House("Lannister", "Casterly Rock")));

    }

    @Test public void testEquals_null() {
      House lannister = new House("Lannister", "Casterly Rock");
      assertFalse(lannister.equals(null));
    }

    @Test public void testEquals_reflexivity() {
      House lannister = new House("Lannister", "Casterly Rock");
      assertTrue(lannister.equals(lannister));
    }

    @Test public void testEquals_equalHouses() {
      House lannister = new House("Lannister", "Casterly Rock");
      House lannisterClone = new House(new String("Lannister"), new String("Casterly Rock"));
      assertTrue(lannister.equals(lannisterClone));
    }

    @Test public void testEquals_differentCharacters() {
      House lannister = new House("Lannister", "Casterly Rock");
      House almostLannister = new House("Stark", "Casterly Rock");

      assertFalse(lannister.equals(almostLannister));

      almostLannister = new House("Lannister", "Casterly Rock'n'Roll");
      assertFalse(lannister.equals(almostLannister));
    }

    @Test public void testEquals_differentTypes() {
      House lannister = new House("Lannister", "Casterly Rock");
      assertFalse(lannister.equals("Lannister @ Casterly Rock"));
    }
}

