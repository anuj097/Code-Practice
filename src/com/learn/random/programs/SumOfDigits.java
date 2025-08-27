package com.learn.random.programs;

public class SumOfDigits {

	public static void main(String[] args) {
		int n = 123;
		
		int sum=0;
		while(n!=0) {
			int mod = n%10;
			sum +=mod;
			n /=10;
		}
		System.out.println("The sum of Digits: "+ sum);

	}

}
