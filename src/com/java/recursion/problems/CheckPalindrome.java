package com.java.recursion.problems;

public class CheckPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "JALBJ";
		if(str.equalsIgnoreCase(palindrome(str, 0, str.length()-1))) {
			System.out.println("Given String is a Palindrome Number");
		}
	}
	
	public static String palindrome(String str, int start, int end) {
		
		if(start>=end) return str;
		
		if(str.charAt(start)!=str.charAt(end)) throw new IllegalArgumentException("Not a Palindrome number");
		
		return palindrome(str, start+1, end-1);
	}

}
