package com.learn.random.programs;

public class ReverseANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 123;
		int res=0;
		
		while(n!=0) {
			int mod = n%10;
			res = res*10 + mod;
			n = n/10;
		}
		
		System.out.println(res);

	}

}
