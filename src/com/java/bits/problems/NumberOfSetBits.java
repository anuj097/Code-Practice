package com.java.bits.problems;


/*
		Set Bits are 1, the binary number of 10 is = 1010
		so the total set bits are 2 in above.
		EXAMPLE  -> n=10
			- n&1 means -
			(1010 & 0001) = 0000 
			(101 & 001) = 001 (count++) 
			(10 & 01) = 0 
			(1 & 1) = 1(count++)
 */

public class NumberOfSetBits {

	public static void main(String[] args) {
		int n=10;
		int count=0;
		while(n!=0) {
			if((n&1)==1) {		
				count++;
			}
			n = n>>1;
		}
		System.out.println("Set bits are: "+ count);

	}

}
