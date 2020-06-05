package com.example.t247;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static List<String> searchSymmetry(int n, int m) {
        if (n < 0 || m < 0 || n > m) {
            throw new IllegalArgumentException("Invalid Input");
        }
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "1", "8");
        List<String> res = new ArrayList<>();
        List<String> before = searchSymmetry(n - 2, m);//n-2前的结果组合
        for (String s : before) {
            if (n != m) res.add("0" + s + "0");//不保存与自身长度相等的0组合
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }


    public static void main(String[] args) {
        List<String> list = searchSymmetry(4, 4);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}

