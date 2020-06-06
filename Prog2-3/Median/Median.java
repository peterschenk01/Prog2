import java.util.Arrays;

public class Median {
	/*
	 * Gibt den Median der übergebenen Auflistung von Zahlen zurück.
	 */
	public static double computeMedian(int ... ints) {
		if(ints == null)
			throw new IllegalArgumentException("Parameter ints darf nicht null sein.");
		else if(ints.length == 0)
			throw new IllegalArgumentException("Parameter ints darf nicht leer sein.");
		
		Arrays.sort(ints);
		
		if(ints.length % 2 == 0)
			return (ints[ints.length / 2] + ints[(ints.length / 2) - 1]) / 2.0;
		else
			return ints[(ints.length / 2)];
	}
}
