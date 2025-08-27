package com.java.array.problems;

import java.util.ArrayList;
import java.util.List;

/*
 *  In an array {3,3,3,2,2,1,1,2,3,3,2}, size is len=11.
 *   find the two numbers who occurred more than n/3 times.
 */

public class MaxOccuredNumber {

	public static void main(String[] args) {
		int a[] = {3,3,2,2,1,1,2,3,2,3,2};
		
		System.out.println("Answers: "+ findMaxOccurrence(a));
	}
	
	static List<Integer> findMaxOccurrence(int a[]) {
		int ans1=0;
		int count1 =0;
		
		int ans2=0;
		int count2=0;
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<a.length;i++) {
			if(count1==0 && a[i]!=ans2) {
				count1++;
				ans1= a[i];
			}
			else if(count2==0 && a[i] !=ans1) {
				count2++;
				ans2 = a[i];
			}
			else if(a[i]==ans1) {
				count1++;
			} else if(a[i]==ans2) {
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		
		list.add(ans1);
		list.add(ans2);
		
		return list;
		
	}
}

//for(int i=0;i<len;i++) {
//	if(count1==0 && a[i]!=ans2) {
//		count1++;
//		ans1 = a[i];
//	} else if(ans1!=a[i] && a[i]!=ans2){
//		count1--;
//	}else if(ans1==a[i] && a[i]!=ans2){
//		count1++;
//	}
//	
//	if(count2==0 && a[i]!=ans1) {
//		count2++;
//		ans2 = a[i];
//	} else if(ans2!=a[i] && a[i]!=ans1){
//		count2--;
//	}else if(ans2==a[i] && a[i]!=ans1){
//		count2++;
//	}
//}
