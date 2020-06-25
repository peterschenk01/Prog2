package de.hawlandshut.calculus.binaryoperations;

import de.hawlandshut.calculus.realfunctions.RealFunction;

// Abstrakte Klasse von der Binäre Operationen abgeleitet werden können.
public abstract class BinaryOperation extends RealFunction {
	
	private final RealFunction left, right;
	
	public BinaryOperation(RealFunction left, RealFunction right) {
		if(left == null || right == null)
			throw new IllegalArgumentException("Es müssen zwei Funktionen übergeben werden!");
		
		this.left = left;
		this.right = right;
	}
	
	public RealFunction getLeft() {
		return left;
	}
	
	public RealFunction getRight() {
		return right;
	}
}
