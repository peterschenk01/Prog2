package de.hawlandshut.calculus.binaryoperations;

import de.hawlandshut.calculus.differentiable.DiffException;
import de.hawlandshut.calculus.differentiable.Differentiable;
import de.hawlandshut.calculus.realfunctions.RealFunction;

public class Composition extends BinaryOperation implements Differentiable{
	
	public Composition(RealFunction left, RealFunction right) {
		super(left, right);
	}
	
	@Override
	public boolean inDomain(double x) {
		return getRight().inDomain(x) && getLeft().inDomain(getRight().evaluateAt(x));
		// x muss im Definitionsbereich der rechten Funktion liegen und der Wert der rechten Funktion an der Stelle x muss im Definitionsbereich der linken Funktion liegen
	}
	
	@Override
	public double evaluateAt(double x) {
		return getLeft().evaluateAt(getRight().evaluateAt(x));
	}
	
	@Override
	public String toString() {
		return "(" + getLeft().toString() + ")" +  " ° " + "(" + getRight().toString() + ")";
	}
	
	/*
	 * Gibt die Ableitung einer Komposition nach den bekannten Ableitungsregeln zurück.
	 * Liefert DiffException falls eine der beiden Reellen Funktionen Differentiable nicht implementiert.
	 */
	@Override
	public Multiplication derive() throws DiffException{
		if(!(getLeft() instanceof Differentiable) || !(getRight() instanceof Differentiable))
			throw new DiffException("Funktionen müssen differenzierbar seín");
		
		return new Multiplication(new Composition(((Differentiable) getLeft()).derive(), getRight()), ((Differentiable) getRight()).derive());
	}
}
