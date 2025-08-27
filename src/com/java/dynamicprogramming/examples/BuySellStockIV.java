package com.java.dynamicprogramming.examples;

public class BuySellStockIV {
	
	/*
	 * Write a java program to find the max profit based on the given prices and the given Money.
	 * For this example, the best buy price should be 8 and sell price should be 155 Money = 20;
	 * Prices = [23, 230, 16, 24, 35, 80, 70, 18, 29, 150, 8, 155, 17];
	 */

	public static void main(String[] args) {
		int[] prices = {23, 230, 16, 24, 35, 80, 70, 18, 29, 150, 8, 155, 17};
		int money = 20;
		
		System.out.println("Max profit using given "+money+" money is: " + buy(prices, money));
		System.out.println("Max profit using given "+money+" money is: " + bestStock(prices, money));
	}
	
	// way 1
	static int buy(int a[], int m) {
		int profit = 0;
		int buy = 0;
		int check=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>m && check==0) {
				continue;
			}else if(a[i]<m && check==0) {
				buy = a[i++];
				check++;
			}
			
			int cost = a[i] - buy;
			profit = Math.max(profit, cost);
			buy = Math.min(buy, a[i]);
		}
		return profit;
	}
	
	// way 2
	static int bestStock(int ar[], int m) {
		int profit=0;
		int buy=0;
		boolean check=true;
		for(int i=0;i<ar.length;i++) {
			if(ar[i]<m && check || !check && ar[i]<buy) { // first time buy will be 0 so it
				if(buy==0)								// passes and check become false
					check=false;						// next time always second condition will work
				buy = ar[i];
				continue;
			}
			if(buy!=0) {
				profit = Math.max(profit, ar[i]-buy);
			}
		}
		return profit;
	}

}
