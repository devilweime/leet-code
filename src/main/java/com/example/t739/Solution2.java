package com.example.t739;

import java.util.Arrays;

/**
 * @program: leet-code
 * @description:
 * @author: devilweime
 * @create: 2020-05-25 21:53
 **/
public class Solution2 {

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; --i) {
            int warmer_index = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; ++t) {
                if (next[t] < warmer_index)
                    warmer_index = next[t];
            }
            if (warmer_index < Integer.MAX_VALUE)
                ans[i] = warmer_index - i;
            next[T[i]] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] t = {73,74,75,71,69,72,76,73,89};
        int[] days = new Solution2().dailyTemperatures(t);
        System.out.println(Arrays.toString(days));
    }


}
