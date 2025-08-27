package com.java.test.question;

public class ReverseAInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int x = 120;
		//int x = -132;
		int x = 1534236469;

		int rev=0;
		System.out.println("Before Reverse: "+ x);
		while(x!=0) {
			
			int mod = x%10;
			//System.out.println("mod= "+mod);
			
			rev = (rev *10) + mod;
			//System.out.println("rev= "+rev);
			
			x = x/10;
			//System.out.println("x= "+x);
		}
		
		System.out.println("After Reverse: "+ rev);
	}

}
