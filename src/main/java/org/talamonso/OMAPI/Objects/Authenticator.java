package org.talamonso.OMAPI.Objects;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiConnectionException;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Exceptions.OmapiInitException;
import org.talamonso.OMAPI.Exceptions.OmapiObjectException;

/**
 * This class initialises the authentication. Normaly it is used by the setAuth() Method in the Connection Class.
 * 
 * @author Talamonso
 * @version 1.0
 */
public class Authenticator extends Message {

	/**
	 * Spezial Constructor for the authentication init process It only supports HMAC-MD5, because this is the only
	 * algorithm supported by the class Message. (And the DHCP-server of course)
	 * 
	 * @param con
	 * @param keyName The name of the key, as in dhcpd.conf
	 */
	public Authenticator(Connection con, String keyName) {
		super(con);
		this.setMessage("type", "authenticator");
		this.setObjectAsString("name", keyName);
		this.setObjectAsString("algorithm", "hmac-md5.SIG-ALG.REG.INT.");
	}

	/**
	 * Catches the answer of the server.
	 * 
	 * @param con the connection
	 * @param bs ByteArray of the incomming data
	 * @throws OmapiObjectException
	 */
	protected Authenticator(Connection con, byte[] bs) throws OmapiException {
		super(con, bs);
	}

	/**
	 * Send the authenticator to the server
	 * 
	 * @param option
	 * @return returns a new authenticator object with the response of the Server
	 * @throws OmapiConnectionException
	 * @throws OmapiObjectException
	 * @throws OmapiInitException
	 */
	public Authenticator send(int option) throws OmapiException {
		return new Authenticator(this.c, this.sendMessage(option));
	}
}
