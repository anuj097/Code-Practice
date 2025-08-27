package com.java.array.problems;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumberInArray {

	public static void main(String[] args) {
		int a[] = {4,1,1,3,4};
		
		System.out.println("Unique number is : "+ uniqueUsingHashMap(a));
		System.out.println("Unique number is (XOR) : "+ uniqueUsingHashMap(a));

	}
	
	// USing Hash Map
	static int uniqueUsingHashMap(int a[]) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int n : a) {
			map.put(n, map.getOrDefault(n, 0) +1);
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue()==1)
				return entry.getKey();
		}
		return 0;
	}
	
	// Using XOR operation
	static int uniqueUsingXOR(int a[]) {
		int res = 0;
		
		for(int n : a) {
			res = res^n;
		}
		return res;
	}

}
