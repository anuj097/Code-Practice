package com.java.hashMap.problems;

import java.util.HashMap;
import java.util.Map;

public class IndiciesOfTwoNum {

	public static void main(String[] args) {
		int ar[] = {2,3,11,7};
		int target = 9;
		
		for(int ind : indicies(ar, target)) {
			System.out.println("Indicies are: "+ ind);
		}
	}
	
	public static int[] indicies(int ar[], int target) {
		
		Map<Integer, Integer> diff = new HashMap<>();
		
		for(int i=0;i<ar.length;i++) {
			int current = ar[i];
			int comp = target - current;
			
			if(diff.containsKey(comp)) {
				return new int[] { diff.get(comp),i };
			}
			
			diff.put(current, i);
		}
		
		throw new IllegalArgumentException("No Two Sum Solution");
	}

}
