package com.java.array.problems.fixedsizeslidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
		Explanation:
		Input: arr = [12, -1, -7, 8, 15, 30, 16, 28]
       	k = 3
		Output: -1 -1 -7 0 0 0
		
		Window [12, -1, -7] → first negative is -1
		Window [-1, -7, 8] → first negative is -1
		Window [-7, 8, 15] → first negative is -7
		Window [8, 15, 30] → no negative → 0
		Window [15, 30, 16] → no negative → 0
		Window [30, 16, 28] → no negative → 0
 */

public class FirstNegativeInWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {12, -1, -7, 8, 15, 30, 16, 28};
		int k= 3;
		
		System.out.println("firstNegativeUsingLinkedList are: "+ firstNegativeUsingLinkedList(arr, k));
		System.out.println("firstNegativeUsingArrayDeque are: "+ firstNegativeUsingArrayDeque (arr, k));
		
	}
	
	// time and space complexity : O(n*k) & O(k)
	public static List<Integer> firstNegativeUsingLinkedList(int arr[], int k) {
		List<Integer> list = new LinkedList<>();
		List<Integer> l2 = new LinkedList<>();
		
		for(int i=0; i<arr.length;i++) {
			l2.add(arr[i]);
			if(i>=k-1) {
				int min = l2.stream().filter(s->s<0).findFirst().orElse(0);
				if(min<0) 
					list.add(min);
				else 
					list.add(0);
				l2.removeFirst();
			}
		}
		return list;
	}
	
	// time and space complexity : O(n) & O(k)
	public static List<Integer> firstNegativeUsingArrayDeque(int arr[], int k) { 	//arr = [12, -1, -7, 8, 15, 30, 16, 28]
		List<Integer> list = new ArrayList<>();
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i]<0) 
				deque.addLast(i);
			
			if(!deque.isEmpty() && deque.peekFirst()<i-k+1)
				deque.removeFirst();
			
			if(i>=k-1) {
				list.add(deque.isEmpty() ? 0 : arr[deque.peekFirst()]);
			}
		}
		return list;
	}

}
