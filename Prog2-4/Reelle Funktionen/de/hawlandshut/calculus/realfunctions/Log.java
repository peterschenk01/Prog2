package de.hawlandshut.calculus.realfunctions;

import de.hawlandshut.calculus.differentiable.Differentiable;

public class Log extends RealFunction implements Differentiable{

	@Override
	public double evaluateAt(double x){
		if(!inDomain(x))
			throw new OutsideOfDomainException("x muss größer 0 sein!");
		return Math.log(x);
	}
	
	@Override
	public boolean inDomain(double x) {
		return x > 0; // Definitionsbereich des Logarithmus ist alles über 0
	}
	
	@Override
	public String toString() {
		return "ln(x)";
	}
	
	@Override
	public Log derive(){
		return new Log.LogDerivative(); // derive gibt die Ableitung vom Logarithmus als neues Objekt der verschachtelten Klasse LogDerivative zurück
	}
	
	// geschachtelte Klasse, die die Ableitung vom Logarithmus darstellt
	private static class LogDerivative extends Log {
		
		@Override
		public boolean inDomain(double x) {
			return x > 0; // Definitionsbereich vom Logarithmus
		}
		
		@Override
		public double evaluateAt(double x) {
			if(!inDomain(x))
				throw new OutsideOfDomainException("x muss größer 0 sein!");
			return 1/x;
		}
	}
}
