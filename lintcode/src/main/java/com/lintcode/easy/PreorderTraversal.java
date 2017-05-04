package com.lintcode.easy;

import java.util.ArrayList;

/**
 * 给出一棵二叉树，返回其节点值的前序遍历。
 * Created by liqiliang <liqiliang@baibu.la> on 2017/5/4.
 */
public class PreorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result=new ArrayList<>();
        helper(root,result);
        return result;
    }

    public ArrayList<Integer> helper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
        return result;
    }
}
