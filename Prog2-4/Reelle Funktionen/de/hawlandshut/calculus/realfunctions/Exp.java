package de.hawlandshut.calculus.realfunctions;

import de.hawlandshut.calculus.differentiable.Differentiable;

public class Exp extends RealFunction implements Differentiable{
	
	@Override
	public double evaluateAt(double x) {
		return Math.exp(x);
	}
	
	@Override
	public boolean inDomain(double x) {
		return true; // immer true weil der Definitionsbereich die Reellen Zahlen sind
	}
	
	@Override
	public String toString() {
		return "exp(x)";
	}
	
	@Override
	public Exp derive() {
		return new Exp();
	}
}
