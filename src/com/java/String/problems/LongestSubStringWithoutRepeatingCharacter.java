package com.java.String.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacter { //subString means - contiguous

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String s = "dvdf";
		String s = "pwwkew";
		
		System.out.println("Using Map the length is: "+ usingMap(s)); // kew
		
		System.out.println("Using Map the length is: "+ usingSet(s)); // kew

	}
	//Using Set
	static int usingSet(String s) {
        if(s.equals(" ")) return 1;
        
        Set<Character> set = new HashSet<>();
        int left=0, right=0, max=0;
        while(right<s.length()) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(max, right-left+1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
	
	//Using Map
	static int usingMap(String s) {
        if(s.equals(" ")) return 1;

        Map<Character, Integer> map = new HashMap<>();
        int max=0, j=0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.replace(ch, i);
                j = Math.max(max, i - map.get(ch) );
            } else {
                map.put(ch,i);
                max = Math.max(max, i-j+1);
            }
        }
        return max;
    }
}
