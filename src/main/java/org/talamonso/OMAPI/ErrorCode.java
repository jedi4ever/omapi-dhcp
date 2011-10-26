package org.talamonso.OMAPI;

import java.util.HashMap;
import java.util.Map;

/**
 * Decodes the error code of the server. decodes the code as in omapip/result.c in the dhcp server sources
 * 
 * @param code
 * @return The decoded Message
 */
public enum ErrorCode
{
	SUCCESS(0, "success"),
	OUT_OF_MEMORY(1, "out of memory"),
	TIMED_OUT(2, "timed out"),
	NO_THREADS(3, "no available threads"),
	ADDR_UNAVAIL(4, "address not available"),
	ADDR_IN_USE(5, "address in use"),
	UNAUTHORIZED(6, "permission denied"),
	NO_PENDING(7, "no pending connections"),
	NET_UNREACH(8, "network unreachable"),
	HOST_UNREACH(9, "host unreachable"),
	NETWORK_DOWN(10, "network down"),
	HOST_DOWN(11, "host down"),
	CONN_REFUSED(12, "connection refused"),
	NO_RESOURCES(13, "not enough free resources"),
	END_OF_FILE(14, "end of file"),
	SOCKET_IN_USE(15, "socket already bound"),
	TASK_FINISHED(16, "task is done"),
	LOCK_BUSY(17, "lock busy"),
	ALREADY_EXISTS(18, "already exists"),
	NO_SPACE(19, "ran out of space"),
	CANCELLED(20, "operation canceled"),
	SEND_REFUSED(21, "sending events is not allowed"),
	SHUTDOWN(22, "shutting down"),
	NOT_FOUND(23, "not found"),
	UNEXPECTED_END(24, "unexpected end of input"),
	FAILURE(25, "failure"),
	IO_ERROR(26, "I/O error"),
	NOT_IMPLEMENTED(27, "not implemented"),
	PARENTHESES(28, "unbalanced parentheses"),
	NO_MORE(29, "no more"),
	INVALID_FILE(30, "invalid file"),
	BAD_BASE64(31, "bad base64 encoding"),
	UNEXPECTED_TOKEN(32, "unexpected token"),
	QUOTA_REACHED(33, "quota reached"),
	UNEXPECTED_ERROR(34, "unexpected error"),
	ALREADY_RUNNING(35, "already running"),
	HOST_UNKNOWN(36, "host unknown"),
	PROTOCOL_VERSION(37, "protocol version mismatch"),
	PROTOCOL_ERROR(38, "protocol error"),
	INVALID_ARG(39, "invalid argument"),
	NOT_CONNECTED(40, "not connected"),
	NOT_READY(41, "data not yet available"),
	NOT_CHANGED(42, "object unchanged"),
	MULTIPLE_MATCH(43, "more than one object matches key"),
	KEY_CONFLICT(44, "key conflict"),
	PARSE_ERROR(45, "parse error(s) occurred"),
	NO_KEY(46, "no key specified"),
	KEY_UNKNOWN(47, "zone TSIG key not known"),
	KEY_INVALID(48, "invalid TSIG key"),
	IN_PROGRESS(49, "operation in progress"),
	DNS_FORMAT(50, "DNS format error"),
	DNS_SERVER(51, "DNS server failed"),
	NO_DOMAIN(52, "no such domain"),
	NOT_IMPLEMENTED_2(53, "not implemented"),
	REFUSED(54, "refused"),
	DOMAIN_EXISTS(55, "domain already exists"),
	RRSET_EXISTS(56, "RRset already exists"),
	RRSET_NOEXIST(57, "no such RRset"),
	UNAUTHORIZED_2(58, "not authorized"),
	NOT_A_ZONE(59, "not a zone"),
	DNS_BAD_SIG(60, "bad DNS signature"),
	DNS_BAD_KEY(61, "bad DNS key"),
	CLOCK_SKEW(62, "clock skew too great"),
	NO_ROOT_ZONE(63, "no root zone"),
	DEST_REQUIRED(64, "destination address required"),
	CROSS_ZONE(65, "cross-zone update"),
	SIG_MISSING(66, "no TSIG signature"),
	NOT_EQUAL(67, "not equal"),
	CONN_RESET(68, "connection reset by peer"),
	ATTR_UNKNOWN(69, "unknown attribute");
	
	private final int m_Number;
	private final String m_Meaning;

	private static final Map<Integer, ErrorCode> s_InternalMap =
		new HashMap<Integer, ErrorCode>();
	
	static
	{
		for (ErrorCode ec : values())
		{
			s_InternalMap.put(ec.m_Number, ec);
		}
	}
	
	public static ErrorCode get(int code)
	{
		return s_InternalMap.get(code);
	}
	
	ErrorCode(int number, String meaning)
	{
		this.m_Number = number;
		this.m_Meaning = meaning;
	}
	
	public int getNumber()
	{
		return m_Number;
	}
	
	public String getMeaning()
	{
		return m_Meaning;
	}
}