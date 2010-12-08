package org.talamonso.OMAPI.Examples;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Exceptions.OmapiException;

/**
 * This object holds the connection informations used by the examples.
 * 
 * @author Talamonso
 */
public class Default {

	/**
	 * This is just a Default methode...
	 * 
	 * @return a connection object
	 */
	public static Connection getC() {
		Connection c = null;
		try {
			c = new Connection("192.168.2.150", 9991);
			c.setAuth("omapi_key", "2YdVRKaJ4x41lDqHfA8rl8pHx95C4PmBgPcf5hIJ8j417HFN0AxUBEo6/3FoYyWjPyvXXCd+H6fPygtZd/iKxQ==");
		} catch (OmapiException e) {
			System.err.println(e.getMessage());
		}
		return c;
	}
}
