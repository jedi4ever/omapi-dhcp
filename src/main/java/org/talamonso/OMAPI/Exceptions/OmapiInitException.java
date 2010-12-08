package org.talamonso.OMAPI.Exceptions;

/**
 * This Exception is thrown, if initialisation fails
 * @author   Talamonso
 */
public class OmapiInitException extends OmapiException {

	private static final long serialVersionUID = 1L;

	/**
	 * Standard constructor
	 */
	public OmapiInitException() {
		super();
	}

	/**
	 * Standard constructor with message
	 * 
	 * @param errorMessage
	 */
	public OmapiInitException(String errorMessage) {
		super(errorMessage);
	}
}
