package com.example.t739;

import java.util.Stack;

/**
 * @program: leet-code
 * @description:
 * @author: devilweime
 * @create: 2020-05-25 21:53
 **/
public class Solution1 {

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] days  = new int[len];

        for (int i = 0; i < len; i++) {
            int before = T[i];
            int count = 0;
            for (int j = i+1; j< len; j++){
                count ++;
                if (T[j] > before){
                    break;
                }else if (j == len-1){//最后一个比完还是没有比压栈的大
                    count = 0;
                }
            }
            days[i] = count;
        }
        return days;
    }

}
