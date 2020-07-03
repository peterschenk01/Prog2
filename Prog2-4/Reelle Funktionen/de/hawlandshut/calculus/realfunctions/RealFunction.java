package de.hawlandshut.calculus.realfunctions;

import de.hawlandshut.calculus.differentiable.*;

// Abstrakte Klasse von der sich Reelle Funktionen ableiten lassen.
public abstract class RealFunction{
	
	public abstract double evaluateAt(double x); // Gibt den Wert der Funktion an der Stelle x zurück.
	
	public abstract boolean inDomain(double x);	// Gibt true zurück, wenn das übergebene x im Definitionsbereich der Funktion liegt, sonst false.
	
	// Nähert eine Nullstelle der Funktion mit Hilfe der Ableitung an und gibt diese zuück.
	public double newton(double start, double error) throws DiffException {
		double x = start;
		if(!(this instanceof Differentiable))
			throw new DiffException("Funktion muss differenzierbar seín");
		while(Math.abs(this.evaluateAt(x)) > error) {
			x = x - (this.evaluateAt(x) / ((Differentiable) this).derive().evaluateAt(x));
		}
		return x;
	}
}
