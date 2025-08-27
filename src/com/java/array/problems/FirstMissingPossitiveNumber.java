package com.java.array.problems;

import java.util.Arrays;

public class FirstMissingPossitiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int a[] = {7,8,9,11,12};
		//int a[] = {1,2,0};
		//int a[] = {3,4,-1,1};
		//int a[] = {0,1,1,2,2};
		//int a[] = {1,2,2,1,3,1,0,4,0};
		int a[] = {1,2,2,3,1,4};
		//System.out.println(firstMissingPositive(a));
		//System.out.println(firstMissingPos(a));
		System.out.println(firstMissingPosit(a));
		//System.out.println("THIS IS TEST= "+ test(a));
	}
	
	public static int test(int arr[]) {
		
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int firstMissingPositive(int[] nums) {
        int a = 1;
        int res = 0;
        Arrays.sort(nums);
        
        for(int s : nums) {
        	if(s>0) {
        		if(a!=s ) {
        			res = a;
        		} else {
        			a++;
        		}
        	}
        }
        if(res==0)
        	return a++;
        else
        	return res = a;
    }
	
	static int firstMissingPos(int[] nums) {
	    Arrays.sort(nums);
	    int a = 1;

	    for (int s : nums) {
	        if (s < a) continue; // skip duplicates and negatives
	        if (s == a) {
	            a++; // match found, increment
	        } else if (s > a) {
	            return a; // gap found
	        }
	    }

	    return a; // all values from 1 to max present
	}
	
	// Shortest way but tricky
	static int firstMissingPosit(int[] nums) {   // 1,2,2,1,3,1,0,4,0
        int n = nums.length;

        // Step 1: Place each number in its correct position if possible
        for (int i = 0; i < n; i++) {
            // while current number is in range [1, n] and not in correct position
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // Swap nums[i] with the element at its target position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Find the first position where index + 1 != value
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // This is the smallest missing positive
            }
        }

        // If all numbers from 1 to n are in place, return n + 1
        return n + 1;
    }

}
