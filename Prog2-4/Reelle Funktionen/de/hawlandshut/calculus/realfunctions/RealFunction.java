package de.hawlandshut.calculus.realfunctions;

import de.hawlandshut.calculus.differentiable.*;

// Abstrakte Klasse von der sich Reelle Funktionen ableiten lassen.
public abstract class RealFunction implements Differentiable{
	
	public abstract double evaluateAt(double x); // Gibt den Wert der Funktion an der Stelle x zur�ck.
	
	public abstract boolean inDomain(double x);	// Gibt true zur�ck, wenn das �bergebene x im Definitionsbereich der Funktion liegt, sonst false.
	
	// N�hert eine Nullstelle der Funktion mit Hilfe der Ableitung an und gibt diese zu�ck.
	public double newton(double start, double error) throws DiffException {
		double x = start;
		while(Math.abs(this.evaluateAt(x)) > error) {
			x = x - (this.evaluateAt(x) / this.derive().evaluateAt(x));
		}
		return x;
	}
}
