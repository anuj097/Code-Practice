package com.java.twoDArray.examples;

public class SwapFirstRowToLast {

	public static void main(String[] args) {
		
		int arr[][] = {
				{1,4,5}, 
				{5,7,9}, 
				{3,6,8}};
		
		int len = arr.length-1;
		for(int row=0; row < arr.length;row++) {
			for(int col=0;col < arr[0].length;col++) {
				if(row==0) {
					int swap = arr[row][col];
					arr[row][col] = arr[len][col];
					arr[len][col] = swap;
				}
			}
		}
		
		for(int row=0; row < arr.length;row++) {
			for(int col=0;col < arr[0].length;col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}

	}

}
