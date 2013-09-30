package edu.iastate.cs331.finiteAutomata.exceptions;

public class StartAlreadyDefinedException extends RuntimeException {

	/**
	 * Initial version
	 */
	private static final long serialVersionUID = 1L;

	public StartAlreadyDefinedException() {
	}

	public StartAlreadyDefinedException(String message) {
		super(message);
	}
}
