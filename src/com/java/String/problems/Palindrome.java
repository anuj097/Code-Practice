package com.java.String.problems;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aa";
		//String s = "kjowoemiduaaxasnqghxbxkiccikxbxhgqnsaxaaudimeowojk";
		
		System.out.println(palindromeIndex(s));
	}
	
	public static int palindromeIndex(String s) {
	    // Write your code here
	    StringBuilder sb = new StringBuilder(s);
	    int ind = -1;
	    int i=0, j = s.length()-1;
		while (i < j) {
			if (sb.charAt(i) != sb.charAt(j) && sb.charAt(i + 1) == sb.charAt(i)) {
				sb.delete(j, j);
				ind = j;
				break;
			} else if (sb.charAt(i) != sb.charAt(j) && sb.charAt(j - 1) == sb.charAt(j)) {
				sb.delete(i, i);
				ind = i;
				break;
			} else {
				i++;
				j--;
			}
		}
	    return ind;
	}
		

}
