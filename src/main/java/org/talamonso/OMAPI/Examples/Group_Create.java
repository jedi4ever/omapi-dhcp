package org.talamonso.OMAPI.Examples;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Objects.Group;

/**
 * Example for creating a group object.
 * 
 * @author Talamonso
 */
public class Group_Create {

	/**
	 * Creates a group object. You need to set the statement to "dynamic". Don't ask why.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Connection c = Default.getC();
		try {
			Group g = new Group(c);
			g.setName("group");
			g.setStatement("dynamic");
			Group remote = g.send(Message.CREATE);
			System.out.println(remote);
		} catch (OmapiException e) {
			System.err.println(e.getMessage());
		}
		c.close();
	}
}
