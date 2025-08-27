package com.java.dynamicprogramming.examples;

public class ConvertOneStringToAnother {

	// Minimum insertion and deletion to convert a String s1 into s2
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "intention";	//"ABCAD";	//"horse";
		String s2 = "execution";	//"ACDB";		//"ros";
		
		int m = s1.length();
		int n = s2.length();
		
		int lcsLen = LCS(m, n, s1, s2);
		System.out.println("LCS of both String: "+lcsLen); // replace , delete, insert
		
		int decrease = m - lcsLen;
		int increase = n - lcsLen;
		
		System.out.println("Number of deletion required IN s1: "+ decrease);
		System.out.println("Number of deletion required IN s2: "+ increase);
		
		System.out.println();
		// edit distance . means total change(insert/delete/replace) required to convert s1 to s2
		System.err.println(editDistance(m, n, s1, s2));

	}
	
	static int LCS(int m, int n, String s1, String s2) {
		int dp[][] = new int[m+1][n+1];
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = 1+dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m][n];
	}
	
	static int editDistance(int m, int n, String s1, String s2) {
		int dp[][] = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) dp[i][0] = i; // cost of deletions
		for (int j = 0; j <= n; j++) dp[0][j] = j; // cost of insertions
		
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = 1+dp[i-1][j-1];
				else
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
			}
		}
		return dp[m][n];
	}

}
