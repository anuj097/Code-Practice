package com.java.hashMap.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramCheck {

	public static void main(String[] args) {
	
		String s1 = "listen";
		String s2 = "silent";
		
		
		
		System.out.println("(Map.put())String are Anagram ? "+anagramUsingPut(s1, s2));
		
		System.out.println("(Stream API)String are Anagram? "+anagramUsingStream(s1, s2));
	}
	
	public static boolean anagramUsingPut(String s1, String s2) {
		
		if(s1.length()!=s2.length()) return false;
		
		Map<Character, Integer> map = new HashMap<>();
		
		// Count frequency of characters in first string
		for(char c : s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		// Decrease frequency based on second string
		for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) < 0) return false;
        }
		
		return true;
	}
	
	public static boolean anagramUsingStream(String s1, String s2) {
		
		if(s1.length()!=s2.length()) return false;
		
		Map<Character, Long> freq1 = s1.chars().mapToObj(c -> (char) c)
										.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		Map<Character, Long> freq2 = s2.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		return freq1.equals(freq2);
	}

}
