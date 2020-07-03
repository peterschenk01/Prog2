package de.hawlandshut.calculus.binaryoperations;

import de.hawlandshut.calculus.differentiable.DiffException;
import de.hawlandshut.calculus.differentiable.Differentiable;
import de.hawlandshut.calculus.realfunctions.RealFunction;

public class Multiplication extends BinaryOperation implements Differentiable{
	
	public Multiplication(RealFunction left, RealFunction right) {
		super(left, right);
	}
	
	@Override
	public boolean inDomain(double x) {
		return getLeft().inDomain(x) && getRight().inDomain(x); // x muss in den Definitionsbereichen beider Funktionen liegen
	}
	
	@Override
	public double evaluateAt(double x) {
		return getLeft().evaluateAt(x) * getRight().evaluateAt(x);
	}
	
	@Override
	public String toString() {
		return "(" + getLeft().toString() + ")" +  " * " + "(" + getRight().toString() + ")";
	}
	
	/*
	 * Gibt die Ableitung einer Multiplikation nach den bekannten Ableitungsregeln zurück.
	 * Liefert DiffException falls eine der beiden Reellen Funktionen Differentiable nicht implementiert.
	 */
	@Override
	public Addition derive() throws DiffException{
		if(!(getLeft() instanceof Differentiable) || !(getRight() instanceof Differentiable))
			throw new DiffException("Funktionen müssen differenzierbar seín");
		
		return new Addition(new Multiplication(getLeft(), ((Differentiable) getRight()).derive()), new Multiplication(getRight(), ((Differentiable) getLeft()).derive()));
	}
}
