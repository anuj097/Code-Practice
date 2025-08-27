package com.java.dynamicprogramming.examples;

public class BuySellStockIII {
	
	/*
	 	Only 2 times you can buy or sell stock. and get the max profit
	 	below buy=0, sell=3, profit=3, 
	 		  buy=1, sell=4, profit=3;
	 	so max profit is 6
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println("Max profit: "+ maxProfit(prices));
		
		System.out.println("Test: "+ test(prices));
	}
	
	static int test(int[] prices) {
		int buy1 = Integer.MIN_VALUE;
		int buy2 = Integer.MIN_VALUE;
		int sell1 = 0; int sell2 = 0;
		
		for(int p : prices) {
			buy1 = Math.max(buy1, -p);
			sell1 = Math.max(sell1, buy1+p);
			buy2 = Math.max(buy2, sell1-p);
			sell2 = Math.max(sell2, buy2+p);
			
		}
		
		return sell2;
	}

	static int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1=0, sell2=0;

        for(int p : prices) {
            buy1 = Math.max(buy1, -p);
            sell1 = Math.max(sell1, buy1 + p);
            buy2 = Math.max(buy2, sell1-p);
            sell2 = Math.max(sell2, buy2 + p);
        }
        return sell2;
    }

}
