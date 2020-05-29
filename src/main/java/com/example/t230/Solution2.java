package com.example.t230;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {


    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int res = 0;
        while (cur != null || !stack.isEmpty()){//第一层

            while (cur != null){//树的左边压入栈
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (--k == 0){
                res =  cur.val;
            }
            cur =cur.right;//将右节点的左边也压入栈（包含右根节点）
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode1, treeNode4);
        int smallest = new Solution2().kthSmallest(treeNode3, 3);
        System.out.println(smallest);
    }

}
