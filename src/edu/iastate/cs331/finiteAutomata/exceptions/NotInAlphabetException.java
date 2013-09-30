package edu.iastate.cs331.finiteAutomata.exceptions;

/**
 * Exception thrown when a character is found that does not exist in the correct alphabet 
 * @author Brandon
 *
 */
public class NotInAlphabetException extends RuntimeException {

	/**
	 * Initial version
	 */
	private static final long serialVersionUID = 1L;

	public NotInAlphabetException() {
		super();
	}
	
	public NotInAlphabetException(String message) {
		super(message);
	}
}
