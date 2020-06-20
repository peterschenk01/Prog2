package de.hawlandshut.calculus.realfunctions;

/*
 * Abstrakte Klasse von der sich Reelle Funktionen ableiten lassen.
 */
public abstract class RealFunction{
	
	public abstract double evaluateAt(double x); // Gibt den Wert der Funktion an der Stelle x zurück.
	
	public abstract boolean inDomain(double x);	// Gibt true zurück, wenn das übergebene x im Definitionsbereich der Funktion liegt, sonst false.
}
