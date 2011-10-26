package org.talamonso.OMAPI.Exceptions;

import org.talamonso.OMAPI.ErrorCode;

/**
 * Represents an error returned by the server in the course of the
 * normal protocol exchange, for example, object not found.
 * 
 * @author Chris Wilson <chris+omapi@aptivate.org>
 */
public class OmapiCallException extends OmapiException
{
	private static final long serialVersionUID = 1L;
	
	private String m_ServerErrorMessage;
	private int m_ServerErrorCodeNumber;
	private ErrorCode m_ServerErrorCode;

	/**
	 * Standard constructor with message
	 * 
	 * @param errorMessage
	 */
	public OmapiCallException(String errorMessage, int errorCode)
	{
		super("The server said: " + errorMessage + 
			" (which is a special case of: " + 
			ErrorCode.get(errorCode).getMeaning() + ")");
		m_ServerErrorMessage = errorMessage;
		m_ServerErrorCodeNumber = errorCode;
		m_ServerErrorCode = ErrorCode.get(errorCode);
	}

	public String getServerMessage() 
	{
		return m_ServerErrorMessage;
	}

	public int getCodeNumber() 
	{
		return m_ServerErrorCodeNumber;
	}
	
	public ErrorCode getErrorCode()
	{
		return m_ServerErrorCode;
	}
}
