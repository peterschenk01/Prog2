package de.hawlandshut.calculus.differentiable;

import de.hawlandshut.calculus.realfunctions.RealFunction;

// Interface, das von Binären Operationen und Reellen Funktionen implementiert wird.
public interface Differentiable{
	
	RealFunction derive() throws DiffException; // Gibt die Ableitung der Funktion als neue RealFunction zurück. Liefert im Fehlerfall eine DiffException.
}
