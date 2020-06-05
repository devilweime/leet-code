package com.example.t347;

import java.util.*;

public class Solution1 {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) return nums;
        int len = nums.length;
        if (len * k == 0 && len*k == 1){
            return nums;
        }
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i],countMap.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue((a,b)-> countMap.get(b)-countMap.get(a));
        Set<Map.Entry<Integer, Integer>> entries = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (pq.size() < k){
                pq.add(entry.getKey());
            }else if (entry.getValue() > countMap.get(pq.peek())){
                pq.remove();
                pq.add(entry.getKey());
            }
        }

        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }

        return res;
    }

    public static void main(String[] args) {
        int [] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        int[] res = new Solution1().topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }

}
