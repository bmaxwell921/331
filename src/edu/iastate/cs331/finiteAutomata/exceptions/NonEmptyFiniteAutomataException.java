package edu.iastate.cs331.finiteAutomata.exceptions;

public class NonEmptyFiniteAutomataException extends RuntimeException {

	/**
	 * Inital Version
	 */
	private static final long serialVersionUID = 1L;

	public NonEmptyFiniteAutomataException() {
		super();
	}
	
	public NonEmptyFiniteAutomataException(String message) {
		super(message);
	}
}
