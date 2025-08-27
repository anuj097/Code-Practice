package com.java.array.problems.fixedsizeslidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FirstLongestSubString {

	public static void main(String[] args) {
		//String s = "abcabcbb";
		//String s = "bbbbbb";
		String s = "abbaabcd";//pwwkeq
		//String s = " ";
		System.out.println("  "+ lenOfLongSubstring(s));
		System.out.println("  "+ lenOfLongSubs(s));
		
		String sa = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		//String sa = "AAAAAAAAAAAAA";
		System.out.println("DNA: "+ findRepeatedDnaSequences(sa));

	}
	
	static int lenOfLongSubstring(String s) { // this method will give you 1st char as duplicate and rest are unique 
		if(s.equals(" ")) return 0;						// ex-> abbaabcd , output-> 3 (bcd)
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, j=0;
        for(int i=0; i<s.length();i++) {
            if(map.containsKey(s.charAt(i))) {
                j = 0;
                map.replace(s.charAt(i), i);
            }
            
            map.put(s.charAt(i), i);
            max = Math.max(max, ++j);

        }
        
        return max;
    }
	
	static int lenOfLongSubs(String s) { // this method will give you contiguous non-repeating char
		if(s.equals(" ")) return 0;						// // ex-> abbaabcd , output-> 4 (abcd)
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, j=0;
        for(int i=0; i<s.length();i++) {
        	char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                j = Math.max(j, map.get(ch)+1);
            }
            
            map.put(ch, i);
            max = Math.max(max, i-j+1);
        }
        
        return max;
    }
	
	
	
	
	static List<String> findRepeatedDnaSequences(String s) {
		Set<String> seen = new HashSet<>();
	    Set<String> repeated = new HashSet<>();
	    
	    for (int i = 0; i <= s.length() - 10; i++) {
	        String sub = s.substring(i, i + 10);
	        if (!seen.add(sub)) {
	            repeated.add(sub);
	        }
	    }

	    return new ArrayList<>(repeated);
    }

}
