package com.java.test.question;

public class HighestSumOfTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {15,9,6,9,10,8};
		System.out.println("Highest profit: "+ high(arr));
	}
	
	static int high(int[] ar) {
		int prev = ar[0], prev2 = ar[1];
		
		int max = prev + prev2;
		
		for(int i=2;i<ar.length;i++) {
			
			if(prev < ar[i]) {
				max = Math.max(max, (max +ar[i])-prev);
			} else {
				max = Math.max(max, (max+ar[i])-prev2);
			}	
			
		}
		return max;
	}

}
