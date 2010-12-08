package org.talamonso.OMAPI.Examples;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Exceptions.OmapiObjectException;
import org.talamonso.OMAPI.Objects.Lease;
import org.talamonso.OMAPI.Objects.Subnet;

/**
 * Open multiple lease objects
 * 
 * @author Talamonso
 */
public class Subnet_multipleLeases {

	/**
	 * Opens multiple lease objects and print out some informations.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Connection c = Default.getC();
		Subnet s = new Subnet(c);
		try {
			Lease[] la;
			la = s.getLeases("172.27.5.0", "172.27.5.255");
			for (int i = 0; i < la.length; i++) {
				System.err.println(la[i].toStringAll() + "\n");
			}
		} catch (OmapiObjectException e) {
			e.printStackTrace();
		}
		c.close();
	}
}
