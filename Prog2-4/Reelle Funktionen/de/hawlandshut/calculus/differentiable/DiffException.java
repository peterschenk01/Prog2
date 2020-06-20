package de.hawlandshut.calculus.differentiable;

/*
 * Ausnahme mit den 3 Konstruktoren aus der Vorlesung, die von Exception abgeleitet wird.
 */
public class DiffException extends Exception {

	private static final long serialVersionUID = -777187281018175021L;

	public DiffException(String message) {
		super(message);
	}
	
	public DiffException(Throwable cause) {
		super(cause);
	}
	
	public DiffException(String message, Throwable cause) {
		super(message, cause);
	}
}
