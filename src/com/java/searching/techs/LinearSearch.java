package com.java.searching.techs;

public class LinearSearch {

	public static void main(String[] args) {
		int ar[] = {34,67,24,78,94,12,67,35};
		int val=94;

		System.out.println("Does "+val+" available in array? "+ linear(ar, val));
	}
	
	static boolean linear(int arr[], int val) {
		if(arr.length==0) return false;
		
		for(int a : arr) {
			if(val==a) {
				return true;
			}
		}
		return false;
	}

}
