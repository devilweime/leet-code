package com.example.t739;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: leet-code
 * @description:
 * @author: devilweime
 * @create: 2020-05-25 21:53
 **/
public class Solution4 {

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] days = new Solution4().dailyTemperatures(t);
        System.out.println(Arrays.toString(days));
    }


}
