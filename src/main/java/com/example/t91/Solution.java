package com.example.t91;

public class Solution {

    //TODO 暂时不理解
    public int numDecodings(String s) {

        if(s.charAt(0) == '0') return 0;
        char[] chars = s.toCharArray();
        return decode(chars,chars.length - 1);
    }

    private int decode(char[] chars, int index) {

        if (index <= 0) return 1;
        int count = 0;
        char cur = chars[index];
        char prev = chars[index - 1];

        if (cur > '0'){
            count += decode(chars,index - 1);
        }
        if (prev == '1' || (prev == '2' && cur <= '6')){
            count += decode(chars,index -  2);
        }
        return count;
    }
}
