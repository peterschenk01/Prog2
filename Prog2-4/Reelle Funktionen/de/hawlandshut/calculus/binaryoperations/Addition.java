package de.hawlandshut.calculus.binaryoperations;

import de.hawlandshut.calculus.differentiable.DiffException;
import de.hawlandshut.calculus.differentiable.Differentiable;
import de.hawlandshut.calculus.realfunctions.RealFunction;

public class Addition extends BinaryOperation implements Differentiable{
	
	public Addition(RealFunction left, RealFunction right) {
		super(left, right);
		
		if(left == null || right == null)
			throw new IllegalArgumentException("Es müssen zwei Funktionen übergeben werden!");
	}
	
	@Override
	public boolean inDomain(double x) {
		return getLeft().inDomain(x) && getRight().inDomain(x);
	}
	
	@Override
	public double evaluateAt(double x) {
		return getLeft().evaluateAt(x) + getRight().evaluateAt(x);
	}
	
	@Override
	public String toString() {
		return "(" + getLeft().toString() + ")" +  " + " + "(" + getRight().toString() + ")";
	}
	
	/*
	 * Gibt die Ableitung einer Addition nach den bekannten Ableitungsregeln zurück.
	 * Liefert DiffException falls eine der beiden Reellen Funktionen Differentiable nicht implementiert.
	 */
	@Override
	public Addition derive() throws DiffException{
		if(!(getLeft() instanceof Differentiable) || !(getRight() instanceof Differentiable))
			throw new DiffException("Funktionen müssen differenzierbar seín");
		
		return new Addition(((Differentiable) getLeft()).derive(), ((Differentiable) getRight()).derive());
	}
}
