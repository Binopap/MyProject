package com.miraglo.egas.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SystemPropertyUtil {
	public static String get(String key, String alternative) {
		if (key.equals("mac")) {
			InetAddress ip;
			try {

				ip = InetAddress.getLocalHost();

				NetworkInterface network = NetworkInterface
						.getByInetAddress(ip);

				byte[] mac = network.getHardwareAddress();

				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < mac.length; i++) {
					sb.append(String.format("%02X%s", mac[i],
							(i < mac.length - 1) ? "-" : ""));
				}
				return sb.toString();

			} catch (UnknownHostException e) {

				e.printStackTrace();

			} catch (SocketException e) {

				e.printStackTrace();

			}
			return alternative;
		} else {
			return alternative;
		}
	}
}
