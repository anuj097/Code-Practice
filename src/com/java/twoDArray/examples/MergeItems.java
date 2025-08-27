package com.java.twoDArray.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MergeItems {

	/*
	 * 		if the items1 key is same as items2 key then merge the values and put it in a List<List<Integer>>
	 * 
	 */
	public static void main(String[] args) {

		int it1[][] = {{1,1},{3,2},{2,3}};
		int it2[][] = {{2,1},{3,2},{1,3}};
		
		List<List<Integer>> ans =  mergeSimilarItems(it1, it2);
		System.out.println(ans);
	}
	
	static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
		List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] i : items1) {
            //map.put(i[0], map.getOrDefault(i[0], 0) + i[1]);
        	map.put(i[0], i[1]);
        }
        for (int[] i : items2) {
            map.put(i[0], map.getOrDefault(i[0], 0) + i[1]);
        }
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            res.add(Arrays.asList(i.getKey(), i.getValue()));
        }
        return res;

    }

}
