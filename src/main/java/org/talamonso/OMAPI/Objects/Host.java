package org.talamonso.OMAPI.Objects;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiConnectionException;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Exceptions.OmapiInitException;
import org.talamonso.OMAPI.Exceptions.OmapiObjectException;

import com.widget.util.Hex;

/**
 * Host Object Class.
 * 
 * @author Talamonso
 */
public class Host extends Message {

	/**
	 * Constructor for a Host Object. Requires an OMAPI Connection.
	 * 
	 * @param con connection to OMAPI Server
	 */
	public Host(Connection con) {
		super(con);
		this.setMessage("type", "host");
	}

	/**
	 * Constructor for the received Host Object
	 * 
	 * @param c connection to OMAPI Server
	 * @param b ByteArray of the InputStream
	 * @throws OmapiObjectException
	 */
	private Host(Connection con, byte[] b) throws OmapiException {
		super(con, b);
	}

	/**
	 * @return dhcp client identifier
	 */
	public String getDhcpClientIdentifier() {
		byte[] b = this.getObjectRaw("dhcp-client-identifier");
		return Hex.toHexF(b);
	}

	/**
	 * readable representation of the IP-Address TODO support more than one IP address!
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
	 * get hostname
	 * 
	 * @return name of the host object
	 */
	public String getName() {
		return this.getObjectAsString("name");
	}

	/**
	 * Host Name
	 * 
	 * @return Host Name
	 */
	public int getHardwareType() {
		return this.getObjectAsInt("hardware-type");
	}

	/**
	 * @return group of this host.
	 */
	public String getGroup() {
		return this.getObjectAsString("group");
	}

	/**
	 * set statements of this host.
	 * 
	 * @param val
	 */
	public void setStatements(String val) {
		this.setObjectAsString("statements", val);
	}

	/**
	 * Send this host object to the DHCP server and returns the answer as a new host object.
	 * 
	 * @param option like Message.OPEN, Message.DELETE, ...
	 * @return answer from the server as a new Host object
	 * @throws OmapiObjectException is thrown, if Object creation fails
	 * @throws OmapiInitException is thrown, if initialisation if connection fails
	 * @throws OmapiConnectionException is thrown if connection fails
	 */
	public Host send(int option) throws OmapiException {
		return new Host(this.c, super.sendMessage(option));
	}

	/**
	 * Set the IP-Address of the Object. TODO Exception
	 * 
	 * @param ipString requires the IP address as a dotted quad String (e.g. 192.168.0.1). Multiple IPs are seperated by
	 *        a comma.
	 * @throws OmapiObjectException
	 */
	public void setIPAddress(String ipString) throws OmapiObjectException {
		this.setObjectAsIpAddresses("ip-address", ipString);
	}

	/**
	 * Set's the MAC-Address of the Object.
	 * 
	 * @param mac requires the MAC address as a ":"-seperated Hex String (e.g. aa:aa:aa:aa:aa:aa)
	 * @throws OmapiObjectException if mac address is not well formatted
	 */
	public void setHardwareAddress(String mac) throws OmapiObjectException {
		this.setObjectAsMacAddress("hardware-address", mac);
	}

	/**
	 * Sets the Hostname to the given String
	 * 
	 * @param name Name of the Host
	 */
	public void setName(String name) {
		this.setObjectAsString("name", name);
	}

	/**
	 * Set the Type (1=ethernet)
	 * 
	 * @param type
	 */
	public void setHardwareType(int type) {
		this.setObjectAsInt("hardware-type", type);
	}

	/**
	 * @return This Object as readable String
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("This is an Host Object\n");
		sb.append("Name:          " + this.getName() + "\n");
		sb.append("Identifier:    " + this.getDhcpClientIdentifier() + "\n");
		sb.append("IP-Address:    " + this.getIpAddress() + "\n");
		sb.append("MAC-Address:   " + this.getHardwareAddress() + "\n");
		sb.append("Hardware-Type: " + this.getHardwareType() + "\n");
		sb.append("Group:         " + this.getGroup() + "\n");
		sb.append("known:         " + this.getKnown() + "\n");
		return sb.toString();
	}

	/**
	 * @return 1 if host is known by the server.
	 */
	public int getKnown() {
		return this.getObjectAsInt("known");
	}

	/**
	 * set group of this host.
	 * 
	 * @param string
	 */
	public void setGroup(String string) {
		this.setObjectAsString("group", string);
	}

	/**
	 * Update ip address of host object.
	 * 
	 * @param string
	 * @throws OmapiObjectException
	 */
	public void updateIPAddress(String string) throws OmapiObjectException {
		this.updateObjectAsIpAddresses("ip-address", string);
	}
}
