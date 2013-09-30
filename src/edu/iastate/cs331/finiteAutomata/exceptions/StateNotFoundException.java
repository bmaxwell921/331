package edu.iastate.cs331.finiteAutomata.exceptions;

public class StateNotFoundException extends RuntimeException {

	/**
	 * Intial version
	 */
	private static final long serialVersionUID = 1L;
	
	public StateNotFoundException() {
		super();
	}
	
	public StateNotFoundException(String message) {
		super(message);
	}
}
