public class Main {

	/**
	 * Hauptprogramm. Erzeugt unvollständigen Stark Stammbaum, lässt Eddard sterben, Raymund Frey gegen Catelyn Stark kämopfen
	 * und gibt am Ende alle Häuser und Charaktere aus.
	 * @param args
	 */
	public static void main(String[] args) {
		House Stark = new House("Stark", "Winterfell");
		Character Eddard = new Character("Eddard", Stark, true, 88);
		Character Catelyn = new Character("Catelyn", Stark, true, 42);
		Character Robb = new Character("Robb", Catelyn, Eddard);
		Character Sansa = new Character("Sansa", Catelyn, Eddard);
		Character Arya = new Character("Arya", Catelyn, Eddard);
		Character Bryan = new Character("Bryan", Catelyn, Eddard);
		
		Eddard.setAlive(false);
		
		House Frey = new House("Frey", "The Twins");
		Character Raymund = new Character("Raymund", Frey, true, 68);
		
		Raymund.fight(Catelyn);
		
		System.out.println(Stark.toString());
		System.out.println(Frey.toString());
		System.out.println(Eddard.toString());
		System.out.println(Catelyn.toString());
		System.out.println(Robb.toString());
		System.out.println(Sansa.toString());
		System.out.println(Arya.toString());
		System.out.println(Bryan.toString());
		System.out.println(Raymund.toString());
	}

}
