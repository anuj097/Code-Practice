package com.java.dynamicprogramming.examples;

/*
  			You are a professional robber planning to rob houses along a street.
			Each house has some amount of money, but:
			You can't rob two adjacent houses, or an alarm will trigger.
			An array of non-negative integers representing the amount of money in each house.
			int[] nums = {2, 7, 9, 3, 1};
			Return the maximum amount you can rob without robbing adjacent houses.
 */

public class HouseRobber {

	public static void main(String[] args) {

		//int[] nums = {2, 7, 9, 3, 1};
		//int[] nums = {2, 1, 1, 2};
		int[] nums = {1, 2, 3, 1};
		
		//System.out.println("Maximum looted amount= "+shortway(nums));
		
		System.out.println("Maximum looted amount (Using array)= "+ usingDPArray(nums));
		
		System.out.println("Maximum looted amount= "+test(nums));
	}
	
	
	//-------------------TRY AGAIN-----------------------
	
	public static int test(int num[]) {
		int prev1=0, prev2=0;
		boolean isDone=true;
		
		for(int n : num) {
			if(isDone) {
				prev1 +=n;
				isDone=false;
			} else {
				prev2 +=n;
				isDone=true;
			}
		}
		return Math.max(prev1, prev2);
	}
	
	
	
	
	
	
	
	
	
	
	public static int usingDPArray(int[] nums) { //2, 7, 9, 3, 1
		if(nums==null) return 0;
		int len = nums.length;
		
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0], nums[1]);
		
		int dp[] = new int[len];
		
		dp[0]= nums[0];
		dp[1] = nums[1];
		
		for(int i=2; i<len;i++) {
			
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		
		return dp[len-1];
	}
	
	
	public static int shortway(int[] nums) {
		int prev1 = 0;
		int prev2 = 0;
		
		for(int num : nums) {
			int temp = Math.max(prev1, prev2 + num);
			prev2 = prev1;
			prev1 = temp;
		}
		
		return prev1;
	}

}
