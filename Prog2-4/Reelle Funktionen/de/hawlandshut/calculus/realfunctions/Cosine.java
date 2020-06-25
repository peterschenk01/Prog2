package de.hawlandshut.calculus.realfunctions;

import de.hawlandshut.calculus.differentiable.Differentiable;

public class Cosine extends RealFunction implements Differentiable{
	
	private final double a, f;
	
	public Cosine(double a, double f) {
		this.a = a;
		this.f = f;
	}
	
	@Override
	public double evaluateAt(double x) {
		return a * Math.cos(f * x);
	}
	
	@Override
	public boolean inDomain(double x) {
		return true; // immer true weil der Definitionsbereich die Reellen Zahlen sind
	}
	
	@Override
	public String toString() {
		return String.format("%f * cos(%f * x)", a, f);
	}
	
	@Override
	public Sine derive() {
		return new Sine(-a * f, f);
	}
}
