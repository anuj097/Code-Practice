package com.java.array.problems;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSumIndexes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[] = {2,7,11,15};
		int target = 13;
		System.out.println("Using Two For Loops.....");
		int res[] = twoSum(nums, target);
		for(int r : res) {
			System.out.print(r + " ");
		}
		System.out.println();
		System.out.println("Using Map.....");
		int res2[] = twoSum(nums, target);
		for(int r : res2) {
			System.out.print(r + " ");
		}
		
//		System.out.println();
//		System.out.println("Test.....");
//		int res3[] = twoSum(nums, target);
//		for(int r : res3) {
//			System.out.print(r + " ");
//		}

	}
	
	static int[] twoSum(int[] nums, int target) {
		if(nums.length<1)	return new int[] {};
		if(nums.length==1)	return new int[] {0};
		if(nums.length==2)	return new int[] {0,1};
		
		for(int i=0; i<nums.length;i++) {
			for(int j=i+1; j<nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					return new int[] {i,j};
				}
			}
		}
		return new int[] {};
		
	}
	
	static int[] twoSumMap(int[] nums, int target) {
		if(nums.length<1)	return new int[] {};
		if(nums.length==1)	return new int[] {0};
		if(nums.length==2)	return new int[] {0,1};
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<nums.length;i++) {
			int val = nums[i] - target;
			if(map.containsKey(val)) {
				return new int[] {map.get(val), i};
			}
			
			map.put(val,  i);
		}
		
		return new int[] {};
	}
}
