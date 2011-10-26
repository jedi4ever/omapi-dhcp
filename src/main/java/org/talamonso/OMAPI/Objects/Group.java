package org.talamonso.OMAPI.Objects;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiConnectionException;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Exceptions.OmapiInitException;
import org.talamonso.OMAPI.Exceptions.OmapiObjectException;

/**
 * Group Object Class.
 * 
 * @author Talamonso
 */
public class Group extends Message {

	/**
	 * Constructor for a Group Object. Requires an OMAPI Connection.
	 * 
	 * @param con connection to OMAPI Server
	 */
	public Group(Connection con) {
		super(con);
		this.setMessage("type", "group");
	}

	/**
	 * Constructor for the received Group Object
	 * 
	 * @param c connection to OMAPI Server
	 * @param b ByteArray of the InputStream
	 * @throws OmapiObjectException
	 */
	private Group(Connection con, byte[] b) throws OmapiException {
		super(con, b);
	}

	/**
	 * @return name of the group.
	 */
	public String getName() {
		return this.getObjectAsString("name");
	}

	/**
	 * @return statements of the group.
	 */
	public String getStatements() {
		return this.getObjectAsString("statements");
	}

	/**
	 * set the name of the group.
	 * 
	 * @param val groupname
	 */
	public void setName(String val) {
		this.setObjectAsString("name", val);
	}

	/**
	 * set statements of this group.
	 * 
	 * @param val
	 */
	public void setStatement(String val) {
		this.setObjectAsString("statements", val);
	}

	/**
	 * Send the group object to the server
	 * 
	 * @param option
	 * @return returns a new group object with the response of the Server
	 * @throws OmapiConnectionException
	 * @throws OmapiObjectException
	 * @throws OmapiInitException
	 */
	public Group send(int option) throws OmapiException {
		return new Group(this.c, super.sendMessage(option));
	}

	/**
	 * Displays the detailed information in an readable form
	 * 
	 * @return details of this Objects
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("This is an group object\n");
		sb.append("group name:     " + this.getName() + "\n");
		return sb.toString();
	}
}
