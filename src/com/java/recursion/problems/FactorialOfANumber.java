package com.java.recursion.problems;

public class FactorialOfANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 5;
		
		System.out.print("Factorail is : "+ factorial(num));
	}
	
	public static int factorial(int num) {
		
		if(num==1) return num;
		
		return factorial(num-1) * num;
	}

}
