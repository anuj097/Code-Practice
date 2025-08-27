package com.java.array.problems;

public class GoodSubArray {

	// GoodArray: if the sum of 2 consecutive elements is divided by a given variable k is equals to 0.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {23,6,9,2,4};
		
		int k = 6;
		
		System.out.println("Is Good Array? "+ goodArray(arr, k));
		
		System.out.println("Test? "+ test(arr, k));
	}
	
	
	
	public static boolean test(int a[], int k) {
		
		for(int i=1;i<a.length;i++) {
			if((a[i-1]+a[i])%k==0) {
				return true;
			} else {
				continue;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean goodArray(int arr[], int k) {
		
		int res = 0;
				
		if((arr[0] + arr[1])%k==0) 
			return true;
		else
			res = arr[0] + arr[1];
		
		for(int i=2;i<arr.length;i++) {
			res += arr[i] - arr[i-2];			// add a new element in res and remove the first added element
			
			if(res%2==0) return true;
		}
		
		return false;
		
	}

}
