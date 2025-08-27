package com.java.String.problems;

public class StringRotate {

	/*
		Original alphabet:      abcdefghijklmnopqrstuvwxyz
		Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc
		
		k = k%26 . means that if we're in z location than we will roatate 'a' again.
		

	 */
	public static void main(String[] args) {
		
		String st = "middle-Outz";
		int k=2;
		System.out.print(caesarCipher(st, k));

	}
	
	static String caesarCipher(String s, int k) {
		StringBuilder result = new StringBuilder();
	    //k = k % 26; // Normalize k to be within 0-25  

	    for (char c : s.toCharArray()) {
	        if (Character.isLowerCase(c)) {
	            char shifted = (char) ((c - 'a' + k) % 26 + 'a'); // 
	            result.append(shifted);
	        } else if (Character.isUpperCase(c)) {
	            char shifted = (char) ((c - 'A' + k) % 26 + 'A');
	            result.append(shifted);
	        } else {
	            result.append(c); // Leave symbols unchanged
	        }
	    }

	    return result.toString();
	}

}
