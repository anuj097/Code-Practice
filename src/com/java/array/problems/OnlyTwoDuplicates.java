package com.java.array.problems;

import java.util.ArrayList;
import java.util.List;

public class OnlyTwoDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = {0,0,1,1,1,1,2,3,3};
		
		//int nums[] = {1,1,1,2,2,3};
		
		System.out.println(removeDuplicates(nums));
		
		System.out.println(removeDuplicate(nums));
	}

	public static int removeDuplicates(int[] nums) {
		int count=0;
        List<Integer> list = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        
        for(int n : nums) {
        	if(prev == n) {
        		count++;
        	} else {
        		prev = n;
        		count=1;
        	}
        	if(count<=2) {
        		list.add(n);
        	}
        }
        
        return list.size();
    }
	
	static int removeDuplicate(int[] nums) { //[1,1,1,2,2,3]
        int n = nums.length;
        if(n<=2){
            return n;
        }

        int j = 2;
        for(int i=2; i<n; i++){
            if(nums[i] != nums[j-2]){
                nums[j] = nums[i];			// [2,2,3,2,2]
                j++;
            }
        }
        return j;
    }
}
