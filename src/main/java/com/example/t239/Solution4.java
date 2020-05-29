package com.example.t239;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution4 {

    private ArrayDeque<Integer> deque = new ArrayDeque<>();

    private int[] numsTmp;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0) return new int[0];
        if (len * k == 1) return nums;
        this.numsTmp = nums;
        int[] output = new int[len - k + 1];

        //初始化部分
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deque.addLast(i);
        }
        output[0] = numsTmp[deque.getFirst()];

        for (int i = k; i < len; i++) {
            clean_deque(i, k);
            deque.addLast(i);
            output[i - k + 1] = numsTmp[deque.getFirst()];//i-k+1等于数组下标
        }
        return output;
    }

    private void clean_deque(int i, int k) {
        if (!deque.isEmpty() && deque.getFirst() == (i - k)) {//根据右边滑动传入的i，求得左边界i-k
            deque.removeFirst();
        }
        //保持窗口左边第一个始终是最大值
        while (!deque.isEmpty() && numsTmp[i] > numsTmp[deque.getLast()]) {
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = new Solution4().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

}
