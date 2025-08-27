package com.java.test.question;

public class ClimbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 4;
		
//		System.out.println(climb(n));
//		System.out.println(climbDP(n));
		
		System.out.println(test(n));

	}
	
	static int test(int n) {
		if(n==0 || n==1) return 1;
		
		int dp[] = new int[n+1];
		
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int climb(int n) {
		if(n==0 || n==1) return 1;
		
		return climb(n-1) + climb(n-2);
	}
	
	static int climbDP(int n) {
		if(n==0 || n==1) return 1;
		
		int dp[] = new int[n+1]; 
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

}
