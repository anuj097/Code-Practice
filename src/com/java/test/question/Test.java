package com.java.test.question;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//	    int n=sc.nextInt();
//	    TreeSet<Integer> list=new TreeSet<>();
//	    for(int i=0;i<n;i++)
//	      list.add(sc.nextInt()); 
//	    
//	    System.out.println(Math.abs(n-list.size()));

//	    List<List<Integer>> lists = Arrays.asList(Arrays.asList(1,2,3,4),
//	    										Arrays.asList(5,6,7,8),
//	    										Arrays.asList(9,10,11,12));
//	    
//	   List<Integer> result = lists.stream().flatMap(Collection::stream)
//			   					.filter(m->m%2==0).collect(Collectors.toList());
//	   System.out.println(result);

		// int ar[] = {0,1,0,2,1,0,1,3,2,1,2,1};
//	   int ar[] = {73,74,75,71,69,72,76,73};
//	   //int res[] = dailyTemperatures(ar);
//	   int result[] = dailyTemperatures1(ar);
//	   for(int r :result) {
//		   System.out.print(r+" ");
//	   }

//		int num1[] = {1,2,3,0,0,0};
//		int num2[] = {4,5,6};
//		int m=3, n=3;
//		merge(num1, m, num2, n);

//		int a[] = {9,9,9,0};
//		
//		int res[] = plusOne(a);
//		for(int i : res) {
//			System.out.print(i+" ");
//		}

//		List<String> ss = Arrays.asList("cats","dog","sand","and","cat");
//		String s = "catsandog";
//		System.out.println(wordBreak(s, ss));

//		String s1 = "aabcc";
//		String s2 = "dbbca";
//		String s3 = "aadbbcbcac";
//
//		System.out.println("Does all characters available and are in same sequence? " + checkStringAndSequence(s1, s2, s3));

//		System.out.println();
//		int arr[] = {1,9,10,2};
//		System.out.println("Total number of opertaions to make all number equal: "+makeAllEqual(arr));
//		
//		System.out.println();
//		int a = 4, p = 3;
//		int x = pow(a, p/2);
//		System.out.println(a +" to the power "+p +" is: "+pow(a, p/2)* x);
		
//		int n[] = {4,2,1,3,3};
//		int k=2;
//		
//		System.out.println(findMaxAverage(n, k));
		
		int arr[] = {4,3,7,4,6,5,3};
		
		System.out.println(dup(arr));
	}
	
	// check the occurrence of repeating number
	static int dup(int a[]) {
		Set<Integer> s = new HashSet<>();
		
		for(int i =0 ;i<a.length;i++) {
			if(s.contains(a[i])) {
				return i;
			} else {
				s.add(a[i]);
			}
		}
		return -1;
	}
	static double findMaxAverage(int[] nums, int k) {
        if(nums.length<k) return (double)0;
        double sum=0;
        for(int i=0;i<k;i++) {
            sum+=nums[i];
        }
        int a=0;
        int val = nums[0];
        for(int i=k;i<nums.length;i++) {
            sum = Math.max(sum, (sum-val)+ nums[i]);
            a++;
            if(nums[a]==0)
            	val +=nums[a];
            else
            	val = nums[a];	
        }
        return sum/k;
    }
	
	static int pow(int x, int n) {
		if(n==0) return 1;
		return x * pow(x, n-1);
	}
	
	static int makeAllEqual(int arr[]) {
		
		Arrays.sort(arr);
		
		int med = arr.length/2;
		
		int ans=0;
		for(int i : arr) {
			ans += Math.abs(arr[med] - i);
		}
		return ans;
	}

	static boolean checkStringAndSequence(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();

		int c1Counter = 0;
		int allCharAvail = 0;
		int checkC1 = Integer.MIN_VALUE;

		for (int i = 0; i < c3.length; i++) {
			if (c1Counter < c1.length) {
				if (c1[c1Counter] == c3[i]) {
					allCharAvail++;
					if (checkC1 < i) {
						checkC1 = i;
						c1Counter++;
					} else {
						return false;
					}
				}
			}
		}
		// all characters of c1 should be available
		if (allCharAvail != c1.length)
			return false;

		allCharAvail = 0;
		int c2Counter = 0;
		int checkC2 = Integer.MIN_VALUE;
		for (int i = 0; i < c3.length; i++) {
			if (c2Counter < c2.length) {
				if (c2[c2Counter] == c3[i]) {
					allCharAvail++;
					if (checkC2 < i) {
						checkC2 = i;
						c2Counter++;
					} else {
						return false;
					}
				}
			}
		}
		// all characters of c2 should be available
		if (allCharAvail != c2.length)
			return false;

		return true;
	}

	// to check if String s contains the word available in wordDict, without
	// repeating/overlapping any character
	static boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (String w : wordDict) {
				int start = i - w.length();
				if (start >= 0 && dp[start] && s.substring(start, i).equals(w)) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	// adding one in the last digit of array (if [9] return [1,0] <-OR-> if [8,9]
	// return [9,0] )
	static int[] plusOne(int[] digits) {
		if (digits.length == 0)
			return new int[] {};
		for (int i = digits.length - 1; i >= 0; i--) {
			// if all digits are less then 9
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			} else {
				// if all digits are
				digits[i] = 0;
			}
		}
		// if we reach here means all digits were 9
		int arr[] = new int[digits.length + 1];
		arr[0] = 1;
		return arr;
	}

	// merge two sorted arrays if based on there size m and n
	static void merge(int[] nums1, int m, int[] nums2, int n) {
		int res[] = new int[m + n];
		int count = 0;
		if (m == 0 && n == 1) {
			res = nums2;
		} else if (m == 1 && n == 0) {
			res = nums1;
		} else {
			for (int i = 0; i < m; i++) {
				res[count] = nums1[i];
				count++;
			}
			for (int i = 0; i < n; i++) {
				res[count] = nums2[i];
				count++;
			}
		}
		for (int x : res) {
			System.out.print(x + " ");
		}
	}

	//
	public static int[] dailyTemperatures(int[] temperatures) {
		int len = temperatures.length;
		int res[] = new int[len];
		if (len == 0)
			return res;

		for (int i = 0; i < len; i++) {
			if (i == len - 1)
				res[i] = 0;
			int count = 0;
			boolean isBig = false;
			for (int j = i + 1; j < len; j++) {
				if (temperatures[j] > temperatures[i]) {
					isBig = true;
					count++;
					break;
				}
				count++;
				if (j == len - 1 && isBig == false) {
					count = 0;
				}
			}
			res[i] = count;
		}
		return res;
	}

	/*
	 * USING STACK -> Monotonic approach -> to find the next greater/smaller element
	 * to the right/left of the element in linear time O(n) To avoid brute force
	 * approach >nested loop
	 * 
	 */
	public static int[] dailyTemperatures1(int[] temps) {
		int[] results = new int[temps.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < temps.length; i++) {
			while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
				results[stack.peek()] = i - stack.pop();
			}
			stack.push(i);
		}

		return results;
	}

}
