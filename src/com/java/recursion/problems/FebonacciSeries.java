package com.java.recursion.problems;

public class FebonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 7;
		
		System.out.print("Febonacci series is: ");
		
		for(int i=0; i<num; i++) {
			System.out.print(febonacci(i) + " ");
		}

	}
	
	public static int febonacci(int num) {
		
		if(num<=1) {
			return num;
		}
		
		return (febonacci(num -1) + febonacci(num - 2));
	}

}
