package org.talamonso.OMAPI.Exceptions;

/**
 * Exception is thrown when connection fails.
 * @author   Talamonso
 */
public class OmapiConnectionException extends OmapiException {

	private static final long serialVersionUID = 4949702170705997465L;

	/**
	 * Standard constructor
	 */
	public OmapiConnectionException() {
		super();
	}

	/**
	 * Standard constructor with message
	 * 
	 * @param errorMessage
	 */
	public OmapiConnectionException(String errorMessage) {
		super(errorMessage);
	}
}
