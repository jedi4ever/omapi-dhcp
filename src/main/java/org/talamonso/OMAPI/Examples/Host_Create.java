package org.talamonso.OMAPI.Examples;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Objects.Host;

/**
 * Creat a new Host Object withe some presets.
 * 
 * @author Talamonso
 */
public class Host_Create {

	/**
	 * Creates an host object. Sets the hostname and some other attributes. You can set more then one ip address!
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Connection c = Default.getC();
		try {
			Host h = new Host(c);
			h.setName("albert");
			h.setIPAddress("1.2.3.4,1.2.3.5");
			h.setHardwareAddress("00:00:00:00:00:11");
			h.setHardwareType(1);
			Host remote = h.send(Message.CREATE);
			System.out.println(remote);
		} catch (OmapiException e) {
			System.err.println(e.getMessage());
		}
		c.close();
	}
}
