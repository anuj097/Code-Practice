package com.java.array.problems;

import java.util.Stack;

public class DailyTemprature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[] = {73,74,75,71,69,72,76,73};
		//int res[] = dailyTemperatures(ar);
		int result[] = dailyTemperatures1(ar);
		for(int r :result) {
			System.out.print(r+" ");
		}
	}
	
	/*	USING STACK -> 
	Monotonic approach -> to find the next greater/smaller element to the right/left of the element in linear time O(n)
	To avoid brute force approach >nested loop
	
	*/
	public static int[] dailyTemperatures1(int[] temps) {
        int[] results = new int[temps.length];
        Stack<Integer> stack = new Stack<>();
        /// UPVOTE !
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return results;
    }
	
	// using brute force approach - linear - nested loop
	public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int res[] = new int[len];
        if(len==0) return res;
        
        for(int i=0;i<len;i++) {
            if(i==len-1) res[i] = 0;
            int count=0;
            boolean isBig = false;
            for(int j=i+1;j<len;j++) {
                if(temperatures[j]>temperatures[i]) {
                	isBig = true;
                    count++;
                    break;
                }
                count++;
                if(j==len-1 && isBig == false) {
                	count=0;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
