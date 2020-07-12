package gameslib;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class GameTest {

  private Platform ns;
  private Platform xboxOne;

  @Before
  public void before_createPlatform(){
    ns = new Platform("Switch", "Nintendo");
    xboxOne = new Platform("Xbox", "Microsoft");
  }

  @Test
  public void test_constructor(){
    Game celeste = new Game("Celeste", Genre.PLATFORMER, ns, 2018, 92);

    assertEquals(celeste.getName(), "Celeste");
    assertEquals(celeste.getGenre(), Genre.PLATFORMER);
    assertEquals(celeste.getPlatform(), ns);
    assertEquals(celeste.getReleaseYear(), 2018);
    assertEquals(celeste.getMetacriticScore(), 92);

  }

  @Test(expected = IllegalArgumentException.class)
  public void test_constructorNullName(){
    new Game(null, Genre.PLATFORMER, ns, 2018, 92);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_constructorEmptyName(){
    new Game("", Genre.PLATFORMER, ns, 2018, 92);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_constructorNullGenre(){
    new Game("Celeste", null, ns, 2018, 92);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_constructorNullPlatform(){
    new Game("Celeste", Genre.PLATFORMER, null, 2018, 92);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_constructorInvalidReleaseYear(){
    new Game("Celeste", Genre.PLATFORMER, ns, 1969, 92);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_constructorInvalidMetacriticScore(){
    new Game("Celeste", Genre.PLATFORMER, ns, 2018, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_constructorInvalidMetacriticScore2(){
    new Game("Celeste", Genre.PLATFORMER, ns, 2018, 101);
  }

  @Test
  public void test_compareToCorrectness(){
    Game celeste = new Game("Celeste", Genre.PLATFORMER, ns, 2018, 92);

    // all attributes equal
    Game other = new Game("Celeste", Genre.PLATFORMER, ns, 2018, 92);
    assertTrue(celeste.compareTo(other) == 0);
    assertTrue(other.compareTo(celeste) == 0);

    // 1. Name
    other = new Game("Beleste", Genre.PLATFORMER, ns, 2018, 92);
    assertTrue(celeste.compareTo(other) > 0);
    assertTrue(other.compareTo(celeste) < 0);

    // 2. Genre
    other = new Game("Celeste", Genre.ADVENTURE, ns, 2018, 92);
    assertTrue(celeste.compareTo(other) > 0);
    assertTrue(other.compareTo(celeste) < 0);

    other = new Game("Deleste", Genre.ADVENTURE, ns, 2018, 92);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);

    // 3. Platform
    other = new Game("Celeste", Genre.PLATFORMER, xboxOne, 2018, 92);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);

    other = new Game("Deleste", Genre.PLATFORMER, xboxOne, 2018, 92);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);

    other = new Game("Celeste", Genre.SHOOTER, xboxOne, 2018, 92);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);

    // 4. Release Year
    other = new Game("Celeste", Genre.PLATFORMER, ns, 2019, 92);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);
other = new Game("Deleste", Genre.PLATFORMER, ns, 2019, 92);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);

    other = new Game("Celeste", Genre.PUZZLE, ns, 2019, 92);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);

    other = new Game("Celeste", Genre.PLATFORMER, xboxOne, 2019, 92);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);
    
    // 5. Metacritic Score
    other = new Game("Celeste", Genre.PLATFORMER, ns, 2018, 93);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);

    other = new Game("Deleste", Genre.PLATFORMER, ns, 2018, 91);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);

    other = new Game("Celeste", Genre.PUZZLE, ns, 2018, 91);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);

    other = new Game("Celeste", Genre.PLATFORMER, xboxOne, 2018, 91);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);

    other = new Game("Celeste", Genre.PLATFORMER, ns, 2019, 91);
    assertTrue(celeste.compareTo(other) < 0);
    assertTrue(other.compareTo(celeste) > 0);
    
  }

  @Test
  public void test_compareToEqualsConsistency(){
    Game celeste = new Game("Celeste", Genre.PLATFORMER, ns, 2018, 92);
    Game other1 = new Game("Celeste", Genre.PLATFORMER, ns, 2018, 92);
    Game other2 = new Game("Deleste", Genre.PLATFORMER, ns, 2018, 92);
    Game other3 = new Game("Celeste", Genre.SHOOTER, ns, 2018, 92);
    Game other4 = new Game("Celeste", Genre.PLATFORMER, xboxOne, 2018, 92);
    Game other5 = new Game("Celeste", Genre.PLATFORMER, ns, 2019, 92);
    Game other6 = new Game("Celeste", Genre.PLATFORMER, ns, 2019, 93);

    Game[] others = new Game[] {other1, other2, other3, other4, other5, other6};

    for (Game other : others){
      assertEquals(celeste.compareTo(other) == 0, celeste.equals(other));
      assertEquals(other.compareTo(celeste) == 0, other.equals(celeste));
    }

  }

  @Test(expected = IllegalArgumentException.class)
  public void test_compareToNull(){
    Game celeste = new Game("Celeste", Genre.PLATFORMER, ns, 2018, 92);
    celeste.compareTo(null);
  }

}

