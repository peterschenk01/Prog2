import java.util.Scanner;

public class WordJumble{
	/*
	 * Wenn das übergebene Wort kürzer als 4 Buchstaben ist, hängt die Methode das Wort unverändert and den StringBuilder an.
	 * Andernfalls vertauscht sie, abgesehen vom ersten und letzen Buchstaben, paarweise von links nach rechts die Buchstaben und hängt
	 * es dann an den StringBuilder an.
	 */
  public static void jumbleWord(String word, StringBuilder builder){
	  if(word.length() <= 3)
		  builder.append(word);
	  else {
		  char[] charArray = word.toCharArray();
		  char c;
		  for(int i = 1; i < (word.length() - 2); i = i + 2) {
			  c = charArray[i];
			  charArray[i] = charArray[i + 1];
			  charArray[i + 1] = c;
		  }
		  String string = String.valueOf(charArray);
		  builder.append(string);
	  }
  }

  public static String jumbleText(Scanner scanner){

    StringBuilder builder = new StringBuilder();

    while (scanner.hasNext()){
      String word = scanner.next();

      jumbleWord(word, builder);
      builder.append(" ");
    }

    return builder.toString();

  }

  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    String result = jumbleText(scanner);

    System.out.print(result);

    scanner.close();


  }
}
