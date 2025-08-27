package com.java.recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsets {

	public static void main(String[] args) {
		
		int arr[] = {1,2};
		
		List<List<Integer>> subset = new ArrayList<>();
		
		subsets(arr, 0, new ArrayList<>(), subset);
		
		System.out.println("Subsets are: ");
		
		for(List<Integer> list : subset) {
			System.out.print(list+" ");
		}

	}
	
	public static void subsets(int arr[], int index, List<Integer> current, List<List<Integer>> res) {
		
		if(arr.length==index) {
			res.add(new ArrayList<>(current));
			return;
		}
		
		current.add(arr[index]);
		subsets(arr, index+1, current, res);
		
		System.out.println("current.size() "+ current.size());
		
		current.remove(current.size()-1);
		subsets(arr, index+1, current, res);
		
		
	}
	

}
