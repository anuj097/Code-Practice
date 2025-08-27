package com.java.String.problems;

public class AddingBinaryNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "100";
		String s2 = "110010";
		
		System.out.println(addBinary(s1, s2));

	}
	
	static String addBinary(String a, String b) { 
        StringBuilder sb = new StringBuilder();
        if(a.equals("")) {
            return b;
        } else if(b.equals("")) {
            return a;
        }
        int minLen = Math.min(a.length(), b.length());
        char c='0';
        for(int i=minLen-1;i>=0;i--) {
            if(a.charAt(i)=='1' && b.charAt(i)=='1') {
                if(c=='1') {
                    sb.append("1");
                }else {
                    sb.append("0");
                }
                c= '1';
            } else if(a.charAt(i)=='1' && b.charAt(i)=='0' ||
            a.charAt(i)=='0' && b.charAt(i)=='1' ) {
                if(c=='1') {
                    sb.append("0");
                    c='1';
                } else {
                    sb.append("1");
                }
            } else {
                if(c=='1') {
                    sb.append("1");
                    c='0';
                } else {
                    sb.append("0");
                }
            }
        }

        if(a.length()>minLen) {
        	minLen = a.length() - b.length();
            for(int i=minLen-1;i>=0;i--) {
                if(a.charAt(i)=='1') {
                    if(c=='1') {
                        sb.append("0");
                        c='1';
                    } else {
                        sb.append("1");
                    }
                } else {
                    if(c=='1') {
                        sb.append("1");
                        c ='0';
                    } else {
                        sb.append("0");
                    }
                }
            }
        }

        if(b.length()>minLen) {
        	minLen = b.length() - a.length();
            for(int i=minLen-1;i>=0;i--) {
                if(b.charAt(i)=='1') {
                    if(c=='1') {
                        sb.append("0");
                        c='1';
                    } else {
                        sb.append("1");
                    }
                } else {
                    if(c=='1') {
                        sb.append("1");
                        c ='0';
                    } else {
                        sb.append("0");
                    }
                }
            }
        }
        if(c=='1') {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

}
