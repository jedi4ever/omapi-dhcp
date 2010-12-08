package org.talamonso.OMAPI.Examples;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Objects.Lease;

/**
 * Update a lease object
 * 
 * @author Talamonso
 */
public class Lease_Update {

	/**
	 * Update a lease object.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Connection c = Default.getC();
		try {
			Lease l = new Lease(c);
			l.setIPAddress("192.168.1.23");
			Lease remote = l.send(Message.OPEN);
			remote = remote.send(Message.UPDATE);
			System.out.println(remote);
		} catch (OmapiException e) {
			System.err.println(e.getMessage());
		}
		c.close();
	}
}
