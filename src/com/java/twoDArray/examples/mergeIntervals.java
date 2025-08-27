package com.java.twoDArray.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] num = {{1,3},{2,6},{8,10},{15,18}};
		
		int[][] res = merge(num);
		
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[i].length;j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static int[][] merge(int[][] num) {
		
		// sorting 2D array based on first number, cause inner arrays are already sorted
		Arrays.sort(num, (a,b) -> Integer.compare(a[0],b[0]));
		
		List<int[]> merged = new ArrayList<>();
		int[] prev = num[0];
		
		for(int i=1;i<num.length;i++) {
			int[] curr = num[i];
			
			if(curr[0]<=prev[1]) {
				prev[1] = Math.max(prev[1], curr[1]);
			} else {
				merged.add(prev);
				prev = curr;
			}
		}
		merged.add(prev);
		
		return merged.toArray(new int[merged.size()][]);
	}

}
