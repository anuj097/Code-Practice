package com.java.String.problems;

public class ReverseAString {

	public static void main(String[] args) {
		String s = "Acoder";
		
		System.out.println("Approach 1: "+ approachOne(s));
		System.out.println("Approach 2: "+ approachTwo(s));

	}
	
	static String approachOne(String s) {
	
		StringBuilder sb = new StringBuilder();
		for(int i=s.length()-1;i>=0;i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();	
	}
	
	static String approachTwo(String s) {
		char c[] = s.toCharArray();
		int a = c.length-1;
		int i=0;
		
		while(a>i) {
			char temp = c[i];
			c[i] = c[a];
			c[a] = temp;
			i++;
			a--;
		}
		return new String(c);
	}

}
