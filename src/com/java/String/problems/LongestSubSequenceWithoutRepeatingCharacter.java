package com.java.String.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestSubSequenceWithoutRepeatingCharacter { // subsequence means - non-contiguous

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "abcdabcdfesb";
		
		System.out.println("Longest SubString Without Repeating character is: " + subString(str));

	}
	
	public static String subString(String str) {
		List<Character> list = new ArrayList<>();
		List<List<Character>> lists = new ArrayList<>();
		String res ="";
		for(int i=0;i<str.length();i++) {
			if(list.contains(str.charAt(i))) {
				lists.add(list);
				list.remove((Character)str.charAt(i));
			}
			if(i!=str.length()-1)
				list.add(str.charAt(i));
		}
		List<Character> finalList = lists.stream().max(Comparator.comparingInt(List::size)).orElse(Collections.emptyList());
		for(Character c: finalList) {
			res +=c;
		}
		return res;
	}

}
