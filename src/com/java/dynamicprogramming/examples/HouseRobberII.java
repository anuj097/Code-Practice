package com.java.dynamicprogramming.examples;

public class HouseRobberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,1,1};
		System.out.println(rob(nums));
	}
	
	public static int rob(int[] nums) {
        if(nums==null) return 0;
        int len = nums.length;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0], nums[1]);
        
        int usingFirst = rob(0,len-1, nums);
        int usingLast = rob(1,len-1, nums);

        return Math.max(usingFirst, usingLast);
    }

	static int rob(int start, int end, int nums[]) {
        int size = end - start +1;
        if(size==1) return nums[start];
        int dp[] = new int[size];
        dp[0]=nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);
        for(int i=2;i<size;i++) {
        	// [i + start] is for if we skip 1st, but still i will give 2nd last pos, so +start is needed (for cond2)
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i+start]);
        }
        return dp[size-1];
    }

}
