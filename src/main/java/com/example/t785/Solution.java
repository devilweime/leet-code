package com.example.t785;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public boolean isBipartite(int[][] graph) {
        //[[1,3], [0,2], [1,3], [0,2]]
        int len = graph.length;
        int[] color = new int[len];
        Arrays.fill(color,-1);

        for (int i = 0; i < len; i++) {
            if (color[i] == -1){
                Stack<Integer> stack = new Stack<>();
                color[i] = 0;
                stack.push(i);
                while (!stack.empty()){
                    Integer node = stack.pop();
                    for (int nei : graph[node]) {
                        if (color[nei] == -1){
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;//标记连接节点跟根节点是不同颜色
                        }else if(color[nei] == color[node]){//如果根节点跟连接节点相同，则返回false
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
