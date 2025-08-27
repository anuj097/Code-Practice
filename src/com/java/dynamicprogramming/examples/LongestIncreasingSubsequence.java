package com.java.dynamicprogramming.examples;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int a[] = {10,9,2,5,3,7,101,18};
		int a[] = {0,1,0,3,2,3};
		//int a[] = {7,7,7,7,7,7,7};
		int len = a.length;
		
		//System.out.println("The Longest Increasing Subsequence's length is: "+ incSub(0,-1,len,a));
		System.out.println("The Longest Increasing Subsequence's length is (DP): "+ incSubDP(len, a));
		
		// If the numbers are not same {7,7,7,7}
		int dp[][] = new int[len+1][len+1];
		for(int i=0; i<dp.length;i++) {
			for(int j=0;j<dp.length;j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;
			}
		}
		//System.out.println("The Longest Increasing Subsequence's length is (DP): "+ incSubDp(len,a, dp));
	}
	
	// time complexity = O(n²)
	static int incSubDP(int n, int a[]) {
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		
		int res = 1;
		
		for(int i=1; i<n;i++) {
			for(int j=0;j<i;j++) {
				if(a[i]>a[j] && dp[j]+1>dp[i])
					dp[i] = dp[j] +1;
			}
			res = Math.max(res, dp[i]);
			System.out.print(res +" ");
		}
		
		return res;
	}
	
	
	// this approach will not work with all the cases (Ex: {7,7,7,7} , output = length of array, expected = 1)
	static int incSubDp(int n, int a[], int dp[][]) {
		
		int b[] = Arrays.copyOf(a, n);
		Arrays.sort(a);
		for(int i=1; i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(a[i-1]!=b[j-1])
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				else
					dp[i][j] = 1 + dp[i-1][j-1];
			}
		}
		
		for(int i=0; i<dp.length;i++) {
			for(int j=0;j<dp.length;j++) {
					System.out.print(dp[i][j]+ " ");
			}
			System.out.println();
		}
		
		return dp[n][n];
		
	}
	
	static int incSub(int ind, int prev, int n, int a[]) {
		if(ind==n) return 0;
	
		int len = 0 + incSub(ind+1, prev, n, a);
		if(prev==-1 || a[ind]>a[prev])
			len = Math.max(len, 1 + incSub(ind+1, ind, n, a));
		return len;
	}

}