package com.java.dynamicprogramming.examples;

/*
	You are climbing a staircase. It takes n steps to reach the top.
	Each time, you can either climb 1 or 2 steps.
	How many distinct ways can you climb to the top?
	
	For n = 3, the ways are:
		1 + 1 + 1
		1 + 2
		2 + 1
		3
	So, output is 3.
 */

public class ClimbingStair {

	public static void main(String[] args) {
		
		int n = 3;
		
		System.out.println("The number of ways to climb "+ n + " number of stairs are: "+ climbing(n));
		System.out.println("The number of ways to climb "+ n + " number of stairs are: "+ climbShort(n));
		System.out.println("The number of ways to climb "+ n + " number of stairs are: "+ climb(n));
		//System.out.println(test(n));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// tabulation
	static int climbShort(int n) {
		if(n==0 || n==1) return 1;
		
		int prev1 = 1;
		int prev2 = 1;
		int current=0;
		
		for(int i=2;i<=n;i++) {
			current = prev1 + prev2;
			prev1 = prev2;
			prev2 = current;
		}
		return current;
	}
	
	// recurssion
	static int climbing(int n) {
		if(n==0 || n==1) return 1;
		
		int ans = climbing(n-1) + climbing(n-2);
		
		return ans;
	}
	
	// memoization using dp
	public static int climb(int n) {
		
		int dp[] = new int[n+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}

}
