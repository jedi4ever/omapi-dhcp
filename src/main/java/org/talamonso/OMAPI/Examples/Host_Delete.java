package org.talamonso.OMAPI.Examples;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Objects.Host;

/**
 * Delete an host Object
 * 
 * @author Talamonso
 */
public class Host_Delete {

	/**
	 * delete a host without notification.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Connection c = Default.getC();
		try {
			Host h = new Host(c);
			h.setName("albert");
			h.delete();
		} catch (OmapiException e) {
			System.err.println(e.getMessage());
		}
		c.close();
	}
}
