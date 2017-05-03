package com.lintcode.easy;

import java.util.ArrayList;

/**
 * 在二叉树中寻找值最大的节点并返回。
 * 给出如下一棵二叉树：
 * <p/>
 * 1
 * /   \
 * -5     2
 * / \   /  \
 * 0   3 -4  -5
 * 返回值为 3 的节点。
 * Created by liqiliang <liqiliang@baibu.la> on 2017/4/26.
 */
public class MaxNode {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        //先把二叉树遍历，放在一个list里
        //然后for循环一次把二叉树取出来找最大值即可。
        TreeNode maxNode;
        if (root == null)
            return null;
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        helper(root, result);
        maxNode = result.get(0);
        for (TreeNode item : result) {
            if (maxNode.val < item.val)
                maxNode = item;
        }
        return maxNode;
    }

    //递归法前序遍历二叉树，遍历结果放到ArrayList里
    public ArrayList<TreeNode> helper(TreeNode root, ArrayList<TreeNode> result) {
        if (root == null) {
            return result;
        }
        helper(root.left, result);
        helper(root.right, result);
        result.add(root);
        return result;
    }
}
