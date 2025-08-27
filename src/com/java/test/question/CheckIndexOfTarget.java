package com.java.test.question;

public class CheckIndexOfTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1,3,5,6};
		int target = 2;
		
		System.out.println("Index of target= "+ getIndex(arr, target));
	}
	
	public static int getIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right) {
            int mid= left + (right-left)/2;
            if(nums[mid]==target) {
                return mid;
            } else if(nums[mid]>target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

}
