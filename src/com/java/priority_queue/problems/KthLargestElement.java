package com.java.priority_queue.problems;

import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		int[] arr = {3,5,9,2,4,6,7,2};
		int k=2;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int a : arr) {
			pq.add(a);
			// poll() will remove the minimum elements 
			if(pq.size()>k) {
				pq.poll();
			}
		}
		System.out.println(pq.peek());
	}

}
