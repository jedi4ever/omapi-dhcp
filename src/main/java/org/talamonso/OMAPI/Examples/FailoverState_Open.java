package org.talamonso.OMAPI.Examples;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Objects.FailoverState;

/**
 * Example of an FailoverState information.
 * 
 * @author Talamonso
 */
public class FailoverState_Open {

	/**
	 * Print out some handy informations about the state and the peer of the failover system.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Connection c = Default.getC();
		try {
			FailoverState fos = new FailoverState(c);
			fos.setName("dhcpd-sv");
			FailoverState remote = fos.send(Message.OPEN);
			System.out.println(remote.toString());
		} catch (OmapiException e) {
			System.err.println(e.getMessage());
		}
		c.close();
	}
}
