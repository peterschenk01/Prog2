package de.hawlandshut.calculus.differentiable;

import de.hawlandshut.calculus.realfunctions.RealFunction;

// Interface, das von Bin�ren Operationen und Reellen Funktionen implementiert wird.
public interface Differentiable{
	
	RealFunction derive() throws DiffException; // Gibt die Ableitung der Funktion als neue RealFunction zur�ck. Liefert im Fehlerfall eine DiffException.
}
