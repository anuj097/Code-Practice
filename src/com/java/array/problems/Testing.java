package com.java.array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n[] = {5,6,6,7,8,8};
//		int n[] = {5,7,7,8,8,10};
//		int ans[] = searchRange(n, 8); 	
//		for(int a : ans) {
//			System.out.print(a +" ");
//		}
		
		int[] v = {-1,0,1,2,-1,-4};
		//int[] v = {1,-1,-1,0};
		System.out.println(threeSum(v));
		
		//int[] v = {2,2,2,4};
		//System.out.println("unique : "+ singleNumber(v));
	}
	
	static int singleNumber(int[] nums) {
		int ones = 0;
	    int twos = 0;

	    for (final int num : nums) {
	      ones ^= (num & ~twos);
	      twos ^= (num & ~ones);
	    }

	    return ones;
    }
	
	static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list2 = new ArrayList<>();
		if(nums.length==3) {
			if(nums[0] + nums[1] + nums[2] == 0) {
				List<Integer> l = Arrays.asList(nums[0], nums[1], nums[2]);
				list2.add(l);
				return list2;
			} else {
				return Collections.emptyList();
			}
		}
        
        for(int i=0;i<nums.length;i++) {
            for(int j=1;j<nums.length-1;j++) {
                for(int k=2;k<=nums.length-1;k++) {
                    if(nums[i]+nums[j]+nums[k]==0 && i!=j && j!=k && i!=k) {
                    	List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        if(!list2.contains(list)) {
                            list2.add(list);
                        }
                    }
                }
            }
            
        }
        
        return list2;
    }
	
	static int[] searchRange(int[] nums, int target) {
        int ar[] = new int[2];
        Arrays.fill(ar,-1);
        int c=0;
        int left =0;
        int right = nums.length-1;

        if(nums.length==0) {
            return ar;
        }
        while(left<=right) {
        	int mid = right-left / 2;
        	
        	if(nums[mid]== target) {
        		ar[c] = mid;
        		right = mid-1;
        		c++;
        		if(c>1) break;
        	} else if(nums[mid]< target) {
        		left = mid +1;
        	} else {
        		right = mid -1;
        	}
        }
        
        return ar;
    }

}
