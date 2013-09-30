package edu.iastate.cs331.finiteAutomata.exceptions;

public class TransitionNotDefinedException extends RuntimeException {

	/**
	 * Initial version
	 */
	private static final long serialVersionUID = 1L;

	public TransitionNotDefinedException() {
		super();
	}
	
	public TransitionNotDefinedException(String message) {
		super(message);
	}
}
