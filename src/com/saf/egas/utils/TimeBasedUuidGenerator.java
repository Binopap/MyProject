package com.miraglo.egas.utils;

import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.util.SystemPropertyUtils;

/**
 * 34 * Generates a time-based {@link UUID}. Please note that this generator 35
 * * uses a pseudo HMAC which is generated based on various VM properties. 36 *
 * Therefore, the pseudo HMAC can change for each VM instance even if you 37 *
 * launch the VM in the same machine. Its purpose is to generate a unique 38 *
 * ID for one VM at most. 39 *
 * 
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 * 
 * @version $Rev: 448 $, $Date: 2008-11-07 17:23:15 +0900 (Fri, 07 Nov 2008) $
 * 
 */
public class TimeBasedUuidGenerator {

	private static final long NODE;
	private static final Object counterLock = new Object();
	private static long timestamp = System.currentTimeMillis();
	private static int clockSeq = (int) System.nanoTime();

	static {
		// Generate nodeKey - we can't use MAC address to support Java 5.
		StringBuilder nodeKey = new StringBuilder(1024);

		// // Append host / IP address information.
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			nodeKey.append(localhost.getCanonicalHostName());
			nodeKey.append(':');
			nodeKey.append(String.valueOf(localhost.getHostAddress()));
		} catch (Exception e) {
			nodeKey.append("localhost:127.0.0.1");
		}

		// // Append standard system properties.
		appendSystemProperty(nodeKey, "java.version");
		appendSystemProperty(nodeKey, "java.home");
		appendSystemProperty(nodeKey, "java.vm.version");
		appendSystemProperty(nodeKey, "java.vm.vendor");
		appendSystemProperty(nodeKey, "java.vm.name");
		appendSystemProperty(nodeKey, "os.name");
		appendSystemProperty(nodeKey, "os.arch");
		appendSystemProperty(nodeKey, "os.version");
		appendSystemProperty(nodeKey, "user.name");

		// // Append the information from java.lang.Runtime.
		nodeKey.append(':');
		nodeKey.append(Runtime.getRuntime().availableProcessors());

		// // Finally, append the another distinguishable string (probably PID.)
		try {
			RuntimeMXBean rtb = ManagementFactory.getRuntimeMXBean();
			nodeKey.append(':');
			nodeKey.append(rtb.getName());
		} catch (Exception e) {
			// Ignore.
		}

		// Generate the digest of the nodeKey.
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new InternalError("MD5 not supported");
		}

		byte[] nodeKeyDigest;
		try {
			nodeKeyDigest = md.digest(nodeKey.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new Error("UTF-8 is not found");
		}

		// Choose 5 bytes from the digest.
		// Please note that the first byte is always 1 (multicast address.)
		long node = 1;
		node = node << 8 | nodeKeyDigest[1] & 0xFF;
		node = node << 8 | nodeKeyDigest[4] & 0xFF;
		node = node << 8 | nodeKeyDigest[7] & 0xFF;
		node = node << 8 | nodeKeyDigest[10] & 0xFF;
		node = node << 8 | nodeKeyDigest[13] & 0xFF;

		// We're done.
		NODE = node;
	}

	private static void appendSystemProperty(StringBuilder buf, String key) {
		buf.append(':');
		buf.append(SystemPropertyUtil.get("mac", "null"));
	}

	/**
	 * Returns a new time-based {@link UUID}.
	 */
	public static UUID generate() {
		final long ts;
		final int cs;
		synchronized (counterLock) {
			cs = (clockSeq++) & 0x3FFF; // 0~16383
			if (cs == 0) {
				// Not all platform has millisecond precision for
				// System.currentTimeMillis() - Just focus on generating
				// unique IDs instead of using correct timestamp.
				ts = ++timestamp;
			} else {
				ts = timestamp;
			}
		}
		long msb = (ts & 0xFFFFFFFFL) << 32 | (ts >>> 32 & 0xFFFF) << 16
				| ts >>> 48 & 0xFFFF;
		long lsb = (long) cs << 48 | NODE;

		// Set to version 1 (i.e. time-based UUID)
		msb = msb & 0xFFFFFFFFFFFF0FFFL | 0x0000000000001000L;

		// Set to IETF variant
		lsb = lsb & 0x3FFFFFFFFFFFFFFFL | 0x8000000000000000L;

		return new UUID(msb, lsb);
	}

	private TimeBasedUuidGenerator() {
		// Unused
	}
}
