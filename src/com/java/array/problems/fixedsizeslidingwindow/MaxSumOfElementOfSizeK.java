package com.java.array.problems.fixedsizeslidingwindow;

import java.util.Arrays;
import java.util.Comparator;

public class MaxSumOfElementOfSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,6,7,2,4,7,6,2};		
		int size = 3;
		
		System.out.println("The Max sum of non-consecutive numbers: "+ sumOfnonConsecutiveElements(arr, size));
		
		System.out.println("The Max sum of consecutive numbers: "+ sumOfConsecutiveElements(arr, size));
	}
	
	public static int sumOfnonConsecutiveElements(int arr[], int size) {
		int sum = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).limit(size).mapToInt(s->s).sum();

		return sum;
	}
	
	public static int sumOfConsecutiveElements(int arr[], int size) {
		
		int sum =0;
		for(int i=0;i<size;i++)
			sum += arr[i];
		int res=sum;
		
		for(int i=3;i<arr.length;i++) {
			sum += arr[i] - arr[i-size];
			res = Math.max(res, sum);
		}
		return res;
	}

}
