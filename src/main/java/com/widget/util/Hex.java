package com.widget.util;

/**
 * Look - it's a disclaimer!
 * <p>
 * Copyright (c) 1996, WIDGET WORKSHOP Inc. All Rights Reserved.
 * <p>
 * Permission to use, copy, modify, and distribute this software and its documentation for NON-COMMERCIAL or COMMERCIAL
 * purposes and without fee is hereby granted, provided that this copyright notice is kept intact.
 * <p>
 * WIDGET WORKSHOP MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR
 * NON-INFRINGEMENT. WIDGET WORKSHOP SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 * <p>
 * THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS
 * REQUIRING FAIL-SAFE PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT NAVIGATION OR COMMUNICATION
 * SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE SOFTWARE
 * COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES").
 * WIDGET WORKSHOP SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR HIGH RISK ACTIVITIES.
 * <p>
 * What won't those crazy lawyers think up next?
 */
public class Hex {
	
	// Converts a string of hex digits into a byte array of those digits
	static public byte[] toByteArr(String no) {
		String nu = no.replaceAll(" ", "");
		byte[] number = new byte[nu.length() / 2];
		int i;
		for (i = 0; i < nu.length(); i += 2) {
			int j = Integer.parseInt(nu.substring(i, i + 2), 16);
			number[i / 2] = (byte) (j & 0x000000ff);
		}
		return number;
	}

	static public void printHex(byte[] b) {
		Hex.printHex(b, b.length);
	}

	static public void printHex(short[] b) {
		Hex.printHex(b, b.length);
	}

	static public void printHex(int[] b) {
		Hex.printHex(b, b.length);
	}

	static public void printHex(String label, byte[] b) {
		Hex.printHex(label, b, b.length);
	}

	static public void printHex(String label, short[] b) {
		Hex.printHex(label, b, b.length);
	}

	static public void printHex(String label, int[] b) {
		Hex.printHex(label, b, b.length);
	}

	static public String toHexF(String label, byte[] b) {
		return Hex.toHexF(label, b, b.length);
	}

	static public String toHexF(String label, short[] b) {
		return Hex.toHexF(label, b, b.length);
	}

	static public String toHexF(String label, int[] b) {
		return Hex.toHexF(label, b, b.length);
	}

	static public String toHexF(int[] b) {
		return Hex.toHexF(b, b.length);
	}

	static public String toHexF(short[] b) {
		return Hex.toHexF(b, b.length);
	}

	static public String toHexF(byte[] b) {
		return Hex.toHexF(b, b.length);
	}

	static public String toHex(byte[] b) {
		return Hex.toHex(b, b.length);
	}

	static public String toHex(short[] b) {
		return Hex.toHex(b, b.length);
	}

	static public String toHex(int[] b) {
		return Hex.toHex(b, b.length);
	}

	static public void printHex(String label, byte[] b, int len) {
		System.out.println(label);
		Hex.printHex(b, len);
	}

	static public void printHex(String label, short[] b, int len) {
		System.out.println(label);
		Hex.printHex(b, len);
	}

	static public void printHex(String label, int[] b, int len) {
		System.out.println(label);
		Hex.printHex(b, len);
	}

	static public void printHex(byte[] b, int len) {
		System.out.print(Hex.toHexF(b, len));
	}

	static public void printHex(short[] b, int len) {
		System.out.print(Hex.toHexF(b, len));
	}

	static public void printHex(int[] b, int len) {
		System.out.print(Hex.toHexF(b, len));
	}

	static public String toHexF(String label, int[] b, int len) {
		return label + "\n" + Hex.toHexF(b, len);
	}

	static public String toHexF(String label, short[] b, int len) {
		return label + "\n" + Hex.toHexF(b, len);
	}

	static public String toHexF(String label, byte[] b, int len) {
		return label + "\n" + Hex.toHexF(b, len);
	}

	static public String toHexF(byte[] b, int len) {
		StringBuffer s = new StringBuffer("");
		int i;
		if (b == null) {
			return "><null>";
		}
		for (i = 0; i < len; i++) {
			s.append(" " + Hex.toHex(b[i]));
			if (i % 16 == 15) {
				s.append("\n");
			} else if (i % 8 == 7) {
				s.append(" ");
			} else if (i % 4 == 3) {
				s.append(" ");
			}
		}
		if (i % 16 != 0) {
			s.append("");
		}
		return s.toString();
	}

	static public String toHexF(short[] b, int len) {
		StringBuffer s = new StringBuffer("");
		int i;
		if (b == null) {
			return "><null>";
		}
		for (i = 0; i < len; i++) {
			s.append(" " + Hex.toHex(b[i]));
			if (i % 16 == 7) {
				s.append("\n");
			} else if (i % 4 == 3) {
				s.append(" ");
			}
		}
		if (i % 8 != 0) {
			s.append("\n");
		}
		return s.toString();
	}

	static public String toHexF(int[] b, int len) {
		StringBuffer s = new StringBuffer("");
		int i;
		if (b == null) {
			return "><null>";
		}
		for (i = 0; i < len; i++) {
			s.append(" " + Hex.toHex(b[i]));
			if (i % 4 == 3) {
				s.append("\n");
			}
		}
		if (i % 4 != 0) {
			s.append("\n");
		}
		return s.toString();
	}

	static public String toHex(int[] b, int len) {
		if (b == null) {
			return "";
		}
		StringBuffer s = new StringBuffer("");
		int i;
		for (i = 0; i < len; i++) {
			s.append(Hex.toHex(b[i]));
		}
		return s.toString();
	}

	static public String toHex(short[] b, int len) {
		if (b == null) {
			return "";
		}
		StringBuffer s = new StringBuffer("");
		int i;
		for (i = 0; i < len; i++) {
			s.append(Hex.toHex(b[i]));
		}
		return s.toString();
	}

	static public String toHex(byte[] b, int len) {
		if (b == null) {
			return "";
		}
		StringBuffer s = new StringBuffer("");
		int i;
		for (i = 0; i < len; i++) {
			s.append(Hex.toHex(b[i]));
		}
		return s.toString();
	}

	static public String toHex(byte b) {
		Integer I = new Integer(((b) << 24) >>> 24);
		int i = I.intValue();
		if (i < (byte) 16) {
			return "0" + Integer.toString(i, 16);
		}
		return Integer.toString(i, 16);
	}

	static public String toHex(short i) {
		byte b[] = new byte[2];
		b[0] = (byte) ((i & 0xff00) >>> 8);
		b[1] = (byte) ((i & 0x00ff));
		return Hex.toHex(b[0]) + Hex.toHex(b[1]);
	}

	static public String toHex(int i) {
		byte b[] = new byte[4];
		b[0] = (byte) ((i & 0xff000000) >>> 24);
		b[1] = (byte) ((i & 0x00ff0000) >>> 16);
		b[2] = (byte) ((i & 0x0000ff00) >>> 8);
		b[3] = (byte) ((i & 0x000000ff));
		return Hex.toHex(b[0]) + Hex.toHex(b[1]) + Hex.toHex(b[2]) + Hex.toHex(b[3]);
	}
}
