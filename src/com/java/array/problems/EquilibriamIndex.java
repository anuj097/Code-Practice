package com.java.array.problems;

public class EquilibriamIndex {

	/*
	 * input = {2,1,7,3,6,5,6,2}
	 * Find the index whose left elements sum is equal to right elements sum
	 * output = 4 (index number)
	 * Explanation = Left (2+1+7+3 = 13) and middle (6) and right (5+6+2 = 13) 
	 */
	
	public static void main(String[] args) {
		int a[] =  {4,2,1,7,3,6,5,6,2,4};
		//int a[] = {1,2,3,4};			// FALSE CASE

		System.out.println("Middle index is : "+ midIndex(a));
		//System.out.println("Middle index is : "+ test(a));
		
	}
	
	static int midIndex(int a[]) {
		int total = 0;
		int left=0, right=0;
	
		for(int v : a) {			// To got the total sum
			total +=v;
		}
		
		for(int i=0;i<a.length;i++) {
			
			right = total - (left+a[i]); // find the left side of sum
			if(left==right) {				// if sum 
				return a[i];
			}
			else {
				left += a[i]; 
			}
		}
		return total;
	}

}
