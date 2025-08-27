package com.java.String.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnagramStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "race", s2 = "care";
		
		//System.out.println(s1+ " and " +s2+ " are Anagram? "+ anagram(s1,s2));	
		System.out.println(s1+ " and " +s2+ " are Anagram? "+ anagram2(s1,s2));	
	}
	
	static boolean anagram(String s1, String s2) {
		if(s1.length()!= s2.length()) return false;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<s1.length();i++) {
			map.put(s1.charAt(i), map.getOrDefault(map, 0)+1);
		}
		
		for(int i=0;i<s2.length();i++) {
			if(map.containsKey(s2.charAt(i))) {
				map.put(s2.charAt(i), map.get(s2.charAt(i))-1);
			}
			else {
				return false;
			}
		}
		Set<Character> keys = map.keySet();
		for(Character c : keys) {
			if(map.get(c)!=0) {
				System.out.println("key: "+ c + " value: "+ map.get(c));
				return false;
			}
		}
		return true;
	}
	
	static boolean anagram2(String s1, String s2) {
		
		if(s1.length()!=s2.length()) return false;
		
		char[] ch = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		
		Arrays.sort(ch);
		Arrays.sort(ch2);
		
		if(Arrays.equals(ch, ch2))
			return true;
		else
			return false;
	}

}
