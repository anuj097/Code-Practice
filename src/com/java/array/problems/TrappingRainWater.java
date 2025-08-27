package com.java.array.problems;

public class TrappingRainWater {
	
	/*
	 * LeetCode ques -> 42 Trapping Rain water -> 2 pointer solution
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int ar[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		int ar[] = {4,2,0,3,2,5};
		
		System.out.println("Total trapped water: "+ trapWater(ar));

	}
	
	static int trapWater(int height[]) {
		int left = 0, right = height.length-1;
		int lMax = 0, rMax = 0, ans = 0;
		
		while(left<right) {
			lMax = Math.max(lMax, height[left]);	// left highest
			rMax = Math.max(rMax, height[right]);	// right highest
			
			if(lMax<rMax) {
				ans += lMax - height[left];
				left++;
			} else {
				ans += rMax - height[right];
				right--;
			}
		}
		return ans;
		
	}

}
