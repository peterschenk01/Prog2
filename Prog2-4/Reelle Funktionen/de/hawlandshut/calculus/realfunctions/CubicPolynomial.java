package de.hawlandshut.calculus.realfunctions;

import de.hawlandshut.calculus.differentiable.Differentiable;

public class CubicPolynomial extends RealFunction implements Differentiable{

	private final double a, b, c, d;
	
	public CubicPolynomial(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	@Override
	public double evaluateAt(double x) {
		return a * Math.pow(x,  3) + b * Math.pow(x,  2) + c * x + d;
	}
	
	@Override
	public boolean inDomain(double x) {
		return true; // immer true weil der Definitionsbereich die Reellen Zahlen sind
	}
	
	@Override
	public String toString() {
		return String.format("%f * x^3 + %f * x^2 + %f * x + %f", a, b, c, d);
	}
	
	@Override
	public CubicPolynomial derive() {
		return new CubicPolynomial(0, 3 * a, 2 * b, c);
	}
}
