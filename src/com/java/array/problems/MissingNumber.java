package com.java.array.problems;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {8,5,4,9,0,1,3,2,6};
		int len = arr.length;
		
		// to get the total sum of (1 to n) - formula
		int sum = (len+1)*len/2;
		
		for(int a : arr) {
			sum -= a;
		}
		
		System.out.print("The missing number is: "+ sum);
	}

}
