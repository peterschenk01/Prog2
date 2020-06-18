package de.hawlandshut.calculus.realfunctions;

public class OutsideOfDomainException extends RuntimeException{

	private static final long serialVersionUID = -4292282583923805139L;

	public OutsideOfDomainException(String message) {
		super(message);
	}
	
	public OutsideOfDomainException(Throwable cause) {
		super(cause);
	}
	
	public OutsideOfDomainException(String message, Throwable cause) {
		super(message, cause);
	}
}
