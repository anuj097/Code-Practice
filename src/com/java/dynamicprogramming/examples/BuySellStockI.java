 package com.java.dynamicprogramming.examples;

public class BuySellStockI {

	public static void main(String[] args) {
		// n = [7, 1, 3, 5, 6, 4];
		
		int a[] = {7, 1, 3, 5, 6, 4};
		int profit = buySellStock(a, a.length);
		System.out.println(profit);
		//System.out.println(test(a, a.length));
	}
	
	public static int buySellStock(int arr[], int len) {
		int min = arr[0];
		int profit = 0;
		
		for(int i=1; i<len;i++) {
			int cost = arr[i] - min;				// the cost of buying a stock
			profit = Math.max(profit, cost);		// the profit after selling a stock
			
			min = Math.min(min, arr[i]);			// the minimum buying value of the stock (should be)
		}
		
		return profit;
	}
	
	
	

}
