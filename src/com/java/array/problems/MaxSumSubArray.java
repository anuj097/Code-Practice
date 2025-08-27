package com.java.array.problems;

public class MaxSumSubArray {

	public static void main(String[] args) {

		int arr[] = {2,1,5,2,3,4};
		int sub = 3;
		
		System.out.println("The maximum sum of sub array of length "+sub+ " is : "+ maxSumMethod(arr, sub));
	}
	
	public static int maxSumMethod(int arr[], int sub) {
		
		int maxSum = 0, res = 0;
		for(int i=0; i<sub;i++) {
			maxSum += arr[i];
		}
		res = maxSum;
		
		for(int i=sub;i<arr.length;i++) {
			maxSum += arr[i] - arr[i-sub];		// removing the first element from maxSum, so that only 3 elements get added (not 4)
			//if(maxSum>res) res = maxSum;
			res = Math.max(maxSum, res);
		}
		return res;
	}

}
