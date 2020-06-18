package de.hawlandshut.calculus.binaryoperations;

import de.hawlandshut.calculus.differentiable.DiffException;
import de.hawlandshut.calculus.differentiable.Differentiable;
import de.hawlandshut.calculus.realfunctions.RealFunction;

public class Composition extends BinaryOperation implements Differentiable{
	
	public Composition(RealFunction left, RealFunction right) {
		super(left, right);
		
		if(left == null || right == null)
			throw new IllegalArgumentException("Es müssen zwei Funktionen übergeben werden!");
	}
	
	@Override
	public boolean inDomain(double x) {
		return getRight().inDomain(x) && getLeft().inDomain(getRight().evaluateAt(x));
	}
	
	@Override
	public double evaluateAt(double x) {
		return getLeft().evaluateAt(getRight().evaluateAt(x));
	}
	
	@Override
	public String toString() {
		return "(" + getLeft().toString() + ")" +  " ° " + "(" + getRight().toString() + ")";
	}
	
	@Override
	public Multiplication derive() throws DiffException{
		if(!(getLeft() instanceof Differentiable) || !(getRight() instanceof Differentiable))
			throw new DiffException("Funktionen müssen differenzierbar seín");
		
		return new Multiplication(new Composition(((Differentiable) getLeft()).derive(), getRight()), ((Differentiable) getRight()).derive());
	}
}
