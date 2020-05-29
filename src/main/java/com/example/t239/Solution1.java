package com.example.t239;

import java.util.*;

public class Solution1 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int left = 0;
        int right = k - 1;
        List<Integer> maxList = new ArrayList<>();//空间可以优化的地方
        for (int i = right; i < nums.length; i++){
            int max = computeMax(nums, left, right);
            maxList.add(max);
            left++;
            right++;
        }

        return toArray(maxList);
    }


    private int[] toArray(List<Integer> list){//转换数组是否可以优化

        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int computeMax(int[] nums ,int left,int right){//最值查找是否可以优化

        int max = Integer.MIN_VALUE ;
        for (int j = left ; j <= right;j++){
            if (nums[j]>max){
                max = nums[j];
            }
        }
        return max;
    }

}
