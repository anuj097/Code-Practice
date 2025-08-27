package com.java.dynamicprogramming.examples;

public class MaximumSubArray {
	
	/*
	 * Best Approach -> Kadane’s Algorithm (Sub array)
	 * need to find the max subArray (contiguous).
	 * Input -> [-2,1,-3,4,-1,2,1,-5,4]
	 * OutPut -> 6 {4,-1,2,1}
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		int arr[] = {2,-2,4,-1,2,1,-4};
		System.out.println("MAX SUB: "+ maxSub(arr));
		
	}
	
	static int maxSub(int arr[]) {
		int max=arr[0], curr=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			curr = Math.max(arr[i], curr+arr[i]);			// 
			max = Math.max(curr, max);	// 
		}
		
		return max;
	}
}
