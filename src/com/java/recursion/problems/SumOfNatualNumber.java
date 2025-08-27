package com.java.recursion.problems;

public class SumOfNatualNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 10;
		
		System.out.print("Sum is : "+ sumOfNatural(num));
	}
	
	public static int sumOfNatural(int num) {
		
		if(num<=1) return 1;
		
		return sumOfNatural(num-1) + num;
		
	}

}
