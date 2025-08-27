package com.java.array.problems;

import java.util.HashMap;
import java.util.Map;

/*
 *  {0,1,1,1,1,1,0,0,0}; 
 *  output = 6
 *  explain = contiguous max sub array is :  {1,1,1,0,0,0} , here total 1's = 3, 0's = 3 
 *  so we have to return the total number of 1's and 0's whose count is equal.
 *  
 */
public class maxContigeusSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {0,1,1,1,1,1,0,0,0};
		
		System.out.println("The Maximum subArray whose sum is equal : "+ maxSubArray(arr));

	}
	
	public int test(int a[]) {
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int maxSubArray(int arr[]) { 	// {-1,1,1,1,1,1,-1,-1,-1}
		
		int max = 0, sum=0;
		Map<Integer, Integer> map = new HashMap<>();
		
		map.put(sum, -1);
		
		for(int a=0; a<arr.length;a++) {
			if(arr[a]==0) 
				arr[a] = -1;
		}
		
		for(int i=0; i<arr.length;i++) {
			
			sum += arr[i];
			if(map.containsKey(sum)) {		// 0,1,2
				max = i - map.get(sum);
			} else {
				map.put(sum, i);  			// -1=0,0=1,1=2,2=3,3=4,4=5
			}
				
		}
		return max;
	}

}
