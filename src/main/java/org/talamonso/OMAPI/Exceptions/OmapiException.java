package org.talamonso.OMAPI.Exceptions;

/**
 * Main exception class for OMAPI
 * 
 * @author Talamonso
 */
public class OmapiException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Standard constructor
	 */
	public OmapiException() {
		super();
	}

	/**
	 * Standard constructor with message
	 * 
	 * @param errorMessage
	 */
	public OmapiException(String errorMessage) {
		super(errorMessage);
	}
}
