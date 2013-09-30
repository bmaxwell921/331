package edu.iastate.cs331.finiteAutomata.exceptions;

public class TransitionAlreadyDefinedException extends RuntimeException {

	/**
	 * Initial version
	 */
	private static final long serialVersionUID = 1L;

	public TransitionAlreadyDefinedException() {
	}

	public TransitionAlreadyDefinedException(String message) {
		super(message);
	}
}
