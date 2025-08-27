package com.java.dynamicprogramming.examples;

public class FindHighestProfit {
	
	/*
	 * Find highest profit using two non-consecutive elements from given array
	 * 
	 */

	public static void main(String[] args) {
		
		int arr[] = {15,9,6,9,10,8};
		
		System.out.print("The Maximum profit is: "+ highestProfit(arr));
	}
	
	public static int highestProfit(int arr[]) {
		
		int prev= 0;
		int next= 0;
		
		int profit = 0;
		
		for(int i=0; i<arr.length;i++) {	
			
			if(prev<next)
				prev = arr[i];
			else
				next = arr[i];
			
			profit = Math.max(profit, prev + next);
			
		}
		
		return profit;
	}

}
