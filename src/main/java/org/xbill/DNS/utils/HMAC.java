// Copyright (c) 1999-2004 Brian Wellington (bwelling@xbill.org)
package org.xbill.DNS.utils;

import java.util.Arrays;
import java.security.*;

/**
 * A pure java implementation of the HMAC-MD5 secure hash algorithm
 * 
 * @author Brian Wellington
 */
public class HMAC {

	MessageDigest dig;

	private byte[] ipad;

	private byte[] opad;

	private static final byte IPAD = 0x36;

	private static final byte OPAD = 0x5c;

	private static final byte PADLEN = 64;

	private void init(byte[] key) {
		int i;
		byte[] k = key;
		if (k.length > HMAC.PADLEN) {
			k = this.dig.digest(k);
			this.dig.reset();
		}
		this.ipad = new byte[HMAC.PADLEN];
		this.opad = new byte[HMAC.PADLEN];
		for (i = 0; i < k.length; i++) {
			this.ipad[i] = (byte) (k[i] ^ HMAC.IPAD);
			this.opad[i] = (byte) (k[i] ^ HMAC.OPAD);
		}
		for (; i < HMAC.PADLEN; i++) {
			this.ipad[i] = HMAC.IPAD;
			this.opad[i] = HMAC.OPAD;
		}
		this.dig.update(this.ipad);
	}

	/**
	 * Creates a new HMAC instance
	 * 
	 * @param digest The message digest object.
	 * @param key The secret key
	 */
	public HMAC(final MessageDigest digest, final byte[] key) {
		digest.reset();
		this.dig = digest;
		this.init(key);
	}

	/**
	 * Creates a new HMAC instance
	 * 
	 * @param digestName The name of the message digest function.
	 * @param key The secret key.
	 */
	public HMAC(final String digestName, final byte[] key) {
		try {
			this.dig = MessageDigest.getInstance(digestName);
		} catch (final NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("unknown digest algorithm " + digestName);
		}
		this.init(key);
	}

	/**
	 * Adds data to the current hash
	 * 
	 * @param b The data
	 * @param offset The index at which to start adding to the hash
	 * @param length The number of bytes to hash
	 */
	public void update(final byte[] b, final int offset, final int length) {
		this.dig.update(b, offset, length);
	}

	/**
	 * Adds data to the current hash
	 * 
	 * @param b The data
	 */
	public void update(final byte[] b) {
		this.dig.update(b);
	}

	/**
	 * Signs the data (computes the secure hash)
	 * 
	 * @return An array with the signature
	 */
	public byte[] sign() {
		final byte[] output = this.dig.digest();
		this.dig.reset();
		this.dig.update(this.opad);
		return this.dig.digest(output);
	}

	/**
	 * Verifies the data (computes the secure hash and compares it to the input)
	 * 
	 * @param signature The signature to compare against
	 * @return true if the signature matched, false otherwise
	 */
	public boolean verify(final byte[] signature) {
		return Arrays.equals(signature, this.sign());
	}

	/**
	 * Resets the HMAC object for further use
	 */
	public void clear() {
		this.dig.reset();
		this.dig.update(this.ipad);
	}
}
