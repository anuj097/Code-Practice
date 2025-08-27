package com.java.test.question;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n[] = {2,7,8,3,1};
		
		System.out.println(robb(n));
		System.out.println(robbing(n));
		
		//System.out.println(test(n));

	}
	static int robb(int n[]) {
		int len = n.length;
		
		int dp[] = new int[len+1];
		dp[0] = n[0];
		dp[1] = n[1];
		
		for(int i=2;i<len;i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+n[i]);
		}
		return dp[len-1];
	}
	
	static int robbing(int n[]) {
		
		int prev = 0;
		int prev2 = 0;
		
		for(int a : n) {
			int temp = Math.max(prev2, prev+a);
			prev = prev2;
			prev2 = temp;
		}
		
		return prev2;
	}

}
