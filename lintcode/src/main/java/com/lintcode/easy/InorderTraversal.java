package com.lintcode.easy;

import java.util.ArrayList;

/**
 * 给出一棵二叉树,返回其中序遍历
 * Created by liqiliang <liqiliang@baibu.la> on 2017/5/4.
 */
public class InorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result=new ArrayList<>();
        helper(root,result);
        return result;
    }

    public ArrayList<Integer> helper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return result;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
        return result;
    }
}
