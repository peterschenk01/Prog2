import org.junit.Test;
import static org.junit.Assert.*;

public class MagicSquareTest {
    @Test public void testGetExample() {
      int[][] example = MagicSquare.getExample();
      assertEquals(example.length, 3);

      for (var row : example)
        assertEquals(row.length, 3);

      assertEquals(example[0][0], 8);
      assertEquals(example[0][1], 1);
      assertEquals(example[0][2], 6);
      assertEquals(example[1][0], 3);
      assertEquals(example[1][1], 5);
      assertEquals(example[1][2], 7);
      assertEquals(example[2][0], 4);
      assertEquals(example[2][1], 9);
      assertEquals(example[2][2], 2);
    }

    private int[][] getDuerer(){
      int duerer[][] = new int[4][4];
      // manual initialization to not give away solution for getExample
      duerer[0][0] = 16;
      duerer[0][1] = 3;
      duerer[0][2] = 2;
      duerer[0][3] = 13;
      duerer[1][0] = 5;
      duerer[1][1] = 10;
      duerer[1][2] = 11;
      duerer[1][3] = 8;
      duerer[2][0] = 9;
      duerer[2][1] = 6;
      duerer[2][2] = 7;
      duerer[2][3] = 12;
      duerer[3][0] = 4;
      duerer[3][1] = 15;
      duerer[3][2] = 14;
      duerer[3][3] = 1;

      return duerer;
    }

    @Test public void testIsMagic(){
    int[][] duerer = getDuerer();

      assertTrue(MagicSquare.isMagic(duerer));
    }

    @Test public void testIsMagicOffDiagonal(){
      int[][] duerer = getDuerer();
      // change something off-diagonal
      duerer[0][1]--;
      assertFalse(MagicSquare.isMagic(duerer));


    }
    
    @Test public void testIsMagicDiagonal(){
      int[][] duerer = getDuerer();
      // change diagonal element but make make row and column sums match
      duerer[1][1] += 5;
      duerer[1][2] -= 5;
      duerer[2][1] -= 5;
      assertFalse(MagicSquare.isMagic(duerer));
    }

    @Test public void testIsMagicAntidiagonal(){
      int[][] duerer = getDuerer();
      // change antidiagonal element but make make row and column sums match
      duerer[1][2] += 5;
      duerer[0][2] -= 5;
      duerer[1][3] -= 5;
      assertFalse(MagicSquare.isMagic(duerer));
    }

    @Test public void testIsMagicEmpty(){
      int[][] empty = new int[0][0];
      assertTrue(MagicSquare.isMagic(empty));
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testIsMagicNull(){
      MagicSquare.isMagic(null);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testIsMagicNonQuadraticButSquare(){
      int[][] nonQuadratic = new int[4][3];
      MagicSquare.isMagic(nonQuadratic);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testIsMagicNonQuadraticNonSquare(){
      int[][] nonSquare = new int[4][];
      nonSquare[0] = new int[4];
      nonSquare[1] = new int[4];
      nonSquare[2] = new int[4];
      nonSquare[3] = new int[5];

      MagicSquare.isMagic(nonSquare);
    }

}
