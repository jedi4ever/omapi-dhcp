package org.talamonso.OMAPI.Examples;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Objects.Lease;

/**
 * Delete an existing lease Object
 * 
 * @author Talamonso
 */
public class Lease_Delete {

	/**
	 * Delete a lease object.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Connection c = Default.getC();
		try {
			Lease l = new Lease(c);
			l.setIPAddress("192.168.1.23");
			l.delete();
		} catch (OmapiException e) {
			System.err.println(e.getMessage());
		}
		c.close();
	}
}
