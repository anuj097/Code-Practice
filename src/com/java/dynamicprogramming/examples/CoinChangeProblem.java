package com.java.dynamicprogramming.examples;

import java.util.Arrays;

public class CoinChangeProblem {

	/*
	 *		use the minimum number of coins to achieve n=18
	 *
	 *		 shortest = {7,5,1}  -> 7+5*5+1 = 18
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {7,5,1};  //{1,2,5};
		
		int n =18;		//11;
		System.out.println(coinChange(n, arr));
	
		//Using Dynamic programming -dp
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		System.out.print(coinChangeUsingDP(n, arr, dp));
		
//		for(int s : dp) {
//			System.out.println(s+" ");
//		}
		
		//System.out.println("Test : " + testdp(arr, n, dp));
		
	}
	/* ------------- TRY AGAIN ---------------*/

	
	
		
	static int coinChange(int n, int arr[]) {
		if(n==0) return 0;
		int ans=Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length;i++) {
			if(n-arr[i]>=0) {
				int subarr = coinChange(n-arr[i], arr);
				
				if(subarr+1<ans) {
					ans = subarr+1;
				}
			}
		}
		
		return ans;
	}
	
	static int coinChangeUsingDP(int n, int arr[], int dp[]) {
		if(n==0) return 0;
		
		int ans = Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(n-arr[i]>=0) {
				int subarr=0;
				if(dp[n-arr[i]]!=-1) {
					subarr = dp[n-arr[i]];
				} else {
					subarr = coinChangeUsingDP(n-arr[i], arr, dp);
				}
				
				if(subarr+1<ans) {
					ans = subarr+1;
				}
			}
		}
		return dp[n] = ans;
	}

}
