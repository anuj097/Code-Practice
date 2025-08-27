package com.java.String.problems;

public class TimeConversion {

	public static void main(String[] args) {
		String s = "06:40:03AM";
		
		System.out.print("Time frame in 24 hours: "+ convert(s));
		
		
	}
	
	static String convert(String s) {
		StringBuilder sb = new StringBuilder();
		if(s.endsWith("PM") || s.endsWith("AM") && s.startsWith("12")) {
			String st = s.substring(0,2);
			int hours = Integer.valueOf(st);
			if(hours == 12 && s.endsWith("AM")) {
				sb.append("00"); 
			}else if(s.endsWith("PM") && !s.startsWith("12")){
				hours += 12;
				sb.append(hours);
			} else {
				sb.append(hours);
			}
			sb.append(s.subSequence(2, s.length()-2));
		} else {
			sb.append(s.subSequence(0, s.length()-2));
		}
		
		return sb.toString();
	}
}
