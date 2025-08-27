package com.java.priority_queue.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrintInOrderOfPriority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Element> pq1 = new PriorityQueue<>(new Comparator<Element>() {
			public int compare(Element e1, Element e2) {
				return Integer.compare(e2.priority, e1.priority);
			}
		});
		PriorityQueue<Element> pq = new PriorityQueue<>();
		
		
		System.out.println("The Element priority wise: ");
		pq.add(new Element("Job", 4));
		pq.add(new Element("House", 2));
		pq.add(new Element("Temple", 1));
		pq.add(new Element("Health", 3));
		pq.add(new Element("Food", 5));
		pq.add(new Element("Oxigen", 6));
		
		while(!pq.isEmpty()) {
			Element e = pq.poll();
			
			System.out.println("value: "+ e.value +", priority: "+ e.priority);
		}
	}

}

class Element {
	String value;
	int priority;
	
	public Element(String value, int priority) {
		this.value = value;
		this.priority = priority;
	}
}
