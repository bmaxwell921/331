package edu.iastate.cs331.finiteAutomata.exceptions;

public class StateNotDefinedException extends RuntimeException {

	/**
	 * Intial version
	 */
	private static final long serialVersionUID = 1L;
	
	public StateNotDefinedException() {
		super();
	}
	
	public StateNotDefinedException(String message) {
		super(message);
	}
}
