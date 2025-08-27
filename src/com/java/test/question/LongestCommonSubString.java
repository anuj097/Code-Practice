package com.java.test.question;

public class LongestCommonSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ABCDEHG";
		String s2 = "ACDEHGR";
		
		//System.out.println("MAX Length of subString: "+ subString(s1, s2));
		
		String s3 = "HOLLABOYZ";
		String s4 = "LIPEBUOY";
		System.out.println("MAX Length of subString: "+ subStr(s3, s4));
		

	}
	
	static int subString(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		int max = 0;
		
		int dp[][] = new int[m+1][n+1];
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;			// if matches then take the diagonal value + 1;
					max = Math.max(max, dp[i][j]);
				}else {
					dp[i][j] = 0;						// else put the current index dp[i][j] as 0.
				}
			}
		}
		return max;
		
	}
	
	static int subStr(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();
		int dp[][] = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];

	}

}
