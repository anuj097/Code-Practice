package com.java.dynamicprogramming.examples;


/* buy and sell as many as stock you want..
 * Get the maximum profit from it
 * If you have buy a stock first day then you have to sell it before buying a new stock next day, 
 * you need to sell the previous stock first.
 * don't go like: buy buy buy then sell sell sell. you need to go like: buy sell, buy sell, buy sell */

public class BuySellStockII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		int arr[] = {34,82,16,74,55,46,44,25,96,80,51,62,73,26,76,30,20,30,55,6,3,93,74,
//					80,8,13,3,82,1,35,68,22,81,63,77,41,51,84,36,46,86,71,5,65,65,91,97,
//					57,92,96,57,97,74,33,19,42,44,22,12,26};
		
		//int arr[] = {7, 1, 5, 3, 6, 4};
		int arr[] = {1,2,5,1,8};
		int profit = buySellStock(0, 1, arr, arr.length);
		
		int profit1 = maxProfit(arr);
		
		System.out.println("using recurssion= "+profit);
		System.out.println("using single loop= "+profit1);
		
		//System.out.println("Testing= "+ test(arr));
	
	}
	
	
	//simple and have O(n) time complexity and O(1) space complexity.
	static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
	
	// Time limit exceed 
	static int buySell(int m, int n, int a[], int l) {
		if(m==l) return 0;
		
		int profit=0;
		
		if(n==1) {
			profit = Math.max(- a[m] + buySell(m+1, 0, a, l), 0 + buySell(m+1, 1, a, l));
		} else {
			profit = Math.max(a[m] + buySell(m+1, 1, a, l), 0 + buySell(m+1, 0, a, l));
		}
		
		return profit;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int buySellStock(int ind, int buy, int arr[], int n) {
		
		if(ind == n)
			return 0;
		
		int profit = 0;
		if(buy==1) {
			profit = Math.max(-arr[ind] + buySellStock(ind+1, 0, arr, n) 
									, 0 + buySellStock(ind+1, 1, arr, n));
			
		} else {
			profit = Math.max(arr[ind] + buySellStock(ind+1, 1, arr, n)
									, 0 + buySellStock(ind+1, 0, arr, n));
		}
		
		return profit;
		
	}

}
