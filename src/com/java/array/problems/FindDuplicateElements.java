package com.java.array.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer arr[] = {1,5,6,7,3,4,1,5,3};
		
		System.out.println("Duplicate values are: "+ duplicates(arr));
		
		System.out.println("Duplicate [using map] values are: "+ duplicatesUsingMap(arr));
	}

	public static Set<Integer> duplicates(Integer arr[]) {
		
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> dup =  Arrays.stream(arr).filter(s -> !set.add(s)).collect(Collectors.toSet());
			
			return dup;
	}
	
	public static Set<Integer> duplicatesUsingMap(Integer arr[]) {
		
		Map<Integer, Long> map = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Set<Integer> set = map.entrySet().stream().filter(v -> v.getValue()>1).map(s -> s.getKey()).collect(Collectors.toSet());
		
		return set;
		
	}
}
