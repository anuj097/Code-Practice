package com.java.String.problems;

public class MatchFirstSubString {
	
	/*
	 * String s1 = "sadbutsad" , s2 = "sad"
	 * if s1 contains s2 than return the index of first matching character from s1
	 * in above s2 occur 2 times in s1, so we need to return the first index of matching character
	 * here return index will be 0 as first ocurrance starts from 0 length.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "sadbutsad";
		String s2 = "sad";
		
		System.out.println(match(s1, s2));

	}
	
	static int match(String s1, String s2) {
		for(int i=0, j=s2.length();j<=s1.length();i++, j++) {
			if(s1.substring(i,j).equals(s2))  {
				return i;
			}
		}
		return -1;
	}

}
