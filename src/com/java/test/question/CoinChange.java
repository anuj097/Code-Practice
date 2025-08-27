package com.java.test.question;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val = 18, ar[] = {7,5,1};
		
		System.out.println(coins(val, ar));
//		
		int dp[] = new int[val+1];
		Arrays.fill(dp, -1);
		System.out.println(coinsDP(val, ar,dp));
		
		//System.out.println(test(val, ar, dp));

	}
	
	static int coins(int val, int a[]) {
		if(val==0) return 0;
		int max = Integer.MAX_VALUE;
		
		for(int i=0;i<a.length;i++) {
			if(val-a[i]>=0) {
				int temp = coins(val-a[i], a);
				
				if(temp+1<max) {
					max = temp+1;
				}
			}
		}
		return max;
	}
	
	static int coinsDP(int val, int a[], int dp[]) {
		if(val==0) return 0;
		int max = Integer.MAX_VALUE;
		
		for(int i=0;i<a.length;i++) {
			if(val-a[i]>=0) {
				int temp=0;
				
				if(dp[val-a[i]]!=-1) {
					temp = dp[val-a[i]];
				}else {
					temp = coinsDP(val-a[i], a, dp);
				}
				
				if(temp+1<max) {
					max = temp+1;
				}
			}
		}
		return dp[val] = max;
	}

}
