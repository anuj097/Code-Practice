package com.java.dynamicprogramming.examples;

public class LongestCommonSusequence {

	public static void main(String[] args) {
		// common subseq = "ACB"
		String str1 = "ABCAB";
		String str2 = "AECB";
		
		// common subseq = "LBOY"
		//String str1 = "HOLLABOYZ";
		//String str2 = "LIFEBUOY";
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		System.out.println("Longest Common subsequence: "+ subseq(len1, len2, str1, str2));
		
		int dp[][] = new int[len1+1][len2+1];
		
		for(int i=1; i<=len1;i++) {
			for(int j=1; j<=len2;j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println("Longest Common subsequence (DP): "+ subseqDp(len1, len2, str1, str2, dp)); 
	}
	
	// To-Down approach without dynamic prog = O(n*m)
	static int subseq(int m, int n, String s1, String s2) {
		
		if(m==0 || n==0) return 0;
		
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			return 1 + subseq(m-1, n-1, s1, s2);
		} else {
			return Math.max(subseq(m-1, n, s1, s2), subseq(m, n-1, s1, s2));
		}
		
	}
	
	// Top-Down approach with dynamic prog (Memoization) - to memorize the common sequences, if occur = O(n*m)
	static int subseqDp(int m, int n, String s1, String s2, int dp[][]) {
		
		if(m==0 || n==0) return 0;
		
		if(dp[m][n]!=-1) return dp[m][n];
		
		if(s1.charAt(m-1)==s2.charAt(n-1)) {
			dp[m][n] = subseqDp(m-1, n-1, s1, s2, dp);
			return dp[m][n];
		} else {
			dp[m][n] = Math.max(subseq(m-1, n, s1, s2), subseq(m, n-1, s1, s2));
			return dp[m][n];
		}
	}

}
