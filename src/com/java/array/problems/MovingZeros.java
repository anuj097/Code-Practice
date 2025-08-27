package com.java.array.problems;

// 	MOVING ZEROS TO FIRST AND LAST WITHOUT USING ANY EXTRA COLLECTION OR ARRAY

public class MovingZeros {

	public static void main(String[] args) {
		int arr[] = {1,0,3,1,0,4,3,0};
		
		// moving zeros to first
		int first[] = zerosToFirst(arr);
		for(int v : first) {
			System.out.print(v+" ");
		}
		System.out.println();
		
		// moving zeros to last
		int last[] = zerosToLast(arr);
		for(int v : last) {
			System.out.print(v+" ");
		}
	}
	
	static int[] zerosToFirst(int a[]) {
		
		int s = a.length-1;
		for(int i=s;i>=0;i--) {
			if(a[i]!=0) {
				a[s] = a[i];
				s--;
			} 
		}
		for(int i=0;i<=s;i++) {
			a[i] = 0;
		}
		return a;
	}
	
	static int[] zerosToLast(int a[]) {
		
		int s = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=0) {
				a[s] = a[i];
				s++;
			}
		}
		
		for(int i=s;i<a.length;i++) {
			a[i] = 0;
		}
		
		return a;
	}

}
