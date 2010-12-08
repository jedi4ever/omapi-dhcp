package org.talamonso.OMAPI.Objects;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Convert;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Exceptions.OmapiObjectException;

/**
 * As long as the subnet object isn't supported by the server this object is just virtual to get all depending leases
 * for a given subnet.
 * 
 * @author Talamonso
 */
public class Subnet extends Message {

	/**
	 * @param con Connection to DHCP server.
	 */
	public Subnet(Connection con) {
		super(con);
	}

	/**
	 * Try to get all leases known by the server in a given intervall.
	 * 
	 * @param start ip address
	 * @param end ip address
	 * @return leases in an array.
	 * @throws OmapiObjectException
	 */
	public Lease[] getLeases(String start, String end) throws OmapiObjectException {
		return this.getLeases(Convert.ip2long(start), Convert.ip2long(end));
	}

	/**
	 * @param start
	 * @param end
	 * @return Leases in Array
	 * @throws OmapiObjectException
	 */
	public Lease[] getLeases(long start, long end) throws OmapiObjectException {
		if (start > end) {
			throw new OmapiObjectException("start ip address must be lower than end ip address.");
		}
		long length = end - start;
		Lease[] la = new Lease[(int) length];
		long now = start;
		while (now < end) {
			long count = now - start;
			la[(int) count] = new Lease(this.c);
			try {
				la[(int) count].setIPAddress(Convert.long2ip(now));
				la[(int) count] = la[(int) count].send(Message.OPEN);
			} catch (OmapiException e) {
				la[(int) count] = null;
			}
			now++;
		}
		return la;
	}
}
