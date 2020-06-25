package de.hawlandshut.calculus;

import de.hawlandshut.calculus.realfunctions.*;
import de.hawlandshut.calculus.binaryoperations.*;
import de.hawlandshut.calculus.differentiable.*;

public class Main {

	public static void main(String[] args)throws DiffException {
		Plotter.plot(new Addition(new Constant(1), new Log()).derive());
	}

}
