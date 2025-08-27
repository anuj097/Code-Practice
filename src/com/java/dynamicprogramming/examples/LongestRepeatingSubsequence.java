package com.java.dynamicprogramming.examples;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "AAPDRCDBBT";
		
		String s1 = s;
		int repeating = LCS2(s, s1);
			System.out.println("we have Longest repeating subsequences: "+ repeating);
	}
	
	static int LCS2(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int dp[][] = new int[m+1][n+1];
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1) && i!=j)
					dp[i][j] = 1 + dp[i-1][j-1];
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}

}
