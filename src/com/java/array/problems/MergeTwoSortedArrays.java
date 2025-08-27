package com.java.array.problems;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {1,2,6,8,9};
		int b[] = {3,5,6,8,11,12};
		int res[] = new int[a.length+b.length];
		
		res = mergeAr(a, b, res);
		for(int v : res) {
			System.out.print(v + " ");
		}
	}
	
	static int[] mergeAr(int a[], int b[], int res[]) {
		
		int l1 = a.length , l2 = b.length;
		
		int i=0, j=0, k=0;
		
		while(i<l1 && j<l2) {
			if(a[i] <= b[j]) {
				res[k++] = a[i++];
			} else {
				res[k++] = b[j++];
			}
		}
		
		while(i<l1) {
			res[k++] = a[i++];
		}
		while(j<l2) {
			res[k++] = b[j++];
		}
		
		return res;
	}

}
