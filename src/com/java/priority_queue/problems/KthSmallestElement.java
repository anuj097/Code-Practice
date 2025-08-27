package com.java.priority_queue.problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {3,5,9,2,4,6,7,2};
		int k=2;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int a : arr) {
			pq.add(a);
			if(pq.size()>k) {
				pq.poll();
			}
		}
		
		System.out.println(pq.peek());

	}

}
