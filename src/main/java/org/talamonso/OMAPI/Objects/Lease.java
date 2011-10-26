package org.talamonso.OMAPI.Objects;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiConnectionException;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Exceptions.OmapiInitException;
import org.talamonso.OMAPI.Exceptions.OmapiObjectException;

import com.widget.util.Hex;

/**
 * Lease Object Class.
 * 
 * @author Talamonso
 */
public class Lease extends Message {

	private final int FREE = 1;

	/**
	 * Constructor for a Lease Object. Requires an OMAPI Connection.
	 * 
	 * @param con connection to OMAPI Server
	 */
	public Lease(Connection con) {
		super(con);
		this.setMessage("type", "lease");
	}

	/**
	 * Constructor for the received Lease Object
	 * 
	 * @param c connection to OMAPI Server
	 * @param b ByteArray of the InputStream
	 * @throws OmapiObjectException
	 */
	private Lease(Connection con, byte[] b) throws OmapiException {
		super(con, b);
	}

	/**
	 * We need to override the default method... Because we need to set it free... Because we can't delete leases...
	 * 
	 * @throws OmapiConnectionException
	 * @throws OmapiInitException
	 * @throws OmapiObjectException
	 */
	public void delete() throws OmapiException {
		Lease expire = this.send(Message.OPEN);
		expire.updateState(this.FREE);
		expire.send(Message.UPDATE);
	}

	/**
	 * update the leases state.
	 * 
	 * @param value
	 */
	public void updateState(int value) {
		this.updateObjectAsInt("state", value);
	}

	/**
	 * @return Hostname of the lease.
	 */
	public String getClientHostname() {
		return this.getObjectAsString("client-hostname");
	}

	/**
	 * @return Handle of the Host object. If available.
	 */
	public int getHost() {
		return this.getObjectAsInt("host");
	}

	/**
	 * @return handle of the related subnet.
	 */
	public int getSubnet() {
		return this.getObjectAsInt("subnet");
	}

	/**
	 * @return handle of the related pool.
	 */
	public int getPool() {
		return this.getObjectAsInt("pool");
	}

	/**
	 * @return handle of the related billing class.
	 */
	public int getBillingClass() {
		return this.getObjectAsInt("billing-class");
	}

	/**
	 * @return the time of the last transaction with the client of this lease.
	 */
	public String getCltt() {
		return this.getObjectAsDate("cltt");
	}

	/**
	 * @return dhcp client identifier of this lease.
	 */
	public String getDhcpClientIdentifier() {
		byte[] b = this.getObjectRaw("dhcp-client-identifier");
		return Hex.toHexF(b);
	}

	/**
	 * Sets the dhcp client identifier.
	 * 
	 * @param val
	 */
	public void setDhcpClientIdentifier(String val) {
		this.setObjectAsString("dhcp-client-identifier", val);
	}

	/**
	 * @return the time when the current state ends, as understood by the client.
	 */
	public String getEnds() {
		return this.getObjectAsDate("ends");
	}

	/**
	 * @return hardware type of the lease object (1 = ethernet)
	 */
	public int getHardwareType() {
		return this.getObjectAsInt("hardware-type");
	}

	/**
	 * readable representation of the IP-Address
	 * 
	 * @return IP address as a dotted quad String (e.g. 192.168.0.1)
	 */
	public String getIpAddress() {
		return this.getObjectAsIpAddress("ip-address");
	}

	/**
	 * readable representation of the MAC-Address
	 * 
	 * @return MAC address as a ":"-seperated Hex String (e.g. aa:aa:aa:aa:aa:aa)
	 */
	public String getHardwareAddress() {
		return this.getObjectAsMacAddress("hardware-address");
	}

	/**
	 * @return start time of this lease.
	 */
	public String getStarts() {
		return this.getObjectAsDate("starts");
	}

	/**
	 * @return state of this lease as int value.
	 */
	public int getState() {
		return this.getObjectAsInt("state");
	}

	/**
	 * @return the time when the current state ends, as understood by the failover peer.
	 */
	public String getTsfp() {
		return this.getObjectAsDate("tsfp");
	}

	/**
	 * @return the time when the current state ends, as understood by the server.
	 */
	public String getTstp() {
		return this.getObjectAsDate("tstp");
	}

	/**
	 * sends the object to the server
	 * 
	 * @param action
	 * @return server answer as a lease object.
	 * @throws OmapiConnectionException
	 * @throws OmapiObjectException
	 * @throws OmapiInitException
	 */
	public Lease send(int action) throws OmapiException {
		return new Lease(this.c, this.sendMessage(action));
	}

	/**
	 * Set's the IP-Address of the Object.
	 * 
	 * @param ipString requires the IP address as a dotted quad String (e.g. 192.168.0.1)
	 * @throws OmapiObjectException
	 */
	public void setIPAddress(String ipString) throws OmapiObjectException {
		this.setObjectAsIpAddresses("ip-address", ipString);
	}

	/**
	 * Set's the MAC-Address of the Object.
	 * 
	 * @param mac requires the MAC address as a ":"-seperated Hex String (e.g. aa:aa:aa:aa:aa:aa)
	 * @throws OmapiObjectException
	 */
	public void setHardwareAddress(String mac) throws OmapiObjectException {
		this.setObjectAsMacAddress("hardware-address", mac);
	}

	/**
	 * Displays the detailed information in an readable form
	 * 
	 * @return details of this objects
	 */
	public String toString() {
		if (this.getState() != 2) {
			return "The lease " + this.getIpAddress() + " is free";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("This is an lease object\n");
		sb.append("State:             " + this.getState() + "\n");
		sb.append("IP-Address:        " + this.getIpAddress() + "\n");
		sb.append("MAC-Address:       " + this.getHardwareAddress() + "\n");
		sb.append("Client identifier:" + this.getDhcpClientIdentifier() + "\n");
		sb.append("Hostname:          " + this.getClientHostname() + "\n");
		sb.append("Hardware type:     " + this.getHardwareType() + "\n");
		sb.append("Starts (client):   " + this.getStarts() + "\n");
		sb.append("Ends (client):     " + this.getEnds() + "\n");
		sb.append("Ends (server):     " + this.getTstp() + "\n");
		sb.append("Ends (failover):   " + this.getTsfp() + "\n");
		sb.append("Last transaction:  " + this.getCltt() + "\n");
		sb.append("Host (handle!):    " + this.getHost() + "\n");
		sb.append("Subnet (handle!):  " + this.getSubnet() + "\n");
		sb.append("Pool (handle!):    " + this.getPool() + "\n");
		return sb.toString();
	}
}
