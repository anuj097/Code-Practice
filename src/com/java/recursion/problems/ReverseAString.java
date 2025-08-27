package com.java.recursion.problems;

public class ReverseAString {

	public static void main(String[] args) {
		
		String str = "Anuj";
		System.out.println("After reverse: "+ reverse(str));

	}
	
	public static String reverse(String str) {
		
		if(str.isEmpty()) return str;
		
		return reverse(str.substring(1))+ str.charAt(0);
	}

}
