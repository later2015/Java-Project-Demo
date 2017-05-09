package com.lintcode.easy;

/**
 * Created by liqiliang <liqiliang@baibu.la> on 2017/5/9.
 */
public class BalancedTree {
    /**
     * 平衡二叉树
     * 给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。
     * 给出二叉树 A={3,9,20,#,#,15,7}, B={3,#,20,15,7}
   A)  3            B)    3
     / \                  \
    9  20                 20
      /  \               / \
     15   7             15  7
     二叉树A是高度平衡的二叉树，但是B不是
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        //算法1
        //return depth2(root)!=-1;

        //算法2
        if (root==null)
            return true;
        if (!isBalanced(root.left))
            return false;
        if (!isBalanced(root.right))
            return false;
        if (Math.abs(depth(root.left)-depth(root.right))>1)
            return false;
        return true;
    }

    int depth(TreeNode node){
        if (node==null)
            return 0;
        return (depth(node.left)>depth(node.right)?depth(node.left):depth(node.right))+1;
    }

    int depth2(TreeNode node){
        if (node==null)
            return 0;
        int left=depth2(node.left);
        int right=depth2(node.right);
        if (left==-1||right==-1||Math.abs(left-right)>1)
            return -1;
        return Math.max(left,right)+1;
    }
}
