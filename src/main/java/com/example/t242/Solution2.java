package com.example.t242;

import java.util.Arrays;

/**
 * @program: leet-code
 * @description:
 * @author: devilweime
 * @create: 2020-05-19 21:30
 **/
public class Solution2 {


    public static void main(String[] args) {
        boolean anagram = new Solution2().isAnagram("a", "b");
        System.out.println(anagram);
    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int len = 26;
        int[] hash = new int[len];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            hash[c - 'a']--;
        }
        for (int i : hash) {
            if (i != 0) {
                {
                    return false;
                }
            }
        }
        return true;
    }
}
