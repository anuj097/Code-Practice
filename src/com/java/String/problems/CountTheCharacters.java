package com.java.String.problems;

public class CountTheCharacters {

	public static void main(String[] args) {
		String s1 = "saaaabbbeed";
		
		System.out.println("The Final String is: "+ counting(s1));
	}
	
	static String counting(String s1) {
		if(s1.equals("")) return "";
		
		StringBuilder sb = new StringBuilder();
		int count=0;
		char ch = s1.charAt(0);
		sb.append(ch);
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)==ch) {
				count++;
			}else {
				ch = s1.charAt(i);
				sb.append(count).append(ch);
				count=1;
			}
		}
		sb.append(count);
		return sb.toString();
	}

}
