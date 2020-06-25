package de.hawlandshut.calculus.realfunctions;

import de.hawlandshut.calculus.differentiable.Differentiable;

public class Constant extends RealFunction implements Differentiable{

	private final double c;
	
	public Constant(double c) {
		this.c = c;
	}
	
	@Override
	public double evaluateAt(double x) {
		return c;
	}
	
	@Override
	public boolean inDomain(double x) {
		return true; // immer true weil der Definitionsbereich die Reellen Zahlen sind
	}
	
	@Override
	public String toString() {
		return String.format("%f", c);
	}
	
	@Override
	public Constant derive() {
		return new Constant(0);
	}
}
