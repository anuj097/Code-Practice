package com.java.test.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = {1,2,3,1,2,3};
//		int k = 2;
//		
//		//System.out.println(containsNearbyDuplicate(arr, k));
//		
//		Map<String, String> map = new HashMap<>();
//		
//		map.put(null, null);
//		map.put("a", null);
//		map.put("b", "bb");
		//System.out.println(map.get("a"));
		
//		String s = "leeetcode";
//		System.out.println(makeFancyString(s));
		
//		int[] fur = {3,6,1};
//		int[] bas = {6,4,7};
//		
//		System.out.println(numOfUnplacedFruits(fur, bas));
		
		int ar[] = {1,4,0,-1,-2,-3,-1,-2};
		System.out.println(find132pattern(ar));
		
	}
	
	static boolean find132pattern(int[] nums) { // i<j<k      nums[i] < nums[k] < nums[j]
        if(nums==null || nums.length<3) return false;

        int i = nums[0];
        int j = nums[1];

        for(int k=2;k<nums.length;k++) {
            if(i<j && j>nums[k] && i<nums[k]) return true;

            else if(i<j && j<nums[k] || i<j && i>nums[k]) {
                j = nums[k];
            }
            else if(i>j && j<nums[k]){
                i = j;
                j = nums[k];
            }
        }
        return false;
    }
	
	static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        //boolean occupied[] = new boolean[baskets.length];
		Set<Integer> set = new HashSet<>();
		int len = fruits.length;
        int count = 0;
        for(int i=0;i<fruits.length;i++) {
            for(int j=0;j<baskets.length;j++) {
                if(fruits[i]<=baskets[j] && !set.contains(baskets[j])) {
                	set.add(baskets[j]);
                	count++;
                    break;
                }
            }
        }
        return len-count;
    }
	
	
	
	
	static String makeFancyString(String s) {
        if(s.equals("")) return "";
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int i=0;
        int count=0;
        while(s.length()-1==i) {
            if(c==s.charAt(i) && count<2) {
                sb.append(c);
                count++;
                i++;
                if(count==2) {
                    count=0;
                }
            } else if(c!=s.charAt(i)){
                if(count<2) {
                    sb.append(c);
                }
                c = s.charAt(i);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    
	
	static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> tab = new HashMap<>();

        for(int i=0;i<len;i++) {
            if(tab.containsKey(nums[i])) {
                if(Math.abs(tab.get(nums[i])-i)<=k) {
                    return true;
                } else {
                    tab.replace(nums[i], i);
                }
            } else {
                tab.put(nums[i], i);
            }
        }
        if(Math.abs(tab.get(nums[len-1])-len)<=k)
        	return true;
        return false;        
    }
	
	

}
