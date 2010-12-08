package org.talamonso.OMAPI.Examples;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Objects.Control;

/**
 * An example how to shutdown a Server via the Java OMAPI classes.
 * 
 * @author Talamonso
 */
public class Control_ShutDown {

	/**
	 * shut down the DHCP server immediatly.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Connection c = Default.getC();
		try {
			Control con = new Control(c);
			con.shutdown();
			Control remote = con.send(Message.OPEN);
			System.out.println(remote);
		} catch (OmapiException e) {
			System.err.println(e.getMessage());
		}
		c.close();
	}
}
