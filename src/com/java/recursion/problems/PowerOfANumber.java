package com.java.recursion.problems;

public class PowerOfANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 5;
		int comp = 3;
		
		System.out.print(num + " Power of "+comp +" is : "+ pow(num, comp));
	}

	public static int pow(int num, int comp) {
	
		if(comp==1) return num;
		
		return pow(num , comp-1) * num;
	}
}
