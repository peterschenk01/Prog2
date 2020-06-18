package de.hawlandshut.calculus.differentiable;

import de.hawlandshut.calculus.realfunctions.RealFunction;

public interface Differentiable{
	
	RealFunction derive() throws DiffException;
}
