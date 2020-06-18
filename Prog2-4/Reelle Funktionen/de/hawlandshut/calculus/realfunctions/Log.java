package de.hawlandshut.calculus.realfunctions;

import de.hawlandshut.calculus.differentiable.Differentiable;

public class Log extends RealFunction implements Differentiable{

	@Override
	public double evaluateAt(double x) {
		if(!inDomain(x))
			throw new OutsideOfDomainException("x muss größer 0 sein!");
		return Math.log(x);
	}
	
	@Override
	public boolean inDomain(double x) {
		return x > 0;
	}
	
	@Override
	public String toString() {
		return "ln(x)";
	}
	
	@Override
	public Log derive(){
		return new Log.LogDerivative();
	}
	
	private static class LogDerivative extends Log {
		
		@Override
		public boolean inDomain(double x) {
			return x > 0;
		}
		
		@Override
		public double evaluateAt(double x) {
			if(!inDomain(x))
				throw new OutsideOfDomainException("x muss größer 0 sein!");
			return 1/x;
		}
	}
}
