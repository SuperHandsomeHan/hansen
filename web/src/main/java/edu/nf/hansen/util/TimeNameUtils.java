package edu.nf.hansen.util;


public class TimeNameUtils {

	public static String newRidName() {
		StringBuilder builder = new StringBuilder();
		builder.append(System.currentTimeMillis());
		return builder.toString();
	}

}
