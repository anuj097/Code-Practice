package com.java.array.problems;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int a[] = {4,12,5,1,2,4,6};
		
//		int res[] = nextGreater(a);
//		for(int r : a) {
//			System.out.print(r +" ");
//		}
//		System.out.println();
//		System.out.println("The below elements showing their next greater Element and -1 means no Next element is Greater");
//		for(int r : res) {
//			System.out.print(r +" ");
//		}
		
		int res1[] = next(a);
		for(int r : a) {
			System.out.print(r +" ");
		}
		System.out.println();
		System.out.println("The below elements showing their next greater Element and -1 means no Next element is Greater");
		for(int r : res1) {
			System.out.print(r +" ");
		}

	}
	
	// Using stack, Monotonic stack approach -O(n)
	static int[] next(int a[]) {
		int len = a.length;
		int res[] = new int[len];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<len;i++) {
			while(!stack.isEmpty() && a[stack.peek()] < a[i]) {
				res[stack.peek()] = a[i];
				stack.pop();
			}
			stack.push(i);
		}
		return res;
		
	}
	
	static int[] nextGreater(int a[]) {  // [4,12,5,1,2,4,6]
		int res[] = new int[a.length];
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=a.length-1;i>=0;i--) {
			if(i==a.length-1) {
				res[i] = -1;
				stack.addElement(a[i]);
			} else {
				if(a[i+1]>a[i]) {
					res[i] = a[i+1];
					stack.addElement(a[i]);
				} else {	
					while(!stack.isEmpty() && stack.lastElement()<a[i]) {
						stack.pop();
					}
					if(stack.isEmpty())
						res[i] = -1;
					else
						res[i]= stack.peek();
				}
			}
		}
		return res;
	}

}
