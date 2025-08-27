package com.java.twoDArray.examples;

public class PrintAllElement {

	public static void main(String[] args) {
		
		int arr[][] = {
				{1,4,5}, 
				{5,7,9}, 
				{3,6,8}};
		
		for(int row=0; row < arr.length;row++) {
			for(int col=0;col < arr[0].length;col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}

	}

}
