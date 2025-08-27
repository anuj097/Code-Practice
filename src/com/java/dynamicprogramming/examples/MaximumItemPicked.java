package com.java.dynamicprogramming.examples;


public class MaximumItemPicked {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int w = 10;
		int weight[] = {1,3,4,6};
		int item[] = {20, 30, 10, 50};
		
		//System.out.println(maxValues(w, weight, item));
		System.out.println(maxVl(w, weight, item));
	}

	static int maxVl(int w, int we[], int it[]) {
		int len = it.length;
		int dp[][] = new int[len+1][w+1];
		
		
		for(int i=1;i<=len;i++) {
			for(int j=0;j<=w;j++) {
				if(we[i-1]<=j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j- we[i-1]] + it[i-1]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[len][w];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int maxValues(int w, int weight[], int item[]) {
		int len = item.length;
		int dp[][] = new int[len+1][w+1];
		
		for(int i=1;i<=len;i++) {
			for(int j=0;j<=w;j++) {
				if(weight[i-1]<=j)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]]+item[i-1]);
				else
					dp[i][j] = dp[i - 1][j];
			}
			
		}
		return dp[len][w];
	}

}
