package com.lintcode.easy;

import java.util.ArrayList;

/**
 * 给出一棵二叉树，返回其节点值的后序遍历。
 * Created by liqiliang <liqiliang@baibu.la> on 2017/5/4.
 */
public class PostorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
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
        helper(root.right, result);
        result.add(root.val);
        return result;
    }
}
