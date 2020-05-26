package com.example.t739;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: leet-code
 * @description:
 * @author: devilweime
 * @create: 2020-05-25 21:53
 **/
public class Solution3 {

    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i]>T[stack.peek()]){
                T[stack.peek()] = i-stack.pop();
            }
            stack.push(i);
            if (i == T.length-1){//将栈内无法取到后面大于它的日期
                while (!stack.isEmpty()){
                    T[stack.pop()] = 0;
                }
            }
        }
        return T;
    }

    public static void main(String[] args) {
        int[] t = {73,74,75,71,69,72,76,73};
        int[] days = new Solution3().dailyTemperatures(t);
        System.out.println(Arrays.toString(days));
    }


}
