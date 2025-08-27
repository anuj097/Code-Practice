package com.java.array.problems;

public class MedianOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2};
		int nums1[] = {3};
		
		System.out.println("Median is: "+ findMedianSortedArrays(nums, nums1));

	}

	static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double num[] = new double[nums1.length + nums2.length];

        double res = 0;
        for(int i=0;i<nums1.length;i++) {
            num[i] = nums1[i];
        }
        for(int i=0;i<nums2.length;i++) {
            num[nums1.length+i] = nums2[i];
        }
        System.out.println(num.length);
        if(num.length%2==0) {
            int div = num.length/2;
            res = (num[div-1] + num[div])/2;
        } else {
            int div = num.length/2;
            res = num[div];
        }
        
        return res;
    }
}
