package gameslib;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlatformTest {

  @Test public void test_constructor(){
    Platform ns = new Platform("Switch", "Nintendo");

    assertEquals(ns.getName(), "Switch");
    assertEquals(ns.getCompany(), "Nintendo");
  }

  @Test(expected = IllegalArgumentException.class) 
  public void test_constructorNullName(){
    new Platform(null, "Nintendo");
  }

  @Test(expected = IllegalArgumentException.class) 
  public void test_constructorEmptyName(){
    new Platform("", "Nintendo");
  }

  @Test(expected = IllegalArgumentException.class) 
  public void test_constructorNullCompany(){
    new Platform("Switch", null);
  }

  @Test(expected = IllegalArgumentException.class) 
  public void test_constructorEmptyCompany(){
    new Platform("Switch", "");
  }

  @Test public void test_equals(){
    Platform ns = new Platform("Switch", "Nintendo");
    Platform ns2 = new Platform("Switch", "Nintendo");
    Platform ns3 = new Platform("Switch", "SEGA");
    Platform wii = new Platform("Wii", "Nintendo");

    assertFalse(ns.equals(null));
    assertTrue(ns.equals(ns));
    assertTrue(ns.equals(ns2));
    assertFalse(ns.equals(ns3));
    assertFalse(ns.equals(wii));
  }

  @Test public void test_compareTo(){
    Platform ns = new Platform("Switch", "Nintendo");
    Platform ns2 = new Platform("Switch", "Nintendo");
    Platform ns3 = new Platform("Switch", "SEGA");
    Platform wii = new Platform("Wii", "Nintendo");

    assertTrue(ns.compareTo(ns2) == 0);
    assertTrue(ns.compareTo(ns3) < 0);
    assertTrue(ns3.compareTo(ns) > 0);
    assertTrue(ns.compareTo(wii) < 0);
    assertTrue(wii.compareTo(ns) > 0);
  }
}
