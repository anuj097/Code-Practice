package com.java.twoDArray.examples;

import java.util.ArrayList;
import java.util.List;

public class PointIntersectCars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> nums = List.of(List.of(3,6),List.of(1,5),List.of(4,7));
		
		//System.out.println(nums);
		System.out.println(intersect(nums));

	}
	
	static int intersect(List<List<Integer>> nums) { // [[3,6],1,5[],[4,7]]
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<nums.size();i++) {
			List<Integer> l1 = nums.get(i);
			int n = l1.get(0);
			int m = l1.get(1);
			while(n<=m) {
				if(!list.contains(n)) {
					list.add(n);
				}
				n++;
			}
		}
		System.out.println(list);
		return list.size();
	}

}
