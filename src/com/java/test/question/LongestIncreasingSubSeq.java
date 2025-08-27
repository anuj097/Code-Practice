package com.java.test.question;

public class LongestIncreasingSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// SUBSEQUENCE -> non-contiguous numbers
		int[] arr = {10,9,2,5,3,7,101,18};
		System.out.println("Longest Increasing SubSequence Length: " + subSeq(arr));
		
		// SUBARRAY -> contiguous numbers
		int[] arr1 = {1,3,5,2,6,7,9,12,10};
		System.out.println("Longest Increasing SubArray Length: " + subArr(arr1));

	}
	
	static int subSeq(int ar[]) {
		int len = ar.length;
		
		int dp[] = new int[len+1];
		dp[0] = 1;
		
		for(int i=1;i<=len-1;i++) {
			if(ar[i-1]<ar[i]) {
				dp[i] = dp[i-1]+1;
			} else {
				dp[i] = dp[i-1];
			}
		}
		
		return dp[len-1];
	}
	
	static int subArr(int ar[]) { // {1,3,5,2,6,7,9,12,10}
		int len = ar.length;
		
		int max=1;
		int temp=1;
		
		for(int i=0;i<len-1;i++) {
			if(ar[i]<ar[i+1]) {
				temp++;
				max= Math.max(max, temp);
			} else {
				temp=1;
			}
		}
		
		return max;
	}

}
