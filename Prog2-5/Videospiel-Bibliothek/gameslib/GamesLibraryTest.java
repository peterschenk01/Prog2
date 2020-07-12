package gameslib;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GamesLibraryTest {

  private GamesLibrary lib;
  private Platform ns;
  private Platform ps4;
  private Platform pc;
  private Game celeste;
  private List<Game> ps4Games;
  private List<Game> pcGames;
  private List<Game> nsGames;
  private Platform ps2;

  @Before
  public void before_createLib(){
    lib = new GamesLibrary();

    ns = new Platform("Switch", "Nintendo");
    ps4 = new Platform("Playstation 4", "Sony");
    pc = new Platform("PC", "n/a");
    ps2 = new Platform("Playstation 2", "Sony");

    lib.addPlatform(ns);
    lib.addPlatform(ps4);
    lib.addPlatform(pc);

    celeste = new Game("Celeste", Genre.PLATFORMER, pc, 2018, 92);

    ps4Games = new ArrayList<Game>();
    pcGames = new ArrayList<Game>();
    nsGames = new ArrayList<Game>();

    // Top 50 Metacritic for PC
    pcGames.add(new Game("Grand Theft Auto V", Genre.ACTION, pc, 2015, 96));
    pcGames.add(new Game("The Orange Box", Genre.SHOOTER, pc, 2007, 96));
    pcGames.add(new Game("Half-Life", Genre.SHOOTER, pc, 1998, 96));
    pcGames.add(new Game("BioShock", Genre.SHOOTER, pc, 2007, 96));
    pcGames.add(new Game("Baldur's Gate II: Shadows of Amn", Genre.ROLE_PLAYING_GAME, pc, 2000, 95));
    pcGames.add(new Game("Portal 2", Genre.PUZZLE, pc, 2011, 95));
    pcGames.add(new Game("The Elder Scrolls V: Skyrim", Genre.ROLE_PLAYING_GAME, pc, 2011, 94));
    pcGames.add(new Game("Mass Effect 2", Genre.ACTION, pc, 2010, 94));
    pcGames.add(new Game("Grand Theft Auto: Vice City", Genre.ACTION, pc, 2003, 94));
    pcGames.add(new Game("Sid Meier's Civilization II", Genre.STRATEGY, pc, 1996, 94));
    pcGames.add(new Game("Quake", Genre.SHOOTER, pc, 1996, 94));
    pcGames.add(new Game("BioShock Infinite", Genre.SHOOTER, pc, 2013, 94));
    pcGames.add(new Game("The Elder Scrolls IV: Oblivion", Genre.ROLE_PLAYING_GAME, pc, 2006, 94));
    pcGames.add(new Game("Grim Fandango", Genre.ADVENTURE, pc, 1998, 94));
    pcGames.add(new Game("Diablo", Genre.ROLE_PLAYING_GAME, pc, 1996, 94));
    pcGames.add(new Game("Sid Meier's Civilization IV", Genre.STRATEGY, pc, 2005, 94));
    pcGames.add(new Game("The Witcher 3: Wild Hunt", Genre.ROLE_PLAYING_GAME, pc, 2015, 93));
    pcGames.add(new Game("Company of Heroes", Genre.STRATEGY, pc, 2006, 93));
    pcGames.add(new Game("Half-Life: Alyx", Genre.ACTION, pc, 2020, 93));
    pcGames.add(new Game("Divinity: Original Sin II", Genre.ROLE_PLAYING_GAME, pc, 2017, 93));
    pcGames.add(new Game("Unreal Tournament 2004", Genre.SHOOTER, pc, 2004, 93));
    pcGames.add(new Game("Starcraft II: Wings of Liberty", Genre.STRATEGY, pc, 2010, 93));
    pcGames.add(new Game("Minecraft", Genre.BUILDING, pc, 2011, 93));
    pcGames.add(new Game("Red Dead Redemption 2", Genre.ACTION, pc, 2019, 93));
    pcGames.add(new Game("Grand Theft Auto III", Genre.ACTION, pc, 2002, 93));
    pcGames.add(new Game("Homeworld", Genre.STRATEGY, pc, 1999, 93));
    pcGames.add(new Game("Star Wars: Knights of the Old Republic", Genre.ROLE_PLAYING_GAME, pc, 2003, 93));
    pcGames.add(new Game("World of Warcraft", Genre.ROLE_PLAYING_GAME, pc, 2004, 93));
    pcGames.add(new Game("Grand Theft Auto: San Andreas", Genre.ACTION, pc, 2005, 93));
    pcGames.add(new Game("Call of Duty 4: Modern Warfare", Genre.ACTION, pc, 2007, 92));
    pcGames.add(new Game("Warcraft III: Reign of Chaos", Genre.STRATEGY, pc, 2002, 92));
    pcGames.add(new Game("Sid Meier's Gettysburg!", Genre.STRATEGY, pc, 1997, 92));
    pcGames.add(new Game("Team Fortress 2", Genre.SHOOTER, pc, 2007, 92));
    pcGames.add(new Game("System Shock 2", Genre.ACTION, pc, 1999, 92));
    pcGames.add(new Game("Tom Clancy's Splinter Cell: Chaos Theory", Genre.ACTION, pc, 2005, 92));
    pcGames.add(new Game("Rome: Total War", Genre.STRATEGY, pc, 2004, 92));
    pcGames.add(new Game("Okami HD", Genre.ADVENTURE, pc, 2017, 92));
    pcGames.add(new Game("Undertale", Genre.ROLE_PLAYING_GAME, pc, 2015, 92));
    pcGames.add(new Game("Thief: The Dark Project", Genre.ACTION, pc, 1998, 92));
    pcGames.add(new Game("Age of Empires II: The Age of Kings", Genre.STRATEGY, pc, 1999, 92));
    pcGames.add(new Game("Unreal Tournament (1999)", Genre.SHOOTER, pc, 1999, 92));
    pcGames.add(new Game("Sid Meier's Alpha Centauri", Genre.STRATEGY, pc, 1999, 92));
    pcGames.add(new Game("Galactic Civilizations II: Twilight of the Arnor", Genre.STRATEGY, pc, 2008, 92));
    pcGames.add(new Game("Out of the Park Baseball 17", Genre.SPORT, pc, 2016, 92));
    pcGames.add(new Game("The Witcher 3: Wild Hunt - Blood and Wine", Genre.ROLE_PLAYING_GAME, pc, 2016, 92));
    pcGames.add(new Game("Tiger Woods PGA Tour 2003", Genre.SPORT, pc, 2002, 92));
    pcGames.add(new Game("Dishonored", Genre.ACTION, pc, 2012, 91));
    pcGames.add(new Game("Medal of Honor: Allied Assault", Genre.SHOOTER, pc, 2002, 91));
    pcGames.add(new Game("Myth: The Fallen Lords", Genre.ADVENTURE, pc, 1997, 91));
    pcGames.add(new Game("World of Warcraft: Wrath of the Lich King", Genre.ROLE_PLAYING_GAME, pc, 2008, 91));

    
    // Top 20 Metacritic for Nintendo Switch
    nsGames.add( new Game("The Legend of Zelda: Breath of the Wild", Genre.ADVENTURE, ns, 2017, 97) );
    nsGames.add( new Game("Super Mario Odyssey", Genre.PLATFORMER, ns, 2017, 97) );
    nsGames.add( new Game("Divinity: Original Sin II - Definitive Edition", Genre.ROLE_PLAYING_GAME, ns, 2019, 93) );
    nsGames.add( new Game("Undertale", Genre.ROLE_PLAYING_GAME, ns, 2018, 93) );
    nsGames.add( new Game("Super Smash Bros. Ultimate", Genre.PLATFORMER, ns, 2018, 93) );
    nsGames.add( new Game("Celeste", Genre.PLATFORMER, ns, 2018, 92) );
    nsGames.add( new Game("Bayonetta 2", Genre.ACTION, ns, 2018, 92) );
    nsGames.add( new Game("Mario Kart 8 Deluxe", Genre.SPORT, ns, 2017, 92) );
    nsGames.add( new Game("INSIDE", Genre.ACTION, ns, 2018, 91) );
    nsGames.add( new Game("Dragon Quest XI S: Echoes of an Elusive Age - Definitive Edition", Genre.ROLE_PLAYING_GAME, ns, 2019, 91) );
    nsGames.add( new Game("Sonic Mania Plus", Genre.PLATFORMER, ns, 2018, 91) );
    nsGames.add( new Game("SteamWorld Heist: Ultimate Edition", Genre.STRATEGY, ns, 2017, 91) );
    nsGames.add( new Game("Shovel Knight: Treasure Trove", Genre.PLATFORMER, ns, 2017, 91) );
    nsGames.add( new Game("Animal Crossing: New Horizons", Genre.BUILDING, ns, 2020, 91) );
    nsGames.add( new Game("Bastion", Genre.ACTION, ns, 2018, 90) );
    nsGames.add( new Game("Hollow Knight", Genre.METROIDVANIA, ns, 2018, 90) );
    nsGames.add( new Game("Ori and the Blind Forest: Definitive Edition", Genre.METROIDVANIA, ns, 2019, 90) );
    nsGames.add( new Game("Bayonetta + Bayonetta 2", Genre.ACTION, ns, 2018, 90) );
    nsGames.add( new Game("Dead Cells", Genre.ACTION, ns, 2018, 89) );


    // Top 30 Metacritic for PS4
    ps4Games.add( new Game("Red Dead Redemption 2", Genre.ACTION, ps4, 2018, 97 ) );
    ps4Games.add( new Game("Grand Theft Auto V", Genre.ACTION, ps4, 2014, 97 ) );
    ps4Games.add( new Game("The Last of Us Part II", Genre.ACTION, ps4, 2020, 96 ) );
    ps4Games.add( new Game("Persona 5 Royal", Genre.ACTION, ps4, 2020, 95 ) );
    ps4Games.add( new Game("The Last of Us Remastered", Genre.ACTION, ps4, 2014, 95 ) );
    ps4Games.add( new Game("God of War", Genre.ACTION, ps4, 2018, 94 ) );
    ps4Games.add( new Game("Persona 5", Genre.ACTION, ps4, 2017, 93 ) );
    ps4Games.add( new Game("Metal Gear Solid V: The Phantom Pain", Genre.ACTION, ps4, 2015, 93 ) );
    ps4Games.add( new Game("Uncharted 4: A Thief's End", Genre.ACTION, ps4, 2016, 93 ) );
    ps4Games.add( new Game("Journey", Genre.ACTION, ps4, 2015, 92 ) );
    ps4Games.add( new Game("Bloodborne", Genre.ACTION, ps4, 2015, 92 ) );
    ps4Games.add( new Game("Undertale", Genre.ACTION, ps4, 2017, 92 ) );
    ps4Games.add( new Game("The Witcher 3: Wild Hunt", Genre.ACTION, ps4, 2015, 92 ) );
    ps4Games.add( new Game("Divinity: Original Sin II - Definitive Edition", Genre.ACTION, ps4, 2018, 92 ) );
    ps4Games.add( new Game("Final Fantasy XIV: Shadowbringers", Genre.ACTION, ps4, 2019, 91 ) );
    ps4Games.add( new Game("Shadow of the Colossus", Genre.ACTION, ps4, 2018, 91 ) );
    ps4Games.add( new Game("The Witcher 3: Wild Hunt - Blood and Wine", Genre.ACTION, ps4, 2016, 91 ) );
    ps4Games.add( new Game("Celeste", Genre.ACTION, ps4, 2018, 91 ) );
    ps4Games.add( new Game("INSIDE", Genre.ACTION, ps4, 2016, 91 ) );
    ps4Games.add( new Game("NieR: Automata - Game of the YoRHa Edition", Genre.ACTION, ps4, 2019, 91 ) );
    ps4Games.add( new Game("Resident Evil 2", Genre.ACTION, ps4, 2019, 91 ) );
    ps4Games.add( new Game("flower", Genre.ACTION, ps4, 2013, 91 ) );
    ps4Games.add( new Game("Diablo III: Ultimate Evil Edition", Genre.ACTION, ps4, 2014, 90 ) );
    ps4Games.add( new Game("Overwatch", Genre.ACTION, ps4, 2016, 90 ) );
    ps4Games.add( new Game("Shovel Knight", Genre.ACTION, ps4, 2015, 90 ) );
    ps4Games.add( new Game("Rayman Legends", Genre.ACTION, ps4, 2014, 90 ) );
    ps4Games.add( new Game("Fez", Genre.ACTION, ps4, 2014, 90 ) );
    ps4Games.add( new Game("Monster Hunter: World", Genre.ACTION, ps4, 2018, 90 ) );
    ps4Games.add( new Game("Tales From The Borderlands: Episode 5 - The Vault of the Traveler", Genre.ACTION, ps4, 2015, 90 ) );
    ps4Games.add( new Game("The Witcher 3: Wild Hunt - Hearts of Stone", Genre.ACTION, ps4, 2015, 90 ) );

    // add all games to library
    pcGames.forEach( game -> lib.addGame(game) );
    nsGames.forEach( game -> lib.addGame(game) );
    ps4Games.forEach( game -> lib.addGame(game) );

  }
  @Test
  public void test_addPlatform(){
    
    GamesLibrary lib = new GamesLibrary();

    lib.addPlatform(ps2);

    assertTrue(lib.getPlatformsReadOnly().contains(ps2));
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_addPlatformNull(){
    lib.addPlatform(null);
  }

  @Test(expected = GamesLibraryException.class)
  public void test_addPlatformDuplicate(){
    lib.addPlatform(ns);
  }

  @Test
  public void test_removePlatform(){
    lib.removePlatform(ns);
    assertFalse(lib.getPlatformsReadOnly().contains(ns));
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_removePlatformNull(){
    lib.removePlatform(null);
  }

  
  @Test
  public void test_removePatformWithGames(){
    lib.removePlatform(ps4);

    ps4Games.forEach( game -> assertFalse( "removePlatform: The games of a platform must be removed along with the platform.", 
          lib.getGamesReadOnly().contains(game) ) );
  }

  @Test
  public void test_addGame(){
    lib.addGame(celeste);

    assertTrue(lib.getGamesReadOnly().contains(celeste));
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_addGameNull(){
    lib.addGame(null);
  }

  @Test(expected = GamesLibraryException.class)
  public void test_addGameInvalidPlatform(){
    
    // Okami was originally released on the PS2
    Game okami = new Game("Okami", Genre.ADVENTURE, ps2, 2006, 93);

    lib.addGame(okami);
  }

  @Test(expected = GamesLibraryException.class)
  public void test_addGameDuplicate(){
    Game game = ps4Games.get(0);
    lib.addGame(game);
  }

  @Test
  public void test_removeGame(){
    lib.removeGame(ps4Games.get(0));
    assertFalse(lib.getGamesReadOnly().contains(ps4Games.get(0)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_removeGameNull(){
    lib.removeGame(null);
  }

  @Test(expected = GamesLibraryException.class)
  public void test_removeGameNotInLib(){
    lib.removeGame(celeste);
  }

  @Test
  public void test_getPlatformsReadOnly(){

    Set<Platform> platforms = lib.getPlatformsReadOnly();

    assertNotNull(platforms);

    assertEquals(platforms.size(), 3);

    // check right order: games must be ordered according to
    // Platform.compareTo()
    Iterator<Platform> it = platforms.iterator();
    assertEquals( pc, it.next() );
    assertEquals( ps4, it.next() );
    assertEquals( ns, it.next() );

  }

  @Test(expected = UnsupportedOperationException.class)
  public void test_getPlatformsReadOnlyReallyReadOnly(){
    Set<Platform> platforms = lib.getPlatformsReadOnly();
    platforms.add(ps2);
  }

  @Test
  public void test_getGamesReadonly(){
    Set<Game> games = lib.getGamesReadOnly();

    assertNotNull(games);

    Set<Game> gamesSorted = new TreeSet<Game>();
    gamesSorted.addAll(ps4Games);
    gamesSorted.addAll(pcGames);
    gamesSorted.addAll(nsGames);

    assertEquals(gamesSorted.size(), games.size());

    // check if games are sorted according to Game.compareTo
    // This simple test assumes that Game.compareTo is correct
    // (tested in GameTest)
    for ( Iterator<Game> i1 = games.iterator(), i2 = gamesSorted.iterator(); i1.hasNext() && i2.hasNext(); ){
      assertEquals(i1.next(), i2.next());
    }
  }

  @Test(expected = UnsupportedOperationException.class)
  public void test_getGamesReadonlyReallyReadOnly(){
    Set<Game> games = lib.getGamesReadOnly();
    games.add(celeste);

  }

  @Test
  public void test_getBestGame(){
    // add a new best game with perfect score
    // of course it's Okami for the Switch
    Game okami = new Game("Okami", Genre.ACTION, ns, 2018, 100 );
    lib.addGame(okami);

    assertEquals(okami, lib.getBestGame());

  }

  @Test
  public void test_getGenreCount(){
    Map<Genre, Integer> genreCount = lib.getGenreCount();

    assertEquals((int) genreCount.get(Genre.ACTION), 47);
    assertEquals((int) genreCount.get(Genre.METROIDVANIA), 2);
    assertEquals((int) genreCount.get(Genre.ROLE_PLAYING_GAME), 14);

  }

  @Test
  public void test_getGamesForPlatform(){
    Map<Platform,Set<Game>> gamesForPlatform = lib.getGamesForPlatform();

    assertEquals(ps4Games.size(), gamesForPlatform.get(ps4).size());
    assertTrue(ps4Games.containsAll(gamesForPlatform.get(ps4)));
    assertEquals(nsGames.size(), gamesForPlatform.get(ns).size());
    assertTrue(nsGames.containsAll(gamesForPlatform.get(ns)));
    assertEquals(pcGames.size(), gamesForPlatform.get(pc).size());
    assertTrue(pcGames.containsAll(gamesForPlatform.get(pc)));
  }

  @Test
  public void test_getAverageScoreForPlatform(){

    Map<Platform, Double> scoreForPlatform = lib.getAverageScoreForPlatform();

    assertEquals(92.0333, scoreForPlatform.get(ps4), 1e-03);
    assertEquals(91.7894, scoreForPlatform.get(ns), 1e-03);
    assertEquals(93.02, scoreForPlatform.get(pc), 1e-03);
  }

  @Test
  public void test_getBestPlatform(){
    assertEquals(pc, lib.getBestPlatform());
  }

  @Test
  public void test_sortGamesByMetacriticScore(){
    List<Game> top = lib.sortGamesByMetacriticScore();


    assertEquals(top.size(), ps4Games.size() + nsGames.size(), + pcGames.size());

    assertTrue(top.containsAll(ps4Games));
    assertTrue(top.containsAll(nsGames));
    assertTrue(top.containsAll(pcGames));

    for (int i = 0; i < top.size()-1; i++){

      assertTrue(top.get(i).getMetacriticScore() >= top.get(i+1).getMetacriticScore());

    }

  }


}
