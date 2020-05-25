package com.example.t20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: leet-code
 * @description:
 * @author: devilweime
 * @create: 2020-05-22 23:14
 **/
public class Solution {

    public boolean isValid(String s) {

        if (s == null) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push('|');
        for (Character aChar : chars) {
            Character prev = stack.peek();
            Character pair = map.get(prev);
            if (pair != null && pair.equals(aChar)) {
                stack.pop();//将栈里值弹出
            } else {
                stack.push(aChar);
            }
        }
        if (stack.size() == 1 && stack.pop().equals('|') ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean valid = solution.isValid("{[{}]}");
        System.out.println(valid);
    }
}
