package com.java.test.question;

public class MaxItemPicked {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = 10;
		int weight[] = {1,3,4,6};
		int item[] = {20, 30, 10, 50};
		
		System.out.println(maxItems(w, weight, item));

	}
	
	static int maxItems(int w, int we[], int it[]) {
		int len = we.length;
		
		int dp[][] = new int[len+1][w+1];
		
		for(int i=1;i<=len;i++) {
			for(int j=0;j<=w;j++) {
				if(we[i-1]<=j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-we[i-1]] + it[i-1]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[len][w];
	}

}
