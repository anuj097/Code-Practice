package stream.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s1 = {"GROCERY15","ELECTRONICS_50","DISCOUNT10"};
		String[] s2 = {"grocery","electronics","invalid"};
		boolean[] b = {false,true,true};
		
		//System.out.println(validateCoupons(s1, s2, b));
		
		String str = "abx";
		
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String dup = sb.toString();
		if(str.equals(dup)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("NOT Palindrome");
		}
	}
	
	static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> list= new ArrayList<>();

        for(int i=0;i<code.length;i++) {
            if(isValid(code[i])==true && 
            !businessLine[i].equals("invalid") &&
            isActive[i]!=false) {
                list.add(code[i]);
            }
        }
        return list;
    }
	
	static boolean isValid(String s) {
		if(s.equals("")) return false;
		Pattern pattern = Pattern.compile("[@$#]");
		Matcher matcher = pattern.matcher(s);
		
		if(matcher.find()) {
			return false;
		}
		return true;
	}

}
