package com.java.String.problems;

import java.util.ArrayList;
import java.util.List;

public class StringMatching {
	/*
	 * input = {"mass", "as", "hero","superhero"}
	 * output = {"as", "hero"}
	 * 
	 * Explanation = Like "as" is a subString of "mass" and "hero" is substring of "superhero".
	 * 
	 */

	public static void main(String[] args) {
		String s[] = {"mass", "as", "hero","superhero"};
		System.out.println("Matching subStrings are: " + match(s));
		//System.out.println("Matching subStrings are: " + test(s));

	}
	
	static List<String> match(String s[]) {
		List<String> res = new ArrayList<>();
		for(int i=0; i<s.length;i++) {
			for(int j=0;j<s.length;j++) {
				if(i!=j && s[i].length()>=s[j].length() && s[i].contains(s[j])) {
					res.add(s[j]);
				}
			}
		}
		return res;
	}

}
