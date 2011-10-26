package org.talamonso.OMAPI;

import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Exceptions.OmapiObjectException;

/**
 * This is an nearly empty Message class. It's necessarry, because Message is (and will stay) abstract, so it's not
 * possible to create Message Objects directly.
 * 
 * @author Talamonso
 */
public class EmptyMessage extends Message {

	/**
	 * Initialises a Message received from the DHCP server
	 * 
	 * @param con the connection to the DHCP server
	 * @param b the Bytes received from the DHCP as bytearray
	 * @throws OmapiObjectException is thrown in any error case.
	 */
	public EmptyMessage(Connection con, byte[] b) throws OmapiException {
		super(con, b);
	}

	/**
	 * Initialises an empty Message Object.
	 * 
	 * @param con
	 */
	public EmptyMessage(Connection con) {
		super(con);
	}
}
