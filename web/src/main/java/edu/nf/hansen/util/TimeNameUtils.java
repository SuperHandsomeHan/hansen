package edu.nf.hansen.util;


public class TimeNameUtils {

	private static String name = "";

	public static String newRidName() {
		StringBuilder builder;
		while (true){
			builder = new StringBuilder();
			builder.append(System.currentTimeMillis());
			if(!name.equals(builder.toString())){
				break;
			}
		}
		name = builder.toString();
		return name;
	}

}
