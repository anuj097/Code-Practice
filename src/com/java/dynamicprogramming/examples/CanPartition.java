package com.java.dynamicprogramming.examples;

public class CanPartition {

	/*
	 	Given an integer array nums, return true if you can partition 
	 	the array into two subsets such that the sum of the elements 
	 	in both subsets is equal or false otherwise.
	 	Input: nums = [1,5,11,5]
		Output: true
		Explanation: The array can be partitioned as [1, 5, 5] and [11].
	 */
	public static void main(String[] args) {
		//int[] nums = {1,5,11,5};
		int[] nums = {2,2,1,1};
		//int[] nums = {1,2,3,4,5};
		System.out.println(partition(nums));
	}
	
	static boolean partition(int nums[]) {
		int totalSum = 0;
		for(int n : nums) {
			totalSum += n;
		}
		if(totalSum%2!=0) {
			return false;
		}
		int target = totalSum/2;
		boolean[] dp = new boolean[target+1];
		dp[0] = true;
		
		for(int n : nums) {
			for(int curr = target;curr>=n;curr--) {
				dp[curr] = dp[curr] || dp[curr-n];
				if(dp[target]) return true;
			}
		}
		
		return false;
	}

}
