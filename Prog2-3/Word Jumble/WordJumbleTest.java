import org.junit.Test;
import static org.junit.Assert.*;

public class WordJumbleTest {

  private String jumbleWord(String word){
    StringBuilder builder = new StringBuilder();
    WordJumble.jumbleWord(word, builder);
    return builder.toString();
  }


  @Test public void jumbleWord_shortWord(){
    assertEquals(jumbleWord(""), "");
    assertEquals(jumbleWord("a"), "a");
    assertEquals(jumbleWord("as"), "as");
    assertEquals(jumbleWord("das"), "das");
  }

  @Test public void jumbleWord_longWords(){
    assertEquals(jumbleWord("Test"), "Tset");
    assertEquals(jumbleWord("Programmieren"), "Porrgmaimreen");
    assertEquals(jumbleWord("Donaudampfschifffahrtskapitaen"), "Dnouaadpmsfhcfiffhatrkspatiean");
                
  }

}
