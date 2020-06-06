
import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterTest {
    @Test public void testConstructor() {
      House lannister = new House("Lannister", "Casterly Rock");
      Character jamie = new Character("Jamie", lannister, true, 76);
      assertEquals(jamie.getHouse(), lannister);
      assertEquals(jamie.getName(), "Jamie");
      assertEquals(jamie.getAlive(), true);
      assertEquals(jamie.getMother(), null);
      assertEquals(jamie.getFather(), null);
      assertEquals(jamie.getFightSkills(), 76);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testConstructor_nameNull() {
      House lannister = new House("Lannister", "Casterly Rock");
      Character jamie = new Character(null, lannister, true, 76);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testConstructor_nameEmpty() {
      House lannister = new House("Lannister", "Casterly Rock");
      Character jamie = new Character("", lannister, true, 76);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testConstructor_toLowFightSkills() {
      House lannister = new House("Lannister", "Casterly Rock");
      Character jamie = new Character("Jamie", lannister, true, -1);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testConstructor_toLargeFightSkills() {
      House lannister = new House("Lannister", "Casterly Rock");
      Character jamie = new Character("Jamie", lannister, true, 124);
    }
  
    @Test public void testCopyConstructor(){
      House lannister = new House("Lannister", "Casterly Rock");
      Character jamie = new Character("Jamie", lannister, true, 29);
      Character clone = new Character(jamie);

      assertEquals(jamie, clone);
    }

    private House createLannister(){
      return new House("Lannister", "Casterly Rock");
    }

    private Character createJamie(House house){
      return new Character("Jamie", house, true, 65);
    }

    private Character createCersei(House house){
      return new Character("Cersei", house, true, 30);
    }

    @Test public void testBirthConstructor(){
      House lannister = createLannister();
      Character jamie = createJamie(lannister);
      Character cersei = createCersei(lannister);

      Character joffrey = new Character("Joffrey", cersei, jamie);

      assertEquals(joffrey.getName(), "Joffrey");
      assertEquals(joffrey.getHouse(), lannister);
      assertEquals(joffrey.getFightSkills(), 48);
      assertEquals(joffrey.getFather(), jamie);
      assertEquals(joffrey.getMother(), cersei);
    }

    @Test public void testBirthConstructor_rightHouse(){
      House lannister = createLannister();
      Character jamie = createJamie(lannister);
      Character cersei = createCersei(null);

      Character joffrey = new Character("Joffrey", cersei, jamie);

      assertEquals(joffrey.getHouse(), jamie.getHouse());
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testBirthConstructor_nullName() {
      House lannister = createLannister();
      Character jamie = createJamie(lannister);
      Character cersei = createCersei(lannister);
      Character joffrey = new Character(null, cersei, jamie);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testBirthConstructor_emptyName() {
      House lannister = createLannister();
      Character jamie = createJamie(lannister);
      Character cersei = createCersei(lannister);
      Character joffrey = new Character("", cersei, jamie);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testBirthConstructor_nullFather() {
      House lannister = createLannister();
      Character jamie = createJamie(lannister);
      Character joffrey = new Character("Joffrey", null, jamie);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testBirthConstructor_nullMother() {
      House lannister = createLannister();
      Character cersei = createCersei(lannister);
      Character joffrey = new Character("Joffrey", cersei, null);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testBirthConstructor_equalMotherFather() {
      House lannister = createLannister();
      Character cersei = createCersei(lannister);
      Character joffrey = new Character("Joffrey", cersei, new Character(cersei));
    }


    @Test(expected = IllegalArgumentException.class) 
    public void testBirthConstructor_deadFather() {
      House lannister = createLannister();
      Character jamie = createJamie(lannister);
      jamie.setAlive(false);
      Character cersei = createCersei(lannister);
      Character joffrey = new Character("Joffrey", cersei, jamie);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testBirthConstructor_deadMother() {
      House lannister = createLannister();
      Character jamie = createJamie(lannister);
      Character cersei = createCersei(lannister);
      cersei.setAlive(false);
      Character joffrey = new Character("Joffrey", cersei, jamie);
    }

    @Test public void testFight(){
      House lannister = createLannister();
      House clegane = new House("Clegane", "Clegane's Keep");
      Character hound = new Character("The Hound", clegane, true, 99);
      Character redShirtKnight = new Character("Red Shirt Knight", null, true, 10);

      hound.fight(redShirtKnight);

      assertFalse(redShirtKnight.getAlive());
      assertTrue(hound.getAlive());
    }

    @Test public void testFight2(){
      House clegane = new House("Clegane", "Clegane's Keep");
      Character hound = new Character("The Hound", clegane, true, 99);
      Character redShirtKnight = new Character("Red Shirt Knight", null, true, 10);

      redShirtKnight.fight(hound);

      assertFalse(redShirtKnight.getAlive());
      assertTrue(hound.getAlive());
    }

    @Test public void testToString(){
      House lannister = createLannister();
      Character jamie = createJamie(lannister);
      String s = jamie.toString();

      assertTrue(s.contains("Jamie"));
      assertTrue(s.contains("Lannister"));
      assertTrue(s.contains("65"));

    }


    @Test(expected = IllegalArgumentException.class) 
    public void testFight_nullOpponent(){
      House clegane = new House("Clegane", "Clegane's Keep");
      Character hound = new Character("The Hound", clegane, true, 99);

      hound.fight(null);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testFight_deadOpponent(){
      House clegane = new House("Clegane", "Clegane's Keep");
      Character hound = new Character("The Hound", clegane, true, 99);

      hound.fight(new Character("Dead Knight", null, false, 10));
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testFight_deadCharacter(){
      House clegane = new House("Clegane", "Clegane's Keep");
      Character hound = new Character("The Hound", clegane, false, 99);

      hound.fight(new Character("Dead Knight", null, true, 10));
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testFight_sameCharacter(){
      House clegane = new House("Clegane", "Clegane's Keep");
      Character hound = new Character("The Hound", clegane, false, 99);

      hound.fight(hound);
    }

    @Test public void testEquals_null() {
      House lannister = createLannister();
      Character jamie = createJamie(lannister);
      assertFalse(jamie.equals(null));
    }

    @Test public void testEquals_reflexivity() {
      House lannister = createLannister();
      Character jamie = createJamie(lannister);
      assertTrue(jamie.equals(jamie));
    }

    @Test public void testEquals_equalCharacters() {
      House lannister = createLannister();
      House lannisterClone = createLannister();
      Character jamie = createJamie(lannister);
      Character jamieClone = new Character(new String("Jamie"), lannisterClone, true, 65);
      assertTrue(jamie.equals(jamieClone));
    }

    @Test public void testEquals_differentCharacters() {
      House lannister = createLannister();
      House clegane = new House("Clegane", "Clegane's Keep");
      Character jamie = createJamie(lannister);

      Character almostJamie = new Character("Jamie James", lannister, true, 65);
      assertFalse(jamie.equals(almostJamie));

      almostJamie = new Character("Jamie", clegane, true, 65);
      assertFalse(jamie.equals(almostJamie));

      almostJamie = new Character("Jamie", lannister, false, 65);
      assertFalse(jamie.equals(almostJamie));

      almostJamie = new Character("Jamie", lannister, true, 63);
      assertFalse(jamie.equals(almostJamie));
    }
    @Test public void testEquals_differentTypes() {
      House lannister = createLannister();
      Character jamie = createJamie(lannister);

      assertFalse(jamie.equals("It's me, Jamie! I swear!"));


    }
    
    

}


