package com.java.searching.techs;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = {2,5,6,8,12,34,56,59,67,89};
		int val=35;
		System.out.println("Does "+val+" available in array? "+ binary(arr, val));

	}
	
	static boolean binary(int arr[], int val) {
		int l = 0, r = arr.length-1;
		
		while(l<=r) {
			int mid = (l+r)/2;
			
			if(arr[mid]<val) {
				l = mid+1;
			} else if(arr[mid]>val){
				r = mid-1; 
			} else {
				return true;
			}
		}
		return false;
	}

}
