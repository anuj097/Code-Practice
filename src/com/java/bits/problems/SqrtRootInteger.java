package com.java.bits.problems;

import java.util.ArrayList;
import java.util.List;

public class SqrtRootInteger {

	public static void main(String[] args) {
		//find the 3rd highest number
		System.out.println(isSubsequence("abc", "axbhdc"));
	}
	static boolean isSubsequence(String s, String t) {
        int last=0;
        for(int i=0;i<s.length();i++) {
            boolean isAvail=false;
            for(int j=last;j<t.length();j++) {
                if(s.charAt(i)==t.charAt(j)) {
                    isAvail = true;
                    last = j+1;
                    break;
                }
            }
            if(isAvail==false) return false;
        }
        return true;
    }
}
