public class MagicSquare {
	
	/*
	 * Erzeugt das Beispiel aus der Aufgabe und gibt es zurück.
	 */
	public static int[][] getExample(){
		int[][] example = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
		return example;
	}
	
	/*
	 * Überprüft ob das übergebene Zweidimensionale Array, wenn es nicht null ist und ein Quadrat ist, ob es ein magisches Quadrat ist.
	 */
	public static boolean isMagic(int[][] quadrat) {
		if(quadrat == null)
			throw new IllegalArgumentException("Parameter quadrat darf nicht null sein.");
		else {
			for(int i = 0; i < quadrat.length; i++) {
				if(quadrat[i].length != quadrat.length)
					throw new IllegalArgumentException("Parameter quadrat muss quadratisch sein");
			}
		}
		
		int summe = 0;
		for(int i = 0; i < quadrat.length; i++) {
			summe += quadrat[i][0];
		}
		
		return checkHorizontal(quadrat, summe) && checkVertikal(quadrat, summe) && checkDiagonal(quadrat, summe) && checkAntiDiagonal(quadrat, summe);
		
	}
	
	/*
	 * Überprüft ob die Summen der Zahlen in den einzelnen Zeilen mit der Summe aus der ersten Zeile übereinstimmen.
	 */
	public static boolean checkHorizontal(int[][] quadrat, int summe) {
		int horizontalsumme = 0, zaehler = 0;
		for(int a = 0; a < quadrat.length; a++) {
			for(int b = 0; b < quadrat.length; b++) {
				horizontalsumme += quadrat[a][b];
			}
			if(horizontalsumme == summe)
				zaehler++;
			horizontalsumme = 0;
		}
		if(zaehler == quadrat.length)
			return true;
		else
			return false;
	}
	
	/*
	 * Überprüft ob die Summen der Zahlen in den einzelnen Spalten mit der Summe aus der ersten Zeile übereinstimmen.
	 */
	public static boolean checkVertikal(int[][] quadrat, int summe) {
		int vertikalsumme = 0, zaehler = 0;
		for(int a = 0; a < quadrat.length; a++) {
			for(int b = 0; b < quadrat.length; b++) {
				vertikalsumme += quadrat[b][a];
			}
			if(vertikalsumme == summe)
				zaehler++;
			vertikalsumme = 0;
		}
		if(zaehler == quadrat.length)
			return true;
		else
			return false;
	}
	
	/*
	 * Überprüft ob die Summe der Zahlen in der Diagonalen mit der Summe aus der ersten Zeile übereinstimmt.
	 */
	public static boolean checkDiagonal(int[][] quadrat, int summe) {
		int diagonalsumme = 0;
		for(int a = 0; a < quadrat.length; a++) {
				diagonalsumme += quadrat[a][a];
		}
		if(diagonalsumme == summe)
			return true;
		else
			return false;
	}
	
	/*
	 * Überprüft ob die Summe der Zahlen in der AntiDiagonalen mit der Summe aus der ersten Zeile übereinstimmt.
	 */
	public static boolean checkAntiDiagonal(int[][] quadrat, int summe) {
		int diagonalsumme = 0, b = 0;
		for(int a = quadrat.length - 1; a >= 0; a--) {
				diagonalsumme += quadrat[b][a];
				b++;
		}
		if(diagonalsumme == summe)
			return true;
		else
			return false;
	}
}
