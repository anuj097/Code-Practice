package com.java.sorting.techs;

public class BubbleSort {

	public static void main(String[] args) {
		
		//int[] arr = {6,2,4,7,8,3,1,6};
		
		int[] arr = {3,5,7,9,10,15};

		bubble(arr);
		for(int a : arr) {
			System.out.print(a + " ");
		}
	}
	static void bubble(int[] a) {
		int len = a.length;
		boolean swapped;
		
		for(int i=0;i<len-1;i++) {
			swapped = false;
			
			for(int j=0;j<len-i-1;j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) break; // array is already sorted
		}
	}

}
