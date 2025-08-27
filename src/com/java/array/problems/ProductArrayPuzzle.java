package com.java.array.problems;

public class ProductArrayPuzzle {
	
	/*
	 * Input = {1,2,3,4}
	 * output = {24,12,8,6}
	 * 
	 * Explanation = If we're in index 1 then we've to get the multiplication of other indexes.
	 * 					if we are in 1 then 2*3*4 = 24 etc....
	 */
	public static void main(String[] args) {
		int a[] = {1,2,3,4};
		int res[] = product(a);
		System.out.println("The Product of array is: ");
		for(int r : res) {
			System.out.print(r +" ");
		}
	}
	
	static int[] product(int a[]) { //[1,2,3,4]
		int l = a.length;
		int left[] = new int[l];
		int right[] = new int[l];
		int result[] = new int[l];
		int total=1;
		
		for(int i=0;i<l;i++) {  
			
			if(i==0)
				left[i] = total;
			else {
				total *= a[i-1];
				left[i] = total;
			}
		}
		total=1;
		for(int i=l-1;i>=0;i--) {
			if(i==l-1)
				right[i] = total;
			else {
				total *= a[i+1];
				right[i] = total;
			}
		}
		
		for(int i=0;i<l;i++) {	// [24,]
			result[i] = left[i] *right[i];
		}
		
		return result;
		
		
	}

}
