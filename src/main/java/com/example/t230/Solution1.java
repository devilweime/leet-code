package com.example.t230;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {


    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);

        return list.get(k-1);
    }

    private List<Integer>  inorder(TreeNode node , List<Integer> list){

        if (node == null){
            return list;
        }
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
        return list;
    }


    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode1, treeNode4);
        int smallest = new Solution1().kthSmallest(treeNode3, 3);
        System.out.println(smallest);
    }

}
