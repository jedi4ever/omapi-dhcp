package org.talamonso.OMAPI.Examples;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Objects.Host;

/**
 * Open an host object
 * 
 * @author Talamonso
 */
public class Host_Open {

	/**
	 * opens an host object
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Connection c = Default.getC();
		try {
			Host h = new Host(c);
			h.setHardwareAddress("00:00:00:00:00:11");
			// h.setName("albert");
			Host remote = h.send(Message.OPEN);
			System.out.println(remote);
		} catch (OmapiException e) {
			System.err.println(e.getMessage());
		}
		c.close();
	}
}
