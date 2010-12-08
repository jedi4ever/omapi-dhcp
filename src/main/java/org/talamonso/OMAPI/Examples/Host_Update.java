package org.talamonso.OMAPI.Examples;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Objects.Host;

/**
 * Update an existing host object.
 * 
 * @author Talamonso
 */
public class Host_Update {

	/**
	 * updates host object. You have to create it first, otherwise an exeption is occurs. You have to open the object
	 * first to update it!
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Connection c = Default.getC();
		try {
			Host h = new Host(c);
			h.setName("albert");
			h.updateIPAddress("1.3.1.46");
			Host remote = h.send(Message.UPDATE);
			System.out.println(remote.toString());
		} catch (OmapiException e) {
			System.err.println(e.getMessage());
		}
		c.close();
	}
}
