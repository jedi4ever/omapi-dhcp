package org.talamonso.OMAPI.Objects;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiConnectionException;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Exceptions.OmapiInitException;
import org.talamonso.OMAPI.Exceptions.OmapiObjectException;

/**
 * Control object class.
 * 
 * @author Talamonso
 */
public class Control extends Message {

	/**
	 * Constructor for a control object. Requires an OMAPI Connection.
	 * 
	 * @param con connection to OMAPI Server
	 */
	public Control(Connection con) {
		super(con);
		this.setMessage("type", "control");
	}

	/**
	 * Constructor for the received control object
	 * 
	 * @param c connection to OMAPI Server
	 * @param b ByteArray of the InputStream
	 * @throws OmapiException
	 */
	private Control(Connection con, byte[] b) throws OmapiException {
		super(con, b);
	}

	/**
	 * Send the control object to the DHCP server.
	 * 
	 * @param option
	 * @return the control object answer from the server
	 * @throws OmapiObjectException
	 * @throws OmapiInitException
	 * @throws OmapiConnectionException
	 */
	public Control send(int option) throws OmapiException {
		return new Control(this.c, super.sendMessage(option));
	}

	/**
	 * Shuts the server down. Really! No comeback via OMAPI possible!
	 * 
	 * @throws OmapiObjectException
	 * @throws OmapiInitException
	 * @throws OmapiConnectionException
	 */
	public void shutdown() throws OmapiException {
		this.updateObjectAsInt("state", 2);
		this.send(Message.UPDATE);
	}

	/**
	 * Displays the detailed information in an readable form
	 * 
	 * @return details of this Objects
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("This is an Control Object\n");
		System.out.print("Server is: ");
		if (this.getObjectAsInt("state") == 0) {
			System.out.println("up and running");
		} else {
			System.out.println("going down");
		}
		return sb.toString();
	}
}
