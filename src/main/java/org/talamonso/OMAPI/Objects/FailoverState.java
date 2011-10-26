package org.talamonso.OMAPI.Objects;

import org.talamonso.OMAPI.Connection;
import org.talamonso.OMAPI.Message;
import org.talamonso.OMAPI.Exceptions.OmapiConnectionException;
import org.talamonso.OMAPI.Exceptions.OmapiException;
import org.talamonso.OMAPI.Exceptions.OmapiInitException;
import org.talamonso.OMAPI.Exceptions.OmapiObjectException;

/**
 * FailoverState class
 * 
 * @author Talamonso
 */
public class FailoverState extends Message {

	/**
	 * communication interrupted
	 */
	public static final int COMMUNICATION_INTERRUPTED = 3;

	/**
	 * normal
	 */
	public static final int NORMAL = 2;

	/**
	 * partner down
	 */
	public static final int PARTNER_DOWN = 1;

	/**
	 * paused
	 */
	public static final int PAUSED = 9;

	/**
	 * potential conflict
	 */
	public static final int POTENTIAL_CONFLICT = 5;

	/**
	 * recover
	 */
	public static final int RECOVER = 6;

	/**
	 * revover done
	 */
	public static final int RECOVER_DONE = 7;

	/**
	 * recover wait
	 */
	public static final int RECOVER_WAIT = 11;

	/**
	 * resolution interrupted
	 */
	public static final int RESOLUTION_INTERRUPTED = 4;

	/**
	 * shutdown
	 */
	public static final int SHUTDOWN = 8;

	/**
	 * startup
	 */
	public static final int STARTUP = 10;

	/**
	 * Constructor for a Host Object. Requires an OMAPI Connection.
	 * 
	 * @param con connection to OMAPI Server
	 */
	public FailoverState(Connection con) {
		super(con);
		this.setMessage("type", "failover-state");
	}

	/**
	 * Constructor for the received Host Object
	 * 
	 * @param c connection to OMAPI Server
	 * @param b ByteArray of the InputStream
	 * @throws OmapiObjectException
	 */
	private FailoverState(Connection con, byte[] b) throws OmapiException {
		super(con, b);
	}

	/**
	 * Shows how many updates are not acknowledged by the failover server.
	 * 
	 * @return unacked updates as int
	 */
	public int getCurUnackedUpdated() {
		return this.getObjectAsInt("cur-unacked-updates");
	}

	/**
	 * Shows the hierarchy between the servers.
	 * 
	 * @return 1 if this server is primary. 0 if any other.
	 */
	public int getHierarchy() {
		return this.getObjectAsInt("hierarchy");
	}

	/**
	 * @return Date when the last packet was sent.
	 */
	public String getLastPacketSent() {
		return this.getObjectAsDate("last-packet-sent");
	}

	/**
	 * @return Date when the last timestamp was received.
	 */
	public String getLastTimestampReceived() {
		return this.getObjectAsDate("last-timestamp-received");
	}

	/**
	 * @return Hash bucket array of this failover peer.
	 */
	public String getLoadBalanceHBA() {
		return this.getObjectAsHex("load-balance-hba");
	}

	/**
	 * @return max delay before bypassing failover peer.
	 */
	public int getLoadBalanceMaxSecs() {
		return this.getObjectAsInt("load-balance-max-secs");
	}

	/**
	 * @return local ip address used by the server.
	 */
	public String getLocalAddress() {
		return this.getObjectAsHex("local-address");
	}

	/**
	 * @return local port used by the server for sync.
	 */
	public int getLocalPort() {
		return this.getObjectAsInt("local-port");
	}

	/**
	 * @return local server state as int value.
	 */
	public int getLocalState() {
		return this.getObjectAsInt("local-state");
	}

	/**
	 * @return time when this server entered present state.
	 */
	public String getLocalStos() {
		return this.getObjectAsDate("local-stos");
	}

	/**
	 * @return count of outstanding updates.
	 */
	public int getMaxOutstandingUpdates() {
		return this.getObjectAsInt("max-outstanding-updates");
	}

	/**
	 * @return delay of remote server in seconds.
	 */
	public int getMaxResponseDelay() {
		return this.getObjectAsInt("max-response-delay");
	}

	/**
	 * @return maximum client lead time.
	 */
	public int getMclt() {
		return this.getObjectAsInt("mclt");
	}

	/**
	 * get hostname
	 * 
	 * @return name of the host object.
	 */
	public String getName() {
		return this.getObjectAsString("name");
	}

	/**
	 * @return ip address of partner server.
	 */
	public String getPartnerAddress() {
		return this.getObjectAsHex("partner-address");
	}

	/**
	 * @return port of the parner server.
	 */
	public int getPartnerPort() {
		return this.getObjectAsInt("partner-port");
	}

	/**
	 * @return the state of the partner as int value
	 */
	public int getPartnerState() {
		return this.getObjectAsInt("partner-state");
	}

	/**
	 * @return time when the remote server entered present state.
	 */
	public String getPartnerStos() {
		return this.getObjectAsDate("partner-stos");
	}

	/**
	 * @return time skew between this and the remote server.
	 */
	public int getSkew() {
		return this.getObjectAsInt("skew");
	}

	/**
	 * @param option
	 * @return response
	 * @throws OmapiObjectException
	 * @throws OmapiInitException
	 * @throws OmapiConnectionException
	 */
	public FailoverState send(int option) throws OmapiException {
		return new FailoverState(this.c, super.sendMessage(option));
	}

	/**
	 * Sets the local state (don't try this)
	 * 
	 * @param n
	 */
	public void updateLocalState(int n) {
		this.updateObjectAsInt("local-state", n);
	}

	/**
	 * Set name of the failover state configuration.
	 * 
	 * @param val
	 */
	public void setName(String val) {
		this.setObjectAsString("name", val);
	}

	/**
	 * Displays the detailed information in an readable form
	 * 
	 * @return details of this Objects
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("This is an FailoverPair Object\n");
		sb.append("Name:                    " + this.getName() + "\n");
		sb.append("Partner address:         " + this.getPartnerAddress() + ":" + this.getPartnerPort() + "\n");
		sb.append("Local address:           " + this.getLocalAddress() + ":" + this.getLocalPort() + "\n");
		sb.append("Max outstanding upd.:    " + this.getMaxOutstandingUpdates() + "\n");
		sb.append("Max client lead time:    " + this.getMclt() + "\n");
		sb.append("Max load balance sec:    " + this.getLoadBalanceMaxSecs() + "\n");
		sb.append("Load balance hba:\n" + this.getLoadBalanceHBA());
		sb.append("Local state:             " + this.getLocalState() + "\n");
		sb.append("Partner state:           " + this.getPartnerState() + "\n");
		sb.append("Local stos:              " + this.getLocalStos() + "\n");
		sb.append("Partner stos:            " + this.getPartnerStos() + "\n");
		sb.append("Hierarchy:               " + this.getHierarchy() + "\n");
		sb.append("Last packet send:        " + this.getLastPacketSent() + "\n");
		sb.append("Last timestamp received: " + this.getLastTimestampReceived() + "\n");
		sb.append("Clock Skew:              " + this.getSkew() + "\n");
		sb.append("Max response delay:      " + this.getMaxResponseDelay() + "\n");
		sb.append("Cur. unacked updates:    " + this.getCurUnackedUpdated() + "\n");
		return sb.toString();
	}
}
