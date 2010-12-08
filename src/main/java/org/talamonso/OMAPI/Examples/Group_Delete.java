package org.talamonso.OMAPI.Examples;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Objects.Group;

/**
 * Shows how to delete a group object.
 * 
 * @author Talamonso
 */
public class Group_Delete {

	/**
	 * Delete a group object.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Connection c = Default.getC();
		try {
			Group g = new Group(c);
			g.setName("group");
			g.delete();
		} catch (OmapiException e) {
			System.err.println(e.getMessage());
		}
		c.close();
	}
}
