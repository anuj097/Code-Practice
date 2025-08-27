package com.java.test.question;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a1 = {1,4,6,8};
		int[] a2 = {1,3,5,6,7};
		
		int res[] = new int[a1.length+a2.length];
		int i=0;
		int j=0;
		int k=0;
		
		// To merge the small numbers
		while(i<a1.length && j<a2.length) {
			if(a1[i]<a2[j]) {
				res[k] = a1[i];
				i++; k++;
			} else if(a2[j]<a1[i]) {
				res[k] = a2[j];
				j++; k++;
			} else {
				res[k] = a1[i];
				k++;
				res[k] = a2[j];
				i++; j++; k++;
			}
		}
		// if any element is left in a1 array
		while(i<a1.length) {
			res[k] = a1[i];
			k++; i++;
		}
		// if any element is left in a2 array
		while(j<a1.length) {
			res[k] = a2[j];
			k++; j++;
		}
		
		System.out.println("<-- AFTER MERGING TWO SORTED ARRAYS -->");
		for(int r : res) {
			System.out.print(r+ " ");
		}
	}

}
