package com.example.t239;

public class Solution2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];

        int [] output = new int[n - k + 1];//n - k + 1 输出的数组长度
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++)//i：窗口的左边，i+k窗口的右边
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }
}
