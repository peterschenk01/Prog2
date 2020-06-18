package de.hawlandshut.calculus;

import de.hawlandshut.calculus.realfunctions.*;

public class Main {

	public static void main(String[] args) {
		Plotter.plot(new Exp(), new Sine(1, 1), new Cosine(1, 1), new Sine(2, 2).derive(),new Log());

	}

}
