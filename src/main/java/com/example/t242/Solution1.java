package com.example.t242;

import java.util.Arrays;

/**
 * @program: leet-code
 * @description:
 * @author: devilweime
 * @create: 2020-05-19 21:30
 **/
public class Solution1 {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }
}
