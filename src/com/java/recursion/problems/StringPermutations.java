package com.java.recursion.problems;

public class StringPermutations {

	public static void main(String[] args) {
		
		String s1="abc";
		System.out.println("Permutations are: ");
		
		generatePermutations(s1, "");

	}
	static void generatePermutations(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix); // Print the complete permutation
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            // Pick one character, then permute the rest
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            generatePermutations(remaining, prefix + ch);
        }
    }

}
