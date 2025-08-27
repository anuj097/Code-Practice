package com.java.array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramArragement {
	
	/*
	 * Need to create a List<List<String>>, where anagram strings will be stored in a list, 
	 * and all list will be stored in a List.
	 * Input -> ["eat","tea","tan","ate","nat","bat"]
	 * Output -> [[eat, tea, ate], [bat], [tan, nat]]
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strs[] = {"eat","tea","tan","ate","nat","bat"};
		
		System.out.println(groupAnagrams(strs));

	}

	static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String key = new String(ch);
			// it creates a new key->value(List) pair if key doesn't exist, if key already exist than it'll add into the value list.
			map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
		}

		return new ArrayList<>(map.values());

	}

}
