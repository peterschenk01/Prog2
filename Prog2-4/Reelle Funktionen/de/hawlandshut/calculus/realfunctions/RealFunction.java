package de.hawlandshut.calculus.realfunctions;

/*
 * Abstrakte Klasse von der sich Reelle Funktionen ableiten lassen.
 */
public abstract class RealFunction{
	
	public abstract double evaluateAt(double x); // Gibt den Wert der Funktion an der Stelle x zur�ck.
	
	public abstract boolean inDomain(double x);	// Gibt true zur�ck, wenn das �bergebene x im Definitionsbereich der Funktion liegt, sonst false.
}
