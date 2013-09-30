package edu.iastate.cs331.finiteAutomata.exceptions;

public class StateAlreadyDefinedException extends RuntimeException {

	/**
	 * Initial version
	 */
	private static final long serialVersionUID = 1L;

	public StateAlreadyDefinedException() {
	}

	public StateAlreadyDefinedException(String message) {
		super(message);
	}
}
