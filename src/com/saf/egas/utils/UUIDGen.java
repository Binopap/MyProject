package com.miraglo.egas.utils;

import java.util.Date;
import java.util.Random;

public class UUIDGen {
	public static void main(String args[]) {
		System.out.println(getRandomNumber(32));
	}

	private static Random rnd = new Random(new Date().getTime());

	public static String getRandomNumber(int digCount) {
		StringBuilder sb = new StringBuilder(digCount);
		for (int i = 0; i < digCount; i++) {
			sb.append((char) ('0' + rnd.nextInt(10)));
		}
		return sb.toString();
	}
}
