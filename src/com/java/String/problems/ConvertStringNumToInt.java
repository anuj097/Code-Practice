package com.java.String.problems;

import java.util.HashMap;
import java.util.Map;

public class ConvertStringNumToInt {

	public static void main(String[] args) {
		String s1 = "One thousand five hundred fifteen";
		
		System.out.println(s1 +" in numbers is: "+ convert(s1));
		
	}
	
	public static int convert(String s) {
		Map<String, Integer> numbers = new HashMap<>();
		
		numbers.put("one", 1);
		numbers.put("two", 2);
		numbers.put("three", 3);
		numbers.put("four", 4);
		numbers.put("five", 5);
		numbers.put("six", 6);
		numbers.put("seven", 7);
		numbers.put("eight", 8);
		numbers.put("nine", 9);
		numbers.put("ten", 10);
		numbers.put("eleven", 11);
		numbers.put("twelve", 12);
		numbers.put("thirteen", 13);
		numbers.put("fourteen", 14);
		numbers.put("fifteen", 15);
		numbers.put("sixteen", 16);
		numbers.put("seventeen", 17);
		numbers.put("eighteen", 18);
		numbers.put("nineteen", 19);
		numbers.put("twenty", 20);
		numbers.put("thirty", 30);
		numbers.put("fourty", 40);
		numbers.put("fifty", 50);
		numbers.put("sixty", 60);
		numbers.put("seventy", 70);
		numbers.put("eighty", 80);
		numbers.put("ninety", 90);
		numbers.put("hundred", 100);
		numbers.put("thousand", 1000);
		
		String ch[] = s.toLowerCase().split(" ");
		
		int total = 0, value = 0;
		
		for(String c : ch) {
			int num = numbers.get(c);
			
			if(num == 100) { 
				value *=num;
			} else if(num == 1000) {
				value *=num;
				total +=value;
				value = 0;
			} else {
				value +=num;
			}
		}
		total += value;
		return total;
	}

}
