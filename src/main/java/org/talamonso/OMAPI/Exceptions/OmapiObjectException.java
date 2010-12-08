package org.talamonso.OMAPI.Exceptions;

/**
 * Eception is thrown, if Object errors occurs.
 * 
 * @author Talamonso
 */
public class OmapiObjectException extends OmapiException {

	private static final long serialVersionUID = 1L;

	/**
	 * Standard constructor
	 */
	public OmapiObjectException() {
		super();
	}

	/**
	 * Standard constructor with message
	 * 
	 * @param errorMessage
	 */
	public OmapiObjectException(String errorMessage) {
		super(errorMessage);
	}
}
